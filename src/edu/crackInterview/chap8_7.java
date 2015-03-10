package edu.crackInterview;

import java.util.LinkedList;

public class chap8_7 {
	//ɸѡ�����������б�
	//7.1�и����������淨��
	//�淨һ��һ�γ��ֻ��ᣬͶ�����е÷�
	//�淨�������γ��ֻ��ᣬ������������
	//���p��ĳ��Ͷ�����и��ʣ���pֵΪ���ٲŻ�ѡ���淨һ�����淨��
	//�淨�����������κ����������������
	
	//7.2�����εĶ������һֻ���ϣ�����������ű����У���ֻ������ֻ����װ��һ���
	//�����ж�󣿼ٶ�ÿֻ�������ѡ��һ������ÿ������ѡ���ļ�����ȣ�
	//�������ϵ������ٶ���ͬ��
	//�������⣺n�������ϵ�nֻ����
	//��ֻ���Ͼ�˳ʱ�뷽�������ʱ�뷽��Ϊ1/4
	//nֻ������ͬ��Ϊ1/2��n-1�η�
	
	//7.3����ֱ������ϵ�ϵ������ߣ�ȷ���������߲����ཻ
	//��Ҫ����б�ʺͽؾ�Ϊ���������Դ���Ĺؼ����ڸ��������е�
	
	//7.4ʵ�������ĳ˷���������������ֻ�����üӺ�
	public int opposite(int val)
	{
		int rs = 0;
		int pace = val > 0 ? -1 : 1;
		while(val != 0)
		{
			val += pace;
			rs += pace;
		}
		return rs;
	}
	
	public int abs(int num)
	{
		if(num < 0)
			return opposite(num);
		return num;
	}
	
	public int minus(int num1 , int num2)
	{
		return num1 + opposite(num2);
	}
	
	public int Mutil(int num1 , int num2)
	{
		if(num2 < 0 && num1 > 0)
			return Mutil(num2 , num1);
		if(num2 < 0 && num1 < 0)
			return Mutil(abs(num1) , abs(num2));
		int rs = 0;
		for(int i = 0; i < num2; i++)
			rs += num1;
		return rs;
	}
	
	public int divide(int num1 , int num2)
	{
		if(num1 < 0 && num2 < 0)
			return divide(opposite(num1) , opposite(num2));
		if((num1 >0 && num2 < 0) || (num1 < 0 && num2 > 0))
			return opposite(divide(abs(num1) , abs(num2)));
		int rs = 0;
		while(num2 <= num1)
		{
			num1 -= num2;
			rs++;
		}
		return rs;		
	}

	//7.5�ڶ�άƽ���ϣ������������Σ����ҳ�һ��ֱ�ߣ��ܽ������������ζ԰�֣�
	//�ٶ������ε�������������x��ƽ��
	//��ֱ��һ���ǹ������������ĵģ�
	//ע���������������غϵ�������Լ�б�ʲ����ڵ����k
	
	//7.6�ڶ�άƽ���ϣ���һЩ�㣬�ҳ�������������ֱ��
	//��б����ɢ�б���¼ֱ�ߣ�ö��ÿһ��ֱ�ߣ����������ִ��������
	//�ؼ����ڶԸ������Ĵ���
	
	//7.7��Щ����������ֻ��3��5��7������㷨���ҳ����е�K��	
	public int getMins(int val1 , int val2)
	{
		return val1 < val2 ? val1 : val2;
	}
	
	public int getKth(int k ){
		int tmp = 3;
		LinkedList<Integer> que3 = new LinkedList<Integer>();
		LinkedList<Integer> que5 = new LinkedList<Integer>();
		LinkedList<Integer> que7 = new LinkedList<Integer>();
		que3.add(3);
		que5.add(5);
		que7.add(7);
		while(k > 0)
		{
			tmp = getMins(que3.getFirst() , getMins(que5.getFirst() , que7.getFirst()));
			if(tmp == que3.getFirst())
			{
				que3.removeFirst();
				que3.add(3 * tmp);
				que5.add(5 * tmp);
				que7.add(7 * tmp);
			}
			else if(tmp == que5.getFirst())
			{
				que5.removeFirst();
				que5.add(5 * tmp);
				que7.add(7 * tmp);
			}
			else if(tmp == que7.getFirst())
			{
				que7.removeFirst();
				que7.add(7 * tmp);
			}
			k--;
		}
		return tmp;
	}
	
}
