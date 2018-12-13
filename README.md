# Algorithmn
## Sorting
### Bubble Sorting
### Selection Sort
### Insert Sort
### Merge Sort
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


