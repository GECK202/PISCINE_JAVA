import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Path currentPath;
		String commandLine;
		LS ls = new LS();
		MV mv = new MV();
		CD cd = new CD();
		String[] arg;
		Scanner sc;
		String[] command;
		if (args.length != 1) {
			System.err.println("Argument must be one and content path in format: \"--current-folder=...\"");
			System.exit(1);
		}
		if (!args[0].startsWith("--current-folder=")) {
			System.err.println("Argument must be in format: \"--current-folder=...\"");
			System.exit(1);
		}
		arg = args[0].split("=");
		if (arg.length != 2) {
			System.err.println("Argument must be in format: \"--current-folder=...\"");
			System.exit(1);
		}
		if (arg[1].equals("")) {
			System.err.println("Argument must be in format: \"--current-folder=...\"");
			System.exit(1);
		}
		currentPath =Paths.get(arg[1]);
		if (Files.exists(currentPath)) {
			if (!Files.isDirectory(currentPath)) {
				currentPath = currentPath.getParent();
			}
		}
		else {
			currentPath = currentPath.getParent();
			if (!Files.exists(currentPath)) {
				System.err.println("Argument must be in format: \"--current-folder=...\"");
				System.exit(1);
			}
		}
		System.out.println(currentPath);
		sc = new Scanner(System.in);
		while (true) {
			System.out.print("-> ");
			commandLine = sc.nextLine();
			command = commandLine.split(" ");
			if (command[0].equals("exit")) {
				break ;
			}
			else if (command[0].equals("cd")) {
				currentPath = cd.goTo(command, currentPath);
			}
			else if (command[0].equals("ls")) {
				ls.showFiles(command, currentPath);
			}
			else if (command[0].equals("mv")) {
				mv.parseArguments(command, currentPath);
			}
			else {
				System.out.println("Invalid command!");
			}
		}
		sc.close();
	}
}
