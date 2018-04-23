package algorism;

public class cacao2018_1_1 {
	
	public static void main(String[] args) {
//		int n = 5;
//		int[] arr1 = {9, 20, 28, 18, 11};
//		int[] arr2 = {30, 1, 21, 17, 28};
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		String[] result = solution(n, arr1, arr2);
		for(int i =0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
		System.out.println();
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] temp = new String[n];
		
		for(int i = 0; i < n; i++)
		{
			answer[i] = ""; 	//초기화
			int bitOrRs = arr1[i] | arr2[i]; //논리합(or)결과를 구하기
			temp[i] = Integer.toBinaryString(bitOrRs); //이진수로 변경
			
			//생략된 공백에 0 채워 넣기
			int length = temp[i].length();
			if(length < n)	
			{
				for(int j = 0; j < n - length; j++)
				{
					temp[i] = '0' + temp[i];
				}
			}
			
			// "#", " "으로 변경하기
			for(int j = 0; j < n; j++)
			{
				if(temp[i].charAt(j) == '0')
				{
					answer[i] += " ";
				}
				else
				{
					answer[i] += "#";
				}
			}
		}
		return answer;
	}
	 
}
