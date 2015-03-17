package edu.crackInterview;

public class chap8_11 {
	// 归并排序
	// start,end分别为起止下标，即0和length - 1
	public void mergeSort(int[] vals, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		mergeSort(vals, start, mid);
		mergeSort(vals, mid + 1, end);
		merge(vals, start, end);
	}

	public void merge(int[] vals, int start, int end) {
		int[] help = new int[end - start + 1];
		int i;
		for (i = 0; i < end - start + 1; i++)
			help[i] = vals[start + i];
		i--;
		int preStart = 0;
		int tailStart = i / 2 + 1;
		int poi = start;
		while (preStart <= i / 2 && tailStart <= i) {
			if (help[preStart] < help[tailStart]) {
				vals[poi] = help[preStart];
				preStart++;
				poi++;
			} else {
				vals[poi] = help[tailStart];
				tailStart++;
				poi++;
			}
		}
		while (preStart <= i / 2) {
			vals[poi] = help[preStart];
			poi++;
			preStart++;
		}
	}

	// 快速排序
	public void fastSort(int[] val, int start, int end) {
		if (start > end)
			return;
		int bench = partion(val, start, end);
		fastSort(val, start, bench - 1);
		fastSort(val, bench + 1, end);
	}

	public int partion(int[] vals, int start, int end) {
		int mid = (start + end) / 2;
		int mid_val = vals[mid];
		while (start < end) {
			while (vals[start] < mid_val)
				start++;

			while (vals[end] > mid_val)
				end--;
			if (start < end) {
				int tmp = vals[start];
				vals[start] = vals[end];
				vals[end] = tmp;
			}
		}
		return start;

	}
	// 11.1给定两个排序后的数组A和B，其中A的末端有足够的缓冲容纳B。
	//编写一个方法，将B合并入A
	public void JoinBA(int[] valA , int lenA , int[] valB , int lenB)
	{
		int startMerge = lenA + lenB - 1 , startA = lenA - 1 , startB = lenB - 1;
		while(startA >= 0 && startB >= 0)
		{
			if(valA[startA] > valB[startB])
			{
				valA[startMerge] = valA[startA];
				startMerge--;
				startA--;
			}
			else
			{
				valA[startMerge] = valB[startB];
				startMerge--;
				startB--;
			}
		}
		while(startB >= 0){
			valA[startMerge] = valB[startB];
			startMerge--;
			startB--;
		}
	}
	// 11.2编写方法，对字符串数组进行排序，将所有变位词排在响相邻位置
	public void sortString(String[] vals)
	{
		
		
	}
	
	// 11.3给定一个排序后的数组，包含n个整数，但这个数组已经被旋转过多次，次数不知。
	//请查找某个元素
	// 假定元素原先为从小到大顺序排列
	public int found(int[] vals , int low , int high , int target)
	{
		
	}
	
	// 11.4有20Gb的文件，每一行一个字符串，说明如何将这个文件排序
	// 11.5有排序后的字符串数组，其中散布一些空字符串，找出给定字符串的位置
	
	// 11.6给定M*N的矩阵，每一行，每一列都以升序排列，找出某元素
	//从右上角开始，如果target大于该值，划去该行。如果target小于该值，划去该列
	
	// 11.7设计叠罗汉游戏，一个人站在另一个人肩膀上，上面的人更矮更轻。已知所有人的高度和重量，
	// 计算最多能叠几个人
	// 11.8正在读取一串整数，每隔一段时间，希望找出数字x的秩（小于或者等于x的值的数目）。
	// 实现数据结构和算法支持该操作。即实现track(int x)方法，每读一个数字都调用该方法，
	// 以及getRankOfNumber(int x)，返回值为小于或等于x的元素个数
}
