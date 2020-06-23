//import src.Game;
import java.io.IOException;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) throws IOException
	{
		
		int enemiesCount = -1;
		int wallsCount = -1;
		int size = -1;
		String errorMessage = "";
		boolean bonus = false;
		Game game;
		Map map;
		Enemy[] enemies;
		Wall[] walls;
		Target target;
		Player player;

		int x;
		int y;

		for (String str : args) {
			String[] sArray;
			try {
				if (str.contains("--enemiesCount=") && (enemiesCount == -1)) {
					sArray = str.split("=");
					enemiesCount = Integer.parseInt(sArray[1]);
					if (enemiesCount < 0) {
						errorMessage = "Enemies count must be 0 and more!";
						break ;
					}
				}
				else if (str.contains("--wallsCount=") && (wallsCount == -1)) {
					sArray = str.split("=");
					wallsCount = Integer.parseInt(sArray[1]);
					if (wallsCount < 0) {
						errorMessage = "Walls count must be 0 and more!";
						break ;
					}
				}
				else if (str.contains("--size=") && (size == -1)) {
					sArray = str.split("=");
					size = Integer.parseInt(sArray[1]);
					if (size < 2) {
						errorMessage = "Size must be 2 and more!";
						break ;
					}
				}
				else if (str.contains("--bonus")) {
					bonus = true;
				}
				else {
					errorMessage = str + " is not valid argument!\n";
					errorMessage += "Valid arguments: --enemiesCount=[number] --wallsCount=[number] --size=[number]";
					break ;
				}
			}
			catch (Exception e) {
				errorMessage = "Argument must be a number!";
				break ;
			}
		}
		if (enemiesCount == -1) {
			errorMessage = "Enemies count has not been entered!";
		}
		if (wallsCount == -1) {
			errorMessage = "Walls count has not been entered!";
		}
		if (size == -1) {
			errorMessage = "Size has not been entered!";
		} 
		if (enemiesCount + wallsCount + 2 > size * size) {
			errorMessage = "Items cannot be placed on the map!";
		}
		if (!errorMessage.equals("")){
			System.out.println("IllegalArgument\n" + errorMessage);
			System.exit(-1);
		}

		map = new Map(size, bonus);	

		enemies = new Enemy[enemiesCount];
		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy(map, bonus);
		}

		walls = new Wall[wallsCount];
		for (int i = 0; i < walls.length; i++) {
			walls[i] = new Wall(map, bonus);
		}

		target = new Target(map, bonus);
		player = new Player(map, bonus);
		game = new Game();
		game.ClearTerminal();
		//game.PrintHello();

		int command;
		while (true) {
			game.ClearTerminal();
			if (bonus) {
				game.SetFonColor();
			}
			map.DrawMap(game);
			game.ResetFonColor();
			System.out.println("Put number: 0 to left; 1 to up; 2 to right; 3 to down; 9 to exit");
			//game.ClearTerminal();
			command = game.GetInput();
			if (command >= 0 && command <= 3) {
				if (!player.isMove(command, map)){
					break ;
				}
			}
			else if (command == 9) {
				game.ClearTerminal();
				break ;
			}
			
		}
		
		

/*		
		sArray = args[0].split("=");
		try {
            enemiesCount = 
        }
        catch (Exception e) {
            System.out.println("IllegalArgument");
            System.exit(-1);
        }

		int i = 0;
		for (String str : args) {
			String[] sArray = str.split("=");
			arg[i++] = Integer.parseInt(sArray[1]);
			System.out.println(arg[i - 1]);
        }



		Map map = new Map(arg[0]);
		map.DrawMap();




		Enemy[] enemies;
		arr = new Enemy[n];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = new Enemy();
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j].GetSymbol());
		}
		System.out.println(); */
        //String osName = System.getProperty("os.name");
        //System.out.println(osName);
	}

}	
