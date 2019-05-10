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
		// ���������ļ�������
		Properties props = new Properties();

		// ͨ��ʹ����ļ�������ʽ���л�ȡ
		InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc/config/config-dev.ini");
		try {
			props.load(is);
		} catch(IOException e) {
			e.printStackTrace();
		}

		// ��ֵ����
		driverClass = props.getProperty("dbDriver");
		dbUrl = props.getProperty("dbUrl");
		username = props.getProperty("dbUser");
		password = props.getProperty("dbPwd");
	}
	
	/**
	 *  ע�������ķ���
	 * @throws ClassNotFoundException
	 */
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName(driverClass);
	}
	
	/**
	 * ������ӵķ���
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		loadDriver();
		Connection conn = DriverManager.getConnection(dbUrl, username, password);
		return conn;
	}

	/**
	 *  �ͷ���Դ
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
	 * �ͷ���Դ
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