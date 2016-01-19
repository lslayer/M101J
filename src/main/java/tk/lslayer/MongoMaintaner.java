package tk.lslayer;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoMaintaner {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("students");
		MongoCollection<Document> collection = db.getCollection("grades");
		BasicDBObject dbObject=new BasicDBObject();
		dbObject.append("status","ACTIVE");
		
		List<Integer> all = collection.distinct("student_id", Integer.class).into(new ArrayList<Integer>());
		for (Integer current : all ) {
			
			System.out.println("Looking for data with sudentid: " + current);
			List<Document> curnet_student_data = collection.find(new Document("student_id", current)).into(new ArrayList<Document>());
			
			
			
		}
	}

}
