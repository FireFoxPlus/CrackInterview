package edu.crackInterview;

import java.util.LinkedList;

public class chap8_5 {
	//5.1��������32λ����N��M���Լ���ʾ����λ�õ�i��j����M����N��ʹ��M��N�ĵ�jλ��ʼ������iλ�������ٶ���
	//jλ��iλ��������M
	//�������뼴��
	
	//5.2����һ������0��1֮���ʵ��������Ϊdouble����ӡ������Ʊ�ʾ������������޷���32λ�Ķ����Ʊ�ʾ
	//���ӡERROR
	//С������2֮����������λ�����λΪ1������Ϊ0���������1��һ֮���ظ��ù��̣�ֱ�����Ϊ0����ѭ��
	
	//5.3����һ���������ҳ���������Ʊ�ʾ�е�1�ĸ�����ͬ���Ҵ�С��ӽ�������������һ���Դ�һ����С��
	public int getOnes(int num)
	{
		int rs = 0;
		while(num != 0)
		{
			if((num &  1) == 1)
				rs++;
			num = num >> 1;
		}
		return rs;
	}
	
	public int getSmaller(int num)
	{
		int rs = num - 1;
		while(true)
		{
			if(getOnes(rs) == getOnes(num))
				break;
			rs--;
		}
		return rs;
	}
	
	public int getSmaller_2(int num)
	{
		int rs = num;
		return rs;
	}
	public int getBigger(int num)
	{
		int rs = num + 1;
		while(true)
		{
			if(getOnes(rs) == getOnes(num))
				break;
			rs++;
		}
		return rs;
	}
	
	public int getBigger_2(int num)
	{
		int tmp = num;
		int zeroLoc = 1;
		int countOne = 0;
		int mask = 0;
		boolean flag = false;
		//�ҵ���һ���ǵ�β0
		while(tmp != 0)
		{
			if((tmp & 1) == 1)
			{
				flag = true;
				countOne++;
			}
			else if((tmp & 1) != 1 && flag)
				break;
			zeroLoc++;
			tmp = tmp >> 1;
		}
		num = num | (1 << (zeroLoc - 1));//��ת0
//		for(int i = 0; i < zeroLoc - 1; i++)
//		{
//				mask = mask | (1 << i);
//		}
		mask = mask | ~((1 << (zeroLoc - 1)) - 1);
		num = num & mask;//����
		mask = 0;
//		for(int i = 0; i < countOne - 1; i++)
//		{
//			mask = mask | (1 << i);
//		}
		mask = mask | ((1 << countOne - 1) - 1);
		num = num | mask;
		return num;
	}
	
	//5.4���ʹ���((n & (n - 1)) == 0)�ľ��庬��
	//n&(n-1)Ϊȥ�����ҵ�1�����˶��������Ƿ�ֻ��һ��1�����Ƿ�Ϊ2��ĳ�η�
	
	//5.5ȷ����Ҫ�ı����λ�����ܽ�����aת��Ϊ����b
	//���� 31 ��14 ��Ϊ2
	public int changeLoca(int a , int b)
	{
		int tmp = a ^ b;
		int rs = 0;
		while(tmp != 0){
			if((tmp & 1) == 1)
				rs++;
			tmp = tmp>>1;
		}
		return rs;
	}
	
	//5.6����ĳ������������λ��ż��λ��ʹ��ָ��Խ��Խ�ã���λ0��Ϊ1������λ2��λ3������
	public int  swap(int x)
	{
		return (( (x & 0xaaaaaaaa) >> 1) | ( (x & 0x55555555)<< 1) );
		
	}
	
	//5.7����A����0��n������������������ȱ��һ��������������У�ֻ��һ�β����޷�ȡ������A��ĳ���������������ݡ����⣬
	//����A��Ԫ�ؽ��Զ����Ʊ�ʾ��Ψһ���õķ��ʲ����Ǵ�A[i]ȡ����jλ��������������ʱ�临�Ӷ�Ϊ�������ҳ�ȱʧ����������O(n)
	public int getMissing(int[] vals , int n )
	{
		int rs = 0;
		LinkedList<Integer> zero = new LinkedList<Integer>();
		LinkedList<Integer> nonZero = new LinkedList<Integer>();
		for(int i = 0; i < n; i++)
		{
			zero.add(vals[i]);
		}
		int i = 0;
		while(true)
		{
			for(int k = 0; k < zero.size(); k++)
			{
				if((zero.get(k) & (1<<i)) == 1)
					nonZero.add(zero.get(k));
			}
			zero.removeAll(nonZero);			
			if(zero.size() == 0 && nonZero.size() == 0)
				break;
			if(zero.size() <= nonZero.size())
			{
				//��λΪ0
				rs  = rs | (0 << i);
				i++;
				nonZero.clear();
			}
			else
			{
				//��λΪ1
				rs =  rs | (1 << i);
				i++;
				LinkedList<Integer> tmp;
				tmp = zero;
				zero = nonZero;
				nonZero = tmp;
				nonZero.clear();
			}
		}
		return rs;
	}
	
	//5.8�и���ɫ��Ļ�洢��һ��һά�ֽ������У�ʹ��8���������ؿ��Դ����һ���ֽ����Ļ���Ϊw��
	//��w���Ա�8��������һ���ֽڲ���ֲ��������ϣ�����Ļ�߶ȿ��������鳤�ȼ���Ļ������������
	//ʵ��drwa(byte[] screen , int width�� int x1 , int x2 , int y)�����ƴӣ�x1 �� y������x2 �� y����ˮƽ��
	//w*(y - 1)/8 
	//x1/8ȡ������������Ϊ��һ��Ԫ�ؿ�ʼ�ĵڼ�λ��1��
	//x2/8ȡ������������Ϊ��һ��Ԫ�صĵڼ�λΪֹ��1
}
