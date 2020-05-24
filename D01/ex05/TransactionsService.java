public class TransactionsService {

	private UsersArrayList userList;

	public TransactionsService() {
		userList = new UsersArrayList();
	}

	 public void addUser(String userName, int startBalance) {
		 userList.addUser(userName, startBalance);
	 }

  public String getUserName(int userId) {
  	return (userList.getUser(userId).getName());
  }

  public int getUserBalance(int userId) {
  	return (userList.getUser(userId).getBalance());
  }

  public void addTransaction(int userId1, int userId2, int amount) {
		User user1;
		User user2;
		Transaction transaction;

		if (amount <= 0) {
			throw new IllegalTransactionException("Amount must be more than 0!");
		}
		user1 = userList.getUser(userId1);
		if ((user1.getBalance() - amount) < 0) {
			throw new IllegalTransactionException("Insufficient funds!");
		}
		user2 = userList.getUser(userId2);
		transaction = new Transaction(user1, user2, -amount, CategoryOfTranslation.OUTCOME);
		user1.addTransaction(transaction);
		user2.addTransaction(new Transaction(user2, user1, amount, CategoryOfTranslation.INCOME, transaction.getId()));
		user1.setBalance(user1.getBalance() - amount);
		user2.setBalance(user2.getBalance() + amount);
	}

  public Transaction[] getTransactions(int userId) {
  	return userList.getUser(userId).getTransactionsList().toArray();
  }

  public void removeTransaction(int userId, String transactionId) {
  	userList.getUser(userId).removeTransaction(transactionId);
  }

	public Transaction[] getIncorrectTransactions() {
		TransactionsList incorrectList = new TransactionsLinkedList();
		Transaction[] trArr = userList.getUser(1).getTransactionsList().toArray();
		for (int i = 0; i < trArr.length; i++) {
			incorrectList.addTransaction(trArr[i]);
		}
		for (int i = 1; i < userList.getCountUsers(); i++) {
			trArr = userList.getUser(i + 1).getTransactionsList().toArray();
			Transaction[] addedTrArr = incorrectList.toArray();
			for (int j = 0; j < trArr.length; j++) {
				boolean addFlag = true;
				String id = trArr[j].getId();
				for (int k = 0; k < addedTrArr.length; k++) {
					if (id.equals(addedTrArr[k].getId())) {
						incorrectList.removeTransaction(id);
						addFlag = false;
						break ;
					}
				}
				if (addFlag) {
					incorrectList.addTransaction(trArr[j]);
				}
			}
		}
		return incorrectList.toArray();
	}
}
