/**
 * 
 */
package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shinji
 *
 */
public class ConnectionManager {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/mydb?characterEncoding=UTF-8";
	private static final String USER = "test";
	private static final String PASS = "pass";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
	/**
	 * 
	 */
	public ConnectionManager() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
