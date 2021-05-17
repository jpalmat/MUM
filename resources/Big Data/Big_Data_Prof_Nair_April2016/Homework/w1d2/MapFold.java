package inter;

public class MapFold {

	public static int f(int x) {
		return (x != 3 && x != 4) ? -1 : x;
	}

	public static int g(int x, int y) {
		if (x == 1) {
			return x;
		}

		if (y == 4) {
			x = 0;
			return x;
		} else if (y == 3) {
			x = 1;
			return x;
		}
		return x;
	}

	public static void main(String[] args) {
		int[] a = { 4, 11, 12, 3, 0, 21 };
		int[] b = new int[a.length];
		int[] c = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			b[i] = f(a[i]);
		}

		int x = 2;
		for (int i = 0; i < a.length; i++) {
			x = g(x, b[i]);
			c[i] = x;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print("\t" + a[i] + " ");
		System.out.println();
		for (int i = 0; i < a.length; i++)
			System.out.print("\t" + b[i] + " ");
		System.out.println();
		for (int i = 0; i < a.length; i++)
			System.out.print("\t" + c[i] + " ");
		System.out.println();
	}
}
