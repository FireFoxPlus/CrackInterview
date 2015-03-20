package edu.crackInterview;

public class chap8_16 {
	/*
	 * 16.1进程和线程的区别？
	 * 进程是系统调度的单位，线程是进程内的，是资源分配的最小单位。
	 * 
	 * 16.2如何测量上下文切换的时间
	 * 16.3使用线程和锁，避免哲学家就餐问题中出现的死锁
	 * 16.4设计一个类，只有在不发生死锁的情况下，才提供锁
	 * 16.5以下代码
	 * public class Foo
	 * {
	 * public Foo(){}
	 * public void first(){}
	 * public void second(){}
	 * public void third(){}
	 * }
	 * 同一个Foo实例会被传入三个不同的线程。threadA会调用first，
	 * thredB会调用second，threadC会调用third。设计一种机制，
	 * 确保first在second之前调用，second在third之前调用
	 * 16.6给定一个类，内含同步方法A和普通方法B。在同一个程序实例中，有两个线程，
	 * 能够同时执行A？两者能否同时执行A和B?
	 */
	
}
