import java.util.ArrayList;

public class Similarity {
	public double calculate(ArrayList<Integer> vec1, ArrayList<Integer> vec2) {
		return (multVec(vec1, vec2) / (modVec(vec1) * modVec(vec2)));
	}

	private int multVec(ArrayList<Integer> vec1, ArrayList<Integer> vec2) {
		int res = 0;
		for(int i = 0; i < vec1.size(); i++) {
			res += (vec1.get(i) * vec2.get(i));
		}
		return res;
	}

	private double modVec(ArrayList<Integer> vec) {
		int res = 0;
		for(int i = 0; i < vec.size(); i++) {
			res += (vec.get(i) * vec.get(i));
		}
		return Math.sqrt(res);
	}
}
