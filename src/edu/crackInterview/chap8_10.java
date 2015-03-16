package edu.crackInterview;

public class chap8_10 {
	//10.1假如你正在搭建某种服务，有多达1000个客户端软件会调用该服务，取得每天盘后的
	//股票价格信息（开盘、收盘、最高、最低）。假设你手里有这些数据，
	//存储格式可以自行定义。那么你如何定义这套面向客户端的服务，向客户端软件提供信息？
	//1.纯文本
	//2.SQL
	//3.XML
	
	//10.2如何设计诸如FacebookheLinkedIn的超大型社交网站？请设计一种算法，
	//展示两个人之间的连接关系或者社交路径
	//针对简单情况，将所有用户做成图，那么这个问题就成为了两点之间是否有路径的问题，
	//需要指出，寻路时，深度优先可能会较广度优先更差，
	//因为某两个节点可能只有一度的间隔，但是可能会在深度优先中搜索不止一个节点
	
	//进阶：在百万用户的条件下，不能将所有的信息都存储在同一台机器上，
	//这就意味着朋友的资料和我们的资料可能不在一台机器上
	//必须要在机器之间跳转
	
	//10.3给定一个文件， 包含40亿个非负整数，设计算法，产生一个不在该文件的中的整数
	//假设你有1GB的内存来完成这项任务
	//用一位记录一个整数，绰绰有余
	//进阶，如果只有10Mb内存可用呢？假定所有值都是唯一的
	//将所有的数进行分区块计数，每个区块的数的数量一定，用一个整数计量。
	//那么区块中所出现的数少于标准的，即少了一个数，再用位向量来找出所少的数
	
	//10.4给定一个数组，包含1-N的整数，N最大为32000，数组可能含有重复的值，
	//且N的取值不定。若只有4kb内存可用，该如何打印数组中所有重复的元素？
	//使用位向量来标记出现过的数

	//10.5设计一个网络爬虫程序，如何避免陷入无限循环？
	//仍然可以抽象为图的遍历，图中有环，则会循环，可以使用散列表来记录访问过的页面
	
	//10.6给定100亿个网址，如何检测出重复的文件？这里的重复指的是两个URL完全相同
	//1.存储至磁盘
	//先将URL散列到不同的文件（相同的URL被散列到相同的文件），再对每个文件进行处理。
	//2.多台机器
	//或者使用多机模拟多文件，优点在于可以并行处理
	
	//10.7有个web服务器，实现简化版的搜索引擎。有100台机器来响应搜索查询，
	//可能会对另外的机器集群调用processSearch(String qurey)以得到真正的结果。
	//响应查询请求的机器是随机挑选的，因此两个同样地请求不一定由同一台机器响应。
	//方法processSearch开销很大，请设计一种缓存机制，缓存最近几次的查询结果，
	//当数据发生变化时，务必说明如何更新缓存
	
	
	
	
}
