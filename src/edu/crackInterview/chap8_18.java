package edu.crackInterview;

public class chap8_18 {
	//18.1将两数相加，不使用加号或其他算术运算符
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
	
	//18.2洗一副牌，做到完美洗牌。即这副牌52！种排列组合方式出现的概率相同
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
	
	//18.3从大小为n的数组中随机选出m个数。要求每个元素被选中的概率相同
	//记录哪些位置被选中过？
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
	
	//18.4编写方法，数出0到n中数字2出现的次数
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
	
	//18.5有个内含单词的超大文本文件，给定任意两个单词，
	//找出这两个单词在文件中的最小距离，即相隔几个单词
	//能在O(1)时间里完成吗？空间复杂度如何？
		
	//18.6有十亿个数字，找出最小的100万个。假定计算机内存足以容纳所有十亿个数字
	//堆排序
	//时间复杂度为O（nlog(m)）m为要排序的元素
	
	//18.7给定一组单词，编写一个程序，找出其中最长的单词，
	//且该单词由这组词中的其他单词组合而成
	//用c实现
	
	//18.8给定一个字符串s和一个包含较短字符串的数组T，根据T中的每一个较短字符串，
	//对s进行搜索
	//应该建立字典树，即trie树
	
	//18.9随机生成一些数字并传入某个方法，编写程序，每当收到数字，找出并记录中位数
	//平衡二叉排序树
	
	//18.10给定两个字典里的词，长度相等。将一个单词变换为另一个单词，
	//一次只改动一个字母，
	//变换过程中，每一步新得到的单词都必须是字典里有的
	//18.11给定一个方阵，其中每个元素非黑即白，找出四条边皆为黑色像素的最大子方阵
	//18.12给定一个正整数和负整数组成的M*N矩阵，编写代码找出元素总和最大的子矩阵
	//18.13给定一份几百万个单词的清单，设计算法，创建由字母组成的最大矩形，其中
	//每一行组成一个单词，每一列也组成一个单词，不要求这些单词在清单里连续出现，
	//但是要求所有的行等长，所有的列，等高。

}
