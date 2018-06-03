package algorism;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class cacao2018_1_5 {
	public static void main(String[] args) {
		char[] str1 = "FRANCE".toCharArray();
		char[] str2 = "french".toCharArray();
		System.out.println(solution(str1, str2));
	}
	public static int solution(char[] str1, char[] str2)
	{
		ArrayList<String> str1Set = new ArrayList<String>();	//문자열1의 집합
		ArrayList<String> str2Set = new ArrayList<String>();	//문자열2의 집합

		//문자열을 원소로 분리해 집합으로 만들기
		classificationElement(str1, str1Set);
		classificationElement(str2, str2Set);
		
		int intersection = 0;	//교집합 갯수
		int union = str1Set.size() + str2Set.size();	//합집합 갯수
		int answer = 0; //자카드 유사도 * 65536
		if(str1Set.size() == 0 && str2Set.size() == 0)		//모두 공집합인 경우
			answer = 1 * 65536;
		else
		{
			//교집합 구하기
			for(int i=0; i<str1Set.size(); i++)
			{
				String element = str1Set.get(i);//집합1 원소
				//집합2에서 공통되는 원소가 있는지 확인
				for(int j=0; j<str2Set.size(); j++)
				{
					if(element.equalsIgnoreCase(str2Set.get(j)))	//공통된 원소가 있는 경우
					{
						intersection += 1;	//교집합 갯수 증가
						str2Set.remove(j);	//교집합 원소는 삭제해 중복 카운팅을 방지
						break;
					}
				}
			}
			//합집합 구하기
			union -= intersection; //두 집합의 원소의 갯수를 합친후 교집합을 빼면 합집합의 수를 구할 수 있음
			answer = (int)((double)intersection / union * 65536);
		}
		return answer;
	}
	//원소로 분리하는 함수
	public static void classificationElement(char[] str, ArrayList<String> strSet)
	{
		ArrayList<Character> element = new ArrayList<Character>();	//원소를 저장할 임시 리스트
		//문자열1의 집합 구하기
		for(int i = 0 ; i < str.length; i++)
		{
			element.add(str[i]);	//원소에 해당 문자 추가
			if(element.size() > 2) //원소가 2개 초과로 쌓인 경우
			{
				element.remove(0);	//앞 문자 삭제
			}
			
			String pattern = "^[a-zA-Z][a-zA-Z]$";	//영문자 2글자로 구성된 문자열만 받아들이는 정규식
			//두 글자로 구성된 원소가 완성되고 영문자로만 구성된 경우
			if(element.size() == 2 && Pattern.matches(pattern, String.valueOf(element.get(0)) + String.valueOf(element.get(1)) ))
				strSet.add(String.valueOf(element.get(0)) + String.valueOf(element.get(1)));
		}
	}
}
