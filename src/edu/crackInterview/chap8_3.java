package edu.crackInterview;

import java.util.Stack;

public class chap8_3 {
	//3.1�����һ������ʵ������ջ
	//�������Ϊ���Σ�����ÿһ�εĳ��ȣ���ÿ��ջ��ջ��ָ��
	
	
	//3.2���һ��ջ��֧��min�������ɷ���ջ����Сֵ
	//ʹ�ø���ջ�洢��СԪ����ǰԪ��С�ڸ���ջջ����ѹ�븨��ջ������ѹ�롣����Ԫ��ʱ�����鸨��ջջ���Ƿ�Ϊ��ǰԪ��
	
	//3.3��һ�����ӣ���̫�߻ᵹ�������������ʵ�����У����Ӷѵ�һ���߶�ʱ���������һ������
	//ʵ�����ݽṹSetOfStacks��ģ��������Ϊ��SetOfStacksӦ���ɶ��ջ��ɣ�����ǰһ��ջ����ʱ�½�һ��ջ�����⣬
	//��push��pop����Ӧ������ͨջ��ͬ
	//�ٽ�һ����ʵ��popAt(int index)������ָ������ջ��ִ��pop
	//���԰�ջ��֯��ջ��������
	
	//3.4��ŵ�����⣬�����������Լ�N����ͬ��С�Ĵ���Բ�̣�һ��ʼ�����������Ե����ϴӴ�Сһ�����ڵ�һ�������ϣ�
	//��ÿ�����Ӷ�ֻ�ܷ��ڸ���������ϡ��ƶ���������������
	//1.ÿ��ֻ�ƶ�һ������2.����ֻ�ɷ��ڱ�����������
	//ʹ��ջ�����������Ӵӵ�һ������Ų�����һ��
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
	//3.5ʵ��������ջģ�����
	//һ��ջ������ӣ�һ��ջ���ڳ�����ӣ�����ջ�գ������ջԪ��ѹ�����ջ

	//3.6�������ջ�������򣬼����Ԫ��λ��ջ�������ֻ��ʹ��һ������ջ�����ʱ���ݡ����ǲ����Խ����ݸ��Ƶ��������ݽṹ��
	//��ջ֧��peek��push��pop��isEmpty����
	//������ģ��quicksort,mergesort
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
	
	//3.7�ڶ�����������������ֻ���������ϵĶ������ʱ�������������ѡè�򹷣���Ϊ���ද�������ϣ���
	//�����ʺ����ϵͳ�����ݽṹ��ʵ�ָ��ֲ�������������enqueue��dequeueany��dequeueDog��dequeCat������ʹ��LinkedList
	//ά��è�����Ķ��и�һ�����������ϵĻ��߱��������ϵ�
}
