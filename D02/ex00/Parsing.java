import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

class Parsing {
	public void readSignaturesFile(Signature signature, String fileName) {
		try (FileInputStream fileInputStream = new FileInputStream(fileName)){
			convertFileToStrings(signature, fileInputStream);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Ошибка доступа к файлу signatures.txt!");
			System.exit(1);
		}
	}

	public String extractMagic(String fileName, int len) {
		byte[] buffer = new byte[len];
		ArrayList<Character> data = new ArrayList<Character>();
		String str = "";
		try (FileInputStream fileInputStream = new FileInputStream(fileName)){
			fileInputStream.read(buffer);
			for (int i = 0; i < buffer.length; i++) {
				int tmp = buffer[i];
				if (buffer[i] < 0) {
					tmp = 256 + buffer[i];
				}
				data.add(convertToHex(tmp / 16));
				data.add(convertToHex(tmp % 16));
			}
			str = convertListToString(data);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Ошибка доступа к файлу " + fileName + "!");
			System.exit(1);
		}
		return str;
	}

	private void convertFileToStrings(Signature signature, FileInputStream fileInputStream) {
		ArrayList<Character> data = new ArrayList<Character>();
		int i;
		String s;
		String[] f;
		try {

			while((i=fileInputStream.read())!= -1){				
				if (i == 10 && (data.size() > 0)) {
					s = convertListToString(data);				
					f = s.split(",");
					if (f.length == 2) {
						signature.addElement(f[1], f[0]);
					}					
					data = new ArrayList<Character>();
				}
				else if (i != 32){
					data.add((char)i);
				}
			}
			if (data.size() > 0) {				
				s = convertListToString(data);					
				f = s.split(",");
				if (f.length == 2) {
					signature.addElement(f[1], f[0]);
				}				
			}
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
			System.out.println("Ошибка чтения!");
			System.exit(1);
		}
	}

	private String convertListToString(ArrayList<Character> list)
	{
		StringBuilder builder = new StringBuilder(list.size());
		for(Character ch : list)
		{
			builder.append(ch);
		}
		return builder.toString();
	}

	private char convertToHex(int b) {
		char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		return hex[b];
	}
}