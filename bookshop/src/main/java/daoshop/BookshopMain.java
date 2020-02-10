package daoshop;

import dao.test.BookDaoTest;
import dao.test.CartDaoTest;
import dao.test.CategoryDaoTest;
import dao.test.MemberDaoTest;
import dao.test.OrdersDaoTest;

public class BookshopMain {

	public static void main(String[] args) {
		
		
		//CategoryDaoTest.insertTest("소설");
		//CategoryDaoTest.insertTest("수필");
		//CategoryDaoTest.insertTest("컴퓨터/IT");
		
		//CategoryDaoTest.updateTest(3L,"IT/컴퓨터");
		System.out.println("************************************카테고리 출력**************************************");
		CategoryDaoTest.selectTest();
		
		
		//BookDaoTest.insertTest("변신", 12000L , 1L);
		//BookDaoTest.insertTest("알고리즘을 통해 본 세상", 12000L , 2L);
		//BookDaoTest.insertTest("컴퓨터활용능력1급 필기", 28000L , 3L);
		System.out.println("**************************************책  출력****************************************");
		BookDaoTest.selectTest();
		
		//MemberDaoTest.insertTest("조현정","010-1234-5678","johg@naver.com","현정12");
		//MemberDaoTest.insertTest("김용우","010-4545-9993","douzoneWang@douzone.com","용우12");
		System.out.println("************************************고객정보 출력**************************************");
		MemberDaoTest.selectTest();
		
		//CartDaoTest.insertTest(1L,1L,1L);
		//CartDaoTest.insertTest(2L,3L,2L);
		System.out.println("************************************카트 출력**************************************");		
		CartDaoTest.selectTest();
		
		//OrdersDaoTest.insertTest("20200129-00001",12000L,"인천",1L);
		//OrdersDaoTest.insertTest(1L,3L,1L);
		System.out.println("************************************주문정보 출력**************************************");
		OrdersDaoTest.selectTest();
		System.out.println("************************************주문도서 출력**************************************");
		OrdersDaoTest.orderBookSelectTest();
		
		
		
		
	}

}
