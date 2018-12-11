package algorithmn;

public class MyMain {

	public static void main(String[] args) {
		Comparable[] increaseArr = {1,2,3,4};
		Comparable[] decreaseArr = {4,3,2,1};
		Comparable[] randomArr = {10,29,14,37,14};
		
		Comparable[] arr = randomArr;
		Sorting.bubbleSortDeepImproved(arr);
		for(Comparable a: arr) {
			System.out.print(a+" ");
		}
	}

}
