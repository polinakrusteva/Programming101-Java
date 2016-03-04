package monday;

public class Sequences {

	public static boolean IsIncreasing(int[] sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] > sequence[i + 1] || sequence.length == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean IsDecreasing(int[] sequence) {
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] < sequence[i + 1] || sequence.length == 1) {
				return false;
			}
		}
		return true;
	}

	public static int maxEqualConsecutive(int[] items) {
		int counter = 1;
		int maxCounter = 1;
		for (int i = 0; i < items.length - 1; i++) {
			if (items[i] == items[i + 1]) {
				counter++;
				if (counter > maxCounter) {
					maxCounter = counter;
				}
			} else {
				counter = 1;
			}
		}
		return maxCounter;
	}

	public static int maxIncreasingConsecutive(int[] items) {
		int counter = 1;
		int maxCounter = 1;
		for (int i = 0; i < items.length - 1; i++) {
			if (items[i] <= items[i + 1]) {
				counter++;
				if (counter > maxCounter) {
					maxCounter = counter;
				}
			} else {
				counter = 1;
			}
		}
		return maxCounter;
	}

	public static void main(String[] args) {
		int[] seq1 = { 1, 2, 3, 3, 3, 3, 4, 3, 3 };
		int[] seq2 = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5 };
		// System.out.println(maxEqualConsecutive(seq1));
		// System.out.println(maxEqualConsecutive(seq2));
		System.out.println(maxIncreasingConsecutive(seq1));
		System.out.println(maxIncreasingConsecutive(seq2));
	}
}
