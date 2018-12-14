package Sort;

public class QuickSort extends Sorting{

	/** Normal Input **/
	public void sort(Comparable[] arr) {
		sort(arr,0,arr.length-1);
	}
	private void sort(Comparable[] arr,int low,int high) {
		if(low>=high) return;
		int index = calculateIndex(arr, low, high);
		sort(arr,low,index-1);
		sort(arr,index+1,high);
	}
	private int calculateIndex(Comparable[] arr,int low,int high) {
		int i=low,j=high;
		Comparable temp = arr[low];
		while(true) {
			while(i<high) {
				if(compareTo(arr[i],temp)) break;
				i++;
			}
			while(low<j) {
				if(compareTo(temp,arr[j])) break;
				j--;
			}
			if(i>=j) break;
			swap(arr,i,j);
		}
		swap(arr,low,j);
		return j;
	}
	
	/** Improved Quick Sort **/
	public void sortImproved(Comparable[] arr) {
		sortImproved(arr,0,arr.length-1);
	}
	private void sortImproved(Comparable[] arr,int low,int high) {
		if(low>=high) return;
		if(arr.length<20) {
			insertSort(arr);
		}else {
			if(low>=high) return;
			int index = calculateIndex(arr, low, high);
			sortImproved(arr,low,index-1);
			sortImproved(arr,index+1,high);
		}
	}
	
	private void insertSort(Comparable[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(compareTo(arr[j-1],arr[j])) {
					swap(arr,j,j-1);
				}else {
					break;
				}
			}
		}
	}

}
