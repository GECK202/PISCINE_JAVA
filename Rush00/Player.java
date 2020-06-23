public class Player {
	private Item item;
	private boolean bonus;

	public Player(Map map, boolean bonus) {
		item = new Item (map);
		this.bonus = bonus;
		if (!bonus) {
			item.SetSymbol("o ");
		}
		else {
			item.SetSymbol("😀");
		}
		map.SetCell(item.GetX(), item.GetY(), item.GetSymbol());
	}

	public String GetSymbol() {
		return (item.GetSymbol());
	}

	public boolean isMove(int direction, Map map) {
		int x = item.GetX();
		int y = item.GetY();
		int size = map.GetSize();
		if (direction == 0) {
			if (x > 0 && map.isEmptyCell(x - 1, y)) {
				this.Move(x, y, x - 1, y, map);
				return true;
			}
		}
		else if (direction == 1) {
			if (y > 0 && map.isEmptyCell(x, y - 1)) {
				this.Move(x, y, x, y - 1, map);
				return true;
			}
		}
		else if (direction == 2) {
			if (x < size - 1 && map.isEmptyCell(x + 1, y)) {
				this.Move(x, y, x + 1, y, map);
				return true;
			}
		}
		else if (direction == 3) {
			if (y < size - 1 && map.isEmptyCell(x, y + 1)) {
				this.Move(x, y, x, y + 1, map);
				return true;
			}
		}
		return false;
	}

	public void Move(int x, int y, int targetX, int targetY, Map map) {
		item.SetXY(targetX, targetY);
		map.SetCell(targetX, targetY, item.GetSymbol());
		map.SetCell(x, y, map.GetSymbol());
	}
}
