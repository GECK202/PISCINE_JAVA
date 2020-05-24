public class Program {

	public static void main(String[] args)
	{
		UsersArrayList userList = new UsersArrayList();
		userList.addUser("John", 777);
		userList.addUser("Mike", 150);

		User usr1 = userList.getUser(1);
		User usr2 = userList.getUser(2);

		String id1 = usr1.addTransaction(usr2, 50, CategoryOfTranslation.INCOME);
		String id2 = usr1.addTransaction(usr2, -50, CategoryOfTranslation.INCOME);
		String id3 = usr1.addTransaction(usr2, 0, CategoryOfTranslation.INCOME);

		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		usr1.printTransactions();
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());
		usr2.printTransactions();
		usr1.removeTransaction(id2);
		usr2.removeTransaction(id1);
		id1 = usr1.addTransaction(usr2, 50, CategoryOfTranslation.OUTCOME);
		usr1.removeTransaction(id3);

		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		usr1.printTransactions();
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());
		usr2.printTransactions();
	}
}

enum CategoryOfTranslation {
	INCOME,
	OUTCOME;
}
