package chap1;

import java.util.Arrays;

public class Solution02 {

	public static void main(String[] args) {
		/*
		 클래스명: Solution02
		 문제:
		 nums 배열에 저장된 요소의 개수만큼 ★을 출력하는 프로그램을 구현합니다.
		 
		 입력: 
	     입력은 따로 진행하지 않습니다.
	     예제로 사용할 배열을 제시합니다.
	     int[] nums = {4, 2, 6, 1, 3};
	
         출력:
	     ex) 
	     ★★★★
	     ★★
	     ★★★★★★
	     ★
	     ★★★	     
	     의 형태로 출력합니다.*/

		int[] nums = {4, 2, 6, 1, 3};
		
		System.out.println("현재 배열의 상태는 다음과 같습니다." + Arrays.toString(nums));
		
		for(int i=0; i<nums.length; i++) {			
			for(int j=0; j<nums[i]; j++) {
				System.out.print("★");
			}
			System.out.println();
		}	
		
		System.out.println("이쁜 별 감상하세요~");

	}

}
