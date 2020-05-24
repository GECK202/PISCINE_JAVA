public class Program {

	public static void main(String[] args)
	{
		UsersArrayList userList = new UsersArrayList();
		userList.addUser("John", 777);
		userList.addUser("Mike", 150);

		User usr1 = userList.getUser(1);
		User usr2 = userList.getUser(2);

		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());

		Transaction tr1 = new Transaction(usr1, usr2, 50, CategoryOfTranslation.INCOME);
		Transaction tr2 = new Transaction(usr1, usr2, -50, CategoryOfTranslation.INCOME);
		Transaction tr3 = new Transaction(usr1, usr2, 0, CategoryOfTranslation.INCOME);

		usr1.addTransaction(tr1);
		usr1.addTransaction(tr2);
		usr1.addTransaction(tr3);

		Transaction[] trArr = usr1.getTransactionsList().toArray();
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

		usr1.removeTransaction(tr2.getId());
		usr1.removeTransaction(tr1.getId());
		tr1 = new Transaction(usr1, usr2, 50, CategoryOfTranslation.INCOME);
		usr1.addTransaction(tr1);
		usr2.removeTransaction(tr3.getId());

		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());

		trArr = usr1.getTransactionsList().toArray();
		for (int i = 0; i < trArr.length; i++) {
			System.out.println(trArr[i].getPayee().getName() + "->" + trArr[i].getSender().getName() + ", " + trArr[i].getStringAmount() + ", " + trArr[i].getTranslation() + ", " + trArr[i].getId());
		}

	}
}

enum CategoryOfTranslation {
	INCOME,
	OUTCOME;
}
