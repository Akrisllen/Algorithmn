package algorithmn;

public class BubbleSort extends Sorting{
	
	/** Normal Bubble Sort **/
	public void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (compareTo(arr[j], arr[j + 1])) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	/** Improved Bubble Sort **/
	public void sortImproved(Comparable[] arr) {
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
					pos = -1;
				}
			}
			if (!swapped) {
				continue;
			}
		}
	}

	/** Advanced Bubble Sort **/
	// select minimum and maximum in one loop, reverse in 2 direction
	public void sortDeepImproved(Comparable[] arr) {
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
}
