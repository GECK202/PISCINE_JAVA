public class User {
	private int id;
	private String name;
	private int startBalance;
	private int balance;

	public User(int id, String name, int balance) {
		setId(id);
		setName(name);
		setBalance(balance);
		startBalance = this.balance;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setBalance (int balance) {
		if (balance < 0) {
			balance = 0;
		}
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getStartBalance() {
		return startBalance;
	}
}
