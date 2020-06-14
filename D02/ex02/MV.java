import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class MV {
	public void parseArguments(String[] command, Path currentPath) {
		Path file;
		Path pathName;
		if (command.length < 3) {
			System.out.println("Not enough parameters!");
			return ;
		}
		else if (command.length > 3) {
			System.out.println("Too many parameters!");
			return ;
		}
		file = currentPath.resolve(command[1]);
		if (!Files.exists(file) || Files.isDirectory(file)) {
			System.out.println("File " + file.getFileName() + " not found!");
			return ;
		}
		pathName = currentPath.resolve(command[2]).normalize();
		if (Files.isDirectory(pathName)) {
			System.out.println("Directory to move is  " + pathName.getFileName());
			moveFile(file, pathName);
			return ;
		}
		//else {
			System.out.println("is not directory");
		//}
		//fileName = command[1];

		//System.out.println(" mv OK");

		//pathName = command[2];

		//System.out.print("file="+file);
		//System.out.print(" from "+pathName);
		//System.out.println(" mv OK");

	}

	private void moveFile(Path src, Path dest) {
		Path result = null;
		try {
			result =  Files.move(src, dest);
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

	private void copyFile(String src, String dest ) {
		Path result = null;

		try {
            Files.copy(Paths.get(src), Paths.get(dest), REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

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

	private void renameFile(String src, String dest ) {
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
