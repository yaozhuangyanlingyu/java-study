package jdbc;
import com.mchange.v2.c3p0.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * c3p0连接池练习
 * @author yaoxf
 *
 */
public class jdbc_c3p0_01 {
	private static final String dbDriver;
	private static final String dbUrl;
	private static final String dbUser;
	private static final String dbPassword;

	static {
		// 初始化数据库连接属性
		Properties props = new Properties();

		// 通常使用加载类的方式获取
		InputStream is = jdbc_c3p0_01.class.getClassLoader().getResourceAsStream("jdbc/config/config-dev.ini");
		try {
			props.load(is);
		} catch(IOException e) {
			e.printStackTrace();
		}

		// 属性赋值
		dbDriver = props.getProperty("dbDriver");
		dbUrl = props.getProperty("dbUrl");
		dbUser = props.getProperty("dbUser");
		dbPassword = props.getProperty("dbPwd");
	}
	
	public static void main(String[] args) {
		ComboPooledDataSource dataSource = null;
		PreparedStatement preStatement = null;
		Connection conn = null;
		try {
			// 创建连接池
			dataSource = new ComboPooledDataSource();
	
			// 加载驱动并设置驱动
			dataSource.setDriverClass(dbDriver);
			dataSource.setJdbcUrl(dbUrl);
			dataSource.setUser(dbUser);
			dataSource.setPassword(dbPassword);
			dataSource.setMaxPoolSize(20);
			dataSource.setInitialPoolSize(5);

			// 从连接池获取数据库连接
			conn = dataSource.getConnection();

			// 创建预编译发送SQL的对象
			String sql = "SELECT * FROM t_user WHERE id > ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, 0);

			// 查询数据并遍历
			ResultSet rs = preStatement.executeQuery();
			while( rs.next() ) {
				System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " phone: " + rs.getString("phone"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源对象
			if( dataSource != null ) {
				try {
					dataSource.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
				dataSource = null;
			}
			if( preStatement != null ) {
				try {
					preStatement.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				preStatement = null;
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
}