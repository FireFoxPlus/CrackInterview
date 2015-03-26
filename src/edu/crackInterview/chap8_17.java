package edu.crackInterview;

public class chap8_17 {
	//17.1不用临时变量，直接交换两个数
	//已用c实现
	
	// 17.2判断玩家是否赢了井字游戏
	//针对3*3棋盘的设计
	public int wonSharpGame(int[][] deck)
	{
		//正对角线
		if(deck[0][0] == deck[1][1] && deck[1][1] == deck[2][2])
			return deck[0][0];
		//副对角线
		if(deck[0][2] == deck[1][1] && deck[0][2] == deck[2][0])
			return deck[0][2];
		//行
		for(int i = 0; i < 3; i++)
			if(deck[i][0] == deck[i][1] && deck[i][0] == deck[i][2])
				return deck[i][0];
		//列
		for(int i = 0; i < 3; i++)
			if(deck[0][i] == deck[1][i] && deck[0][i] == deck[2][i])
				return deck[0][i];
		return 0;
	}
	//思路2：建立散列表，将所有的棋盘情况都存储在整数中，
	//用1,2,3分别代表玩家1、玩家2和没有棋子，那么，整个棋盘
	//其实是一个9位整数，且各位为1或2或3。
	//在对一个特定的棋盘进行判断的时候，其实是将棋盘转换成了对应的整数，
	//再查找散列表
	public int DeckByInt(char[][] deck)
	{
		int rs = 0;
		int factor = 1;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
			{
				if(deck[i][j] == 'X')
					rs += 3 * factor;
				else if(deck[i][j] == 'O')
					rs += 2 * factor;
				
				factor *= 3;
			}
		return rs;
	}
	
	//17.3算出n阶乘有多少个尾随0
	public int countDivi(int num , int divi)
	{
		int rs = 0;
		while(num > 0)
		{
			if(num % divi == 0)
				rs++;
			num /= divi;
		}
		return rs;
	}
	
	public int getLastZero(int num)
	{
		int rs = 0;
		for(int i = 1; i <= num; i++)
		{
			rs += countDivi(i,5);
		}
		return rs;
	}
	//17.4找出两个数字中较大的一个，不用if-else或其他比较运算符
	public int flip(int val)
	{
		return val ^ 1;
	}
	
	public int sign(int val)
	{
		return flip((val >> 31) & 1);
	}
	
	public int getBigger_OverFlow(int val1 , int val2)
	{
		int fir = sign(val1 - val2);
		int sec = flip(fir);
		return val1 * fir + val2 * sec;
	}
	
	public int getBigger(int val1 , int val2)
	{
		int minus = val1 - val2;
		int signFir = sign(val1);
		int signSec = sign(val2);
		int signMinus = sign(minus);
		
		int fir = (signFir ^ signSec) * signFir + flip(signFir ^ signSec) * signMinus;
		int sec = flip(fir);
		return fir * val1 + sec * val2;
	}
		
	//17.5 计算机有四个槽，每个槽放一个球，颜色可能是红色、黄色、绿色或蓝色
	//作为用户，你视图猜出颜色组合，打个比方，可能会猜YRGB。
	//要是才对某个槽的颜色，则算一次猜中，要是只才对颜色但是槽位猜错，就算一次伪猜中
	//猜中不算伪猜中。比如：实际为RGBY，猜，GGRR，则算一次猜中，一次伪猜中。
	//给定一个猜测和一种颜色组合，编写一个方法，返回猜中和伪猜中的次数
	//已用c解决
	public int map(char color)
	{
		int rs = 0; 
		if(color == 'R')
			rs = 0;
		else if(color == 'G')
			rs = 1;
		else if(color == 'B')
			rs = 2;
		else if(color == 'Y')
			rs = 3;
		return rs;
	}
	public void guessColor(String guess , String infact)
	{
		int[] record = {0  ,  0  ,  0  , 0};
		int fake = 0 , right = 0; 
		for(int i  = 0; i < 4; i++)
			record[map(guess.charAt(i))]++;
		
		for(int i = 0; i < 4; i++)
		{
			if(record[map(infact.charAt(i))] > 0)
			{
				record[map(infact.charAt(i))]--;
				if(guess.charAt(i) != infact.charAt(i))
					fake++;
				else 
					right++;
			}
		}
		System.out.println("fake:" + fake +";right:" + right);
	}
	
	//17.6给定一个整数数组，找出索引m和n，只要将m和n之间的元素排好序，
	//整个数组就是有序的。注意m-n越小越好，也就是说，找出符合条件的最短序列
	//已用c解决
	
	//17.7给定一个整数，打印该整数的英文描述
	public void printString(int val)
	{
		String[] num1 = {"" , "one" , "two" , "three" , "four" , "five" , "six" , "seven"
				, "eight" , "nine"};
		String[] num2 = {"" , "ten" , "eleven" , "twelve" , "thirteen" , "fourteen" , 
				"fifteen" , "sixteen" , "seventeen" , "eightteen" , "nineteen" , "twenty"
				,"thirty" , "fourty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
		String[] digits = {"thousand" ,  "hundred" , "" , ""};
		String int_rs = new String();
		while(val != 0)
		{
			String tmp = new String();
			tmp = String.valueOf(val % 10);
			int_rs = tmp + int_rs;
			val /= 10;
		}
		String str_rs = new String();
		for(int j = int_rs.length() - 1; j >= 0; j--)
		{
			String tmp = new String();
			if(j == int_rs.length() - 1 && int_rs.charAt(int_rs.length() - 2) != '1')
			{
				tmp = num1[int_rs.charAt(j) - '0']; 
			}
			else if(j == int_rs.length() - 1 && int_rs.charAt(int_rs.length() - 2) == '1')
			{
				tmp = num2[int_rs.charAt(int_rs.length() - 1) + int_rs.charAt(int_rs.length() - 2) - '0' - '0']; 
				j--;
			}
			else{
				tmp = num1[int_rs.charAt(j) - '0'];
				if(int_rs.charAt(j) != '0')
					tmp += digits[j];
			}
			str_rs = tmp + "  " + str_rs;
		}
		System.out.println(str_rs);
	}
	
	//17.8给定一个整数数组，求出综合最大的连续数列，并返回总和
	public int getMaxSum(int []vals , int len)
	{
		int max = 0;
		int tmp = 0;
		String rs = null;
		StringBuffer rsTmp = new StringBuffer();
		for(int i = 0; i < len; i++)
		{
			tmp += vals[i];
			if(tmp > 0)
			{
				rsTmp.append(vals[i]);
				if(tmp > max)
				{
					rs = rsTmp.toString();
					max = tmp;
				}
			}
			else
			{
				tmp = 0;
				rsTmp.delete(0 , rsTmp.capacity());
			}
		}
		System.out.println(rs);
		return max;
	}
	//17.9设计一个方法，找出任意指定单词在一本书中出现的频率
	//单次查询：依次查询，O(n)
	//多次查询：对单词构造散列表
	
	//17.10xml非常冗长，找到一种编码方式，可将每个标签对应为预先定义好的整数值。
	//打印xml元素编码后的版本
	//17.11给定rand5()，实现一个方法rand7()。也就是说，给定一个产生0-4随机数的方法，
	//产生0到6的随机数
	//关键问题在于，产生0-7的每个数字概率都需要等于1/7。所以，
	//单纯的对rand5调用多次并不可行，需要使得调用结果，
	//恰好产生某个范围内的数字各一次，5*rand5 + rand5就恰好产生
	//0-24范围内的数字各一次。
	
	//17.12设计算法，找出数组中，两数之和为指定值的所有整数对
	//未排序的数组只有已知s，找sum-s
	//数组已排序
	public void findPair(int[] vals , int len , int target)
	{
		int start = 0 , end = len - 1;
		while(start != end)
		{
			if(vals[start] + vals[end] == target)
			{
				System.out.println(vals[start] + " : " + vals[end]);
				end--;
			}
			else if(vals[start] + vals[end] > target)
				end--;
			else
				start++;
		}
	}
	//17.13有个简单的类似节点的数据结构BiNode，包含两个指向其他节点的指针
	//public class{
	//public BiNode node1 , node2;
	//public int data;
	//}
	// 数据结构BiNode可以用来表示二叉树，或双向链表，编写一个方法， 将二叉查找树
	//转换为双向链表。要求所有数值的排序不变，
	//已用c实现
	
	//17.14刚写好文章，却因为误用”查找/替换“，不慎删除了文档中所有空格、标点，
	//大写变为小写。只要能正确的分离各个单词，加标点和大小写都不是问题，大部分单词
	//在词典中都可以找到，有些则找不到。
	//给定一个字典，设计一个算法，找出拆分一连串单词的最佳方式。最佳的意义是：
	//解析后无法辨识的单词最少，无法辨识的单词全部用大写表示
}
