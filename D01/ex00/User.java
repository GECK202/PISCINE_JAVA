import java.util.UUID;

public class User {
	private String id = UUID.randomUUID().toString();
	private String name = null;
	private int balance;

	public boolean isSetUser(String name, int balance) {
		if (this.name == null) {
			SetUser(name, balance);
			return true;
		}
		return false;
	}

	private void SetUser(String name, int balance) {
		this.name = name;
		if (balance < 0) {
			balance = 0;
		}
		this.balance = balance;
	}

	public int GetBalance() {
		return balance;
	}

	public String GetName() {
		return name;
	}

	public String GetID() {
		return id;
	}
}
