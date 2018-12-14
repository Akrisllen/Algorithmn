package Sort;

public abstract class Sorting {
	
	protected int swapCount = 0;
	protected int compareCount = 0;
	
	public abstract void sort(Comparable[] arr);
	public void sortImproved(Comparable[] arr) {};
	
	// if a>b return true; if a<=b return false
	protected boolean compareTo(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	protected void swap(Comparable[] arr, int i, int j) {
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}