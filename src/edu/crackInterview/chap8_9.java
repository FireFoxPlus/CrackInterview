package edu.crackInterview;

import java.util.HashMap;
import java.util.LinkedList;

public class chap8_9 {
	// 9.1有个小孩正在上楼梯，楼梯有n阶，小孩可以一次上1阶、2阶或3阶，求小孩共有
	// 多少种上楼方式
	public int upstair(int height) {
		if (height == 1)
			return 1;
		if (height == 2)
			return 2;
		if (height == 3)
			return 4;
		return upstair(height - 1) + upstair(height - 2) + upstair(height - 3);
	}

	// 9.2有个机器人坐在x*y的网格的左上角，只能向右、下移动，机器人从(0 , 0)到
	// (x , y)有多少种走法？
	// 实质是计算组合数，即从(0,0)到(x,y)一共x+y步，选出x步向右，y步向下
	public int paths(point src, point dst) {
		if (src.getX() == dst.getX() && src.getY() - 1 == dst.getY())
			return 1;
		if (src.getX() + 1 == dst.getX() && src.getY() == dst.getY())
			return 1;
		return paths(new point(src.getX() + 1, src.getY()), dst)
				+ paths(new point(src.getX(), src.getY() - 1), dst);
	}

	// 进阶：假设某些点为禁区，找出一条从左上角到右下角的路

	public void printPath(LinkedList<point> rs) {
		for (int i = 0; i < rs.size(); i++)
			System.out.print(rs.get(i).getX() + "," + rs.get(i).getY() + "#");
		System.out.println();
	}

	public boolean paths_2(point src, point dst, point dis, LinkedList<point> rs) {
		if (src.getX() > dst.getX())
			return false;
		if (src.getY() < dst.getY())
			return false;
		if (src.getX() == dst.getX() && src.getY() - 1 == dst.getY()) {
			rs.add(src);
			printPath(rs);
			rs.removeLast();
			return true;
		}
		if (src.getX() + 1 == dst.getX() && src.getY() == dst.getY()) {
			rs.add(src);
			printPath(rs);
			rs.removeLast();
			return true;
		}
		if (src.getX() + 1 == dis.getX() && src.getY() == dis.getY())
			return false;
		if (src.getX() == dis.getX() && src.getY() + 1 == dis.getY())
			return false;
		if ((src.getX() + 1 == dis.getX() && src.getY() != dis.getY())
				|| (src.getX() + 1 != dis.getX())) {
			rs.add(src);
			paths_2(new point(src.getX() + 1, src.getY()), dst, dis, rs);
			rs.removeLast();
		}
		if ((src.getY() - 1 == dis.getY() && src.getX() != dis.getX())
				|| src.getY() - 1 != dis.getY()) {
			rs.add(src);
			paths_2(new point(src.getX(), src.getY() - 1), dst, dis, rs);
			rs.removeLast();
		}
		return true;
	}

	// 9.3在A[0...n-1]中，有所谓的魔术索引，满足A[i] = i;给定一个有序整数数组，元素值
	// 各不相同，在数组A中找出一个魔术索引，如果存在的话
	public int getMagic(int[] val, int start, int end) {
		boolean found = false;
		int mid = (start + end) / 2;
		while (start < end) {
			if (val[mid] > mid) {
				end = mid - 1;
				mid = (start + end) / 2;
			} else {
				start = mid + 1;
				mid = (start + end) / 2;
			}
			if (val[mid] == mid) {
				found = true;
				break;
			}
		}
		if (found)
			return mid;
		else
			return -1;
	}

	
	// 进阶：数组元素如果有重复，如何处理？
	public int getMagic_2(int[] val , int start , int end)
	{
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(mid == val[mid])
			return mid;
		int left = getMagic_2(val, start, mid - 1 < val[mid] ? mid - 1 : val[mid]);
		if(left != -1)
			return left;
		int right = getMagic_2(val, mid + 1 > val[mid] ? mid + 1 : val[mid] , end);
		if(right != -1)
			return right;
		return -1;
	}
	
	// 9.4求某集合所有子集
	// 或者使用二进制加法模拟
	public void subSet(int[] vals, int start, int end,
			LinkedList<LinkedList<Integer>> rs) {
		if (start == end) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			tmp.add(vals[start]);
			rs.add(tmp);
			return;
		}
		subSet(vals, start + 1, end, rs);
		int len = rs.size();
		for (int i = 0; i < len; i++) {
			LinkedList<Integer> new_tmp = new LinkedList<Integer>();
			LinkedList<Integer> tmp = rs.get(i);
			new_tmp.add(vals[start]);
			for (int j = 0; j < tmp.size(); j++)
				new_tmp.add(tmp.get(j));
			rs.add(new_tmp);
		}
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		tmp.add(vals[start]);
		rs.add(tmp);
	}

	public void printRs(LinkedList<LinkedList<Integer>> rs) {
		LinkedList<Integer> tmp = new LinkedList<Integer>();
		for (int i = 0; i < rs.size(); i++) {
			tmp = rs.get(i);
			for (int j = 0; j < tmp.size(); j++)
				System.out.print(tmp.get(j));
			System.out.println();
		}
	}

	// 9.5求某字符串所有排列组合
	// 已用c实现

	// 9.6打印n对括号所有的有效组合
	public void printBracket(int n) {
		int min = 0;
		for (int i = 0; i < n; i++) {
			min = min | (1 << i);
		}
		for (int i = min; (i & (1 << (2 * n - 1))) != (1 << (2 * n - 1)); i++) {
			if (getOneNum(i) != n)
				continue;
			if (judgeZero(i, n * 2))
				printBracket(i, n * 2);
		}

	}

	public boolean judgeZero(int num, int noto) {
		int countZero = 0, countOne = 0;
		for (int i = noto - 1; i >= 0; i--) {
			if ((num & (1 << i)) == (1 << i))
				countOne++;
			else
				countZero++;
			if (countOne > countZero)
				return false;
		}
		return true;
	}

	public void printBracket(int num, int noto) {
		for (int i = noto - 1; i >= 0; i--) {
			if ((num & (1 << i)) == (1 << i))
				System.out.print(")");
			else
				System.out.print("(");
		}
		System.out.println();
	}

	public int getOneNum(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num = num & (num - 1);
		}
		return count;
	}
	public void printBrackets(int n)
	{
		StringBuffer rs = new StringBuffer();
		printBrackets(n , n  , rs);
	}
	public void printBrackets(int left , int right , StringBuffer rs)
	{
		if(left == 0 && right == 0)
		{
			System.out.println(rs.toString());
			return;
		}
		if(left != 0)
		{
			rs.append("(");
			printBrackets(left - 1 , right , rs);
			rs.deleteCharAt(rs.length() - 1);
		}
		if(right != 0 && right > left){
			rs.append(")");
			printBrackets(left , right - 1 , rs);
			int len = rs.length();
			rs.deleteCharAt(len - 1);
		}		
	}

	// 9.7编写函数，实现填充颜色功能。给定一个屏幕（二维数组，元素为颜色值），
	// 一个点和一个新的颜色值。将新颜色值填入这个点的周围区域。直到原来的颜色全部改变
	public void colorScreen(int[][] screen, int hei, int wid, point seed,
			int color) {
		int seedx = seed.getX();
		int seedy = seed.getY();
		if (seedy - 1 == 0 || seedy - 1 == wid - 1) {
			screen[seedx - 1][seedy - 1] = color;
			return;
		}
		if (seedx - 1 == 0 || seedx - 1 == hei - 1) {
			screen[seedx - 1][seedy - 1] = color;
			return;
		}
		screen[seedx - 1][seedy - 1] = color;
		if (screen[seedx - 2][seedy - 1] != color)
			colorScreen(screen, hei, wid, new point(seedx - 1, seedy), color);
		if (screen[seedx][seedy - 1] != color)
			colorScreen(screen, hei, wid, new point(seedx + 1, seedy), color);
		if (screen[seedx - 2][seedy - 2] != color)
			colorScreen(screen, hei, wid, new point(seedx - 1, seedy - 1),
					color);
		if (screen[seedx - 1][seedy - 2] != color)
			colorScreen(screen, hei, wid, new point(seedx, seedy - 1), color);
		if (screen[seedx - 1][seedy] != color)
			colorScreen(screen, hei, wid, new point(seedx, seedy + 1), color);
		if (screen[seedx - 2][seedy] != color)
			colorScreen(screen, hei, wid, new point(seedx - 1, seedy + 1),
					color);
		if (screen[seedx][seedy] != color)
			colorScreen(screen, hei, wid, new point(seedx + 1, seedy + 1),
					color);
		if (screen[seedx][seedy - 2] != color)
			colorScreen(screen, hei, wid, new point(seedx + 1, seedy - 1),
					color);
	}

	// 9.8给定不限数量的硬币，25、10、5、1分。n分有几种表示方式？
	// 可以用三个for循环，太笨
	public int getNCent(int val , int weight) 
	{
		int next_weight = 0;
		int ways = 0;
		switch(weight)
		{
		case 25:
			next_weight = 10;
			break;
		case 10:
			next_weight = 5;
			break;
		case 5 :
			next_weight = 1;
		case 1 :
			return 1;
		}
		for(int i = 0; i * weight < val; i++)
			ways = getNCent(val - i * weight, next_weight);
		return ways;
	}

	// 9.9打印八皇后的所有摆法
	public void eightQue() {
		int[][] val = new int[8][8];
		int[] line = { -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] col = { -1, -1, -1, -1, -1, -1, -1, -1 };
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				val[i][j] = 0;
		eightQue(val, line, col, 1);
	}

	public void eightQue(int[][] val, int[] line, int[] col, int ith) {
		if (ith > 8) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(val[i][j]);

				}
				System.out.println();
			}
			System.out.println("#####################");
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (poiValid(val, col, ith - 1, i)) {
				line[ith - 1] = 1;
				col[i] = 1;
				val[ith - 1][i] = 1;
				eightQue(val, line, col, ith + 1);
				val[ith - 1][i] = 0;
				line[ith - 1] = 0;
				col[i] = 0;
			}
		}
	}

	public boolean poiValid(int[][] val, int[] col, int now_line, int now_col) {
		for (int i = 0; i < 8; i++)
			if (col[now_col] == 1)
				return false;

		for (int i = 0; now_col - i >= 0 && now_line - i >= 0; i++) {
			if (val[now_line - i][now_col - i] == 1)
				return false;
		}
		for (int i = 0; now_line - i >= 0 && now_col + i < 8; i++) {
			if (val[now_line - i][now_col + i] == 1)
				return false;
		}
		return true;
	}

	// 9.10那个箱子，宽w，高h，深d。箱子不可翻转，箱子堆起来的时候，
	// 下面箱子的宽、高、深必须大于上面的箱子，搭出最高的箱子，箱堆的高度为每个箱子的
	// 高度的和

	// 9.11给定布尔表达式，由0 ， 1 ， & ， | ， ^组成，以及一个想要的结果rs，
	// 实现一个函数，计算有几种括号的放置方法可以得出rs
	// 比如：1^0|0|1
	// 期望：false
	// 1^((0|0)|1)和1^(0|(0|1))
	public int getTF(String exp , boolean rs , int start , int end)
	{
		int ways = 0;
		if(start == end)
		{
			if(exp.charAt(end) == '1' && rs)
				return 1;
			else if(exp.charAt(end) == '0' && !rs)
				return 1;
			return 0;
		}
		if(rs)
		{
			for(int i = start + 1; i < end; i += 2)
			{
				
				
			}
		}
	
	
	
	
	
	}
	}