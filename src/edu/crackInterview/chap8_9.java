package edu.crackInterview;

public class chap8_9 {
	//9.1�и�С��������¥�ݣ�¥����n�ף�С������һ����1�ס�2�׻�3�ף���С������
	//��������¥��ʽ
	public int upstair(int height)
	{
		if(height == 1)
			return 1;
		if(height == 2)
			return 2;
		if(height == 3)
			return 4;
		 return upstair(height - 1) + upstair(height - 2) + upstair(height - 3) + 3;
	}
	//9.2�и�����������x*y����������Ͻǣ�ֻ�����ҡ����ƶ��������˴�(0 , 0)��
	//(x , y)�ж������߷���
	public int paths(int srcx , int srcy , int dstx , int dsty)
	{
		if(srcx == dstx && srcy - 1 == dsty)
			return 1;
		if(srcx + 1 == dstx && srcy == dsty)
			return 1;
		return paths(srcx + 1, srcy , dstx , dsty) + paths(srcx , srcy - 1 , dstx , dsty);
		
	}
	//���ף�����ĳЩ��Ϊ�������ҳ�һ�������Ͻǵ����½ǵ�·
	public boolean paths_2(int srcx , int srcy , int dstx , int dsty , int disx , int disy)
	{
		if(srcx == dstx && srcy - 1 == dsty)
			return true;
		if(srcx + 1 == dstx && srcy == dsty)
			return true;
		
			return true;
	}
	
	//9.3��A[0...n-1]�У�����ν��ħ������������A[i] = i;����һ�������������飬Ԫ��ֵ
	//������ͬ��������A���ҳ�һ��ħ��������������ڵĻ�
	//���ף�����Ԫ��������ظ�����δ���
	//9.4��ĳ���������Ӽ�
	//9.5��ĳ�ַ��������������
	//9.6��ӡn���������е���Ч���
	//9.7��д������ʵ�������ɫ���ܡ�����һ����Ļ����ά���飬Ԫ��Ϊ��ɫֵ����
	//һ�����һ���µ���ɫֵ��������ɫֵ������������Χ����ֱ��ԭ������ɫȫ���ı�
	//9.8��������������Ӳ�ң�25��10��5��1�֡�n���м��ֱ�ʾ��ʽ��
	//9.9��ӡ�˻ʺ�����аڷ�
	//9.10�Ǹ����ӣ���w����h����d�����Ӳ��ɷ�ת�����Ӷ�������ʱ��
	//�������ӵĿ��ߡ�����������������ӣ������ߵ����ӣ���ѵĸ߶�Ϊÿ�����ӵ�
	//�߶ȵĺ�
	//9.11�����������ʽ����0 �� 1 �� & �� | �� ^��ɣ��Լ�һ����Ҫ�Ľ��rs��
	//ʵ��һ�������������м������ŵķ��÷������Եó�rs
	//���磺1^0|0|1
	//������false
	//1^((0|0)|1)��1^(0|(0|1))
}
