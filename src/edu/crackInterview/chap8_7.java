package edu.crackInterview;

import java.util.LinkedList;

public class chap8_7 {
	//筛选法生成素数列表
	//7.1有个篮筐，两种玩法：
	//玩法一：一次出手机会，投篮命中得分
	//玩法二：三次出手机会，必须命中两次
	//如果p是某次投篮命中概率，则p值为多少才会选择玩法一或者玩法二
	//玩法二有命中两次和命中三次两种情况
	
	//7.2三角形的定点各有一只蚂蚁，如果蚂蚁沿着边爬行，两只或者三只蚂蚁装在一起的
	//概率有多大？假定每只蚂蚁随机选择一个方向，每个方向被选到的几率相等，
	//而且蚂蚁的爬行速度相同。
	//类似问题：n个顶点上的n只蚂蚁
	//三只蚂蚁均顺时针方向或者逆时针方向为1/4
	//n只蚂蚁亦同理，为1/2的n-1次方
	
	//7.3给定直角坐标系上的两条线，确定这两条线不会相交
	//不要假设斜率和截距为整数，所以此题的关键在于浮点数的判等
	
	//7.4实现整数的乘法、减法、除法，只允许用加号
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

	//7.5在二维平面上，有两个正方形，请找出一条直线，能将这两个正方形对半分，
	//假定正方形的上下两条边与x轴平行
	//该直线一定是过两正方形中心的，
	//注意两正方形中心重合的情况，以及斜率不存在的情况k
	
	//7.6在二维平面上，有一些点，找出经过点数最多的直线
	//用斜率做散列表，记录直线，枚举每一条直线，看哪条出现次数，最多
	//关键在于对浮点数的处理
	
	//7.7有些数的素因子只有3，5，7，设计算法，找出其中第K个	
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
