package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DBconnection {
	
	private static String url = "jdbc:mysql://localhost:3306/gallery?serverTimezone=GMT";
	private static String id = "root";
	private static String pwd = "1234";
	
	
	
	public static Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("连接数据库...");
			con = DriverManager.getConnection(url,id,pwd);
		}
		catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) throws SQLException { // 测试数据库是否连通
		System.err.println(getConnection());
			
	}

	


}
