import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.DirectoryNotEmptyException;

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
			pathName = pathName.resolve(file.getFileName().toString());
			System.out.println("Directory to move is  " + pathName);
			moveFile(file, pathName);
			return ;
		}
		copyFile(file, pathName);
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

	private void copyFile(Path src, Path dest) {
		try {
			Files.copy(src, dest, REPLACE_EXISTING);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		if (Files.exists(dest)) {
			try {
				Files.delete(src);
			} catch (NoSuchFileException ex) {
				System.err.format("%s: no such" + " file or directory%n", src);
			} catch (DirectoryNotEmptyException ex) {
				System.err.format("%s not empty%n", src);
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
