package algorithmn;

public class MergeSort extends Sorting{

	public void sort(Comparable[] arr) {
		mergeSort(arr,0,arr.length-1);
	}
	
	private void mergeSort(Comparable[] arr, int low, int high) {
		if(low>=high) return;
		int mid = (low+high)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
	
	private void merge(Comparable[] arr,int low,int mid,int high) {
		Comparable[] left = new Comparable[mid-low+1];
		Comparable[] right = new Comparable[high-mid];
		
		for(int i=0;i<mid-low+1;i++) {
			left[i] = arr[low+i];
		}
		for(int i=0;i<high-mid;i++) {
			right[i] = arr[mid+1+i];
		}
		
		int indexLeft = 0;
		int indexRight = 0;
		
		for(int i=low;i<=high;i++) {
			if(indexLeft<left.length && indexRight<right.length) {
				if(compareTo(left[indexLeft],right[indexRight])) {
					arr[i] = right[indexRight++];
				}else {
					arr[i] = left[indexLeft++];
				}
			}else if(indexRight<right.length) {
				arr[i] = right[indexRight++];
			}else if(indexLeft<left.length) {
				arr[i] = left[indexLeft++];
			}
		}
	}
	
	/** Improved MergeSort **/
	
	/**
	 * 1. use insert sort for small array
	 * 2. test whether the array has already in order
	 * 3. eliminate the time (not space) taken to copy array
	 */
	public void sortImproved(Comparable[] arr) {
		if(arr.length<100) {
			insertSort(arr);
		}else {
			mergeSortImproved(arr,0,arr.length-1);
		}
	}
	
	private void insertSort(Comparable[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(compareTo(arr[j-1],arr[j])) {
					swap(arr,j-1,j);
				}else {
					break;
				}
			}
		}
	}
	
	private void mergeSortImproved(Comparable[] arr, int low, int high) {
		if(low>=high) return;
		int mid = (low+high)/2;
		mergeSortImproved(arr,low,mid);
		mergeSortImproved(arr,mid+1,high);
		mergeImproved(arr,low,mid,high);
	}
	
	private void mergeImproved(Comparable[] arr,int low,int mid,int high) {
		// test whether the array has already in order
		if(compareTo(arr[mid+1],arr[mid])) return;
		merge(arr,low,mid,high);
	}
}
