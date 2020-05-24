import java.util.Scanner;

public class Menu {
	private TransactionsService service;
	private boolean devProfile;

	public Menu(String[] args) {
		devProfile = false;
		boolean error = false;

		if (args.length == 1) {
			for (String str : args) {
				if (str.contains("--profile=")) {
					String[] arg = str.split("=");
					if (arg.length == 2) {
						if (arg[1].equals("dev")) {
							devProfile = true;
						}
						else if (arg[1].equals("production")){
							devProfile = false;
						}
						else {
							error = true;
						}
					}
					else {
						error = true;
					}
				}
				else {
					error = true;
				}
			}
		}
		else {
			error = true;
		}
		if (error) {
			System.out.println("Not valid argument!");
		}
		service = new TransactionsService();
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1. Добавить пользователя");
		System.out.println("2. Посмотреть баланс пользователей");
		System.out.println("3. Осуществить перевод");
		System.out.println("4. Посмотреть все переводы конкретного пользователя");
		if (devProfile) {
			System.out.println("5. DEV - удалить перевод по ID");
			System.out.println("6. DEV - проверить корректность переводов");
			System.out.println("7. ВЫХОД");
		}
		else {
			System.out.println("5. ВЫХОД");
		}
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		int maxPos = 5;
		if (devProfile) {
			maxPos = 7;
		}
		while (true) {
			boolean error = false;

			printMenu();
			if (sc.hasNextInt()) {
				int position = sc.nextInt();
				if (position > 0 && position < maxPos) {
					selector(position);
				}
				else if (position == maxPos) {
					return ;
				}
				else {
					error = true;
				}
			}
			else {
				String s = sc.next();
				error = true;
			}
			if (error) {
				System.out.println("Ошибка! Выберите пункт меню от 1 до " + maxPos);
			}
		}
	}

	private void selector(int position) {
		switch(position) {
			case (1):
				addUser();
				break;
			case (2):
				showBalance();
				break;
			case (3):
				makeTransaction();
				break;
			case (4):
				showUserTransactions();
				break;
			case (5):
				removeTransaction();
				break;
			case (6):
				showIncorrectTransactions();
				break;
		}

	}

	private void addUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите имя и баланс пользователя");
		String name = sc.next();
		int balance = 0;
		boolean error = false;
		if (sc.hasNextInt()) {
			balance = sc.nextInt();
			if (balance >= 0) {
				int id = service.addUser(name, balance);
				System.out.println("Пользователь добавлен с id = " + id);
			}
			else {
				error = true;
			}
		}
		else {
			error = true;
		}
		if (error) {
			System.out.println("Ошибка! Балланс должен быть целым числом равным или большим 0!");
		}
	}

	private void showBalance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите id пользователя");
		boolean error = false;
		if (sc.hasNextInt()) {
			int id = sc.nextInt();
			if (id > 0) {
				try {
					System.out.println(service.getUserName(id) + " - " + service.getUserBalance(id));
				}
				catch(UserNotFoundException e) {
					System.out.println("Ошибка! Пользователь не найден!");
				}
			}
			else {
				error = true;
			}
		}
		else {
			error = true;
		}
		if (error) {
			System.out.println("Ошибка! id пользователя должен быть целым числом больше 0!");
		}
	}

	private void makeTransaction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите id-отправителя id-получателя и сумму перевода");
		boolean error = false;
		int[] arg = new int[3];
		for (int i = 0; i < 3; i++) {
			if (sc.hasNextInt()) {
				arg[i] = sc.nextInt();
				if (i < 2 && arg[i] < 1) {
					error = true;
				}
				else if (i == 2 && arg[i] < 0) {
					error = true;
				}
			}
			else {
				error = true;
			}
		}
		if (error == false) {
			try {
				service.addTransaction(arg[0], arg[1], arg[2]);
				System.out.println("Перевод осуществлен");
			}
			catch (UserNotFoundException e) {
				System.out.println("Ошибка! Пользователь не найден!");
			}
			catch (IllegalTransactionException e) {
				System.out.println("Ошибка! Неверные данные для перевода!");
			}
		}
		else {
			System.out.println("Ошибка! id пользователей должны быть целыми числами больше 0!");
			System.out.println("Сумма перевода должна быть больше 0!");
		}		
	}

	private void showUserTransactions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите id пользователя");
		boolean error = false;
		if (sc.hasNextInt()) {
			int id = sc.nextInt();
			if (id > 0) {
				try {
					String direction;
					Transaction[] trArr = service.getTransactions(id);
					for (int i = 0; i < trArr.length; i++) {
						if (trArr[i].getTranslation() == CategoryOfTranslation.INCOME) {
							direction = "From ";
						}
						else {
							direction = "To ";
						}
						System.out.println(direction + trArr[i].getSender().getName() + "(id = " + trArr[i].getSender().getId() + ") " + trArr[i].getAmount() + " with id = " + trArr[i].getId());
					}
				}
				catch(UserNotFoundException e) {
					System.out.println("Ошибка! Пользователь не найден!");
				}
				catch (TransactionNotFoundException e) {
					System.out.println("Ошибка! Перевод не найден!");
				}
			}
			else {
				error = true;
			}
		}
		else {
			error = true;
		}
		if (error) {
			System.out.println("Ошибка! id пользователя должен быть целым числом больше 0!");
		}
	}

	private void removeTransaction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите id пользователя и id перевода");
		boolean error = false;
		if (sc.hasNextInt()) {
			int idUser = sc.nextInt();
			if (idUser > 0) {
				String idTransaction = sc.next();
				try {
					Transaction[] trArr = service.getTransactions(idUser);
					String direction = "";
					User sender = null;
					int amount = 0;
					for (int i = 0; i < trArr.length; i++) {
						if (idTransaction.equals(trArr[i].getId())) {
							if (trArr[i].getTranslation() == CategoryOfTranslation.INCOME) {
								direction = "From ";
							}
							else {
								direction = "To ";
							}
							sender = trArr[i].getSender();
							amount = trArr[i].getAmount();
						}
					}
					if (sender == null) {
						System.out.println("Ошибка! Перевод не найден!");
					}
					else {
						service.removeTransaction(idUser, idTransaction);
					}
					System.out.println("Перевод " + direction + 
						sender.getName() + "(id = " + 
						sender.getId() + ") " + amount + " удален");
				}
				catch(UserNotFoundException e) {
					System.out.println("Ошибка! Пользователь не найден!");
				}
				catch (TransactionNotFoundException e) {
					System.out.println("Ошибка! Перевод не найден!");
				}
			}
			else {
				error = true;
			}
		}
		else {
			error = true;
		}
		if (error) {
			System.out.println("Ошибка! id пользователя должен быть целым числом больше 0!");
		}
	}

	private void showIncorrectTransactions() {
		try {
			String direction;
			Transaction[] trArr = service.getIncorrectTransactions();
			System.out.println("Результат проверки:");
			if (trArr.length == 0) {
				System.out.println("Все транзакции корректны.");
			}
			else {
				for (int i = 0; i < trArr.length; i++) {
					if (trArr[i].getTranslation() == CategoryOfTranslation.INCOME) {
						direction = "From ";
					}
					else {
						direction = "To ";
					}
					System.out.println(trArr[i].getPayee().getName() + "(id = " + 
						trArr[i].getPayee().getId() + ") имеет неподтверждённый перевод id =");
					System.out.println(trArr[i].getId() + " " + direction + trArr[i].getSender().getName() + "(id = " + 
						trArr[i].getSender().getId() + ") на сумму " + trArr[i].getAmount());
				}
			}
		}
		catch(UserNotFoundException e) {
			System.out.println("Ошибка! Пользователь не найден!");
		}
		catch (TransactionNotFoundException e) {
			System.out.println("Ошибка! Перевод не найден!");
		}
	}

}
