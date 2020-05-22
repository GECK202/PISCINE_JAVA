import java.util.Scanner;

public class Program {

	private static final int EXIT_CODE = 42;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int count = 0;

		while (true) {
			int number = sc.nextInt();

			if (number == EXIT_CODE) {
				break ;
			}
			else if (number == 2) {
				++count;
			}
			else
			{
				int summ = 0;
				boolean simple = true;
				int i;
				int sqrt;

				do {
  					summ += number % 10;
  					number /= 10;
 				} while (number > 0);
				sqrt = summ / 2;
				while (sqrt * sqrt > summ) {
					--sqrt;
				}
				for (i = 2; i <= sqrt; i++)
				{
					if (summ % i == 0) {
						simple = false;
						break ;
					}
				}
				if (simple) {
					++count;
				}
			}
		}
		System.out.println("Count of coffee-request - " + count);
	}
}	
