package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App {

    public static void main(String[] args) {

        // Connect to MongoDB on the local system.
        // MongoDB is running on port 27000.
        MongoClient mongoClient = new MongoClient("localhost", 27000);

        // Get database.
        // MongoDB will create the database when data is first inserted.
        MongoDatabase database = mongoClient.getDatabase("mydb");

        // Get collection.
        MongoCollection<Document> collection =
                database.getCollection("test");

        // Create document.
        Document doc = new Document("name", "Kevin Sim")
                .append("class", "DevOps")
                .append("year", "2024")
                .append(
                        "result",
                        new Document("CW", 95)
                                .append("EX", 85)
                );

        // Insert document into MongoDB.
        collection.insertOne(doc);

        // Find the first document.
        Document myDoc = collection.find().first();

        // Display document.
        if (myDoc != null) {
            System.out.println(myDoc.toJson());
        }

        // Close MongoDB connection.
        mongoClient.close();
    }
}