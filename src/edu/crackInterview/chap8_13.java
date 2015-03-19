package edu.crackInterview;

public class chap8_13 {
	//	13.1实现c方法，打印输出文件的最后k行
	//用c实现
	
	//13.2比较并对比散列表和STL map。散列表是怎么实现的？如果输入的数据量不大，
	//可以选用那些数据结构来替代散列表
	//STL map是使用二叉查找树来存放键值对，不需要处理冲突
	//一般的散列表使用拉链法实现的，即用一个链表数组。需要指出，
	//存储在数组某个位置的链表中的元素键是不同的，只是由键找到的位置是相同的，
	//故每个节点都需要存储键和值
	
	//13.3c++虚函数的工作原理是什么？
	//每个含有虚函数的类保有虚函数表指针，在虚函数表中存储正确的函数入口地址
	//若子类没有覆盖父类的虚函数，则保持其父类虚函数的地址，否则改为子类虚函数地址
	//再将子类对象赋给基类指针的时候，vptr指针就会指向子类的vtable，由此实现动态绑定
	
	//13.4深拷贝和浅拷贝的区别？
	//即只拷贝指针，还是将指针所指向的内存一起拷贝
	
	//13.5c语言的关键字volatile有什么作用？
	//告知编译器，即使代码不对变量做任何改动，该变量的值仍然可能会被外界修改。
	//故每次使用这个值的时候，均会从内存中重新读取，而不是使用寄存器的里的缓存值
	//表示该变量是会改变的，防止编译器做错误的优化，另外，可以将
	//const转化为非const
	
	//13.6基类的析构函数为什么要声明为virtual？
	//为了正确的释放派生类的资源
	
	//13.7编写方法，传入参数为指向node的指针，返回传入数据结构的完整拷贝，
	//其中node数据结构含有两个指向其他node的指针
	//建立本节点和其副本的映射，并借此判断某节点是否被复制过，
	//以及查找已经复制过的节点的副本
	
	//13.8编写智能指针类。智能指针是一种数据类型，一般用模板实现，模拟指针行为的同时，
	//提供自动垃圾回收机制，会自动记录smartPointer<T*>对象的引用计数，
	//一旦T类型对象的引用计数为零，就会释放该对象
	//已用c实现
	
	//13.9编写支持对齐分配的malloc和free函数，分配内存时，
	//malloc函数分配的地址必须可以被2的n次方整除
	//示例：align_malloc(1000 , 128)返回的内存地址可以被128整除。
	//并指向一块大小为1000字节的内存
	//align_free会释放align_malloc分配的内存
	//用c实现
	
	//13.10用c编写my2DAlloc函数，可以分配二维数组，
	//将malloc函数的调用次数降低到最少，并确保可以通过arr[i][j]访问该内存
	//已用c解决
}
