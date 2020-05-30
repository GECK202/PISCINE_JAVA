
import java.util.ArrayList;

public class Signature {
	private ArrayList<Association> data;
	private int maxMagicLen;

	public Signature() {
		data = new ArrayList<Association>();
		maxMagicLen = 0;
	}

	public void addElement(String magic, String type) {
		data.add(new Association(type, magic));
		maxMagicLen = (magic.length() > maxMagicLen) ? magic.length() : maxMagicLen;
	}

	public String getElement(String magic) {
		for(Association a : data)
		{
			String s = magic.substring(0, a.getMagic().length());
			if (a.getMagic().equals(s)) {
				return a.getType();
			}
		}
		return "";
	}

	public int getMaxMagicLen() {
		return maxMagicLen / 2;
	}

	private class Association {
		private String type;
		private String magic;

		Association (String type, String magic) {
			this.type = type;
			this.magic = magic;
		}

		public String getType() {
			return type;
		}

		public String getMagic() {
			return magic;
		}
	}
}
