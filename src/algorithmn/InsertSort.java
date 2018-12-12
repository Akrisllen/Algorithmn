package algorithmn;

public class InsertSort extends Sorting{

	public void sort(Comparable[] arr) {
		swapCount=0; compareCount=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				compareCount++;
				if(compareTo(arr[j-1],arr[j])) {
					swap(arr,j,j-1);
					swapCount++;
				}
			}
		}
		System.out.println("Swap Time: " + swapCount);
		System.out.println("Compare Time: " + compareCount);
	}

	public void sortImproved(Comparable[] arr) {
		swapCount=0; compareCount=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				compareCount++;
				if(compareTo(arr[j-1],arr[j])) {
					swap(arr,j,j-1);
					swapCount++;
				}else {
					break;
				}
			}
		}
		System.out.println("Swap Time: " + swapCount);
		System.out.println("Compare Time: " + compareCount);
	}
}