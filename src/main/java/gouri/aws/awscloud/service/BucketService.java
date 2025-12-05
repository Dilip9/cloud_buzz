package gouri.aws.awscloud.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import gouri.aws.awscloud.utils.AWSBucketConstant;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class BucketService {

    private Logger logger = LogManager.getLogger(this.getClass().getName());
    private AmazonS3 amazonS3;



    public BucketService(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
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

    public String addBucket(String bucketName) {
        logger.info("Inside method createBucket");
        try{
            if(bucketAlreadyExists(bucketName)) {
                logger.info("Bucket name is not available. Try with a different Bucket name.");
                return AWSBucketConstant.B_CODE_404;
            }
            amazonS3.createBucket(bucketName);

        }catch(AmazonS3Exception e) {
            logger.error("Unable to create bucket : " + e.getMessage());
        }
        return AWSBucketConstant.B_CODE_201+bucketName;
    }

    private boolean bucketAlreadyExists(String bucketName) {
        logger.info("Inside method bucketAlreadyExists");
        return amazonS3.doesBucketExistV2(bucketName);
    }



    public String deleteBucket(String bucketName) {
        // Check if the bucket is empty before deleting
        ListObjectsRequest req = new ListObjectsRequest()
                .withBucketName(bucketName)
                .withMaxKeys(1);    // Only check first object

        ObjectListing listing = amazonS3.listObjects(req);

        if(listing.getObjectSummaries().isEmpty()) {
            logger.info("Bucket is empty, proceeding to delete: " + bucketName);
            amazonS3.deleteBucket(bucketName);
            return AWSBucketConstant.B_CODE_200;
        } else {
            logger.info("Bucket is not empty : " + bucketName);

            return AWSBucketConstant.B_CODE_409;
        }

    }

    public Map<String, List<String>> listBucketsWithFiles() {
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

    public List<String> listBuckets(){
        return amazonS3.listBuckets().stream().map(Bucket::getName).toList();
    }

    public List<String> listObjectsInBucket(String bucketName){
        return amazonS3.listObjectsV2(bucketName).getObjectSummaries().stream().map(S3ObjectSummary::getKey).toList();

    }
}
