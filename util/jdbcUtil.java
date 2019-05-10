package jdbc.util;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class jdbcUtil {
	private static final String driverClass;
	private static final String dbUrl;
	private static final String username;
	private static final String password;
	
	static {
		// 加载属性文件并解析
		Properties props = new Properties();

		// 通常使用类的加载器方式进行获取
		InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc/config/config-dev.ini");
		try {
			props.load(is);
		} catch(IOException e) {
			e.printStackTrace();
		}

		// 赋值操作
		driverClass = props.getProperty("dbDriver");
		dbUrl = props.getProperty("dbUrl");
		username = props.getProperty("dbUser");
		password = props.getProperty("dbPwd");
	}
	
	/**
	 *  注册驱动的方法
	 * @throws ClassNotFoundException
	 */
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName(driverClass);
	}
	
	/**
	 * 获得连接的方法
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		loadDriver();
		Connection conn = DriverManager.getConnection(dbUrl, username, password);
		return conn;
	}

	/**
	 *  释放资源
	 * @param stat
	 * @param conn
	 */
	public static void releaseResult(Statement stmt, Connection conn) {
		_releaseResult(stmt, conn);
	}
	
	public static void releaseResult(ResultSet rs, Statement stmt, Connection conn) {
		if( rs != null ) {
			try {
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		_releaseResult(stmt, conn);
	}
	
	
	/**
	 * 释放资源
	 * @param stmt
	 * @param conn
	 */
	private static void _releaseResult(Statement stmt, Connection conn) {
		if( stmt != null ) {
			try {
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if( conn != null ) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}