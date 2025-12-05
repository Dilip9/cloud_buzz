package gouri.aws.awscloud.controller;

import gouri.aws.awscloud.service.BucketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Tag(name = "Buckets", description = "Operations for S3 buckets")
@RestController
@RequestMapping("/v1/s3bucket")
@CrossOrigin("*")
public class BucketController {


    private BucketService service;

    public BucketController(BucketService service) {
        this.service = service;
    }


    @Operation(summary = "Create bucket", description = "Create a new S3 bucket")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Bucket created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @io.swagger.v3.oas.annotations.media.Content)
    })
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

    @Operation(summary = "List files based on buckets", description = "Returns a list of files")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned"),
            @ApiResponse(responseCode = "500", description = "Server error", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @DeleteMapping(path="/delete/file/{bucketName}/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String bucketName,@PathVariable String fileName)
    {
        return new ResponseEntity<>(service.deleteFile(bucketName,fileName),HttpStatus.OK);
    }

    @Operation(summary = "Delete bucket", description = "Delete an existing bucket")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Deleted"),
            @ApiResponse(responseCode = "404", description = "Not found", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @DeleteMapping("/delete/bucket/{bucketName}")
    public ResponseEntity<String> deleteBucket(@PathVariable String bucketName) {
        return new ResponseEntity<>(service.deleteBucket(bucketName), HttpStatus.OK);
    }

    @Operation(summary = "List buckets", description = "Returns a list of buckets")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned"),
            @ApiResponse(responseCode = "500", description = "Server error", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @GetMapping("/show/buckets")
    public ResponseEntity<Map<String, List<String>>> showAllBuckets(){
        return new ResponseEntity<>(service.listBuckets(),HttpStatus.OK);
    }

}
