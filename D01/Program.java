import java.util.UUID;

public class Program {

	public static void main(String[] args)
	{
		User user1 = new User();
		User user2 = new User();
		Transaction tr = new Transaction();
		if (user1.isSetUser("John", 777) && user2.isSetUser("Mike", 150)) {
			System.out.println("name - " + user1.GetName() + " balance - " + user1.GetBalance() + " ID - " + user1.GetID());
			System.out.println("name - " + user2.GetName() + " balance - " + user2.GetBalance() + " ID - " + user1.GetID());
			if(tr.isSetTransaction(user1, user2, 50)) {
				System.out.println(tr.GetPayee().GetName() + "->" + tr.GetSender().GetName() + ", " + tr.GetAmount() + ", " + tr.GetTranslation() + ", " + tr.GetID());
			}
		}
	}

}	
