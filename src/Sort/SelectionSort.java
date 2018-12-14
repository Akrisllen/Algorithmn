package Sort;

public class SelectionSort extends Sorting{

	@Override
	public void sort(Comparable[] arr) {
		swapCount = 0;compareCount=0;
		int minIndex;
		for(int i=0;i<arr.length;i++) {
			minIndex = i;
			for(int j=i;j<arr.length;j++) {
				if(compareTo(arr[minIndex],arr[j])) {
					minIndex = j;
				}
			    compareCount++;
			}
			if(minIndex != i) {
				swap(arr,minIndex,i);
				swapCount++;
			}
		}
		System.out.println("Swap Time: " + swapCount);
		System.out.println("Compare Time: " + compareCount);
	}

	// select maximum value and minimum value in one loop
	public void sortImproved(Comparable[] arr) {
		int minIndex,maxIndex;
		
		for(int i=0;i<arr.length/2;i++) {
			// select the minimum value
			minIndex = i;
			for(int j=i;j<arr.length;j++) {
				if(compareTo(arr[j],arr[minIndex])) {
					minIndex = j;
				}
			}
			if(minIndex!=i) swap(arr,minIndex,i);
			// select the maximum value
			maxIndex=arr.length-1-i;
			for(int j=arr.length-1;j>i;j--) {
				if(compareTo(arr[j],arr[maxIndex])) {
					maxIndex = j;
				}
			}
			if(maxIndex!=arr.length-1-i) swap(arr,maxIndex,arr.length-1-i);
		}
	}
}
