package hashMap;

import helper.Util;

public class PLZServiceTest {

	public static void main(String[] args) {
		PLZService plzService = new PLZService("/users/capa/plz_verzeichnis_v2.csv");
		String str = Util.getUserInput();
		Integer key = Integer.parseInt(str);
		System.out.println("[" + key + "] = [" + plzService.search(key) + "]");
		System.out.println("There are " + plzService.count() + " postal codes in switzerland.");

	}

}
