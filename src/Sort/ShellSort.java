package Sort;

public class ShellSort extends Sorting {
	private int N = 5;
	
	/** Normal Shell Sort **/
	public void sort(Comparable[] arr) {
		int step = 1; //set the initial step number to 1
		
		while(step<arr.length/N) step = N*step+1; //calculate the increment sequence

		while(step>0) {
			for(int i=step;i<arr.length;i++) {
				for(int j=i;j>=step;j-=step) {
					if(compareTo(arr[j-step],arr[j])) {
						swap(arr,j,j-step);
					}
				}
			}
			step /= N;
		}
	}
	/** Use more complicate N set**/
	public void sortImproved(Comparable[] arr) {
		
	}

}
