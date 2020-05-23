public class Program {

	public static void main(String[] args)
	{
		UsersArrayList userList = new UsersArrayList();

		System.out.println(userList.getArrayLength());
		for (int i = 0; i < 11; i++) {
			userList.addUser("User" + String.valueOf(i), i*10);
		}
		System.out.println(userList.getArrayLength());

		for (int i = 1; i < userList.getCountUser() + 2; i++) {
			User usr1 = userList.getUser(i);
			System.out.println("name - " + usr1.getName() + ", balance - " + usr1.getBalance() + ", start balance - " + usr1.getStartBalance() + ", ID - " + usr1.getId());
		}
	}
}
