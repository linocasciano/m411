package recusion;

import java.io.File;


/**
 * Adds up the sizes of the files in a directory and its subdirectories recursively.
 * It is a nice demonstration of how a value is passed up the call stack as the stack
 * Unwinds.
 */
public class DiskUsage {

	public static void main(String[] args) {
		String directory = "c:\\temp";
		long size = diskUsage(new File(directory));
		System.out.println("Total size is [" + size + "] Bytes.");
	}

	public static long diskUsage(File f) {
		long diskUsage = 0;
		if (f.isFile()) { diskUsage = f.length(); }
		System.out.println("Checking " + f);
		if (f.isDirectory()) {
			File[] fileList = f.listFiles();
			if (fileList != null) {
				for (File g : fileList) {
					diskUsage += diskUsage(g);
				}
			}
		}
		return diskUsage;
	}

}
