import java.io.File;

public class LS {
	public void showFiles(String nameFolder) {
		File curPath = new File(nameFolder);
		File[] files = curPath.listFiles();
		String strSize;
		long size;
		for (int i = 0; i < files.length; i++) {
			if (files[i].length() < 1024) {
				strSize = String.valueOf(files[i].length()) + "\t b";
			}
			else {
				size = files[i].length() / 1024;
				if (size  < 1024) {
					strSize = String.valueOf(size) + "\t Kb";
				}
				else {
					size = size / 1024;
					if (size  < 1024) {
						strSize = String.valueOf(size) + "\t Mb";
					}
					else {
						strSize = String.valueOf(size / 1024) + "\t Gb";
					}
				}
			}
			System.out.println(files[i].getName() + "\t" + strSize);
		}
	}
}
