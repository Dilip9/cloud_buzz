package gouri.aws.awscloud.utils;

public final class AWSBucketConstant {

    private AWSBucketConstant() {
        // private constructor to prevent instantiation
    }
    public static final String B_CODE_409 = "Bucket cannot be deleted because it is currently in use. ";
    public static final String B_CODE_404 = "Bucket not found. ";
    public static final String B_CODE_200 = "Successful operation. ";
    public static final String B_CODE_201 = "Bucket created successfully with name: ";
    public static final String B_CODE_500 = "Internal server error while processing the bucket. ";

    public static final String F_CODE_404 = "File not found. ";
    public static final String F_CODE_200 = "Successful operation. ";
    public static final String F_CODE_409 = "File cannot be uploaded because it already exists. ";
    public static final String F_CODE_500 = "Internal server error while processing the file. ";



}
