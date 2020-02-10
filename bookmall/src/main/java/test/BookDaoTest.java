package test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest("트와일라잇","대여가능",5L);
		//insertTest("뉴문","대여가능",5L);
		//insertTest("풀하우스","대여가능",3L);
		//deleteTest(1L);
		updateTest(3L);
		selectTest();
	}

	public static void insertTest(String title, String state, Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setState(state);
		vo.setAuthorNo(authorNo);
		
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}
	
	public static void deleteTest(Long l) {
		//BookVo vo = new BookVo();
		new BookDao().delete(l);
	}
	
	public static void updateTest(Long no) {
		BookVo vo = new BookVo();
				
		vo.setNo(no);
		
		new BookDao().update(vo);
	}
}
