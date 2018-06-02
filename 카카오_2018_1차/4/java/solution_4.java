package algorism;

import java.util.ArrayList;
import java.util.Collections;

public class cacao2018_1_4 {

	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = 
			{"08:00", "08:01", "08:02", "08:03"};
//			{"09:10", "09:09", "08:00"};
//		    {"09:00", "09:00", "09:00", "09:00"};
//			{"00:01", "00:01", "00:01", "00:01", "00:01"};
//			{"23:59"};
//			{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		System.out.println(solution(n, t, m, timetable));
	}
	
	public static String solution(int n, int t, int m, String[] timetable)
	{
		ArrayList<String> timetableList = new ArrayList<String>();
		
		//�ð��� 1�д����� ����
		for(int i = 0; i < timetable.length; i++)
		{
			char[] hour = new char[2];
			char[] min = new char[2];
			timetable[i].getChars(0, 2, hour, 0);
			timetable[i].getChars(3, 5, min, 0);
			//����Ʈ�� timetable �� ����
			timetableList.add(( Integer.parseInt(String.valueOf(hour)) * 60 
					+ Integer.parseInt(String.valueOf(min)) ) +""); 
		}
		
		//�ð��� ����(�պ� ����)
		Collections.sort(timetableList);
		
		int busAdTime = 9 * 60;	//9�ø� ������ ȯ�� Ad: arrived
		int index = 0;
		int bd_people = 0;
		//���� ���� Ƚ�� ��ŭ �ݺ�
		for(int i = 0; i < n; i++)
		{
			bd_people = 0;	//ž���� �°� �ʱ�ȭ
			//ž���� �ð��� Ȯ��
			for(; index < timetableList.size(); index++)
			{
				int peopleAdTime = Integer.parseInt(timetableList.get(index));	//���� �ð�
				//���� �����ð� ���� ���־��� ���� ž�°��� �� ���� ���� ���
				if(busAdTime >= peopleAdTime && bd_people < m)
				{
					bd_people ++; //ž�°� ����
				}
				else
				{
					break;
				}
			}
			
			busAdTime += t;	//���� ���� �����ð�
		}
		
		//���� �ʰ� ������ ž���� �� �ִ� �ð��� ã�´�.
		int answer = 0;
		
		//������ ž�� �����ڿ� ���� �ð��� ������ �� ������ ��Ÿ�� ��� ó��
		if(bd_people == m)	//������ ������ ž�� �ο��� ������ ���
		{
			answer = Integer.parseInt(timetableList.get(index-1)) - 1;	//������ ž�¿����ں��� �����忡 1�� ���� �����ϱ�
		}
		else
		{
			answer = busAdTime - t;	//������ ���� �����ð��� �����ϱ�
		}

		//�ð� String���� �����ϱ�
		int hour = answer / 60;
		int min = answer % 60;
		String answerStr = "";
		answerStr = hour < 10 ? "0" + hour : hour+"";
		answerStr += ":";
		answerStr = min < 10 ? answerStr + "0" + min : answerStr + min+"";
		
		return answerStr;
	}
}
