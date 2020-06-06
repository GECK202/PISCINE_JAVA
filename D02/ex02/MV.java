import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MV {
	public void parseMV(Path currentPath, Scanner sc) {
		String fileName;
		String path;
		if (!sc.hasNext()){
			System.out.println("Not enough parameters!");
			return ;
		}
		fileName = sc.next();
		if (!sc.hasNext()) {
			System.out.println("Not enough parameters!");
			return ;
		}
		path = sc.next();
		if (sc.hasNext()) {
			System.out.println("Too many parameters!");
			return ;
		}
	}
	public void moveFile(String src, String dest ) {
		Path result = null;
		try {
			result =  Files.move(Paths.get(src), Paths.get(dest));
		} catch (IOException e) {
			System.out.println("Exception while moving file: " + e.getMessage());
		}
		if(result != null) {
			System.out.println("File moved successfully.");
		}
		else {
			System.out.println("File movement failed.");
		}
	}
}
