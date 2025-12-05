package gouri.aws.awscloud.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Service
public class FileStore {

    Logger logger = LogManager.getLogger(this.getClass().getName());
    private AmazonS3 amazonS3;

    public FileStore(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }


    public void deleteFile(String bucketName, String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }

    public void deleteBucket(String bucketName) {

        amazonS3.deleteBucket(bucketName);
    }

    public void uploadFileToBucket(MultipartFile file, String bucketName) throws Exception {
        logger.info("Inside method uploadFileToBucket");
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
        file.transferTo(convFile);
        try{
            amazonS3.putObject(bucketName, convFile.getName(), convFile);
        }catch(AmazonS3Exception e) {
            logger.error("Unable to upload file to bucket : " + e.getMessage());
            throw new Exception("Unable to upload file to bucket : " + e.getMessage());
        }
    }



}
