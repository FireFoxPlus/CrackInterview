package edu.crackInterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class chap8_18 {
	//18.1��������ӣ���ʹ�üӺŻ��������������
	public int addWithBit(int val1 , int val2)
	{
		int tmp = val1 ^ val2;
		int carry = (val1 & val2)<<1;
		int rs  = tmp | carry;
		if((carry & tmp) << 1 != 0)
			return addWithBit(rs , carry);
		return rs;
	}
	
	public int addWithBit_2(int val1 , int val2)
	{
		int tmp = val1 ^ val2;
		int carry = (val1 & val2)<< 1;
		int rs =  tmp | carry;
		while((tmp & carry) << 1 != 0)
		{
			int newtmp = rs ^ carry;
			carry = (tmp & carry)<<1;
			rs = newtmp | carry;
			tmp = newtmp;
		}
		return rs;
	}
	
	//18.2ϴһ���ƣ���������ϴ�ơ����⸱��52����������Ϸ�ʽ���ֵĸ�����ͬ
	public void shuffle(int[] cards , int len)
	{
		for(int i = 0; i < len; i++)
			{
				int k = (int)(Math.random() * i);
				cards[k] = cards[k] + cards[i];
				cards[i] = cards[k] - cards[i];
				cards[k] = cards[k] - cards[i];
			}
	}
	
	//18.3�Ӵ�СΪn�����������ѡ��m������Ҫ��ÿ��Ԫ�ر�ѡ�еĸ�����ͬ
	//��¼��Щλ�ñ�ѡ�й���
	public void getRandomM(int []vals , int len , int num)
	{
		for(int i = num - 1; i < len; i++)
		{
			int k = (int)(Math.random() * len);
			if(k < num)
			{
				vals[k] = vals[k] + vals[i];
				vals[i] = vals[k] - vals[i];
				vals[k] = vals[k] - vals[i];
			}
		}
	}
	
	//18.4��д����������0��n������2���ֵĴ���
	public int twoInNum(int num)
	{
		int rs = 0;
		while(num != 0)
		{
			if(num % 10 == 2)
				rs++;
			num /= 10;
		}
		return rs;
	}
	
	public int getTwo(int n)
	{
		int rs = 0;
		for(int i = 0; i <= n; i++)
			rs += twoInNum(i);
		return rs;
	}
	
	//18.5�и��ں����ʵĳ����ı��ļ������������������ʣ�
	//�ҳ��������������ļ��е���С���룬�������������
	//����O(1)ʱ��������𣿿ռ临�Ӷ���Σ�
		
	//18.6��ʮ�ڸ����֣��ҳ���С��100������ٶ�������ڴ�������������ʮ�ڸ�����
	//������
	//ʱ�临�Ӷ�ΪO��nlog(m)��mΪҪ�����Ԫ��
	
	//18.7����һ�鵥�ʣ���дһ�������ҳ�������ĵ��ʣ�
	//�Ҹõ�����������е�����������϶���
	//��cʵ��
	
	//18.8����һ���ַ���s��һ�������϶��ַ���������T������T�е�ÿһ���϶��ַ�����
	//��s��������
	//Ӧ�ý����ֵ�������trie��
	
	//18.9�������һЩ���ֲ�����ĳ����������д����ÿ���յ����֣��ҳ�����¼��λ��
	//����������
	
	//18.10���������ֵ���Ĵʣ�������ȡ���һ�����ʱ任Ϊ��һ�����ʣ�
	//һ��ֻ�Ķ�һ����ĸ���任�����У�
	//ÿһ���µõ��ĵ��ʶ��������ֵ����е�
	public LinkedList<String> transform(String start , String end , Set<String> dic)
	{
		start = start.toUpperCase();
		end = end.toUpperCase();
		Queue<String> action = new LinkedList<String>();
		Set<String> visit = new HashSet<String>();
		Map<String , String> backTrack = new TreeMap<String , String>();
		action.add(start);
		visit.add(start);
		while(!action.isEmpty())
		{
			String w = action.poll();
			for(String v : getOneEditWords(w))
			{
				if(v.equals(end))
				{
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while(w != null)
					{
						list.add(0 , w);
						w = backTrack.get(w);
					}
					return list;
				}
				if(dic.contains(v))
				{
					if(!visit.contains(v))
					{
						action.add(v);
						visit.add(v);
						backTrack.put(v , w);
					}
				}
			}			
		}
		return null;
	}
	public Set<String> getOneEditWords(String word)
	{
		Set<String> rs = new TreeSet<String>() ;
		for(int i = 0; i < word.length(); i++)
		{
			char[] wordArray = word.toCharArray();
			for(char c = 'A'; c < 'Z'; c++)
			{
				if(c != wordArray[i])
				{
					wordArray[i] = c;
					rs.add(new String(wordArray));
				}
			}	
		}
		return rs;
	}
	//18.11����һ����������ÿ��Ԫ�طǺڼ��ף��ҳ������߽�Ϊ��ɫ���ص�����ӷ���
	
	//18.12����һ���������͸�������ɵ�M*N���󣬱�д�����ҳ�Ԫ���ܺ������Ӿ���
	public void clearArray(int [] array)
	{
		for(int i = 0; i < array.length; i++)
			array[i] = 0;
	}
	public int maxSubMatrix(int [][] matrix)
	{
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		
		int [] partial = new int[colCount];
		int maxSum = 0;
		
		for(int rowStart = 0; rowStart < rowCount; rowStart++)
		{	
			clearArray(partial);
			for(int rowEnd = rowStart; rowEnd < rowCount; rowEnd++)
			{	
				for(int i = 0; i < colCount; i++)
				{
					partial[i] += matrix[rowEnd][i];
				}
				int tempMax = maxSubArray(partial , colCount);
				maxSum = Math.max(maxSum ,  tempMax);
			}
		}
		return maxSum;
	}
	
	public int maxSubArray(int [] array , int n)
	{
		int maxSum = 0;
		int runningSum = 0;
		for(int i = 0; i < n; i++)
		{
			runningSum += array[i];
			maxSum = Math.max(maxSum , runningSum);
			if(runningSum < 0)
				runningSum = 0;
		}
		return maxSum;
	}
	//18.13����һ�ݼ���������ʵ��嵥������㷨����������ĸ��ɵ������Σ�����
	//ÿһ�����һ�����ʣ�ÿһ��Ҳ���һ�����ʣ���Ҫ����Щ�������嵥���������֣�
	//����Ҫ�����е��еȳ������е��У��ȸߡ�

}
