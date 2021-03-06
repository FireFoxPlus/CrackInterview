package edu.crackInterview;

public class chap8_4 {
	//4.1实现一个函数，检查二叉树是否平衡。平衡二叉树即两棵子树的高度差不超过1
	//已用c实现
	
	//4.2给定一个有向图，确定两个节点之间是否存在一条路径
	public boolean isPath(int[][] graph , int size , int src , int dst , boolean[][] flag)
	{
		int line , col;
		src--;
		dst--;
		for(col = 0; col < size; col++)
		{
			if(graph[src][col] != 0)
				break;
		}
		if(col == dst)
			return true;
		else if(col == size)
			return false;
		flag[src][col] = true;
		return isPath(graph , size , col , dst , flag);
	}
	
	//4.3给定有序整数数组，元素各不相同且按升序排列，创建一棵高度最小的二叉查找树
	//已用c实现
	
	//4.4给定一棵二叉树，创建含有某一深度上所有节点的链表。比如：一棵树的深度为D，则会创建D个链表
	//已用c实现
	
	//4.5实现一个函数，检查一棵二叉树是否为二叉查找树 
	//已用c实现
	
	//4.6找出二叉查找树中指定节点的下一个节点，即中序后继，可以假定每个节点都含有指向父节点的连接
	//已用c实现
	
	//4.7找出二叉树中某两个节点的第一个共同祖先，不得将额外额节点存储在另外的数据结构中。且该树不一定是二叉查找树
	//二叉查找树可以使用其本身的特性，即左子节点<根<右子节点
	//如果有指向父节点的指针，可以转换为两个链表的第一个共同节点
	//普通二叉树只想到了迭代查找，不断减半
	//已解决
	
	//4.8有两棵非常大的二叉树：T1有几百万个节点，T2有几百个节点，设计一个算法，判断T2是否为T1的子树
	//再参看解答
	
	//4.9给定一棵二叉树，其中每个节点都含有一个数值，打印节点数值总和等于某个给定值的所有路径，路径不一定从根节点开始，叶结点结束
	//已用c实现
}
