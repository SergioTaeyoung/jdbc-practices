package dao.test;

import java.util.List;

import dao.CartDao;
import vo.CartVo;


public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest(1L,1L,1L);
		//insertTest(2L,3L,2L);
		
		selectTest();
	}

	public static void insertTest(Long quantity, Long bookNo, Long memberNo) {
		CartVo vo = new CartVo();
		vo.setQuantity(quantity);
		vo.setBookNo(bookNo);
		vo.setMemberNo(memberNo);
		
		
		new CartDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		
		for(CartVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
