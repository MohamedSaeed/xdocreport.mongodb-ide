import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class TestMongo {

	public static void main(String[] args) {
		try {
			// https://mongohq.com/databases/testangelo
			MongoURI uri = new MongoURI("mongodb://a:a@staff.mongohq.com:10093");
			Mongo mongo = new Mongo(uri);
			DB db = mongo.getDB("testangelo");
			boolean b = db.authenticate("a",
					"a".toCharArray());
			System.err.println(b);
			DBCollection col = db.getCollection("person");
			System.err.println(col);
			col.findOne();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
