public interface TransactionsList {
	
	public String addTransaction(User payee, User sender, int amount, CategoryOfTranslation translation);

	public void removeTransaction(String id);

	public void printTransactions();
}
