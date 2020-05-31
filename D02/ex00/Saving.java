import java.io.FileOutputStream;
import java.io.IOException;

public class Saving {
	public void saveResult(String type) {
		String fileName = "result.txt";
		try(FileOutputStream fileOutputStream = new FileOutputStream(fileName, true)) {
			byte[] bytes = type.getBytes();
			fileOutputStream.write(bytes);
			fileOutputStream.write(10);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Ошибка записи файла result.txt!");
			System.exit(1);
		}
	}
}
