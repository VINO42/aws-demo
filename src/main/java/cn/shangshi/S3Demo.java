package cn.shangshi;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.ByteArrayInputStream;


public class S3Demo {
    public static void main(String[] args) {
        System.out.println("开始进入main方法.....");
        AmazonS3 conn;
        String accessKey = "13448655";
        String secretKey = "IJcjfswDFRWQCHKhbyGKkRocToWuyUlH";
        String endpoint = "http://10.12.184.155:8000/";
        String bucketName = "test127";
        String key = "hello123.txt";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
        conn = new AmazonS3Client(credentials, clientConfig);
        conn.setEndpoint(endpoint);
        ByteArrayInputStream input = new ByteArrayInputStream("wo jiu ce shi yi xia222".getBytes());
        PutObjectResult putResl = conn.putObject(bucketName, key, input, new ObjectMetadata());
        System.out.println(putResl.getETag());
        System.out.println("main方法执行完毕.....");
    }
}
