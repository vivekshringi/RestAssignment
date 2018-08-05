package skeleton;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {

	public static Object readJSON(String d, String filename) {
		JSONObject jsonObject = null;
		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filename));
			jsonObject = (JSONObject) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject.get(d);

	}
	
	public static String gettingValueFromJSONObject(Object o, String key) {
		JSONObject jsonObject1 = (JSONObject) o ;
		return (String) jsonObject1.get(key);
	}

}
