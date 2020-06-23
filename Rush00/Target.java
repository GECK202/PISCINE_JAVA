public class Target {
	private Item item;
	private boolean bonus;

	public Target(Map map, boolean bonus) {
		item = new Item (map);
		this.bonus = bonus;
		if (!bonus) {
			item.SetSymbol("O ");
		}
		else {
			item.SetSymbol("🚪");
		}
		map.SetCell(item.GetX(), item.GetY(), item.GetSymbol());
	}

	public String GetSymbol() {
		return (item.GetSymbol());
	}
}
