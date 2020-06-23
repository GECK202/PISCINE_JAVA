import java.util.Random;

public class Item {
	private String symbol;
	private int x;
	private int y;

	public Item (Map map) {
		Random random = new Random();
		do {
			y = random.nextInt(map.GetSize());
			x = random.nextInt(map.GetSize());
		} while (!map.isEmptyCell(x, y));
		
	}

	public void SetSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String GetSymbol() {
		return symbol;
	}

	public void SetXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int GetX() {
		return x;
	}

	public int GetY() {
		return y;
	}
}

