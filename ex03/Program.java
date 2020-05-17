import java.util.Scanner;

public class Program {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String result = "";

		int curWeek = 0;

		int minGrade = 0;

		int tmp;

		while (true) {
			String str = sc.next();

			if (str.equals("42")) {
				if (curWeek > 0) {
					result += "Week " + String.valueOf(curWeek) + " ";
					for (int i = 0; i < minGrade; i++) {
						result += "=";
					}
					result += ">\n";
				}
				break ;
			}
			else if (str.equals("Week"))
			{
				if (curWeek > 0) {
					result += "Week " + String.valueOf(curWeek) + " ";
					for (int i = 0; i < minGrade; i++) {
						result += "=";
					}
					result += ">\n";
				}
				if (!sc.hasNextInt()) {
					result = "Not valid data format!\n";
					result += "Current week must be a number!\n";
					break ;
				}
				tmp = sc.nextInt();
				if (tmp < 1 || tmp > 18) {
					result = "Not valid data format!\n";
					result += "Number of current week must be from 1 to 18!\n";
					break ;
				}
				if (tmp != (curWeek + 1)) {
					result = "Not valid data format!\n";
					result += "It is not next week!\n";
					break ;
				}
				curWeek = tmp;
				minGrade = 0;
				int i;

				for (i = 0; i < 5; i++) {
					if (!sc.hasNextInt()) {
						result = "Not valid data format!\n";
						result += "Grade must be a number!\n";
						break ;
					}
					tmp = sc.nextInt();
					if (tmp < 1 || tmp > 9) {
						result = "Not valid data format!\n";
						result += "Grade must be from 1 to 9!\n";
						break ;
					}
					minGrade = (minGrade == 0) || (tmp < minGrade) ? tmp : minGrade;
				}
				if (i < 4) {
					break ;
				}
			}
			else {
				result = "Not valid data format!\n";
				result += "Valid format:\n";
				result += " -\"42\" - for exit or:\n";
				result += " -First line: \"Week\" number_of_week\n";
				result += " -Next  line: 1_grade 2_grade 3_grade 4_grade 5_grade\n";
				break ;
			}
		}
		System.out.print(result);		
	}
}	
