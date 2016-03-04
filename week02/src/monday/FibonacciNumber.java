package monday;

public class FibonacciNumber {

	private static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static long fibNumber(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(fibonacci(i));
		}
		return Long.parseLong(sb.toString());
	}

	public static void main(String[] args) {
		System.out.println(fibNumber(3));
		System.out.println(fibNumber(10));
	}
}
