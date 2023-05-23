package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public void connect() throws SQLException{
		String url = "jdbc:sqlserver://localhost:59945;databasename=QuanLiXe";
		String user = "sa";
		String pw = "sapassword";
		con = DriverManager.getConnection(url, user, pw);
	}
	
	public static void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}

