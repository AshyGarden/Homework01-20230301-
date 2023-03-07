package RussianRoulette;

import java.util.Arrays;
import java.util.Scanner;

public class RussianRoulette {

	public static void main(String[] args) {
		/*
        - 게임 인원은 2 ~ 4명 입니다.
        - 실탄 개수는 6개 미만으로 설정하겠습니다.
        - 게임이 시작되면, 시작 인원은 랜덤으로 순서가 설정됩니다.
         또한 총알의 위치도 랜덤으로 설정됩니다.
        - 총알의 위치는 boolean 타입의 배열로 선언하여 배치하였습니다.
        ex)  [false, false, false, true, false, false]
        - 룰은 정해진 것은 없지만, 한명이 사망하면 총알의 위치를 
         랜덤으로 바꿔서 남은 인원으로 다시 진행을 할 생각입니다.
         원하는 규칙이 있다면 자유롭게 커스텀해서 작성해 보세요.
        */
		
		//Scanner sc = new Scanner(System.in);
		
		roulette ruleMas = new roulette();
	
		//게임 인원 입력
		//ruleMas.players =0;
		//ruleMas.bullets =0;
		//ruleMas.counter =0;
		
		System.out.print("게임 인원을 입력해주세요: ");	
		ruleMas.howManyPerson(ruleMas.players);		
		
		//플레이어 이름 등록하고
		//배열을 하나 생성해서 플레이어들을 배치하시면 됩니다.
		//배열의 크기는 게임 참가자의 명수와 동일합니다.
		//System.out.printf("%d명으로 게임을 시작했습니다.", players);
		
		System.out.printf("%d명으로 게임을 시작했습니다.", ruleMas.players);
		ruleMas.inputPlayerNames(ruleMas.players);	
						
		//ruleMas.startGames(ruleMas.players,ruleMas.playerNames);
		
		//실탄 개수 입력(1미만이면 안되고, 5초과도 안됩니다.)
		System.out.print("게임에 쓰일 탄환수를 입력해주세요: ");	
		ruleMas.loadBullets(ruleMas.bullets);
		
		//실탄을 탄창에 배치
		boolean[] loadedPos = new boolean[6];
		//int[] loadedPos = new int[6];
		ruleMas.loadedBullets(loadedPos);	
		
		int starter = (int)(Math.random() * ruleMas.players);
		System.out.printf("%s부터 게임을 시작합니다", ruleMas.playerNames[starter]);
		//최후의 1인or총알을 모두 소모할때까지
//		int curbulletPos = 0; //현재 탄환의 위치
//		int fire = 1; //발포횟수
//		int deathCounter = 1; //n번째 죽은사람
//		while(true) {
//			System.out.printf("%s의 %d번째 발포준비.",playerNames[starter],fire);
//			System.out.println("<엔터키로 발포!>");
//			sc.nextLine();
//			//발포시 사망했을때
//			if(bulletPos[curbulletPos]) {
//				System.out.printf("%s의 %d번째 아웃!",playerNames[starter],deathCounter);
//				players--; //사람 줄여주기
//				bullets--; //탄환수 줄여주기
//				//불릿위치 false?
//				//
//				
//			} else {
//				bullets--;//탄환수 줄여주기
//				//다음사람		
//			}
//
//		}
				
		//sc.close();
		
		//수업시간에 써본코드(졸면서쳐서 참고용만)
//		int playerCount = 0;
//		String[] playersCreate = new String[playerCount];
//		
//		//참가자 입력
//		while(true) {
//			System.out.println("게임인원을 입력해주세요(2~4명)");
//			int num = sc.nextInt();
//			playerCount = num;
//			if(playerCount<2) {
//				System.out.println("인원이 너무 적습니다(1명이하). 다시 입력해주세요");	
//			} else if(playerCount>4) {
//				System.out.println("인원이 너무 많습니다(5명이상). 다시 입력해주세요");					
//			} else {//players 2~4
//				for(int i=0; i<playerCount-1; i++) {
//					System.out.printf("%d번째 참가자 이름을 적어주세요.",i+1);
//					String inputPlayer = sc.next(); 
////					inputPlayer = playersCreate[i];
//				}
//				System.out.println("%d명으로 게임을 시작합니다!");
//				break;
//			}
//		}
//		
//		String[] players = new String[playerCount];
////		for(int i=0; i<playerCount-1; i++) {
////			players[i] = playersCreate[i];
////		}		
//		players = playersCreate;
//		playersCreate = null;
		
		
		
		//탄환개수 생성
//		while(true) {
//			System.out.println("탄환 개수를 설정해주세요");
//			
//			int bulletCount  = sc.nextInt();
//			for(int i=0; i<bulletCount; i++) {
//				bulletPos = true;
//			}
//				
//		}
			
			
		
		
//		while(true) {// 게임시작
////			for(int i = 0; i<bulletPos.length; i++) {		
////				if(bullePos[i]) {
////					}
////					
////				}			
////			
//		}
		
		
		int realBulletPos = 0;
		while(true) {
			
			System.out.printf("\n\n[%s의 차례!]\t탄창을 장전했습니다.\n", ruleMas.playerNames[starter]);
			System.out.println("# 엔터를 누르면 격발합니다!");
			ruleMas.sc.nextLine();
			
			if(loadedPos[realBulletPos]) { //총알 격발!
				
				System.out.printf("\n빵!!!\n[%s] 사망...\n"
						, ruleMas.playerNames[starter]);
				ruleMas.bullets--;
				ruleMas.players--;
				loadedPos[realBulletPos] = false; //총알이 소모되었으니 false로 변경.
				//지금 죽은 사람 기준으로 뒤에 있는 값을 한칸씩 땡기는 작업.
				for(int i=starter; i<ruleMas.playerNames.length-1; i++) {
					ruleMas.playerNames[i] = ruleMas.playerNames[i+1];
				}
				
				String[] temp = new String[ruleMas.playerNames.length-1];
				
				for(int j=0; j<temp.length; j++) {
					temp[j] = ruleMas.playerNames[j];
				}
				ruleMas.playerNames = temp; 
				temp = null;
				
				System.out.println("생존 인원: " + Arrays.toString(ruleMas.playerNames));
				
				if(ruleMas.playerNames.length == 1) {
					System.out.println("최후의 생존자: " + ruleMas.playerNames[0]); //마지막 생존자는 0번에위치
					System.out.println("게임 종료");
					break;
				} else if(ruleMas.bullets == 0) {
					System.out.println("총알을 모두 소진했습니다.");
					System.out.println("최종 생존자: " + Arrays.toString(ruleMas.playerNames));
					System.out.println("게임 종료");
					break;
				} else {
					System.out.println("남은 인원이 게임을 재개합니다.");
					
					ruleMas.sc.nextLine();
				}
				
			} else { // false였기 때문에 생존.
				System.out.println("꽝입니다.");
				starter++;
			}
			
			//플레이어가 생존할 때마다 startIdx의 값을 하나씩 올리고 있는데,
			//맨 마지막 사람까지 생존했을 경우에는 다음 차례가 첫번째 사람이기 때문에
			//인덱스를 0으로 바꿔서 배열 맨 앞사람이 순서를 가질 수 있도록 처리.
			if(starter == ruleMas.players) {
				starter = 0;
			}
			
			realBulletPos++;
			
		}
		
		
	}
		
}
	
	

