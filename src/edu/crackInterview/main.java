package edu.crackInterview;

import java.util.Stack;

public class main {

	public static void main(String[] args) {
		boolean[][] flag = new boolean[4][4];
		for(int line = 0; line < 4; line++)
			for(int col = 0; col < 4; col++)
				flag[line][col] = false;
		
		int[][] graph = {{0 , 1 , 0 , 0} , {0 , 0 , 1 , 0} , {1 , 0 , 0 , 1} , {0 , 0 , 0 , 0}};
		
		chap8_4 ob = new chap8_4();
		if(ob.isPath(graph, 4, 4, 2, flag))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
