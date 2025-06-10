package com.javaex.ex01;

import java.util.Scanner;

public class CategoryApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
		
			System.out.println("**************************************************************");
			System.out.println("                            프로그램 시작                        ");
			System.out.println("**************************************************************");
			
			System.out.println("시작메뉴 =================================");
			System.out.println("   1. 주문 / 결제      2. 매출      3. 메뉴      4. 카테고리");
			System.out.println(" =======================================");
			System.out.println("[시작메뉴 번호를 입력해주세요]        * 0번 프로그램 종료");
			System.out.print("시작메뉴 번호 :");
			int menuNum = sc.nextInt();
			System.out.println("");
		
			
			switch(menuNum) {
			        
				case 4:
                    boolean categoryRun = true;
                    
                    while(categoryRun) {
    					System.out.println("카테고리 ----------------------------------------------------");
    					System.out.println("    1. 등록                   2. 수정                   3. 삭제");
    					System.out.println(" -------------------------------------------------------------");
    					System.out.println("<카테고리>");
    					System.out.println("카테고리 번호 - 이모티콘, 이름, 설명");
    					System.out.println();
    					System.out.println("[카테고리 번호를 입력해주세요]        * 0번 상위메뉴");
    					System.out.print("카테고리 번호 :");
    					int categoryNum = sc.nextInt();	
    					
                        if (categoryNum == 0) {
                            categoryRun = false;
                            break;
                        }
    					
    					
    					switch(categoryNum) {
    						case 1:
    							System.out.println("");
    							System.out.println("등록 ..................................................................................................");
    							System.out.println("위치 : 홈 > 카테고리 > 등록");
    							sc.nextLine();
    							System.out.print("1. 이모티콘 : ");
    							String emogi = sc.nextLine();
    							System.out.print("2. 이 름 : ");
    							String name = sc.nextLine();
    							System.out.print("3. 설 명 : ");
    							String explanation = sc.nextLine();
    							System.out.println("<등록되었습니다.>");
    							System.out.println("");
    							
    							break;
    							
    						case 2:
    							System.out.println("");
    							System.out.println("수정 ..................................................................................................");
    							System.out.println("위치 : 홈 > 카테고리 > 수정");
    							System.out.print("메뉴번호 : ");
    							int menuNo = sc.nextInt();
    							sc.nextLine();
    							System.out.print("이름 : ");
    							String menuName = sc.nextLine();
    							System.out.print("설명 : ");
    							String menuExplanation = sc.nextLine();
    							System.out.println("<수정되었습니다.>");
    							System.out.println("");
    							
    							break;
    							
    						case 3:
    							System.out.println("");
    							System.out.println("삭제 ..................................................................................................");
    							System.out.println("위치 : 홈 > 카테고리 > 삭제");
    							System.out.println("메뉴번호 : ");
    							int deleteNum = sc.nextInt();
                                if (deleteNum == 0) {
                                    break;
                                }      
    							System.out.println("<삭제되었습니다.>");
    							System.out.println("");
    							break;
    							              	
    					}//switch

						
					}//while					

					break;
					
				case 0:
					System.out.println("**************************************************************");
					System.out.println("                            프로그램 종료                        ");
					System.out.println("**************************************************************");
					
					run = false;
					break;
					
			        
			}//switch
				
		}//while

		
		
		
		sc.close();
		
	}
	
}
