import Searching.BinarySearchST;
import Sort.ShellSort;
import Sort.Sorting;

public class MyMain {
	public static void main(String[] args) {
		search();
	}
	private static void sort() {
		Comparable[] increaseArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Comparable[] decreaseArr = {40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20};
		Comparable[] randomArr = generateArray(10);
		
		Comparable[] arr = randomArr;
		Sorting sort = new ShellSort();
		
		long startTime = System.currentTimeMillis();
		sort.sort(arr);
		long endTime = System.currentTimeMillis();
		long res = endTime-startTime;
		
		System.out.println("Time Usage: " + res);
	
		for(Comparable a: arr) {
			System.out.print(a+" ");
		}
	}
	private static void search() {
		BinarySearchST bs = new BinarySearchST(10);
		bs.put("1", 1);
		bs.put("2", 2);
		bs.put("3", 3);
		bs.put("4", 4);
		bs.put("5", 5);
		
		System.out.println(bs.floor("2.5"));
	}
	private static Comparable[] generateArray(int length) {
		Comparable[] arr = new Comparable[length];
		for(int i=0;i<length;i++) {
			arr[i] = (Comparable) ((int)(Math.random()*length*10));
		}
		return arr;
	}

}