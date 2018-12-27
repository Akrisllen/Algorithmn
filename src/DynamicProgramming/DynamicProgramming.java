package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {
	public static void main(String[] args) {
		// cut-rod 
		//例：有一根钢条，价格随长度变化为arr， 求切一根n英寸的钢条，最大收益?
		Map<Integer,Integer> arr = new HashMap<Integer,Integer>();
		arr.put(1, 1);
		arr.put(2, 5);
		arr.put(3, 8);
		arr.put(4, 9);
		arr.put(5, 10);
		arr.put(6, 17);
		arr.put(7, 17);
		arr.put(8, 20);
		arr.put(9, 24);
		arr.put(10, 30);
		
		int res = cutRod(0,20,arr);
		System.out.println(res);
	}
	
	
	private static int cutRod(int p,int n,Map<Integer,Integer> arr){
		if(n==0) return 0;
		p = 0;
		// get the value for sub question
		/** Solution one: Top to Bottom **/ 
		for(int i=1;i<n+1;i++) {
			int temp = arr.containsKey(i)?arr.get(i):0;
			p = Math.max(p,temp+cutRod(p,n-i,arr));
		}
		/** Solution tow: Bootom to Top **/
//		for(int i=0;i<n;i++) {
//			int temp = arr.containsKey(n-i)?arr.get(n-i):0;
//			p = Math.max(p, temp+cutRod(p,i,arr));
//		}
//		arr.put(n, p);
		return p;
	}
}
