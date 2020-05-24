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

		System.out.println("------add tr---------------");
		System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));

		Transaction[] trArr = service.getTransactions(1);
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

		System.out.println("------------------------");
		System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));
		Transaction[] trArr2 = service.getTransactions(2);
		for (int i = 0; i < trArr2.length; i++) {
			System.out.println(trArr2[i].getPayee().getName() + "->" + trArr2[i].getSender().getName() + ", " + trArr2[i].getStringAmount() + ", " + trArr2[i].getTranslation() + ", " + trArr2[i].getId());
		}

		//service.removeTransaction(1, trArr[0].getId());
		service.removeTransaction(1, trArr[2].getId());
		service.removeTransaction(1, trArr[1].getId());
		service.addTransaction(2, 1, 50);
		//service.removeTransaction(1, trArr[1].getId());

		//System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		//System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());

		//System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));
		//System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));


		System.out.println("-------rem add tr-------------");
		System.out.println(service.getUserName(1) + " " + service.getUserBalance(1));

		Transaction[] trArr3 = service.getTransactions(1);
		for (int i = 0; i < trArr3.length; i++) {
			System.out.println(trArr3[i].getPayee().getName() + "->" + trArr3[i].getSender().getName() + ", " + trArr3[i].getStringAmount() + ", " + trArr3[i].getTranslation() + ", " + trArr3[i].getId());
		}

		System.out.println("------------------------");
		System.out.println(service.getUserName(2) + " " + service.getUserBalance(2));
		Transaction[] trArr4 = service.getTransactions(2);
		for (int i = 0; i < trArr4.length; i++) {
			System.out.println(trArr4[i].getPayee().getName() + "->" + trArr4[i].getSender().getName() + ", " + trArr4[i].getStringAmount() + ", " + trArr4[i].getTranslation() + ", " + trArr4[i].getId());
		}

	}
}

enum CategoryOfTranslation {
	INCOME,
	OUTCOME;
}
