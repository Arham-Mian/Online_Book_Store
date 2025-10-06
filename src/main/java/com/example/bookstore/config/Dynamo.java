package com.example.bookstore.config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

public class Dynamo {

    // Local endpoint
    private static final String DEFAULT_ENDPOINT = "http://localhost:8000";
    private static final String DEFAULT_REGION = "us-east-1";

    private static DynamoDbClient client;

    public static DynamoDbClient client() {
        if (client == null) {
            client = DynamoDbClient.builder()
                    .endpointOverride(URI.create(getEnv("DDB_ENDPOINT", DEFAULT_ENDPOINT)))
                    .region(Region.of(getEnv("DDB_REGION", DEFAULT_REGION)))
                    .credentialsProvider(
                            StaticCredentialsProvider.create(
                                    AwsBasicCredentials.create("dummy", "dummy")
                            )
                    )
                    .httpClientBuilder(UrlConnectionHttpClient.builder())
                    .build();
        }
        return client;
    }

    private static String getEnv(String k, String def) {
        String v = System.getenv(k);
        return (v == null || v.isBlank()) ? def : v;
    }
}
