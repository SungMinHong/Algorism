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
		ArrayList<String> str1Set = new ArrayList<String>();	//���ڿ�1�� ����
		ArrayList<String> str2Set = new ArrayList<String>();	//���ڿ�2�� ����

		//���ڿ��� ���ҷ� �и��� �������� �����
		classificationElement(str1, str1Set);
		classificationElement(str2, str2Set);
		
		int intersection = 0;	//������ ����
		int union = str1Set.size() + str2Set.size();	//������ ����
		int answer = 0; //��ī�� ���絵 * 65536
		if(str1Set.size() == 0 && str2Set.size() == 0)		//��� �������� ���
			answer = 1 * 65536;
		else
		{
			//������ ���ϱ�
			for(int i=0; i<str1Set.size(); i++)
			{
				String element = str1Set.get(i);//����1 ����
				//����2���� ����Ǵ� ���Ұ� �ִ��� Ȯ��
				for(int j=0; j<str2Set.size(); j++)
				{
					if(element.equalsIgnoreCase(str2Set.get(j)))	//����� ���Ұ� �ִ� ���
					{
						intersection += 1;	//������ ���� ����
						str2Set.remove(j);	//������ ���Ҵ� ������ �ߺ� ī������ ����
						break;
					}
				}
			}
			//������ ���ϱ�
			union -= intersection; //�� ������ ������ ������ ��ģ�� �������� ���� �������� ���� ���� �� ����
			answer = (int)((double)intersection / union * 65536);
		}
		return answer;
	}
	//���ҷ� �и��ϴ� �Լ�
	public static void classificationElement(char[] str, ArrayList<String> strSet)
	{
		ArrayList<Character> element = new ArrayList<Character>();	//���Ҹ� ������ �ӽ� ����Ʈ
		//���ڿ�1�� ���� ���ϱ�
		for(int i = 0 ; i < str.length; i++)
		{
			element.add(str[i]);	//���ҿ� �ش� ���� �߰�
			if(element.size() > 2) //���Ұ� 2�� �ʰ��� ���� ���
			{
				element.remove(0);	//�� ���� ����
			}
			
			String pattern = "^[a-zA-Z][a-zA-Z]$";	//������ 2���ڷ� ������ ���ڿ��� �޾Ƶ��̴� ���Խ�
			//�� ���ڷ� ������ ���Ұ� �ϼ��ǰ� �����ڷθ� ������ ���
			if(element.size() == 2 && Pattern.matches(pattern, String.valueOf(element.get(0)) + String.valueOf(element.get(1)) ))
				strSet.add(String.valueOf(element.get(0)) + String.valueOf(element.get(1)));
		}
	}
}
