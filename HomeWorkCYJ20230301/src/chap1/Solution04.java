package chap1;

import java.util.Scanner;

public class Solution04 {

	public static void main(String[] args) {
		/*
		 
문제:
	학생들 중 과제를 제출하지 않은 학생을 적발하는 문제 입니다.
	총 학생의 수는 10명 입니다. 각 학생들은 1번부터 10번까지 번호를 가지고 있습니다.
	학생들 중 2명의 학생이 과제를 제출하지 않았습니다. 그 학생이 몇 번 학생인지를 출력하면 됩니다.

입력: 
	Scanner를 활용하여 총 8개의 정수를 입력 받습니다.
	출석번호에 중복은 없습니다.
	입력되는 값을 제시합니다. 
	-> 3 1 4 5 7 9 6 10
	
출력:
	ex) 
	숙제를 안 낸 학생의 번호:
	2
	8
	
	의 형태로 출력합니다. 
		 
		 
		 */
		Scanner sc = new Scanner(System.in);
		int[] stuNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] hasFinished = new int[8];
		int counter=0;
		
		stu: while(true) { //숙제한 사람체크
			for(int i=0; i<8; i++) {
				System.out.printf("%d번째로 숙제를 제출한 학생의 번호: ", i+1);
				int checker = sc.nextInt();
				hasFinished[i] = checker;
				
				counter++;

				if(counter == 8)
					break stu;
			}		
		}
	
		for(int i=0; i<hasFinished.length; i++) { //
			for(int j=0; j<stuNum.length; j++) {
				if(hasFinished[i] == stuNum[j]) {
					stuNum[j] = 0;
				}
			}
		}
		
		System.out.println("숙제를 안낸 학생의 번호: ");
		for(int i=0; i<stuNum.length; i++) {
			if(!(stuNum[i]==0)) {
				System.out.println(stuNum[i]);
			}
		}

	}

}
