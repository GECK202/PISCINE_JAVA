
import java.io.IOException;
import java.util.Scanner;

public class Game  {

	public void UpdateGame() throws IOException {
		ClearTerminal();
	}

	public void ClearTerminal() throws IOException {

		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo \"\\e[2J\\e[0;0H\"");
		Process process = processBuilder.start();
		Scanner sc = new Scanner(process.getInputStream());
		while (sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	public void SetFonColor() throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo \"\\e[1;100;93m\"");
		Process process = processBuilder.start();
		Scanner sc = new Scanner(process.getInputStream());
		while (sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	public void ResetFonColor() throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo \"\\e[0;40;37m\"");
		Process process = processBuilder.start();
		Scanner sc = new Scanner(process.getInputStream());
		while (sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	public void SetCursor(String x, String y) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo \"\\e[" + x + ";" + y + "H\"");
		Process process = processBuilder.start();
		Scanner sc = new Scanner(process.getInputStream());
		while (sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	public void PrintHello() throws IOException {
		String  s ="";
		s += " _     _ _______ _       _       _____     _  _  _  _____  ______  _____        \n";
		s += "| |   | (_______) |     | |     / ___ \\   | || || |/ ___ \\(_____ \\(____ \\       \n";
		s += "| |__ | |_____  | |     | |    | |   | |  | || || | |   | |_____) )_   \\ \\      \n";
		s += "|  __)| |  ___) | |     | |    | |   | |  | ||_|| | |   | (_____ (| |   | |     \n";
		s += "| |   | | |_____| |_____| |____| |___| |  | |___| | |___| |     | | |__/ /      \n";
		s += "|_|   |_|_______)_______)_______)_____/    \\______|\\_____/      |_|_____/       \n";
		s += "                                                                                ";
		ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo \"\\e[1;100;93m"+s+"\\e[0m\"");
		Process process = processBuilder.start();
		Scanner sc = new Scanner(process.getInputStream());
		while (sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

	public int GetInput(){
		Scanner sc = new Scanner(System.in);
		int kode;
		while (true) {
			if (sc.hasNextInt()){
				kode = sc.nextInt();
				if (((kode >= 0) && (kode <= 3)) || (kode == 9)) {
					break ;
				}
			}
			System.out.println("Put number: 0 to left; 1 to up; 2 to right; 3 to down; 9 to exit");
		}
		return kode;
	}
}
