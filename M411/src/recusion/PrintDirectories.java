package recusion;

import java.io.File;

public class PrintDirectories {

	public static void main(String[] args) {
		// printDirectories(new File("/users/capa"));
		//searchFile(new File("/users/capa/"), "test.rtf");
		printDirectories(new File("/users/capa/tmp"));
	}

	public static void printDirectories(File f) {
		// System.out.println("Checking " + f);
		if (!f.isDirectory()) {
			return;
		} else {
			//System.out.println(f);
		}
		File[] fileList = f.listFiles();
		if (fileList == null) {
			// Only files that can be read are listed.
			// System.out.println("Filelist is null");
			return;
		}
		for (File g : fileList) {
			printDirectories(g);
		}
		System.out.println(f);
	}

	public static void searchFile(File directory, String filename) {
		File[] fileList = directory.listFiles();
		if (fileList == null) {
			return; // only files that can be read are listed
		}
		for (File g : fileList) {
			//System.out.println("Checking for " + g.getName());
			if (g.isFile() && g.getName().equals(filename)) {
				System.out.println("File found in directory " + g.getParent());
			} 
			if (g.isDirectory()) {
				searchFile(g, filename);
			}
		}

	}

}
