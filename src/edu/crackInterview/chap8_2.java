package edu.crackInterview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class chap8_2 {
	//2.1 �Ƴ�δ���������е��ظ��ڵ�
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
	//2.2�ҳ����������е�����k���ڵ�
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
	
	//2.3ɾ�����������м��ĳ���ڵ㣬�ٶ���ֻ�ܷ��ʸýڵ�
	//��next�ڵ��ֵ���Ǳ��ڵ㣬ɾ��next�ڵ�
	
	//2.4�Ը�����ֵxΪ��׼�������Ϊ�����֣�����С��x�Ľڵ����ڴ��ڻ����x�Ľڵ�֮ǰ
	//cʵ��
	
	//2.5���������������ʾ��������ÿ���ڵ����һ����λ����Щ��λʽ�����ŵģ�����λ���������ײ�����д�������������������
	//�����������ʽ���أ����������������ŵģ�����һ��
	//��һ�ʣ�ֱ�Ӽ��㼴��
	//�ڶ��ʣ�����ǽ�λ������ټ��Ͻ�λ���
	
	//2.6����һ���л�����ʵ��һ���㷨���ػ�·�Ŀ�ͷ�ڵ�
	
	//2.7��������Ƿ�Ϊ����

}
