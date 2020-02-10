package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public Boolean insert(EmployeeVo vo) {
		return false;
	}
	
	public Boolean delete(Long no) {
		return false;
	}
	
	public Boolean delete(String firstName) {
		return false;
	}
	
	public Boolean update(EmployeeVo vo) {
		return false;
	}
	
	public List<EmployeeVo> findByName(EmployeeVo vo){
		List<EmployeeVo> result = new ArrayList<>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver(MyDriver) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");

			//3. SQL문 준비(Prepare, 완성된 쿼리가 아님, 파라피터바인딩)
			String sql = 
					"   select emp_no, first_name, last_name, hire_date" + 
					"     from employees" + 
					"    where first_name like ?" +
					" order by first_name";
			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1, "%" + vo.getFirstName() + "%");
			
			//5. SQL문 실행
			rs = pstmt.executeQuery();
			
			//5. 결과 바인딩
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setNo(no);
				employeeVo.setFirstName(firstName);
				employeeVo.setLastName(lastName);
				employeeVo.setHireDate(hireDate);
				
				result.add(employeeVo);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}
}
