package edu.crackInterview;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1 , 2 , 3} , {4 , 5 , 6 } , {7 , 8 , 9}};
		chap8 ob = new chap8();
		//System.out.println(ob.compressStr("aabcccccddd"));
		ob.roll(a, 3);
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				System.out.println(a[i][j]);
//		if(ob.isSwap("water", "terwas"))
//			System.out.println("true");
//		else
//			System.out.println("false");

	}

}
