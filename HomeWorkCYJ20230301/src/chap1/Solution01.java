package chap1;

import java.util.Scanner;

public class Solution01 {
	
	public static void main(String[] args) {

		/*
		 클래스명: Solution01
		 문제:
		 nums 배열에서 가장 큰 값을 출력하는 코드를 작성합니다. 

	     입력: 
		 Scanner를 사용해서 입력받은 값을 nums 배열에 삽입합니다.
		 배열의 크기는 10이고, 중복 입력값은 없다고 가정합니다.
		 배열의 모든 인덱스에 값을 채울 때 까지 입력을 반복합니다.
		
	     출력:
		 ex) 가장 큰 값: 95 의 형태로 출력합니다.
	     */
		
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		int count = 0; //n번쨰 카운트
		int max = 0;   //제일 큰 수 저장 변수
		
		outer: while(true) { //참일때
			for(int i=0; i<nums.length; i++) {			
				if(count == nums.length) 
					break outer; //모두 채워지면 탈출			
				
				System.out.printf("%d번째 숫자를 입력해주세요: \n", i+1);
				int num = sc.nextInt();
				nums[i] = num;
				count++;				
		    }
		}
		
		//sorting
		for(int i=0; i<nums.length-1; i++) {			
			if(nums[i]>max) {
				max = nums[i];	//제일크면 저장, 이외는 무시			
			} 
		}
		
		System.out.printf("\n입력하신 숫자중 제일 큰 숫자는 %d입니다.",max);
		sc.close();
	}

}
