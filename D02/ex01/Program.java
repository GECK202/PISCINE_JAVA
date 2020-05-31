import java.util.ArrayList;
import java.io.IOException;

public class Program {
	public static void main(String[] args) throws IOException
	{
		if (args.length == 2) {
			try {
				ArrayList<Integer> fileVec1 = new ArrayList<>();
				ArrayList<String> dictionary = new ArrayList<>();
				ArrayList<Integer> fileVec2;
				Analiser analiser = new Analiser();
				Similarity similarity = new Similarity();
				Saver saver = new Saver();

				analiser.fileAnalise(args[0], dictionary, fileVec1);
				fileVec2 = new ArrayList<>(fileVec1.size());
				for(int i = 0; i < fileVec1.size(); i++) {
					fileVec2.add(i, 0);
				}
				analiser.fileAnalise(args[1], dictionary, fileVec2);
				for(int i = fileVec1.size(); i < fileVec2.size(); i++) {
					fileVec1.add(i, 0);
				}
				saver.saveDictionary(dictionary, "dictionary.txt");
				System.out.format("Similarity = %.2f\n", similarity.calculate(fileVec1, fileVec2));
			}
			catch(IOException ex) {
				System.err.println(ex.getMessage());
				System.exit(1);
			}
		}
	}
}
