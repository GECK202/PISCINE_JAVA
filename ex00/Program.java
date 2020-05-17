public class Program {

	public static void main(String[] args)
	{
		int n = 479598;

		int sum = n / 100000;

		n %= 100000;
		sum += n / 10000;
		n %= 10000;
		sum += n / 1000;
		n %= 1000;
		sum += n / 100;
		n %= 100;
		sum += n / 10;
		n %= 10;
		System.out.println(sum + n);
	}
}	
