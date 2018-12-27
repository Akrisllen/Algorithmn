package Searching;

public class MyMain {
	public static void main(String[] args) {
		BinarySearchST<String, Integer> bs = new BinarySearchST<String, Integer>(10);
		bs.put("1", 1);
		bs.put("2", 2);
		bs.put("3", 3);
		bs.put("4", 4);
		bs.put("5", 5);

		System.out.println(bs.floor("2.5"));
	}
}