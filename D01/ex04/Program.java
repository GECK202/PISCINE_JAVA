public class Program {

	public static void main(String[] args)
	{
		TransactionsService service = new TransactionsService();

		service.addUser("John", 777);
		service.addUser("Mike", 150);

		System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));
		System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));


		service.addTransaction(1, 2, 50);
		service.addTransaction(2, 1, 150);
		service.addTransaction(1, 2, 10);

		System.out.println("State after add transaction:");
		System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));
		Transaction[] trArr = service.getTransactions(1);
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

		service.removeTransaction(1, trArr[2].getId());
		service.removeTransaction(1, trArr[1].getId());
		System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));
		trArr = service.getTransactions(2);
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

		service.addTransaction(2, 1, 50);

		System.out.println("State after remove and add transaction:");
		System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));
		trArr = service.getTransactions(1);
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}
		System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));
		trArr = service.getTransactions(2);
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}
		System.out.println("Incorrect transaction:");
		trArr = service.getIncorrectTransactions();
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

	}
}
