package edu.crackInterview;

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
	// 11.2��д���������ַ�������������򣬽����б�λ������������λ��
	public void sortString(String[] vals)
	{
		
		
	}
	
	// 11.3����һ�����������飬����n������������������Ѿ�����ת����Σ�������֪��
	//�����ĳ��Ԫ��
	// �ٶ�Ԫ��ԭ��Ϊ��С����˳������
	public int found(int[] vals , int low , int high , int target)
	{
		
	}
	
	// 11.4��20Gb���ļ���ÿһ��һ���ַ�����˵����ν�����ļ�����
	// 11.5���������ַ������飬����ɢ��һЩ���ַ������ҳ������ַ�����λ��
	
	// 11.6����M*N�ľ���ÿһ�У�ÿһ�ж����������У��ҳ�ĳԪ��
	//�����Ͻǿ�ʼ�����target���ڸ�ֵ����ȥ���С����targetС�ڸ�ֵ����ȥ����
	
	// 11.7��Ƶ��޺���Ϸ��һ����վ����һ���˼���ϣ�������˸������ᡣ��֪�����˵ĸ߶Ⱥ�������
	// ��������ܵ�������
	// 11.8���ڶ�ȡһ��������ÿ��һ��ʱ�䣬ϣ���ҳ�����x���ȣ�С�ڻ��ߵ���x��ֵ����Ŀ����
	// ʵ�����ݽṹ���㷨֧�ָò�������ʵ��track(int x)������ÿ��һ�����ֶ����ø÷�����
	// �Լ�getRankOfNumber(int x)������ֵΪС�ڻ����x��Ԫ�ظ���
}
