package edu.crackInterview;

public class chap8_17 {
	//17.1������ʱ������ֱ�ӽ���������
	//����cʵ��
	
	// 17.2�ж�����Ƿ�Ӯ�˾�����Ϸ
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
	public int getBigger(int val1 , int val2)
	{
		int rs = val2 * (((val1 - val2)>>31) & 1) +
				val1 *  (((val2 - val1)>>31) & 1);
		
		return rs;
	}
	
	
	//17.5 ��������ĸ��ۣ�ÿ���۷�һ������ɫ�����Ǻ�ɫ����ɫ����ɫ����ɫ
	//��Ϊ�û�������ͼ�³���ɫ��ϣ�����ȷ������ܻ��YRGB��
	//Ҫ�ǲŶ�ĳ���۵���ɫ������һ�β��У�Ҫ��ֻ�Ŷ���ɫ���ǲ�λ�´�����һ��α����
	//���в���α���С����磺ʵ��ΪRGBY���£�GGRR������һ�β��У�һ��α���С�
	//����һ���²��һ����ɫ��ϣ���дһ�����������ز��к�α���еĴ���
	//����c���
	
	//17.6����һ���������飬�ҳ�����m��n��ֻҪ��m��n֮���Ԫ���ź���
	//���������������ġ�ע��m-nԽСԽ�ã�Ҳ����˵���ҳ������������������
	//����c���
	
	//17.7����һ����������ӡ��������Ӣ������
	
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
	//17.10xml�ǳ��߳����ҵ�һ�ֱ��뷽ʽ���ɽ�ÿ����ǩ��ӦΪԤ�ȶ���õ�����ֵ��
	//��ӡxmlԪ�ر����İ汾
	//17.11����rand5()��ʵ��һ������rand7()��Ҳ����˵������һ������0-4������ķ�����
	//����0��6�������
	public int rand5()
	{
		return ((int)(Math.random() * 10000)) % 5;
	}
	public int rand2()
	{
		return rand5() % 2;
	}
	public int rand7()
	{
		return  rand5() + rand2();
	}
	//17.12����㷨���ҳ������У�����֮��Ϊָ��ֵ������������
	
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
