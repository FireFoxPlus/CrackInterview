package edu.crackInterview;

import java.util.Stack;

public class chap8_3 {
	//3.1如何用一个数组实现三个栈
	//将数组分为三段，保存每一段的长度，和每个栈的栈顶指针
	
	
	//3.2设计一个栈，支持min方法，可返回栈中最小值
	//使用辅助栈存储最小元，当前元素小于辅助栈栈顶则压入辅助栈，否则不压入。弹出元素时，亦检查辅助栈栈顶是否为当前元素
	
	//3.3有一堆盘子，堆太高会倒下来，因此在现实生活中，盘子堆到一定高度时，会另外堆一堆盘子
	//实现数据结构SetOfStacks，模拟这种行为，SetOfStacks应该由多个栈组成，并在前一个栈填满时新建一个栈。此外，
	//其push和pop方法应该与普通栈相同
	//再进一步，实现popAt(int index)，根据指定的子栈，执行pop
	//可以把栈组织成栈或者链表
	
	//3.4汉诺塔问题，有三根柱子以及N个不同大小的穿孔圆盘，一开始，所有盘子自底向上从大到小一次套在第一根柱子上，
	//即每个盘子都只能放在更大的盘子上。移动盘子有以下限制
	//1.每次只移动一个盘子2.盘子只可放在比其大的盘子上
	//使用栈，将所有盘子从第一根柱子挪到最后一根
	public void Hanoi(Stack<Integer> src , Stack<Integer> help , Stack<Integer> dst , int n)
	{
		if(n == 1)
		{
			dst.push(src.pop());
			return;
		}
		Hanoi(src , dst , help , n - 1);
		dst.push(src.pop());
		Hanoi(help , src , dst , n - 1);
	}
	//3.5实现用两个栈模拟队列
	//一个栈用于入队，一个栈用于出队入队，出队栈空，则将入队栈元素压入出队栈

	//3.6按升序对栈进行排序，即最大元素位于栈顶，最多只能使用一个额外栈存放临时数据。但是不可以将数据复制到其他数据结构中
	//该栈支持peek，push，pop，isEmpty操作
	//还可以模仿quicksort,mergesort
	public void sortStack(Stack<Integer> vals)
	{
		Stack<Integer> help = new Stack<Integer>();
		while(!vals.isEmpty())
		{
			int tmp = vals.pop();
			while(!help.isEmpty() && help.peek() > tmp)
			{
				int popVal = help.pop();
				vals.push(popVal);
			}
			help.push(tmp);
		}
		System.out.println(help.size());
		while(!help.isEmpty())
			System.out.println(help.pop().intValue());	
	}
	
	//3.7在动物收容所，收养人只能收养最老的动物（收容时间最长），或者挑选猫或狗（亦为此类动物中最老）。
	//创建适合这个系统的数据结构，实现各种操作方法，比如enqueue，dequeueany，dequeueDog，dequeCat，允许使用LinkedList
	//维护猫、狗的队列各一个，出队最老的或者本队列最老的
}
