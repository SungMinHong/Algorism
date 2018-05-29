package algorism;

public class cacao2018_1_2 {
	public static void main(String[] args)
	{
		System.out.println(solution("1T2D3D#"));
	}
	
	public static int solution(String data)
	{
		int score[] = {1, 1, 1};
		
		//���ڿ� ��ȯ �˻�
		int j = 0;
		char beforeChar = '.';
		for(int i =0; i<data.length(); i++)
		{
			char mchar = data.charAt(i);
			
			//���� ���
			if('0' <= mchar && '9' >= mchar)
			{
				//���� ���ڰ� ���ڿ����� üũ
				if('0' <= beforeChar && '9' >= beforeChar)
				{
					String num = beforeChar + Character.toString(mchar);
					score[j] *= Integer.parseInt(num);
				}
				else if( i != 0)	//���� ���ڰ� ���ڰ� �ƴϿ��� ���
				{
					String num = Character.toString(mchar);
					score[++j] *= Integer.parseInt(num);
				}
			}
			
			//���ʽ� ���
			if(mchar == 'S')
			{
				score[j] = pow(score[j], 1);
			}
			else if(mchar == 'D')
			{
				score[j] = pow(score[j], 2);
			}
			else if(mchar == 'T')
			{
				score[j] = pow(score[j], 3);
			}
			
			//�ɼ� ���
			if(mchar == '*')	//��Ÿ
			{
				if(j == 0)	//ó���� ��÷�� ���
				{
					score[j] *= 2;
				}
				else	//ó���� �ƴ� ���Ŀ� ��÷�� ���
				{
					score[j-1] *= 2;
					score[j] *= 2;
				}
			}
			else if(mchar == '#')	//����
			{
				score[j] *= -1;
			}
			beforeChar = mchar;
		}
		
		//���� ���
		int sum = 0;
		for(int i=0; i<3; i++)
		{
			sum += score[i];
		}
		return sum;
	}
	
	//������ ��� �Լ�
	public static int pow(int x, int y)
	{
		int result = 1;
		for(int i = 0; i < y; i++)
		{
			result *= x;
		}
		return result;
	}
	
}
