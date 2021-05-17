package inter;


public class W1D2 {

	public int isNice(int[] A) {
		int isWave = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 3) {
				return 1;
			} else if (A[i] == 4) {
				isWave = 0;
			}
		}
		return isWave;
	}

	public static void main(String[] args) {
		W1D2 w1d2 = new W1D2();
		
		int [] c1 = {7, 6, 2, 3, 1};
		int [] c2 = {7, 6, 2, 4, 1};
		int [] c3 = {3, 6, 2, 3, 4};
		int [] c4 = {3, 4, 2, 3, 4, 7, 4};
		int [] c5 = {1, 6, 2, 8, 2, 9};
		System.out.println(w1d2.isNice(c1));
		System.out.println(w1d2.isNice(c2));
		System.out.println(w1d2.isNice(c3));
		System.out.println(w1d2.isNice(c4));
		System.out.println(w1d2.isNice(c5));
		
	}
}
