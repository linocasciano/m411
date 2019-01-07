package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class jsonTest {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "/resources/music.json";
		InputStream is = jsonTest.class.getResourceAsStream(filename);
		JSONTokener jt = new JSONTokener(is);
		JSONArray ja = (JSONArray)jt.nextValue();
		for (int i=0; i<ja.length(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			System.out.println("Artist = [" + jo.get("ARTIST") + "]");
		}
	}
}
