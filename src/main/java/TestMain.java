import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import redis.clients.jedis.Jedis;

import java.util.function.Consumer;

public class TestMain {

    public static void main(String[] args){
//        Jedis jedis = new Jedis("redis-12243.c244.us-east-1-2.ec2.cloud.redislabs.com", 12243);
//        jedis.auth("cCW8XVNtAXmE52pi0otZt62yxhZAd1Zl");
//        jedis.del("foo");
//        String value = jedis.get("foo");
//        System.out.println(value);
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("nosql");
        MongoCollection<Document> coll = database.getCollection("sarath");
        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(final Document document) {
                System.out.println(document.toJson());
            }
        };
        coll.find().forEach(printConsumer);
    }
}
