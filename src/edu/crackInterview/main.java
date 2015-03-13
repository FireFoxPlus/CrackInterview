package edu.crackInterview;

import java.util.LinkedList;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		int[][] screen = {{1 , 1 , 1 , 1} , {1 , 1 , 1 , 1} , {1 , 1 , 1 , 1} , {1 , 1 , 1 , 1}};
		chap8_9 ob = new chap8_9();
		point seed = new point(2, 2);
		ob.colorScreen(screen, 4, 4, seed, 0);
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				System.out.println(screen[i][j]);

	}
}
