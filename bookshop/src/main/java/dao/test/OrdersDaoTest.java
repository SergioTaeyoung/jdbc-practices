package dao.test;

import java.util.List;

import dao.OrdersDao;
import vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		//insertTest("20200129-00001",12000L,"인천",1L);
		//insertTest(1L,3L,1L);
		selectTest();
		orderBookSelectTest();
	}
	public static void insertTest(String bisNum, Long price, String location, Long memberNo) {
		OrdersVo vo = new OrdersVo();
		vo.setBisNum(bisNum);
		vo.setPrice(price);
		vo.setLocation(location);
		vo.setMemberNo(memberNo);
				
		new OrdersDao().insert(vo);		
	}
	
	public static void insertTest(Long no, Long orderNo , Long quantity) {
		OrdersVo vo = new OrdersVo();
		vo.setNo(no);
		vo.setOrderNo(orderNo);
		vo.setQuantity(quantity);		
		
		new OrdersDao().insertOrderBook(vo);		
	}
	
	public static void selectTest() {
		List<OrdersVo> list = new OrdersDao().findAll();
		
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}		
	}
	
	public static void orderBookSelectTest() {
		List<OrdersVo> list = new OrdersDao().findAllOrderBook();
		
		for(OrdersVo vo : list) {
			System.out.println(vo.orderBook());
		}		
	}	
}
