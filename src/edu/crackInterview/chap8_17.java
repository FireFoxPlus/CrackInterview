package edu.crackInterview;

public class chap8_17 {
	//17.1������ʱ������ֱ�ӽ���������
	//����cʵ��
	
	// 17.2�ж�����Ƿ�Ӯ�˾�����Ϸ
	//���3*3���̵����
	public int wonSharpGame(int[][] deck)
	{
		//���Խ���
		if(deck[0][0] == deck[1][1] && deck[1][1] == deck[2][2])
			return deck[0][0];
		//���Խ���
		if(deck[0][2] == deck[1][1] && deck[0][2] == deck[2][0])
			return deck[0][2];
		//��
		for(int i = 0; i < 3; i++)
			if(deck[i][0] == deck[i][1] && deck[i][0] == deck[i][2])
				return deck[i][0];
		//��
		for(int i = 0; i < 3; i++)
			if(deck[0][i] == deck[1][i] && deck[0][i] == deck[2][i])
				return deck[0][i];
		return 0;
	}
	//˼·2������ɢ�б������е�����������洢�������У�
	//��1,2,3�ֱ�������1�����2��û�����ӣ���ô����������
	//��ʵ��һ��9λ�������Ҹ�λΪ1��2��3��
	//�ڶ�һ���ض������̽����жϵ�ʱ����ʵ�ǽ�����ת�����˶�Ӧ��������
	//�ٲ���ɢ�б�
	public int DeckByInt(char[][] deck)
	{
		int rs = 0;
		int factor = 1;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
			{
				if(deck[i][j] == 'X')
					rs += 3 * factor;
				else if(deck[i][j] == 'O')
					rs += 2 * factor;
				
				factor *= 3;
			}
		return rs;
	}
	
	//17.3���n�׳��ж��ٸ�β��0
	public int countDivi(int num , int divi)
	{
		int rs = 0;
		while(num > 0)
		{
			if(num % divi == 0)
				rs++;
			num /= divi;
		}
		return rs;
	}
	
	public int getLastZero(int num)
	{
		int rs = 0;
		for(int i = 1; i <= num; i++)
		{
			rs += countDivi(i,5);
		}
		return rs;
	}
	//17.4�ҳ����������нϴ��һ��������if-else�������Ƚ������
	public int flip(int val)
	{
		return val ^ 1;
	}
	
	public int sign(int val)
	{
		return flip((val >> 31) & 1);
	}
	
	public int getBigger_OverFlow(int val1 , int val2)
	{
		int fir = sign(val1 - val2);
		int sec = flip(fir);
		return val1 * fir + val2 * sec;
	}
	
	public int getBigger(int val1 , int val2)
	{
		int minus = val1 - val2;
		int signFir = sign(val1);
		int signSec = sign(val2);
		int signMinus = sign(minus);
		
		int fir = (signFir ^ signSec) * signFir + flip(signFir ^ signSec) * signMinus;
		int sec = flip(fir);
		return fir * val1 + sec * val2;
	}
		
	//17.5 ��������ĸ��ۣ�ÿ���۷�һ������ɫ�����Ǻ�ɫ����ɫ����ɫ����ɫ
	//��Ϊ�û�������ͼ�³���ɫ��ϣ�����ȷ������ܻ��YRGB��
	//Ҫ�ǲŶ�ĳ���۵���ɫ������һ�β��У�Ҫ��ֻ�Ŷ���ɫ���ǲ�λ�´�����һ��α����
	//���в���α���С����磺ʵ��ΪRGBY���£�GGRR������һ�β��У�һ��α���С�
	//����һ���²��һ����ɫ��ϣ���дһ�����������ز��к�α���еĴ���
	//����c���
	public int map(char color)
	{
		int rs = 0; 
		if(color == 'R')
			rs = 0;
		else if(color == 'G')
			rs = 1;
		else if(color == 'B')
			rs = 2;
		else if(color == 'Y')
			rs = 3;
		return rs;
	}
	public void guessColor(String guess , String infact)
	{
		int[] record = {0  ,  0  ,  0  , 0};
		int fake = 0 , right = 0; 
		for(int i  = 0; i < 4; i++)
			record[map(guess.charAt(i))]++;
		
		for(int i = 0; i < 4; i++)
		{
			if(record[map(infact.charAt(i))] > 0)
			{
				record[map(infact.charAt(i))]--;
				if(guess.charAt(i) != infact.charAt(i))
					fake++;
				else 
					right++;
			}
		}
		System.out.println("fake:" + fake +";right:" + right);
	}
	
	//17.6����һ���������飬�ҳ�����m��n��ֻҪ��m��n֮���Ԫ���ź���
	//���������������ġ�ע��m-nԽСԽ�ã�Ҳ����˵���ҳ������������������
	//����c���
	
	//17.7����һ����������ӡ��������Ӣ������
	public void printString(int val)
	{
		String[] num1 = {"" , "one" , "two" , "three" , "four" , "five" , "six" , "seven"
				, "eight" , "nine"};
		String[] num2 = {"" , "ten" , "eleven" , "twelve" , "thirteen" , "fourteen" , 
				"fifteen" , "sixteen" , "seventeen" , "eightteen" , "nineteen" , "twenty"
				,"thirty" , "fourty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
		String[] digits = {"thousand" ,  "hundred" , "" , ""};
		String int_rs = new String();
		while(val != 0)
		{
			String tmp = new String();
			tmp = String.valueOf(val % 10);
			int_rs = tmp + int_rs;
			val /= 10;
		}
		String str_rs = new String();
		for(int j = int_rs.length() - 1; j >= 0; j--)
		{
			String tmp = new String();
			if(j == int_rs.length() - 1 && int_rs.charAt(int_rs.length() - 2) != '1')
			{
				tmp = num1[int_rs.charAt(j) - '0']; 
			}
			else if(j == int_rs.length() - 1 && int_rs.charAt(int_rs.length() - 2) == '1')
			{
				tmp = num2[int_rs.charAt(int_rs.length() - 1) + int_rs.charAt(int_rs.length() - 2) - '0' - '0']; 
				j--;
			}
			else{
				tmp = num1[int_rs.charAt(j) - '0'];
				if(int_rs.charAt(j) != '0')
					tmp += digits[j];
			}
			str_rs = tmp + "  " + str_rs;
		}
		System.out.println(str_rs);
	}
	
	//17.8����һ���������飬����ۺ������������У��������ܺ�
	public int getMaxSum(int []vals , int len)
	{
		int max = 0;
		int tmp = 0;
		String rs = null;
		StringBuffer rsTmp = new StringBuffer();
		for(int i = 0; i < len; i++)
		{
			tmp += vals[i];
			if(tmp > 0)
			{
				rsTmp.append(vals[i]);
				if(tmp > max)
				{
					rs = rsTmp.toString();
					max = tmp;
				}
			}
			else
			{
				tmp = 0;
				rsTmp.delete(0 , rsTmp.capacity());
			}
		}
		System.out.println(rs);
		return max;
	}
	//17.9���һ���������ҳ�����ָ��������һ�����г��ֵ�Ƶ��
	//���β�ѯ�����β�ѯ��O(n)
	//��β�ѯ���Ե��ʹ���ɢ�б�
	
	//17.10xml�ǳ��߳����ҵ�һ�ֱ��뷽ʽ���ɽ�ÿ����ǩ��ӦΪԤ�ȶ���õ�����ֵ��
	//��ӡxmlԪ�ر����İ汾
	//17.11����rand5()��ʵ��һ������rand7()��Ҳ����˵������һ������0-4������ķ�����
	//����0��6�������
	//�ؼ��������ڣ�����0-7��ÿ�����ָ��ʶ���Ҫ����1/7�����ԣ�
	//�����Ķ�rand5���ö�β������У���Ҫʹ�õ��ý����
	//ǡ�ò���ĳ����Χ�ڵ����ָ�һ�Σ�5*rand5 + rand5��ǡ�ò���
	//0-24��Χ�ڵ����ָ�һ�Ρ�
	
	//17.12����㷨���ҳ������У�����֮��Ϊָ��ֵ������������
	//δ���������ֻ����֪s����sum-s
	//����������
	public void findPair(int[] vals , int len , int target)
	{
		int start = 0 , end = len - 1;
		while(start != end)
		{
			if(vals[start] + vals[end] == target)
			{
				System.out.println(vals[start] + " : " + vals[end]);
				end--;
			}
			else if(vals[start] + vals[end] > target)
				end--;
			else
				start++;
		}
	}
	//17.13�и��򵥵����ƽڵ�����ݽṹBiNode����������ָ�������ڵ��ָ��
	//public class{
	//public BiNode node1 , node2;
	//public int data;
	//}
	// ���ݽṹBiNode����������ʾ����������˫��������дһ�������� �����������
	//ת��Ϊ˫������Ҫ��������ֵ�����򲻱䣬
	//����cʵ��
	
	//17.14��д�����£�ȴ��Ϊ���á�����/�滻��������ɾ�����ĵ������пո񡢱�㣬
	//��д��ΪСд��ֻҪ����ȷ�ķ���������ʣ��ӱ��ʹ�Сд���������⣬�󲿷ֵ���
	//�ڴʵ��ж������ҵ�����Щ���Ҳ�����
	//����һ���ֵ䣬���һ���㷨���ҳ����һ�������ʵ���ѷ�ʽ����ѵ������ǣ�
	//�������޷���ʶ�ĵ������٣��޷���ʶ�ĵ���ȫ���ô�д��ʾ
}
