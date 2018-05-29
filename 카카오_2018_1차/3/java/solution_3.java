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
		System.out.println("����ð�: "+solution(cacheSize,  cities));
	}
	
	public static int solution(int cacheSize, String[] cities)
	{
		ArrayList<String> cache = new ArrayList<String>();
		int runTime = 0;//���� �ð�
		
		//ĳ�� ��ȯ
		for(int i=0; i < cities.length; i++)
		{
			boolean cacheHit = false;	//ĳ�� hit ���� �Ǵ�
			String city = cities[i];	//���� ����
			for(int j = 0; j < cache.size(); j++ )
			{
				if(cache.get(j).equalsIgnoreCase(city)) //ĳ�� hit 
				{
					cacheHit = true;
					cache.remove(j);	//�ش� �ε��� ����
					break;
				}
			}
			
			if(!cacheHit) //cache miss
			{
				if(cache.size() == cacheSize && cacheSize > 0)	//ĳ�ð� �� �� ���
					cache.remove(0);	//ù ��° ĳ�� �ε��� �����Ѵ�
				runTime += 5; // 5 ����
			}
			else //cache hit
			{
				runTime ++; 	//1 ����
			}
			cache.add(city); //ĳ�ÿ� ���� �߰�
		}
		return runTime;
	}
}
