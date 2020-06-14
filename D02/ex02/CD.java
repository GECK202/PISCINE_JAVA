import java.nio.file.Files;
import java.nio.file.Path;

public class CD {
	public Path goTo(String[] command, Path currentDir) {
		Path newPath;
		if (command.length == 1) {
			System.err.println("Not enough parameters!");
			return currentDir;
		}
		else if (command.length > 2) {
			System.err.println("Too many parameters!");
			return currentDir;
		}
		try {
			newPath = currentDir.resolve(command[1]).normalize();
			if (!Files.isDirectory(newPath)) {
				System.err.println(newPath + " is not directory!");
				return currentDir;
			}
			System.out.println(newPath);
			return newPath;
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return currentDir;
    }
}
