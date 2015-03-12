package edu.crackInterview;

import java.util.HashMap;
import java.util.LinkedList;


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
	public int paths(point src , point dst)
	{
		if(src.getX() == dst.getX() && src.getY() - 1 == dst.getY())
			return 1;
		if(src.getX() + 1 == dst.getX() && src.getY() == dst.getY())
			return 1;
		return paths(new point(src.getX() + 1 , src.getY()) , dst) +
				paths(new point(src.getX() , src.getY() - 1) , dst);
	}
	//���ף�����ĳЩ��Ϊ�������ҳ�һ�������Ͻǵ����½ǵ�·
	public void printPath(LinkedList<point> rs)
	{
		for(int i = 0; i < rs.size(); i++)
			System.out.print(rs.get(i).getX() + "," + rs.get(i).getY()+ "#");
		System.out.println();
	}
	public boolean paths_2(point src , point dst , point dis , LinkedList<point> rs)
	{
		if(src.getX() > dst.getX())
			return false;
		if(src.getY() < dst.getY())
			return false;
		if(src.getX() == dst.getX() && src.getY() - 1 == dst.getY())
		{
			rs.add(src);
			printPath(rs);
			rs.removeLast();
			return true;
		}
		if(src.getX() + 1 == dst.getX() && src.getY() == dst.getY())
		{
			rs.add(src);
			printPath(rs);
			rs.removeLast();
			return true;
		}
		if(src.getX() + 1 == dis.getX() && src.getY() == dis.getY())
			return false;
		if(src.getX() == dis.getX() && src.getY() + 1 == dis.getY())
			return false;
		if((src.getX() + 1 == dis.getX() && src.getY() != dis.getY()) 
				|| (src.getX() + 1 != dis.getX())){
			rs.add(src);
			paths_2(new point(src.getX() + 1, src.getY()), dst, dis, rs);
			rs.removeLast();
		}
		if((src.getY() - 1 == dis.getY() && src.getX() != dis.getX()) 
				|| src.getY() - 1 != dis.getY())
		{
			rs.add(src);
			paths_2(new point(src.getX() , src.getY() - 1), dst, dis, rs);
			rs.removeLast();
		}
		return true;
	}
	
	//9.3��A[0...n-1]�У�����ν��ħ������������A[i] = i;����һ�������������飬Ԫ��ֵ
	//������ͬ��������A���ҳ�һ��ħ��������������ڵĻ�
	//���ף�����Ԫ��������ظ�����δ���
	
	//9.4��ĳ���������Ӽ�
	//����ʹ�ö����Ƽӷ�ģ��
	public void subSet(int[] vals , int start , int end , LinkedList<LinkedList<Integer> > rs){
		if(start == end){
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			tmp.add(vals[start]);
			rs.add(tmp);
			return;
		}
		subSet(vals , start + 1 , end , rs);
		int len = rs.size();
		for(int i = 0; i < len; i++)
		{
			LinkedList<Integer> new_tmp = new LinkedList<Integer>();
			LinkedList<Integer> tmp = rs.get(i);
			new_tmp.add(vals[start]);
			for(int j = 0; j < tmp.size(); j++)
				new_tmp.add(tmp.get(j));
			rs.add(new_tmp);		
		}
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		tmp.add(vals[start]);
		rs.add(tmp);
	}
	public void printRs(LinkedList<LinkedList<Integer> > rs)
	{
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for(int i= 0; i < rs.size(); i++){
			tmp = rs.get(i);
			for(int j = 0; j < tmp.size(); j++)
				System.out.print(tmp.get(j));
			System.out.println();
		}
	}
	//9.5��ĳ�ַ��������������
	//����cʵ��
	
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
