package edu.crackInterview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class chap8_2 {
	//2.1 移除未排序链表中的重复节点
	public void removeRe(List<Integer> value)
	{
		int[] flag = new int[256];
		List<Integer> rem = new LinkedList<Integer>();
		for(int i = 0; i < 256; i++){
			flag[i] = 0;
		}
		int counts = 0;
		for(Integer a : value){
			if(flag[a.intValue()] == 1)
				rem.add(counts);
			else
				flag[a.intValue()]++;
			counts++;
			}
		counts = 0;
		for(Integer a: rem){
			value.remove(a.intValue() - counts);
			counts++;
		}
	}
	//2.2找出单向链表中倒数第k个节点
	public Integer lastKth(List<Integer> value , int k){
		Iterator<Integer> iter1 = value.iterator();
		Iterator<Integer> iter2 = value.iterator();
		for(int i = 0; i < k; i++){
			if(iter1.hasNext())
				iter1.next();
		}
		while(iter1.hasNext()){
			iter1.next();
			iter2.next();
		}
		return iter2.next();
	}
	
	//2.3删除单向链表中间的某个节点，假定你只能访问该节点
	//用next节点的值覆盖本节点，删除next节点
	
	//2.4以给定的值x为基准将链表分为两部分，所有小于x的节点排在大于或等于x的节点之前
	//c实现
	
	//2.5给定两个用链表表示的整数，每个节点包含一个数位，这些数位式反向存放的，即各位排在链表首部。编写函数对这两个整数求和
	//并以链表的形式返回，假设数据是正向存放的，再做一次
	//第一问：直接计算即可
	//第二问：先算非进位结果，再加上进位结果
	
	//2.6给定一个有环链表，实现一个算法返回环路的开头节点
	
	//2.7检查链表是否为回文

}
