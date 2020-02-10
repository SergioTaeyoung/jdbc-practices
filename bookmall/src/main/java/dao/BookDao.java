package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BookVo;

public class BookDao {
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// String sql = "select no, title, state, author_no from book";
			String sql = "select b.no, title, a.name, state, author_no " + "from author a, book b "
					+ "where a.no = b.author_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				String state = rs.getString(4);
				Long authorNo = rs.getLong(5);

				BookVo vo = new BookVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setAuthorName(name);
				vo.setState(state);
				vo.setAuthorNo(authorNo);

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
	
	

	public Boolean insert(BookVo bookVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into book values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getState());
			pstmt.setLong(3, bookVo.getAuthorNo());
			pstmt.setString(4, bookVo.getAuthorName());

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

			String sql = "delete from book where no = " + l;
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
	public Boolean update(BookVo bookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;

		try {
			// 1. JDBC Driver(MySQL)로딩
			conn = getConnection();
						
			// 4. SQL문 실행
			String sql = "update book" +
			" set state = ?" +
			" where no = ? ";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, "대여중");
			pstmt.setLong(2, bookVo.getNo());
			
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

			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;

	}

}
