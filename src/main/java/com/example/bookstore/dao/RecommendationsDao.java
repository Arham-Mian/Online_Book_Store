package com.example.bookstore.dao;

import com.example.bookstore.config.Dynamo;
import com.example.bookstore.model.Recommendation;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecommendationsDao {

    private static final String TABLE = "RecommendedBooks"; // PK: userId (S), SK: rank (N)

    public void createTableIfNotExists() {
        DynamoDbClient ddb = Dynamo.client();

        // Check if table exists
        try {
            ddb.describeTable(DescribeTableRequest.builder().tableName(TABLE).build());
            return; // exists
        } catch (ResourceNotFoundException ignore) {}

        CreateTableRequest req = CreateTableRequest.builder()
                .tableName(TABLE)
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("userId").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("rank").attributeType(ScalarAttributeType.N).build()
                )
                .keySchema(
                        KeySchemaElement.builder().attributeName("userId").keyType(KeyType.HASH).build(), // partition
                        KeySchemaElement.builder().attributeName("rank").keyType(KeyType.RANGE).build()   // sort
                )
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L).writeCapacityUnits(5L).build())
                .build();

        ddb.createTable(req);
        ddb.waiter().waitUntilTableExists(DescribeTableRequest.builder().tableName(TABLE).build());
    }

    public void seedForUser(String userId) {
        DynamoDbClient ddb = Dynamo.client();

        // if already has items, skip
        QueryResponse qr = ddb.query(QueryRequest.builder()
                .tableName(TABLE)
                .keyConditionExpression("userId = :u")
                .expressionAttributeValues(Map.of(":u", AttributeValue.builder().s(userId).build()))
                .limit(1)
                .build());
        if (qr.hasItems() && !qr.items().isEmpty()) return;

        // Sample 5 recs (link to known titles)
        List<Recommendation> recs = List.of(
                new Recommendation(userId, 1, 1L, "Clean Code", "Robert C. Martin"),
                new Recommendation(userId, 2, 2L, "Design Patterns", "Erich Gamma"),
                new Recommendation(userId, 3, 3L, "Harry Potter and the Philosopher's Stone", "J.K. Rowling"),
                new Recommendation(userId, 4, 1L, "Clean Code", "Robert C. Martin"), // repeating allowed for demo
                new Recommendation(userId, 5, 2L, "Design Patterns", "Erich Gamma")
        );

        for (Recommendation r : recs) {
            ddb.putItem(PutItemRequest.builder()
                    .tableName(TABLE)
                    .item(Map.of(
                            "userId", AttributeValue.builder().s(r.getUserId()).build(),
                            "rank", AttributeValue.builder().n(Integer.toString(r.getRank())).build(),
                            "bookId", AttributeValue.builder().n(Long.toString(r.getBookId())).build(),
                            "title", AttributeValue.builder().s(r.getTitle()).build(),
                            "author", AttributeValue.builder().s(r.getAuthor()).build()
                    ))
                    .build());
        }
    }

    public List<Recommendation> topN(String userId, int n) {
        DynamoDbClient ddb = Dynamo.client();
        QueryResponse qr = ddb.query(QueryRequest.builder()
                .tableName(TABLE)
                .keyConditionExpression("userId = :u")
                .expressionAttributeValues(Map.of(":u", AttributeValue.builder().s(userId).build()))
                .scanIndexForward(true) // rank ascending
                .limit(n)
                .build());

        List<Recommendation> out = new ArrayList<>();
        for (Map<String, AttributeValue> m : qr.items()) {
            Recommendation r = new Recommendation();
            r.setUserId(m.get("userId").s());
            r.setRank(Integer.parseInt(m.get("rank").n()));
            if (m.containsKey("bookId")) r.setBookId(Long.parseLong(m.get("bookId").n()));
            if (m.containsKey("title")) r.setTitle(m.get("title").s());
            if (m.containsKey("author")) r.setAuthor(m.get("author").s());
            out.add(r);
        }
        return out;
    }
}
