import java.util.Scanner;

public class Menu {
  private TransactionsService service;
  private boolean devProfile;

  public Menu(String[] args) {
    devProfile = false;
    boolean error = false;
    if (args.length == 1) {
      for (String str : args) {
        if (str.compareTo("--profile=") == 0) {
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
  }

  private void printMenu() {
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
        error = true;
      }
      if (error) {
        System.out.println("Выберите пункт меню от 1 до " + maxPos);
      }
    }
  }

  public void selector(int position) {

  }
}
