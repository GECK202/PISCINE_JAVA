public class Program {

	public static void main(String[] args)
	{
		User usr1 = new User("John", 777);
		User usr2 = new User("Mike", 150);

		System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		System.out.println("name - " + usr2.getName() + ", balance - " + usr2.getBalance() + ", start balance - " + usr1.getStartBalance() + ". ID - " + usr2.getId());
	}
}
