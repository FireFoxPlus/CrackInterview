package edu.crackInterview;

import java.util.Arrays;
import java.util.HashMap;

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
	// 11.2编写方法，对字符串数组进行排序，将所有变位词排在相邻位置
	public String rebuildString(String rs)
	{
		char[] charRs = rs.toCharArray();
		Arrays.sort(charRs);
		return new String(charRs);
	}
	
	public void sortString(String[] vals)
	{
		for(int i  = 0; i < vals.length - 1; i++)
			for(int j = 0; j < vals.length - i - 1; j++)
			{
				String tmpj = new String() , tmpj_1 = new String();
				tmpj = rebuildString(vals[j]) ; 
						tmpj_1 = rebuildString(vals[j + 1]);
				if(tmpj.compareTo(tmpj_1) > 0)
				{
					String tmp = vals[j];
					vals[j] = vals[j + 1];
					vals[j + 1] = tmp;
				}
			}
	}
	
	// 11.3给定一个排序后的数组，包含n个整数，但这个数组已经被旋转过多次，次数不知。
	//请查找某个元素
	// 假定元素原先为从小到大顺序排列
	//此题的关键在于，以mid元素为界，一定有半边的元素是有序的
	public int found(int[] vals , int low , int high , int target)
	{
		if(low < high)
			return BSearch(vals , low , high , target);
		int mid = (low + high) / 2;
		if(vals[mid] == target)
			return mid;
		//左半有序
		if(vals[low] < vals[mid - 1])
		{
			//在左半
			if(vals[low] < target && vals[mid - 1] > target)
				return BSearch(vals , low , mid - 1 , target);
			else
				//在右半
				return found(vals , mid + 1 , high, target);
		}
		//右半有序
		else if(vals[mid + 1] < vals[high])
		{
			//在右半
			if(vals[mid + 1] < target && target < vals[high])
				return found(vals , mid + 1 , high , target);
			else
				return found(vals , low , mid - 1 , target);
		}
		else
			{
			if(found(vals , low , mid - 1 , target) == -1)
				return found(vals , mid + 1 , high , target);
			else
				return found(vals , low , mid - 1 , target);
			}
	}
	
	public int BSearch(int[] vals , int low , int high , int target)
	{
		if(low > high)
			return -1;
		int mid; 
		while(low <= high)
		{
			mid = (low +high) / 2;
			if(vals[mid] == target)
				return mid;
			if(vals[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
	// 11.4有20Gb的文件，每一行一个字符串，说明如何将这个文件排序
	//即在内存有限的情况下进行排序。
	//使用文件的外部排序，计算在当前给定的内存情况下可以读入多少字符串，并依据此将文件分块，
	//将每块文件度读入内存后，进行排序。则得到了分块有序的文件。再将各块文件进行归并排序，
	//最终得到有序的文件
	
	// 11.5有排序后的字符串数组，其中散布一些空字符串，找出给定字符串的位置
	public int getString(String[] vals , int start , int end , String target)
	{
		if(start > end || end < 0 || start < 0)
			return -1;
		int mid = (start + end) / 2;
		int tmp;
		if(vals[mid].equals(target))
			return mid;
		if(vals[mid].equals(new String("")))
			tmp = getFirstNotBlank(vals , start , end , -1 , mid);
		else
			tmp = mid;
		if(vals[tmp].compareTo(target) > 0)
			return getString(vals , start , tmp , target);
		else if(vals[tmp].equals(target))
			return tmp;
		else
			return getString(vals , getFirstNotBlank(vals , start , end , 1 , tmp) 
					, end , target);
		}
	
	public int getFirstNotBlank(String[] vals , int start , int end , int pace , int poi)
	{
		if(poi > end || poi< start)
			return -1;
		while(poi >= start && poi <= end)
		{
			if(vals[poi].equals(new String("")))
				break;
			poi += pace;
		}
		return poi;
	}
	
	// 11.6给定M*N的矩阵，每一行，每一列都以升序排列，找出某元素
	//从右上角开始，如果target大于该值，划去该行。如果target小于该值，划去该列
	
	// 11.7设计叠罗汉游戏，一个人站在另一个人肩膀上，上面的人更矮更轻。
	//已知所有人的高度和重量，
	// 计算最多能叠几个人
	//求一个最大的降序序列，冒泡
	public int Bubble(point[] persons)
	{
		for(int i = 0; i < persons.length - 1; i++)
			for(int j = 0; j < persons.length - 1 - i; j++)
			{
				if(persons[j].lessThan(persons[j + 1]))
				{
					point tmp = persons[j];
					persons[j] = persons[j + 1];
					persons[j + 1] = tmp;
				}
			}
		int count;
		for(count = 0; count < persons.length - 1; count++)
		{
			if(persons[count].isInValid(persons[count + 1]))
				break;
		}
		return count + 1;
	}
	//不改变输入本身的解法
	//保存以某元素结尾的最长子序列
	
	// 11.8正在读取一串整数，每隔一段时间，
	//希望找出数字x的秩（小于或者等于x的值的数目）。
	// 实现数据结构和算法支持该操作。即实现track(int x)方法，每读一个数字都调用该方法，
	// 以及getRankOfNumber(int x)，返回值为小于或等于x的元素个数
	//用二叉查找树组织数据，每个元素存储自己的左节点数目（包括孩子的孩子）。
	//当需要某个节点的秩的时候，使用中序遍历对该节点进行查找即可
	//需要注意，节点左移不需要计数，节点右移才需要。
}
