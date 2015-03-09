package edu.crackInterview;

import java.util.LinkedList;

public class chap8_5 {
	//5.1给定两个32位整数N和M，以及表示比特位置的i和j，将M插入N，使得M从N的第j位开始，到第i位结束，假定从
	//j位到i位足以容纳M
	//做出掩码即可
	
	//5.2给定一个介于0和1之间的实数，类型为double，打印其二进制表示，如果该数字无法用32位的二进制表示
	//则打印ERROR
	//小数乘以2之后，有整数进位，则该位为1，否则为0。结果大于1减一之后重复该过程，直至结果为0或者循环
	
	//5.3给定一个整数，找出与其二进制表示中的1的个数相同，且大小最接近的那两个数（一个略大，一个略小）
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
		//找到第一个非掉尾0
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
		num = num | (1 << (zeroLoc - 1));//翻转0
//		for(int i = 0; i < zeroLoc - 1; i++)
//		{
//				mask = mask | (1 << i);
//		}
		mask = mask | ~((1 << (zeroLoc - 1)) - 1);
		num = num & mask;//清零
		mask = 0;
//		for(int i = 0; i < countOne - 1; i++)
//		{
//			mask = mask | (1 << i);
//		}
		mask = mask | ((1 << countOne - 1) - 1);
		num = num | mask;
		return num;
	}
	
	//5.4解释代码((n & (n - 1)) == 0)的具体含义
	//n&(n-1)为去掉最右的1。即此二进制数是否只有一个1，即是否为2的某次方
	
	//5.5确定需要改变多少位，才能将整数a转换为整数b
	//比如 31 ，14 则为2
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
	
	//5.6交换某个整数的奇数位和偶数位，使用指令越少越好（即位0与为1交换，位2与位3交换）
	public int  swap(int x)
	{
		return (( (x & 0xaaaaaaaa) >> 1) | ( (x & 0x55555555)<< 1) );
		
	}
	
	//5.7数组A包含0到n的所有整数，但其中缺了一个，在这个问题中，只用一次操作无法取得数组A里某个整数的完整内容。此外，
	//数组A的元素皆以二进制表示，唯一可用的访问操作是从A[i]取出第j位操作，给操作的时间复杂度为常数。找出缺失的整数，在O(n)
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
				//此位为0
				rs  = rs | (0 << i);
				i++;
				nonZero.clear();
			}
			else
			{
				//此位为1
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
	
	//5.8有个单色屏幕存储在一个一维字节数组中，使得8个连续像素可以存放在一个字节里。屏幕宽度为w，
	//且w可以被8整除（即一个字节不会分布在两行上），屏幕高度可以由数组长度及屏幕宽度推算而出。
	//实现drwa(byte[] screen , int width， int x1 , int x2 , int y)，绘制从（x1 ， y）到（x2 ， y）的水平线
	//w*(y - 1)/8 
	//x1/8取整，余数部分为下一个元素开始的第几位置1，
	//x2/8取整，余数部分为下一个元素的第几位为止置1
}
