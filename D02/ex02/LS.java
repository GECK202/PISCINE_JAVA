import java.io.File;

public class LS {
	public void showFiles(String[] command, String nameFolder) {
		File curPath = new File(nameFolder);
		File[] files = curPath.listFiles();
		String strSize;
		double size;
		for (int i = 0; i < files.length; i++) {
			if (files[i].length() < 1024) {
				strSize = String.valueOf((double)files[i].length()) + " B";
			}
			else {
				size = files[i].length() / 1024;
				if (size  < 1024) {
					strSize = String.valueOf(size) + " Kb";
				}
				else {
					size = size / 1024;
					if (size  < 1024) {
						strSize = String.valueOf(size) + " Mb";
					}
					else {
						strSize = String.valueOf(size / 1024) + " Gb";
					}
				}
			}
			System.out.println(files[i].getName() + " " + strSize);
		}
	}
}
