public class Wall {
	private Item item;
	private boolean bonus;

	public Wall(Map map, boolean bonus) {
		item = new Item (map);
		this.bonus = bonus;
		if (!bonus) {
			item.SetSymbol("# ");
		}
		else {
			item.SetSymbol("▒▒");
		}
		map.SetCell(item.GetX(), item.GetY(), item.GetSymbol());
	}

	public String GetSymbol() {
		return (item.GetSymbol());
	}
}
