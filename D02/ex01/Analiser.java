import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Analiser {
	public void fileAnalise(String fileName, ArrayList<String> dictionary, ArrayList<Integer> fileVec) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String str;
		int n = 0;
		while ((str = br.readLine())!=null){
			//str = str.replaceAll("[\\W\\d&&[^\\s\\.]]", " ");
			str = str.replaceAll("[^\\w\\. ]", " ");

			String[] arr = str.split(" ");
			for(int i = 0; i < arr.length; i++) {
				//str = arr[i];//.replaceAll("[\\s\\t^\\.]", "");
				str = arr[i].replaceAll("^[\\d\\.[\\.\\d]]", "");
				if (!str.equals("")) {
					addWord(str.toLowerCase(), dictionary, fileVec);
					++n;
				}
			}
		}
		br.close();
	}

	private void addWord(String word, ArrayList<String> dictionary, ArrayList<Integer> fileVec) {
		int index;
		if (!dictionary.contains(word)) {
			dictionary.add(word);
			index = dictionary.indexOf(word);
			fileVec.add(index, 1);
		}
		else {
			index = dictionary.indexOf(word);
			fileVec.set(index, fileVec.get(index) + 1);
		}
	}
}
