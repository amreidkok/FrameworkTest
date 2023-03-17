package Utilities;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonDataHelper {

	public static String[] readjson(String filepath,String node) throws IOException, org.json.simple.parser.ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(filepath);
		Object obj = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray array = (JSONArray) jsonObject.get(node);
		String arr[] = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			JSONObject users = (JSONObject) array.get(i);
			String username = (String) users.get("username");
			String password = (String) users.get("password");
			arr[i] = username+","+password;
		}
		return arr;
	}
}