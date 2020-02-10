package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CategoryVo;

public class CategoryDao {
	public List<CategoryVo> findAll() {
		List<CategoryVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, category_name from category";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {		
				Long no = rs.getLong(1);
				String CategoryName = rs.getString(2);				

				CategoryVo vo = new CategoryVo();

				vo.setNo(no);
				vo.setCategoryName(CategoryName);				

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}	

	public Boolean insert(CategoryVo CategoryVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, CategoryVo.getCategoryName());			

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean delete(long l) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;

		try {
			conn = getConnection();
			// 3. Statement 객체 생성

			// 4. SQL문 실행

			String sql = "delete from category where no = " + l;
			pstmt = conn.prepareStatement(sql);

			int count = pstmt.executeUpdate(sql);
			result = count == 1;

			// 5. 결과 가져오기

			return result;

		} catch (SQLException e) {
			System.out.println("error " + e);
		} finally {
			// 6. 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public Boolean update(CategoryVo CategoryVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;

		try {
			// 1. JDBC Driver(MySQL)로딩
			conn = getConnection();
						
			// 4. SQL문 실행
			String sql = "update category" +
			" set category_name = ?" +
			" where no = ? ";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, CategoryVo.getCategoryName());
			pstmt.setLong(2, CategoryVo.getNo());
			
			int count = pstmt.executeUpdate();			
			// 5. 결과 가져오기
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error " + e);
		} finally {
			// 6. 자원 정리
			try {				
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return result;
		
	}



	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;

	}
}
