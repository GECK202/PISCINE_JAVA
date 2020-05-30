import java.io.*;
import java.util.*;

public class Signature {
	private HashMap<String, String> map;
	private int maxKeyLen;

	public Signature() {
		map = new HashMap<String, String>();
		maxKeyLen = 0;
	}

	private void addElement(String key, String format) {
		map.put(key, format);
		maxKeyLen = (key.length() > maxKeyLen) ? key.length() : maxKeyLen;
	}

	public String getElement(String key) {
		for(Map.Entry<String, String> element: map.entrySet()) {
            System.out.println(element.getKey() + " - " + element.getValue());
		}
		//String format = map.get(key);
		//if (format == null) {
			return "";
		//}
		//return format;
	}

	public boolean readSignaturesFile() {
		boolean result = true;
		
		try(FileInputStream fileInputStream = new FileInputStream("signatures.txt")) {
			result = convertFileToStrings(fileInputStream);
		}
        catch(IOException ex){
            result = false;
            System.out.println(ex.getMessage());
            System.out.println("Ошибка доступа!");
        }
        return result;
	}

	private boolean convertFileToStrings(FileInputStream fileInputStream) {
		ArrayList<Character> data = new ArrayList<Character>();
		int i;
		boolean result = true;
		try {
			while((i=fileInputStream.read())!= -1){
				if (i == 10) {
					String s = convertListToString(data);					
					String f[] = s.split(",");
					addElement(f[1], f[0]);
					data = new ArrayList<Character>();
				}
				else if (i != 32){
					data.add((char)i);
				}
			}
		}
		catch(IOException ex){
            result = false;
            System.out.println(ex.getMessage());
            System.out.println("Ошибка чтения!");
        }
        return result;
	}

	private String convertListToString(ArrayList<Character> list)
	{    
    	StringBuilder builder = new StringBuilder(list.size());
    	for(Character ch: list)
    	{
    	    builder.append(ch);
    	}
    	return builder.toString();
	}
}
