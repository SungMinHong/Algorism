package algorism;

import java.util.ArrayList;

public class cacao2018_1_3 {

	public static void main(String[] args) {
		String[] cities = 
			{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//			{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//			{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//			{"Jeju", "Pangyo", "NewYork", "newyork"};
//			{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize = 3;
		System.out.println("실행시간: "+solution(cacheSize,  cities));
	}
	
	public static int solution(int cacheSize, String[] cities)
	{
		ArrayList<String> cache = new ArrayList<String>();
		int runTime = 0;//실행 시간
		
		//캐시 순환
		for(int i=0; i < cities.length; i++)
		{
			boolean cacheHit = false;	//캐쉬 hit 유무 판단
			String city = cities[i];	//도시 저장
			for(int j = 0; j < cache.size(); j++ )
			{
				if(cache.get(j).equalsIgnoreCase(city)) //캐시 hit 
				{
					cacheHit = true;
					cache.remove(j);	//해당 인덱스 삭제
					break;
				}
			}
			
			if(!cacheHit) //cache miss
			{
				if(cache.size() == cacheSize && cacheSize > 0)	//캐시가 꽉 찬 경우
					cache.remove(0);	//첫 번째 캐시 인덱스 삭제한다
				runTime += 5; // 5 증가
			}
			else //cache hit
			{
				runTime ++; 	//1 증가
			}
			cache.add(city); //캐시에 도시 추가
		}
		return runTime;
	}
}
