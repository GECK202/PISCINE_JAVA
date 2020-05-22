import java.util.Scanner;

public class Program {

	private static final int MAX_COUNT = 10;
	private static final int MAX_SIZE = 10;
	private static final int MAX_INT = 2147483647;
	private static final int MAX_INDEX = 65535;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		char[] strToArray = str.toCharArray();

		int[] symbols = new int[MAX_INDEX];

		char[] keys = new char[MAX_COUNT];

		int[] counts = new int[MAX_COUNT];

		int maxCount = 0;

		int minCount = MAX_INT;

		int maxIndex = 0;

		boolean runSort;

		for (int i = 0;  i < strToArray.length; i++) {
			++symbols[strToArray[i]];			
		}

		for (int i = 0; i < MAX_COUNT; i++) {
			maxCount = 0;
			char curSymbol = 32;
			for (int j = 0; j < MAX_INDEX; j++) {
				if (symbols[j] > maxCount) {
					maxCount = symbols[j];
					curSymbol = (char)j;
				}
			}

			if (maxCount > 0) {
				keys[i] = curSymbol;
				counts[i] = maxCount;
				symbols[(int)curSymbol] = 0;
				++maxIndex;
			}
		}
		minCount = maxCount;
		maxCount = counts[0];

		if (counts[0] > 0) {
			double step = (double)maxCount / 10.0;
			int digits = 2;

			do {
  				++digits;
  				maxCount /= 10;
 			} while (maxCount > 0);

			for (int i = MAX_SIZE; i >= 0; i--) {
				String result = "";

				for (int j = 0; j < maxIndex; j++) {
					int size = (int)((double)counts[j] / step);

					if (i == size) {
						int spaces = digits;
						int tmp = counts[j];

						do {
  							--spaces;
  							tmp /= 10;
 						} while (tmp > 0);

 						for (int k = 0; k < spaces; k++) {
							System.out.print(" ");
						}
						System.out.print(counts[j]);
					}
					else if (i < size) {
						for (int k = 1; k < digits; k++) {
							System.out.print(" ");
						}
						System.out.print("#");
					}
				}
				System.out.println();
			}

			for (int i = 0; i < maxIndex; i++){
				for (int k = 1; k < digits; k++) {
					System.out.print(" ");
				}
				System.out.print(keys[i]);
			}
			System.out.println();
		}
	}
}	
