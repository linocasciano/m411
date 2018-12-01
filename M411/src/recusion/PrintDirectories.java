package recusion;

import java.io.File;

public class PrintDirectories {

	public static void main(String[] args) {
		printDirectories(new File("C:\\Daten\\"));
	}
	
	public static void printDirectories(File f) {
		//System.out.println("Checking " + f);
		if (!f.isDirectory()) {
			return;
		} else {
			System.out.println(f);
		}
		File[] fileList = f.listFiles();
		if (fileList == null) {
			// Permission problem?
			//System.out.println("Filelist is null");
			return;
		}
		for (File g : fileList) {
			printDirectories(g);
		}
	}

}
