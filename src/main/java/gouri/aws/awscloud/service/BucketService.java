package gouri.aws.awscloud.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class BucketService {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    private AmazonS3 amazonS3;
    private FileStore fileStorage;


    public BucketService(AmazonS3 amazonS3, FileStore fileStorage) {
        this.amazonS3 = amazonS3;
        this.fileStorage = fileStorage;
    }


    public void downloadFile(String fileName, AmazonS3 s3, String bucketName) {
        try {
            logger.info("file to be fetched from s3 {} " + fileName);
            S3Object s3Object = s3.getObject(bucketName, fileName);
            InputStream objectData = s3Object.getObjectContent();
            String content = IOUtils.toString(objectData);
            logger.info("file content fetched from s3 {} " + content);

        } catch (IOException e) {
            logger.error("Error in reading file content {} " + e.getMessage());
        } catch (AmazonS3Exception s3Exception) {
            logger.error("Error occurred while downloading file from S3 bucket: " + s3Exception.getMessage());
        }
    }

    public String createBucket(String bucketName) {
//        if (amazonS3.doesBucketExistV2(bucketName)) {
//            logger.info("Bucket with name {} already exists.", bucketName);
//            return "Bucket already exists.";
//        } else {
//            amazonS3.createBucket(bucketName);
//            logger.info("Bucket with name {} created successfully.", bucketName);
//            return "Bucket created successfully.";
//        }
        return fileStorage.createBucket(bucketName);
    }

    public String uploadFile(MultipartFile file, String bucketName) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        try {
            fileStorage.uploadFileToBucket(file, bucketName);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        return "File uploaded successfully.";
    }

    public String deleteBucket(String bucketName) {
        fileStorage.deleteBucket(bucketName);
        return "Bucket and files deleted successfully.";
    }

    public String deleteFile(String bucketName, String fileName) {
        fileStorage.deleteFile(bucketName, fileName);
        return "File deleted successfully.";
    }

    public Map<String, List<String>> listBuckets() {
        Map<String, List<String>> bucketFiles = new HashMap<>();

        try {
            List<Bucket> buckets = amazonS3.listBuckets();

            for (Bucket bucket : buckets) {
                List<String> files = new ArrayList<>();

                ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucket.getName());
                ListObjectsV2Result result;

                do {
                    result = amazonS3.listObjectsV2(req);

                    for (S3ObjectSummary summary : result.getObjectSummaries()) {
                        files.add(summary.getKey());
                    }

                    req.setContinuationToken(result.getNextContinuationToken());

                } while (result.isTruncated());

                bucketFiles.put(bucket.getName(), files);
            }

            return bucketFiles;

        } catch (AmazonS3Exception e) {
            logger.error("Error occurred while listing S3 buckets: " + e.getMessage());
            return Collections.emptyMap();
        }
    }
}
