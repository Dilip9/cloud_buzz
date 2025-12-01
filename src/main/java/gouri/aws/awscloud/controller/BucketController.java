package gouri.aws.awscloud.controller;

import gouri.aws.awscloud.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/s3bucket")
@CrossOrigin("*")
public class BucketController {


    private BucketService service;

    public BucketController(BucketService service) {
        this.service = service;
    }


    @PostMapping("/add/{bucketName}")
    public ResponseEntity<String> createBucket(@PathVariable String bucketName){
        return new ResponseEntity<>(service.createBucket(bucketName),HttpStatus.OK);
    }

    @PostMapping(path = "/upload/file/{bucketName}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file,
                                             @PathVariable String bucketName){
        return new ResponseEntity<>(service.uploadFile(file, bucketName),HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/file/{bucketName}/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String bucketName,@PathVariable String fileName)
    {
        return new ResponseEntity<>(service.deleteFile(bucketName,fileName),HttpStatus.OK);
    }

    @DeleteMapping("/delete/bucket/{bucketName}")
    public ResponseEntity<String> deleteBucket(@PathVariable String bucketName) {
        return new ResponseEntity<>(service.deleteBucket(bucketName), HttpStatus.OK);
    }

    @GetMapping("/show/buckets")
    public ResponseEntity<Map<String, List<String>>> showAllBuckets(){
        return new ResponseEntity<>(service.listBuckets(),HttpStatus.OK);
    }

}
