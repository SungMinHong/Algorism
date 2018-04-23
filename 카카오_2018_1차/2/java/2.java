package algorism;

public class cacao2018_1_2 {
	public static void main(String[] args)
	{
		System.out.println(solution("1T2D3D#"));
	}
	
	public static int solution(String data)
	{
		int score[] = {1, 1, 1};
		
		//문자열 순환 검색
		int j = 0;
		char beforeChar = '.';
		for(int i =0; i<data.length(); i++)
		{
			char mchar = data.charAt(i);
			
			//점수 계산
			if('0' <= mchar && '9' >= mchar)
			{
				//이전 문자가 숫자였는지 체크
				if('0' <= beforeChar && '9' >= beforeChar)
				{
					String num = beforeChar + Character.toString(mchar);
					score[j] *= Integer.parseInt(num);
				}
				else if( i != 0)	//이전 문자가 숫자가 아니였던 경우
				{
					String num = Character.toString(mchar);
					score[++j] *= Integer.parseInt(num);
				}
			}
			
			//보너스 계산
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
			
			//옵션 계산
			if(mchar == '*')	//스타
			{
				if(j == 0)	//처음에 당첨된 경우
				{
					score[j] *= 2;
				}
				else	//처음이 아닌 이후에 당첨된 경우
				{
					score[j-1] *= 2;
					score[j] *= 2;
				}
			}
			else if(mchar == '#')	//아차
			{
				score[j] *= -1;
			}
			beforeChar = mchar;
		}
		
		//최종 계산
		int sum = 0;
		for(int i=0; i<3; i++)
		{
			sum += score[i];
		}
		return sum;
	}
	
	//제곱근 계산 함수
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
