package algorithmn;

public class Sorting {

	/** Normal Bubble Sort **/
	public static void bubbleSort(Comparable[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (compareTo(arr[j], arr[j + 1])) {
					swap(arr, j, j + 1);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	/** Improved Bubble Sort **/
	public static void bubbleSortImproved(Comparable[] arr) {
		int count = 0;
		int pos = -1;
		boolean swapped = false;
		for (int i = 0; i < arr.length; i++) {
			if (pos == i)
				continue;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				pos = j;
				if (compareTo(arr[j], arr[j + 1])) {
					swap(arr, j, j + 1);
					swapped = true;
					count++;
					pos = -1;
				}
			}
			if (!swapped) {
				continue;
			}
		}
		System.out.println(count);
	}

	/** Advanced Bubble Sort **/
	// select minimum and maximum in one loop, reverse in 2 direction
	public static void bubbleSortDeepImproved(Comparable[] arr) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			for (int i = low; i < high; i++) {
				// select the maximum
				if (compareTo(arr[i], arr[i + 1])) {
					swap(arr, i, i + 1);
				}
			}
			high--;
			// select the minimum
			for (int i = high; i > low; i--) {
				if (compareTo(arr[i-1], arr[i])) {
					swap(arr, i, i-1);
				}
			}
			low++;
		}
	}

	// if a>b return true; if a<=b return false
	public static boolean compareTo(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	public static void swap(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}