public class Enemy {
	private Item item;
	private boolean bonus;

	public Enemy(Map map, boolean bonus) {
		item = new Item (map);
		this.bonus = bonus;
		if (!bonus) {
			item.SetSymbol("x ");
		}
		else {
			item.SetSymbol("😱");
		}
		map.SetCell(item.GetX(), item.GetY(), item.GetSymbol());
	}

	public String GetSymbol() {
		return (item.GetSymbol());
	}
}
