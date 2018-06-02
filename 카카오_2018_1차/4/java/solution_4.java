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
		
		//시간을 1분단위로 변경
		for(int i = 0; i < timetable.length; i++)
		{
			char[] hour = new char[2];
			char[] min = new char[2];
			timetable[i].getChars(0, 2, hour, 0);
			timetable[i].getChars(3, 5, min, 0);
			//리스트에 timetable 값 삽입
			timetableList.add(( Integer.parseInt(String.valueOf(hour)) * 60 
					+ Integer.parseInt(String.valueOf(min)) ) +""); 
		}
		
		//시간순 정렬(합병 정렬)
		Collections.sort(timetableList);
		
		int busAdTime = 9 * 60;	//9시를 분으로 환산 Ad: arrived
		int index = 0;
		int bd_people = 0;
		//버스 운행 횟수 만큼 반복
		for(int i = 0; i < n; i++)
		{
			bd_people = 0;	//탑승한 승객 초기화
			//탑승자 시간을 확인
			for(; index < timetableList.size(); index++)
			{
				int peopleAdTime = Integer.parseInt(timetableList.get(index));	//도착 시간
				//버스 도착시간 전에 와있었고 버스 탑승객이 다 차지 않은 경우
				if(busAdTime >= peopleAdTime && bd_people < m)
				{
					bd_people ++; //탑승객 증가
				}
				else
				{
					break;
				}
			}
			
			busAdTime += t;	//다음 버스 도착시간
		}
		
		//가장 늦게 버스에 탑승할 수 있는 시간을 찾는다.
		int answer = 0;
		
		//마지막 탑승 예정자와 같은 시간에 도착할 때 버스에 못타는 경우 처리
		if(bd_people == m)	//마지막 버스의 탑승 인원이 가득찬 경우
		{
			answer = Integer.parseInt(timetableList.get(index-1)) - 1;	//마지막 탑승예상자보다 정류장에 1분 먼저 도착하기
		}
		else
		{
			answer = busAdTime - t;	//마지막 버스 도착시간에 도착하기
		}

		//시간 String으로 변경하기
		int hour = answer / 60;
		int min = answer % 60;
		String answerStr = "";
		answerStr = hour < 10 ? "0" + hour : hour+"";
		answerStr += ":";
		answerStr = min < 10 ? answerStr + "0" + min : answerStr + min+"";
		
		return answerStr;
	}
}
