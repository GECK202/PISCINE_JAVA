public class Program {

	public static void main(String[] args)
	{
		User usr1 = new User(1, "John", 777);
		User usr2 = new User(2, "Mike", 150);
		Transaction tr1;
		
		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());
		tr1 = new Transaction(usr1, usr2, 50, CategoryOfTranslation.OUTCOME);
		System.out.println(tr1.getPayee().getName() + "->" + tr1.getSender().getName() + ", " + tr1.getStringAmount() + ", " + tr1.getTranslation() + ", " + tr1.getID());
		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());
		
	}
}	

enum CategoryOfTranslation {
	INCOME,
	OUTCOME;
}
