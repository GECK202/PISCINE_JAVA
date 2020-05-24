public class UsersArrayList implements UsersList {
	private User[] userList;
	private int countUser;

	public UsersArrayList() {
		userList = new User[10];
		countUser = 0;
	}

	public void addUser(String name, int balance) {
		int len = userList.length;
		if (len <= countUser) {
			User[] tmp = new User[len]; 
			tmp = arrayCopy(userList, tmp);
			userList = new User[(int)(len * 1.5)];
			userList = arrayCopy(tmp, userList);
		}
		userList[countUser++] = new User(name, balance);
	}

	public User getUser(int id) throws UserNotFoundException {
		for (int i = 0; i < countUser; i++) {
			if (userList[i].getId() == id) {
				return userList[i];
			}
		}
		throw new UserNotFoundException("User with id=" + String.valueOf(id) + " not found!");
	}

	public int getCountUser() {
		return countUser;
	}

	private User[] arrayCopy(User[] arrayFrom, User[] arrayTo) {
		for (int i = 0; i < arrayFrom.length; i++) {
			arrayTo[i] = arrayFrom[i];
		}
		return arrayTo;
	}

	public int getArrayLength() {
		return userList.length;
	}
}