package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private Connection conn;
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL= "jdbc:mysql://localhost:3306/mldn";
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	public DataBaseConnection() {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public Connection getConnection() {
		return this.conn;
	}
	public void close(){
		try {
			if(this.conn != null){
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
