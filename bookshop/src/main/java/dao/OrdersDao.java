package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrdersVo;

public class OrdersDao {
	public List<OrdersVo> findAll() {
		List<OrdersVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select bis_no, b.name, email, price, location" + 
					" from orders a, member b" + 
					" where b.no = a.member_no";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {		
				String bisNum = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				Long price = rs.getLong(4);
				String location = rs.getString(5);	
				

				OrdersVo vo = new OrdersVo();

				vo.setBisNum(bisNum);
				vo.setName(name);
				vo.setEmail(email);
				vo.setPrice(price);
				vo.setLocation(location);
				
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
	public List<OrdersVo> findAllOrderBook() {
		List<OrdersVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, title, quantity" + 
					" from book a, order_book b" + 
					" where a.no = b.book_no";
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {		
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long quantity = rs.getLong(3);
				
				

				OrdersVo vo = new OrdersVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setQuantity(quantity);
				
				
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

	public Boolean insert(OrdersVo OrdersVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, OrdersVo.getBisNum());
			pstmt.setLong(2,OrdersVo.getPrice());
			pstmt.setString(3,OrdersVo.getLocation());
			pstmt.setLong(4,OrdersVo.getMemberNo());

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
	
	public Boolean insertOrderBook(OrdersVo OrdersVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order_book values(?,?,?);";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1,OrdersVo.getNo());
			pstmt.setLong(2,OrdersVo.getOrderNo());
			pstmt.setLong(3,OrdersVo.getQuantity());
			

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

			String sql = "delete from orders where no = " + l;
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
