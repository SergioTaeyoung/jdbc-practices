package dao.test;

import java.util.List;

import dao.CategoryDao;
import vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest("소설");
		insertTest("수필");
		insertTest("컴퓨터/IT");
		
		updateTest(3L,"IT/컴퓨터");
		selectTest();
	}

	public static void insertTest(String categoryName) {
		CategoryVo vo = new CategoryVo();
		vo.setCategoryName(categoryName);
		
		
		new CategoryDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
		
	}
	
	public static void deleteTest(Long l) {
		//CategoryVo vo = new CategoryVo();
		new CategoryDao().delete(l);
	}
	
	public static void updateTest(Long no, String categoryName) {
		CategoryVo vo = new CategoryVo();
				
		vo.setNo(no);
		vo.setCategoryName(categoryName);
		
		new CategoryDao().update(vo);
	}
}
