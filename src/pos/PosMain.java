package pos;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PosMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //사용자 입력 받기 위 Scanner 객체 생성
        while (true) {
        	System.out.println("\n********************************************************************");
            System.out.println("                           프로그램 시작                        ");
            System.out.println("********************************************************************");
            System.out.println("\n시작메뉴 ===========================================================");
            System.out.println("      1. 주문 / 결제      2. 매출      3. 메뉴      4. 카테고리");
            System.out.println("====================================================================");

            int choice; 
            
            //메뉴 번호에 숫자 외(기호, 문자) 입력 시 예외 처리
            try{
                System.out.print("[시작메뉴 번호를 입력해주세요]        * 0번 프로그램 종료\n시작메뉴 번호 : ");
                choice = sc.nextInt();
            
        	}catch(InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 잘못된 입력 버리기
            continue; // 다시 입력받기
            }
            
            try {
                switch (choice) {
                    case 0:
                    	//프로그램 종료
                        System.out.println("\n********************************************************************");
                        System.out.println("                           프로그램 종료                        ");
                        System.out.println("********************************************************************");
                        return;

                    case 4:
                    	//카테고리 관리 메뉴 호출
                        categoryManagementMenu(sc);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    // 카테고리 관리 메뉴
    static void categoryManagementMenu(Scanner sc) throws SQLException {
    	
    	CategoryDAO categoryDao = new CategoryDAO(); //카테고리 데이터베이스 접근 객체 생성
        
        while (true) {
        	//카테고리 관리 메뉴 출력
            System.out.println("\n카테고리 -----------------------------------------------------------");
            System.out.println("      1. 등록                   2. 수정                   3. 삭제");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("<카테고리>");
            
            //List<CategoryVO> categories = new ArrayList();

//            for (int i =0; i<categories.size(); i++) {
//                System.out.println(categories.get(i).getId() + " - 이모티콘(" + categories.get(i).getEmoji() + "), "
//                					+ "이름(" + categories.get(i).getName() + "), 설명(" + categories.get(i).getDescription() + ")");
//            }
            
            // 데이터베이스에서 카테고리 목록 조회 및 출력
            List<CategoryVO> categories = categoryDao.getAllCategories();
            
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(categories.get(i).getId() + " - 이모티콘(" + categories.get(i).getEmoji() + "), "
                    + "이름(" + categories.get(i).getName() + "), 설명(" + categories.get(i).getDescription() + ")");
            }
            
            int sub;
            
            // 서브 메뉴 번호 입력 처리 (숫자 외 입력 시 예외 처리)
            try{
                System.out.print("\n[카테고리 번호를 입력해주세요]        * 0번 상위메뉴\n카테고리 번호 : ");      
                sub = sc.nextInt();
            
        	}catch(InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            sc.nextLine(); // 잘못된 입력 버리기
            continue; // 다시 입력받기
            }
            
            switch (sub) {
                case 1:
                	// 카테고리 등록
                    System.out.println("\n등록 ..............................................................");
                    System.out.println("위치 : 홈 > 카테고리 > 등록");
                    sc.nextLine(); //입력 버퍼 비우기 (문자 같은 줄 표기 오류 해결)
                    System.out.print("1. 이모티콘 : ");
                    String emoji = sc.nextLine();
                    System.out.print("2. 이 름 : ");
                    String name = sc.nextLine();
                    System.out.print("3. 설 명 : ");
                    String desc = sc.nextLine();
                    categoryDao.categoryInsert(emoji, name, desc);
                    System.out.println("<등록되었습니다.>");
                    System.out.println("");
                    break;
                    
                case 2:
                	// 카테고리 수정
                    System.out.println("\n수정 ..............................................................");
                    System.out.println("위치 : 홈 > 카테고리 > 수정");
                    
                    int catId;
                    
                    while (true) {
                        try {
                            System.out.print("카테고리번호 : ");
                            catId = sc.nextInt();
                            sc.nextLine(); // 입력 버퍼 비우기
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                            sc.nextLine(); // 잘못된 입력 버리기
                        }
                    }
                    
                    System.out.print("1. 이모티콘 : ");
                    String newEmoji = sc.nextLine();
                    System.out.print("2. 이 름 : ");
                    String newName = sc.nextLine();
                    System.out.print("3. 설 명 : ");
                    String newDesc = sc.nextLine();
                    categoryDao.updateCategory(catId, newEmoji, newName, newDesc);
                    System.out.println("<수정되었습니다.>");
                    System.out.println("");
                    break;
                    
                case 3:
                	// 카테고리 삭제
                    System.out.println("\n삭제 ..............................................................");
                    System.out.println("위치 : 홈 > 카테고리 > 삭제");
                    
                    int delId ;
                    
                    while (true) {
                        try {
                            System.out.print("카테고리번호 : ");
                            delId = sc.nextInt();
                            sc.nextLine(); // 입력 버퍼 비우기
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                            sc.nextLine(); // 잘못된 입력 버리기
                        }
                    }
                    
                    categoryDao.deleteCategory(delId);
                    System.out.println("<삭제되었습니다.>");
                    System.out.println("");
                    break;
                    
				case 0:
					 // 상위 메뉴로 복귀
					return;
					
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}