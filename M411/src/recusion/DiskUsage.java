package recusion;

import java.io.File;

public class DiskUsage {

	public static void main(String[] args) {
		long size = diskUsage(new File("C:\\Temp\\A"));
		System.out.println("Total size is [" + size + "] Bytes.");

	}

	public static long diskUsage(File f) {
		long diskUsage = 0;
		if (!f.isDirectory()) { diskUsage = f.length(); }
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
