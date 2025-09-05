package com.kh.passenger.view;

import java.util.List;
import java.util.Scanner;

import com.kh.passenger.controller.PassengerController;
import com.kh.passenger.model.vo.Passenger;

public class PassengerView {

	private Scanner sc = new Scanner(System.in);
	private PassengerController pc = new PassengerController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 승객 정보 서비스 입니다 ===");
			System.out.println("1. 승객 전체 조회");
			System.out.println("2. 특정 항공편 승객만 조회");
			System.out.println("3. 승객 이름 키워드로 조회");
			System.out.println("4. 승객 추가");
			System.out.println("5. 승객 정보 변경");
			System.out.println("6. 승객 취소");
			System.out.println("7. 티켓 정보 보기");
			System.out.println("9.프로그램 종료");
			System.out.print("메뉴 번호 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo){
				case 1: findAll();break;
				case 2: findByFlight();break;
				case 3: findByKeyword();break;
				case 4: save();break;
				case 5: break;
				case 6: break;
				case 9: System.out.println("프로그램 종료");return;
				default: System.out.println("잘못된 번호 입력");
			}
		}
	}
	
	private void findAll() {
		
		List<Passenger> passengers = pc.findAll();
		
		if(!passengers.isEmpty()) {
			for(Passenger pass : passengers) {
				System.out.print("승객 번호 : "+pass.getPassId());
				System.out.print(" 이름 : "+pass.getPassName());
				System.out.print(" 주민등록번호 : "+pass.getPassNo());
				System.out.print(" 국적 : "+pass.getPassCountry());
				System.out.print(" 항공편 : "+pass.getFlight());
				System.out.print(" 전화번호 : "+pass.getPhone());
				System.out.print(" 좌석번호 : "+pass.getSeat());
				System.out.println();
			}
		} else {
			System.out.println("조회 결과 없음");
		}
		
		
	}
	
	private void findByFlight() {
		System.out.println("항공편으로 승객을 조회합니다.");
		System.out.print("조회할 항공편을 입력해주십시오 > ");
		String flight = sc.nextLine();
		
		Passenger pass = pc.findByFlight(flight);
		
		if(pass != null) {
			System.out.println(flight+"항공편 승객입니다.");
			System.out.println(" 승객 번호 : "+pass.getPassId());
			System.out.println(" 이름 : "+pass.getPassName());
			System.out.println(" 주민등록번호 : "+pass.getPassNo());
			System.out.println(" 국적 : "+pass.getPassCountry());
			System.out.println(" 전화번호 : "+pass.getPhone());
			System.out.println(" 좌석번호 : "+pass.getSeat());
		} else {
			System.out.println("조회 결과 없음");
		}
		
	}
	private void findByKeyword() {
		System.out.print("찾을 승객의 이름 키워드를 입력 > ");
		String keyword = sc.nextLine();
		
		List<Passenger> passengers = pc.findByKeyword(keyword);
		
		if(!passengers.isEmpty()) {
			for(Passenger pass : passengers) {
				System.out.print("승객 번호 : "+pass.getPassId());
				System.out.print(" 이름 : "+pass.getPassName());
				System.out.print(" 주민등록번호 : "+pass.getPassNo());
				System.out.print(" 국적 : "+pass.getPassCountry());
				System.out.print(" 항공편 : "+pass.getFlight());
				System.out.print(" 전화번호 : "+pass.getPhone());
				System.out.print(" 좌석번호 : "+pass.getSeat());
				System.out.println();
			}
		} else {
			System.out.println("조회 결과 없음");
		}
		
	}
	
}
