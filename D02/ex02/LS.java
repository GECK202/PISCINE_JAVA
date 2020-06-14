import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;

public class LS {
	public void showFiles(String[] command, Path dir) {		
		if (command.length != 1) {
			System.err.println("arguments not allowed!");
			return ;
		}
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) {
				System.out.println(file.getFileName() + " " + getSize(file));
			}
		} catch (IOException | DirectoryIteratorException ex) {
			System.err.println(ex);
		}
	}

	private String getSize(Path file) {
		long size;
		String[] capacity = new String[] {"B", "KB", "MB", "GB", "TB"};
		int iterator = 0;;
		if (Files.isDirectory(file)){
			return "dir";
		}
		try {
			size = Files.size(file);
			while (size > 1024) {
				size /= 1024;
				++iterator;
			}
			if (iterator > capacity.length - 1) {
				iterator = capacity.length - 1;
			}
			return String.valueOf(size) + " " + capacity[iterator];
		} catch(IOException ex) {
			System.err.println(ex);
		}
		return ("error!");
	}
}
