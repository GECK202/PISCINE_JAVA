import java.util.Scanner;

public class Program {

	private static final String[] week = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};

	private static final int START_MONTH = 1;

	private static final int LAST_DAY = 30;

	private static final int MAX_STUDENTS = 10;

	private static final int MAX_LESSONS = 50;

	private static final int MAX_LESSONS_ON_WEEK = 10;

	private static final int STAGE_ADD_STUDENTS = 0;

	private static final int STAGE_ADD_LESSONS = 1;

	private static final int STAGE_ADD_VISITS = 2;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String[] students = new String[MAX_STUDENTS];

		int[] lessons = new int[MAX_LESSONS];

		int[][] visits = new int[MAX_STUDENTS][MAX_LESSONS];

		int countOfLessons = 0;

		int maxLessons = 0;

		int countOfStudents = 0;

		int countOfVisits = 0;

		int currentStage = STAGE_ADD_STUDENTS;

		String errMessage = "";

		while (true) {
			if (currentStage == STAGE_ADD_STUDENTS) {
				String str = sc.nextLine();
				if (str.equals(".")) {
					if (countOfStudents == 0) {
						errMessage = "Not valid data!\nNo students!" ;
						break ;
					}
					++currentStage;
				}
				else {
					boolean newStudent = true;

					if (countOfStudents == MAX_STUDENTS) {
						errMessage = "Not valid data!\nToo many students!" ;
						break ;
					}

					if (str.equals("")) {
						errMessage = "Not valid data!\nSecond name of student is empty!" ;
						break ;
					}

					for (int i = 0; i <= countOfStudents; i++) {
						if (str.equals(students[i])) {
							newStudent = false;
							break ;
						}
					}

					if (!newStudent) {
						errMessage = "Not valid data!\n" + str + " is not a new student!" ;
						break ;
					}
					students[countOfStudents++] = str;
				}
			}
			else if (currentStage == STAGE_ADD_LESSONS) {
				String str;

				if (!sc.hasNextInt()) {
					boolean runSort = true;

					if (!(str = sc.next()).equals(".")) {
						errMessage = "Not valid data!\nHour of lesson must be a number!";
						break ;
					}
					while (runSort) {
						runSort = false;
						for (int i = 0; i < countOfLessons; i++) {
							for (int j = i + 1; j < countOfLessons; j++) {
								if (lessons[i] > lessons[j]) {
									int tmp = lessons[i];
									lessons[i] = lessons[j];
									lessons[j] = tmp;
									runSort = true;
								}
							}
						}
					}
					++currentStage;
				}
				else {
					int hour = sc.nextInt();
					String dayOfWeek = sc.next();
					boolean isDayOfWeek = false;
					int day;
					int currentDayOfWeek = START_MONTH;

					if (maxLessons == MAX_LESSONS_ON_WEEK) {
						errMessage = "Not valid data!\nToo many lessons per week!";
						break ;
					}

					if (hour < 1 || hour > 6) {
						errMessage = "Not valid data!\n";
						errMessage += "Hour of lesson must be a number from 1 to 6 pm!";
						break ;
					}

					for (day = 0; day < week.length; day++) {
						if (dayOfWeek.equals(week[day])) {
							isDayOfWeek = true;
							break ;
						}
					}

					if (!isDayOfWeek) {
						errMessage = "Not valid data!\nIt is not day of week!\n";
						errMessage += "Valid day of week is MO, TU, WE, TH, FR, SA or SU!";
						break ;
					}

					for (int dayOfMonth = 1; dayOfMonth <= LAST_DAY; dayOfMonth++) {
						if (day == currentDayOfWeek) {
							for (int i = 0; i <= countOfLessons; i++) {
								if (lessons[i] == dayOfMonth * 10 + hour) {
									errMessage = "Not valid data!\nThis lesson has already been added!";
									break ;
								}
							}
							lessons[countOfLessons++] = dayOfMonth * 10 + hour;
							if (countOfLessons >= MAX_LESSONS) {
								errMessage = "Not valid data!\nToo many lessons!";
								break ;
							}
						}
						currentDayOfWeek = (currentDayOfWeek == 6) ? 0 : currentDayOfWeek + 1;
					}
					if (!errMessage.equals("")) {
						break ;
					}
					++maxLessons;
				};
			}
			else if (currentStage == STAGE_ADD_VISITS) {
				String str = sc.next();
				if (str.equals(".")) {
					break ;
				}
				else {
					int indexStudent = -1;
					int hour;
					int day;
					int visit;
					int indexLesson = -1;

					for (int i = 0; i < countOfStudents; i++) {
						if (str.equals(students[i])) {
							indexStudent = i;
							break ;
						}
					}
					if (indexStudent == -1) {
						errMessage = "Not valid data!\nStudent " + str + " not find!";
						break ;
					}
					
					if (!sc.hasNextInt()) {
						errMessage = "Not valid data!\nHour of lesson must be a number!";
						break ;
					}
					hour = sc.nextInt();
					if (hour < 1 || hour > 6) {
						errMessage = "Not valid data!\n";
						errMessage += "Hour of lesson must be a number from 1 to 6 pm!";
						break ;
					}

					if (!sc.hasNextInt()) {
						errMessage = "Not valid data!\nDay of lesson must be a number!";
						break ;
					}
					day = sc.nextInt();
					if (day < 1 || day > LAST_DAY) {
						errMessage = "Not valid data!\n";
						errMessage += "Day of lesson must be a number from 1 to " + String.valueOf(LAST_DAY) + "!";
						break ;
					}

					str = sc.next();
					if (str.equals("HERE")) {
						visit = 1;
					}
					else if (str.equals("NOT_HERE")) {
						visit = -1;
					}
					else {
						errMessage = "Not valid data!\n";
						errMessage += "Valid visit is HERE or NOT_HERE!";
						break ;
					}

					for (int i = 0; i < countOfLessons; i++) {
						if (lessons[i] == day * 10 + hour) {
							indexLesson = i;
							break ;
						}
					}
					if (indexLesson == -1) {
						errMessage = "Not valid data!\nThere is no lesson at this time!";
						break ;
					}
					visits[indexStudent][indexLesson] = visit;
					++countOfVisits;
				}	
				//break ;
			}
			
		}
		if (errMessage.equals("")) {
			//for (int i = 0; i < countOfStudents; i++) {
			//	System.out.println("-" + students[i]);
			//}
			System.out.print("          ");
			for (int i = 0; i < countOfLessons; i++) {
				int weekIndex = lessons[i] / 10;
				weekIndex = (weekIndex >= week.length) ? weekIndex % 7 : weekIndex;
				weekIndex = weekIndex + START_MONTH - 1;
				System.out.printf("%d:00 %s %02d|", lessons[i] % 10, week[weekIndex], lessons[i] / 10);
			}
			System.out.println();
			for (int i = 0; i < countOfStudents; i++) {
				System.out.printf("%10s", students[i]);
				for (int j = 0; j < countOfLessons; j++) {
					if (visits[i][j] != 0) {
						System.out.printf("%10d|", visits[i][j]);
					}
					else {
						System.out.print("          |");
					}
				}
				System.out.println();
			}
		}
		else {
			System.out.println(errMessage);
		}

				
	}
}	
