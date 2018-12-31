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
		// create a document builder
		InputStream is = jsonTest.class.getResourceAsStream(filename);
		File f = new File(jsonTest.class.getResource(filename).getFile());
		Scanner scanner = new Scanner(f);
		String line;
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();
		JSONTokener jt = new JSONTokener(is);
		//Object o = jt.nextValue();
		while (jt.more()) {
			System.out.println(jt.nextValue().toString());
		}
	}
}
