import com.mongodb.MongoClient;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tefo-matshediso-tlotla on 2017/05/25.
 */
public class PrototypeMongoDB {
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection;

    public String connectToDatabaseServer(String host, int port){
        try {
            mongoClient = new MongoClient(host, port);
        }catch(MongoSocketOpenException e){
            return "Something is wrong with the port connection ";
        }

        return "Connections successful";
    }

    public List<String> listCollections(MongoDatabase mongoDatabase){
        List<String> listOfCollections = new ArrayList<>();
        for(String collectionName:mongoDatabase.listCollectionNames())
            listOfCollections.add(collectionName);
        return listOfCollections;
    }

    public MongoCollection getCollection(String collection){
        return mongoCollection = mongoDatabase.getCollection(collection);
    }


}
