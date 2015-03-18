package edu.crackInterview;

import java.util.Arrays;
import java.util.HashMap;

public class chap8_11 {
	// �鲢����
	// start,end�ֱ�Ϊ��ֹ�±꣬��0��length - 1
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

	// ��������
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
	// 11.1������������������A��B������A��ĩ�����㹻�Ļ�������B��
	//��дһ����������B�ϲ���A
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
	// 11.2��д���������ַ�������������򣬽����б�λ����������λ��
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
	
	// 11.3����һ�����������飬����n������������������Ѿ�����ת����Σ�������֪��
	//�����ĳ��Ԫ��
	// �ٶ�Ԫ��ԭ��Ϊ��С����˳������
	//����Ĺؼ����ڣ���midԪ��Ϊ�磬һ���а�ߵ�Ԫ���������
	public int found(int[] vals , int low , int high , int target)
	{
		if(low < high)
			return BSearch(vals , low , high , target);
		int mid = (low + high) / 2;
		if(vals[mid] == target)
			return mid;
		//�������
		if(vals[low] < vals[mid - 1])
		{
			//�����
			if(vals[low] < target && vals[mid - 1] > target)
				return BSearch(vals , low , mid - 1 , target);
			else
				//���Ұ�
				return found(vals , mid + 1 , high, target);
		}
		//�Ұ�����
		else if(vals[mid + 1] < vals[high])
		{
			//���Ұ�
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
	// 11.4��20Gb���ļ���ÿһ��һ���ַ�����˵����ν�����ļ�����
	//�����ڴ����޵�����½�������
	//ʹ���ļ����ⲿ���򣬼����ڵ�ǰ�������ڴ�����¿��Զ�������ַ����������ݴ˽��ļ��ֿ飬
	//��ÿ���ļ��ȶ����ڴ�󣬽���������õ��˷ֿ�������ļ����ٽ������ļ����й鲢����
	//���յõ�������ļ�
	
	// 11.5���������ַ������飬����ɢ��һЩ���ַ������ҳ������ַ�����λ��
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
	
	// 11.6����M*N�ľ���ÿһ�У�ÿһ�ж����������У��ҳ�ĳԪ��
	//�����Ͻǿ�ʼ�����target���ڸ�ֵ����ȥ���С����targetС�ڸ�ֵ����ȥ����
	
	// 11.7��Ƶ��޺���Ϸ��һ����վ����һ���˼���ϣ�������˸������ᡣ
	//��֪�����˵ĸ߶Ⱥ�������
	// ��������ܵ�������
	//��һ�����Ľ������У�ð��
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
	//���ı����뱾��Ľⷨ
	//������ĳԪ�ؽ�β���������
	
	// 11.8���ڶ�ȡһ��������ÿ��һ��ʱ�䣬
	//ϣ���ҳ�����x���ȣ�С�ڻ��ߵ���x��ֵ����Ŀ����
	// ʵ�����ݽṹ���㷨֧�ָò�������ʵ��track(int x)������ÿ��һ�����ֶ����ø÷�����
	// �Լ�getRankOfNumber(int x)������ֵΪС�ڻ����x��Ԫ�ظ���
	//�ö����������֯���ݣ�ÿ��Ԫ�ش洢�Լ�����ڵ���Ŀ���������ӵĺ��ӣ���
	//����Ҫĳ���ڵ���ȵ�ʱ��ʹ����������Ըýڵ���в��Ҽ���
	//��Ҫע�⣬�ڵ����Ʋ���Ҫ�������ڵ����Ʋ���Ҫ��
}
