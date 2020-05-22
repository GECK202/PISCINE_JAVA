import java.util.UUID;

public class Transaction {
	private String id = UUID.randomUUID().toString();
	private User payee = null;
	private User sender = null;
	private String translation = "";
	private int amount = 0;

	public boolean isSetTransaction(User payee, User sender, int amount) {
		if (this.payee == null && this.sender == null && amount != 0) {
			SetTransaction(payee, sender, amount);
			return true;
		}
		return false;
	}

	private void SetTransaction(User payee, User sender, int amount) {
		this.payee = payee;
		this.sender = sender;
		this.amount = amount;
		if (amount < 0) {
			translation = "OUTCOME";
		}
		else {
			translation = "INCOME";
		}
	}

	public String GetTranslation() {
		return translation;
	}

	public User GetPayee() {
		return payee;
	}

	public User GetSender() {
		return sender;
	}

	public String GetID() {
		return id;
	}

	public int GetAmount() {
		return amount;
	}
}
