import java.io.IOException;

public class Map {
	private int size;
	private String[][] map;
	private String symbol;
	private boolean bonus;

	public Map (int size, boolean bonus) {
		this.size = size;
		this.bonus = bonus;
		if (!bonus) {
			symbol = ". ";
		}
		else {
			symbol = "  ";
		}
		map = new String[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = symbol;
			}
		}
	}

	public int GetSize(){
		return size;
	}

	public void SetSize(int size) {
		this.size = size;
	}

	public void SetSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String GetSymbol() {
		return symbol;
	}

	public String GetCell(int x, int y) {
		return map[x][y];
	}

	public void SetCell(int x, int y, String symbol) {
		map[x][y] = symbol;
	}

	public boolean isEmptyCell(int x, int y) {
		if (map[x][y].equals(symbol)) {
			return true;
		}
		return false;
	}



	public void DrawMap(Game game)  throws IOException {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
} 
