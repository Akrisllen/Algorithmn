# Algorithmn
## Sorting
### Bubble Sorting
核心思想
每次把通过相邻比较和交换的方式，找出未排序数组中最大值并移到最右侧。

性能分析
效率低下，O(n^2)。

改进方法
1. 添加判断，如果待排序数组已经有序则不进入第二次循环
2. 一次循环，找出最大值，和最小值

实现代码与改进代码如下：
```

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
		boolean swapped = false;
		int i = 0;
		do  {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (compareTo(arr[j], arr[j + 1])) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if(!swapped) continue;
		}while(i++ < arr.length);
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
```
### Selection Sort
核心思想
与冒泡类似，每次选择最小值，通过和未排序数组首位交换的方式，实现排序。与冒泡不同，选择排序并不是每次和相邻数组交换，而是记录下最小值的位置。在第二层循环结束之后进行交换。减少了交换的次数，因此比冒泡的效率好一些。

性能分析
选择排序减少了交换的次数，但是算法效率依旧是O(n^2)

优化策略
类似冒泡的优化，可以每次选出最大值和最小值

具体实现如下
```
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
```

### Insert Sort 
核心思想
插入排序 是在已有序的数组中添加新值。

性能分析
由于插入位置之前的数组已经有序，不需要像冒泡或者选择排序一样，每次循环都需要两两比较，减少了比较的次数。

优化方式
如果数组插入值大于当前值跳出循环

代码实现
```
package Sort;

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
```

### Shell Sort
核心思想
希尔排序 是 插入排序的进阶版，实际上就是按照一定步长进行分组后，执行插入排序。最后当步长为1时，执行插入排序。
希尔排序的优点在于，小步长排序之后，数组对于大步长也是有序的。因此算法在迭代之前不会打乱之前的顺序。提高了排序的效率。

性能分析
希尔排序 的效率依赖于步长的选择。
一般使用如下方式，基本够用
```
int h=1;
while(h<N/5) h=h*5+1;
```

实现代码
```
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

}
```

### Merge Sort
核心思想：

代码实现：
```
package Sort;

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

```
### Quick Sort
核心思想：
快排 是 归并排序的增强版，同样是分治法的一种实现方式，需要分成左右两部分分别排序。
唯一的区别就是快排的基准并不是中间值，而是需要满足左边<基准，右边>基准的值。

需要避免/改进的情况：
1. 基准的选择： 快排依赖基准。因此应该针对首位为最小值这一情况进行优化
2. 递归的结束： 快排中左右分别排序使用了递归方式，当左右子数组长度为1时应该停止递归
3. 循环的结束： 应考虑，是否写出了死循环，循环中是否每个数都参与了比较，是否排除了基准的比较。

性能分析：
快排 避免了在内循环中交换数字，因此相比归并排序和希尔排序有一定优势。
而且快排减少了比较的次数。选择了都与基准相比较的方式。
最佳情况是，基准的选择是数组的中位数。

优化策略：
小数组使用insert sort;
选基准选择三个数的中位数
如果存在较多的重复数据，将数组分为相等，大于，小于三个部分

```
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
```
改进的快排
```
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
```


