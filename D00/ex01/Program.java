import java.util.Scanner;

public class Program {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		if (number < 2) {
			System.out.println("IllegalArgument");
		}
		else if (number == 2) {
			System.out.println("true 0");
		}
		else {
			boolean simple = true;
			int i = 2;
			int sqrt = number / 2;

			while (sqrt * sqrt > number) {
				--sqrt;
			}
			for (;i <= sqrt; i++) {
				if (number % i == 0) {
					simple = false;
					break ;
				}
			}
			System.out.println(simple + " " + ( -- i));
		}
	}
}