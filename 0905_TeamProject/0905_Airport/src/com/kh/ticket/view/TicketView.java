package com.kh.ticket.view;

import java.util.Scanner;

public class TicketView {
	private Scanner sc = new Scanner(System.in);

	
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("티켓 정보 조회 서비스입니다!");
			System.out.println("\n===========================");
			System.out.println("1. 항공편 추가하기");
			System.out.println("2. 티켓 전부 조회하기");
			System.out.println("3. 이름으로 티켓 하기");
			System.out.println("4. 출발시간 변경하기");
			System.out.println("5. 항공편 취소하기");
			System.out.println("9. 메인 메뉴로 돌아가기");
			System.out.println("메뉴를 선택해주세요. > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1: insertTicket(); break;
			case 2: findAll(); break;
			case 3: findByName(); break;
			case 4: ticketUpdate(); break;
			case 5: ticketDelete(); break;
			case 9: System.out.println("프로그램 종료합니다."); return;
			}
		}
	}

	public void insertTicket() {
		System.out.println("항공편 추가 서비스입니다.");
		
		System.out.println("항공편을 입력해주세요. > ");
		String flight = sc.nextLine();
		System.out.println("출발날짜를 입력해주세요. > ");
		String departureDate = sc.nextLine();
		System.out.println("탑승시간을 입력해주세요. > ");
		String boardingTime = sc.nextLine();
		System.out.println("게이트번호를 입력해주세요. > ");
		String gate = sc.nextLine();
		System.out.println("목적지을 입력해주세요. > ");
		String destination = sc.nextLine();
		
		
		
		
	}
		
		
	
	
	
	
}
