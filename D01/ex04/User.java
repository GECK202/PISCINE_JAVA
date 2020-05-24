public class User {
	private int id;
	private String name;
	private int startBalance;
	private int balance;
	private TransactionsList trList;

	public User(String name, int balance) {
		this();
		setName(name);
		setBalance(balance);
		startBalance = this.balance;
	}

	public User() {
		id = UserIdsGenerator.getInstance().generateId();
		startBalance = 0;
		balance = 0;
		trList = new TransactionsLinkedList();
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

	public void addTransaction(Transaction transaction) {
		trList.addTransaction(transaction);
	}

	public void removeTransaction(String id) {
		trList.removeTransaction(id);
	}

	public TransactionsList getTransactionsList () {
		return trList;
	}
}
