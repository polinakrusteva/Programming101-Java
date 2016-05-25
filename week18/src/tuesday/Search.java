package tuesday;

public class Search<T> {

	public static int interpolation(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while (arr[left] != arr[right] && arr[left] <= key && arr[right] >= key) {
			int k = (key - arr[left]) / (arr[right] - arr[left]);
			int mid = left + k * (right - left);
			if (key > arr[mid]) {
				left = mid + 1;
			} else if (key < arr[mid]) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		if (key == arr[left]) {
			return left;
		} else {
			return -1;
		}
	}

}
