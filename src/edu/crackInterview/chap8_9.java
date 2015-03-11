package edu.crackInterview;

public class chap8_9 {
	//9.1有个小孩正在上楼梯，楼梯有n阶，小孩可以一次上1阶、2阶或3阶，求小孩共有
	//多少种上楼方式
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
	//9.2有个机器人坐在x*y的网格的左上角，只能向右、下移动，机器人从(0 , 0)到
	//(x , y)有多少种走法？
	public int paths(int srcx , int srcy , int dstx , int dsty)
	{
		if(srcx == dstx && srcy - 1 == dsty)
			return 1;
		if(srcx + 1 == dstx && srcy == dsty)
			return 1;
		return paths(srcx + 1, srcy , dstx , dsty) + paths(srcx , srcy - 1 , dstx , dsty);
		
	}
	//进阶：假设某些点为禁区，找出一条从左上角到右下角的路
	public boolean paths_2(int srcx , int srcy , int dstx , int dsty , int disx , int disy)
	{
		if(srcx == dstx && srcy - 1 == dsty)
			return true;
		if(srcx + 1 == dstx && srcy == dsty)
			return true;
		
			return true;
	}
	
	//9.3在A[0...n-1]中，有所谓的魔术索引，满足A[i] = i;给定一个有序整数数组，元素值
	//各不相同，在数组A中找出一个魔术索引，如果存在的话
	//进阶：数组元素如果有重复，如何处理？
	//9.4求某集合所有子集
	//9.5求某字符串所有排列组合
	//9.6打印n对括号所有的有效组合
	//9.7编写函数，实现填充颜色功能。给定一个屏幕（二维数组，元素为颜色值），
	//一个点和一个新的颜色值。将新颜色值填入这个点的周围区域。直到原来的颜色全部改变
	//9.8给定不限数量的硬币，25、10、5、1分。n分有几种表示方式？
	//9.9打印八皇后的所有摆法
	//9.10那个箱子，宽w，高h，深d。箱子不可翻转，箱子堆起来的时候，
	//下面箱子的宽、高、深必须大于上面的箱子，搭出最高的箱子，箱堆的高度为每个箱子的
	//高度的和
	//9.11给定布尔表达式，由0 ， 1 ， & ， | ， ^组成，以及一个想要的结果rs，
	//实现一个函数，计算有几种括号的放置方法可以得出rs
	//比如：1^0|0|1
	//期望：false
	//1^((0|0)|1)和1^(0|(0|1))
}
