package dao.test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		
		insertTest("변신", 12000L , 1L);
		insertTest("알고리즘을 통해 본 세상", 12000L , 2L);
		insertTest("컴퓨터활용능력1급 필기", 28000L , 3L);
		
		selectTest();
		

	}

	public static void insertTest(String title, Long price, Long categoryNo) {
		BookVo vo = new BookVo();
		
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		
		
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
