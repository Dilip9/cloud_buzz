package gouri.aws.awscloud.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import gouri.aws.awscloud.utils.AWSBucketConstant;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Service
public class FileStoreService {

    Logger logger = LogManager.getLogger(this.getClass().getName());
    private AmazonS3 amazonS3;

    public FileStoreService(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }


    public String deleteFile(String bucketName, String fileName) {
        try{
            if(amazonS3.doesBucketExistV2(bucketName)){
                //amazonS3.getObjectMetadata(bucketName, fileName);
                if(amazonS3.doesObjectExist(bucketName, fileName)){
                    amazonS3.deleteObject(bucketName, fileName);
                }else{
                    return AWSBucketConstant.F_CODE_404;
                }
                return AWSBucketConstant.F_CODE_200;
            }else{
                return AWSBucketConstant.B_CODE_404;
            }
        }catch (AmazonS3Exception e){
            logger.error("Unable to delete file from bucket : " + e.getMessage());
            return AWSBucketConstant.F_CODE_500+ e.getMessage();
        }


    }


    public void uploadFileToBucket(MultipartFile file, String bucketName) throws Exception {
        logger.info("Inside method uploadFileToBucket");
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
        file.transferTo(convFile);
        try{
            amazonS3.putObject(bucketName, convFile.getName(), convFile);
        }catch(AmazonS3Exception e) {
            logger.error("Unable to upload file to bucket : " + e.getMessage());
            throw new Exception(AWSBucketConstant.F_CODE_500+ e.getMessage());
        }
    }

    public String uploadFile(MultipartFile file, String bucketName) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        try {
            uploadFileToBucket(file, bucketName);
        } catch (Exception e) {
            throw new IllegalStateException(AWSBucketConstant.F_CODE_500 + e.getMessage());
        }
        return AWSBucketConstant.B_CODE_200;
    }



}
