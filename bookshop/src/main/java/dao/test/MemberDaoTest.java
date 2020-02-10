package dao.test;

import java.util.List;

import dao.MemberDao;
import vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest("조현정","010-1234-5678","johg@naver.com","현정12");
		insertTest("김용우","010-4545-9993","douzoneWang@douzone.com","용우12");
		
		selectTest();
		
		

	}
	
	public static void insertTest(String name,String phoneNum, String email, String password) {
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setPhoneNum(phoneNum);
		vo.setEmail(email);
		vo.setPassword(password);
		
		
		
		new MemberDao().insert(vo);
	}
	
	public static void selectTest() {
		List<MemberVo> list = new MemberDao().findAll();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
		
	}
	
	public static void deleteTest(Long l) {
		//MemberVo vo = new MemberVo();
		new MemberDao().delete(l);
	}	


}
