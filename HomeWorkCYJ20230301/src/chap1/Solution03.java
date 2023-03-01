package chap1;

import java.util.Scanner;

public class Solution03 {

	public static void main(String[] args) {
		/*
		 문제:
		 scores 배열에 존재하는 점수에 순위를 매겨서 출력하는 프로그램 입니다.
		 입력: 
	     Scanner를 활용하여 총 5개의 점수를 입력받습니다.
	     타입은 정수 타입이며 scores 배열에 순서대로 삽입합니다.
	     점수의 순서는 정해진 것이 없습니다만 중복은 허용하지 않는다고 가정합니다.
	     ex) 85 100 35 47 90 
	
         출력:
	     ex) 
	     점수    		순위
	     --------------------------
	     85		     3
	     100		 1
	     35		     5
	     47		     4
	     90		     2
	
	     의 형태로 출력합니다. 점수와 순위의 간격은 적절하게 띄워 주시면 되겠습니다.
		 */
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5];
		int rankCounter = 1;
		int[] rank = new int[5];
		System.out.println("중복하지 않는 정수를 입력해주세요!");
		
		for(int i=0; i<scores.length; i++) { //점수입력
			System.out.printf("%d번쨰 점수를 입력해주세요: ",i+1);
			int inputNum = sc.nextInt();
			scores[i] = inputNum;
		}
		
		//순위 모두 1로 초기화
		for(int i=0; i<rank.length; i++){
			rank[i] = rankCounter;
		}
		
		//순위매기기
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores.length; j++) {
				if(scores[j]>scores[i]) { //같거나 작으며 어짜피 안올라감
					rank[i]++;
				}
			}
		}
		
		System.out.println("입력받은 점수들의 순위는 다음과 같습니다.");
		System.out.println("점수       순위");
		System.out.println("-------------------------------");
		
		for(int i =0; i<scores.length; i++){
			System.out.printf("%d        %d\n",scores[i], rank[i]);
		}
		
		sc.close();

	}

}
