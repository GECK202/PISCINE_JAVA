import java.util.UUID;

public class Transaction {
	private String id;
	private User payee;
	private User sender;
	private CategoryOfTranslation translation;
	private int amount;

	public Transaction(User payee, User sender, int amount, CategoryOfTranslation translation) {
		this();
		setPayee(payee);
		setSender(sender);
		setAmount(amount);
		setTranslation(translation);
	}

	public Transaction() {
		id = UUID.randomUUID().toString();
	}

	public void setPayee(User payee) {
		this.payee = payee;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private void setTranslation(CategoryOfTranslation translation) {
		if (amount < 0) {
			this.translation = CategoryOfTranslation.OUTCOME;
		}
		else if (amount > 0) {
			this.translation = CategoryOfTranslation.INCOME;
		}
		else {
			this.translation = translation;
		}
		
	}

	public CategoryOfTranslation getTranslation() {
		return translation;
	}

	public User getPayee() {
		return payee;
	}

	public User getSender() {
		return sender;
	}

	public String getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

	public String getStringAmount() {
		if (amount > 0) {
			return "+" + String.valueOf(amount);
		}
		return String.valueOf(amount);
	}
}
