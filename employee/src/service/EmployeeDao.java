package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "root";
	private final String DB_PW = "java0000";
	

	PreparedStatement stmt= null;
	ResultSet rs = null;
	Connection conn = null;
	
	
	//DB연결 .
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(this.DRIVER);
			conn = DriverManager.getConnection(this.URL, this.DB_USER, this.DB_PW);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 실패!");
			e.printStackTrace();
		}
		return conn;
	}
	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(stmt != null) {
			try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(conn != null) {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public ArrayList<Employee> SelectAll() throws SQLException{
		ArrayList<Employee> returnlist = new ArrayList<Employee>();
		try{	
			conn = this.getConnection();
				String sql = "select * from employee";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()){
					Employee em = new Employee();
					em.setEmployeeNo(rs.getInt("employee_no"));
					em.setEmployeeName(rs.getString("employee_name"));
					em.setEmployeeGender(rs.getString("employee_gender"));
					returnlist.add(em);
				}
		}finally{
			this.close(conn, stmt, rs);
	}
		return returnlist ;
}
	
	public void Einsert(String a, String b) throws SQLException{//예외 던저버림
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn = this.getConnection();
			System.out.println(conn+"<<==conn 값");
			stmt = conn.prepareStatement("INSERT INTO employee" +
											"(employee_name, employee_gender)"+
												"VALUES ?, ?");
			stmt.setString(1, a);
			stmt.setString(2, b);
			System.out.println(a+"<<==a 값");
			System.out.println(b+"<<==b 값");
			stmt.executeUpdate();
			
		
		
		}finally{
		     this.close(conn, stmt, rs);
			}
		
	}
}
