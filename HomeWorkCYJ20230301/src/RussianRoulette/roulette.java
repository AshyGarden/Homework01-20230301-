package RussianRoulette;

import java.util.Scanner;

public class roulette {
	
	Scanner sc = new Scanner(System.in);
	int players = 0; //참가인원
	int bullets = 0; //쓰일 탄환수
	int loadCounter = 0; //로디드 카운터(몇발장전되었는지 확인)
	int counter = 0;
	String[] playerNames = new String[players];
	void howManyPerson(int playersCount) {
		playersCount = sc.nextInt();				
		while (true){
		if(playersCount<2) {//사람수가 너무적을때
			System.out.print("게임인원이 부족합니다. 다시입력해주세요\n");
		} else if(playersCount>4) {//사람수가 너무많을떄		
			System.out.print("게임인원이 너무 많습니다. 다시입력해주세요\n");
		} else {
			players = playersCount;
			break;					
		}
		
		}
	}
	
	void startGames(int pNums, String[] pNames) {	//n명으로 게임시작	
		System.out.printf("%d명으로 게임을 시작했습니다.", pNums);
	//	return 0;	
		
		for(int i=0; i<pNames.length; i++) {
			System.out.printf("%번째 플레이어이름을 입력해주세요.",i+1);
			pNames[i] = sc.next();	
			playerNames[i] = pNames[i];
		}
	}
	
	void loadBullets(int inputBullets) { //장전함수
		inputBullets = sc.nextInt();
		while (true){									
			if(inputBullets<1) {
				System.out.print("게임에 쓰일 탄환이 너무 부족합니다. 다시입력해주세요\n");
			} else if(inputBullets>4) {
				System.out.print("게임에 쓰일 탄환이 너무많습니다. 다시입력해주세요\n");				
			} else {
				bullets = inputBullets;
				break; //여기까지 끝나면 탄환갯수가 0이 아님
			}
		}
	}
	
	//실탄을 탄창에 배치
	//실행순서 정하기	
	//난수를 이용하여 실행순서 정하기 false->true로 바꾸는것이 장전
	//시작인덱스를 난수로 정해서 돌아가게 하셔도되지만 같은위치에 두개의 실탄이 장전x		
	//아예 배치를 섞어도 상관X
	
//	void loadedBullets(boolean[] bulPos) {		
//	int armed = (int) (Math.random() * bulPos.length);
//			
//	bulletIndex: while(true) {
//		for(int i=0; i<bullets; i++) {
//			if(bulPos[armed]) { //깔끔한 코드라 본인것보다 강사님코드로 참조
//				continue;
//			} else {
//				bulPos[armed] = true;
//				counter++;
//			}
//				
//			if(counter == bullets)
//				break bulletIndex;			
//		}
//	}
//	}
	
	void loadedBullets(boolean[] bulPos) {	
		int checkNum = 0; //실탄을 정화히 장전한 횟수
		while(checkNum <bullets) { //횟수를 모르기에 while
			int position = (int) (Math.random()*bulPos.length);
			if(bulPos[position]) {
				continue;
			} else {
				bulPos[position] = true;
				checkNum++;
			}
		} //총알 배치 끝.	
	}
}
