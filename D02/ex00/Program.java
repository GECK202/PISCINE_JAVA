import java.util.Scanner;

public class Program {

	private static final String EXIT_CODE = "42";

	public static void main(String[] args)
	{
		Parsing parsing = new Parsing();
		Signature signature = new Signature();
		Saving saving = new Saving();
		String fileName = "new/signatures.txt";

		parsing.readSignaturesFile(signature, fileName);
		String magic;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("-> ");
			fileName = sc.nextLine();
			if (fileName.equals(EXIT_CODE)) {
				break ;
			}
			magic = parsing.extractMagic(fileName, signature.getMaxMagicLen());
			if (!magic.equals("")) {
				String type = signature.getElement(magic);
				String result = "PROCESSED";
				if (type.equals("")) {
					type = "UNDEFINDED";
					result = "UNDEFINDED";
				}
				saving.saveResult(type);
				System.out.println(result);
			}
			else {
				System.out.println("Ошибка");
			}
		}
		
	}
}	
