public class Program {

	public static void main(String[] args)
	{
		Signature signature = new Signature();

		if (signature.readSignaturesFile()) {
			signature.getElement("");
			System.out.println("OK");
		}
		else {
			System.out.println("KO");
		}
	}
}	
