package com.kh.ticket.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.kh.ticket.controller.TicketController;
import com.kh.ticket.model.dto.TicketDTO;
import com.kh.ticket.model.vo.Ticket;

public class TicketView {
	private Scanner sc = new Scanner(System.in);
	private TicketController tc = new TicketController();
	
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("티켓 정보 조회 서비스입니다!");
			System.out.println("\n===========================");
			System.out.println("1. 항공편 추가하기");
			System.out.println("2. 항공편 전부 조회하기");
			System.out.println("3. 이름으로 티켓 조회하기");
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
			case 4: /*ticketUpdate();*/ break;
			case 5: /*ticketDelete();*/ break;
			case 9: System.out.println("프로그램 종료합니다."); return;
			}
		}
	}

	public void insertTicket() {
		System.out.println("항공편 추가 서비스입니다.");
		
		System.out.println("항공편을 입력해주세요. > ");
		String flight = sc.nextLine();
		System.out.println("출발날짜를 입력해주세요. > ");
		Date departureDate = Date.valueOf(sc.nextLine());
		System.out.println("탑승시간을 입력해주세요. > ");
		String boardingTime = sc.nextLine();
		System.out.println("게이트를 입력해주세요. > ");
		String gate = sc.nextLine();
		System.out.println("목적지을 입력해주세요. > ");
		String destination = sc.nextLine();
		
		int result = tc.insertTicket(flight, departureDate, boardingTime, gate, destination);

		if(result > 0) {
			System.out.println("회원 가입에 성공했습니다.");
		} else {
			System.out.println("회원 가입에 실패했습니다.");
		}
	}
		
	public void findAll() {
		
		System.out.println("\n회원 전체 조회");
		
		List<Ticket> tickets = tc.findAll();
		
		System.out.println("\n조회된 총 회원수는 " + tickets.size() + "명 입니다.");
		if(tickets.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			
			for(Ticket ticket : tickets) {
				System.out.println("==============================");
				System.out.println(ticket.getFlight() + "의 정보");
				System.out.print("출발날짜 : " + ticket.getDepartureDate() + ", ");
				System.out.print("탑승시간 : " + ticket.getBoardingTime() + ", ");
				System.out.print("게이트 : " + ticket.getGate() + ", ");
				System.out.print("목적지 : " + ticket.getDestination() + ", ");
				System.out.println();
			}
		}
	}
	
	public void findByName() {
		System.out.println("\n성함으로 항공편 검색 서비스입니다. ");
		System.out.print("성함을 입력해주세요. > ");
		String passName = sc.nextLine();
		
		TicketDTO ticketDto = tc.findByName(passName);
		
		if(ticketDto != null) {
			System.out.println(passName + "님의 항공편 검색 결과입니다.");
			System.out.println("====================================");
			System.out.print("항공편 : " + ticketDto.getFlight() + ", ");
			System.out.print("좌석번호 : " + ticketDto.getSeat() + ", ");
			System.out.print("출발날짜 : " + ticketDto.getDepartureDate() + ", ");
			System.out.print("탑승시간 : " + ticketDto.getBoardingTime() + ", ");
			System.out.print("게이트 : " + ticketDto.getGate() + ", ");
			System.out.print("목적지 : " + ticketDto.getDestination());
			System.out.println();
		} else {
			System.out.println("존재하지 않는 항공편 입니다.");
		}
		
	}
	
	
}
