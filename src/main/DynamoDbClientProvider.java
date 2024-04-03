package main;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbClientProvider {

    public static AmazonDynamoDB LOCAL_CLIENT = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    public static AmazonDynamoDB REMOTE_CLIENT = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-2").build();
}
