import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Saver {
	public void saveDictionary(ArrayList<String> dictionary, String fileName) throws IOException{
		try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
			for (String word : dictionary) {
				writter.write(word + "\n");
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
