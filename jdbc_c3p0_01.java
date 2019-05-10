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
 * c3p0���ӳ���ϰ
 * @author yaoxf
 *
 */
public class jdbc_c3p0_01 {
	private static final String dbDriver;
	private static final String dbUrl;
	private static final String dbUser;
	private static final String dbPassword;

	static {
		// ��ʼ�����ݿ���������
		Properties props = new Properties();

		// ͨ��ʹ�ü�����ķ�ʽ��ȡ
		InputStream is = jdbc_c3p0_01.class.getClassLoader().getResourceAsStream("jdbc/config/config-dev.ini");
		try {
			props.load(is);
		} catch(IOException e) {
			e.printStackTrace();
		}

		// ���Ը�ֵ
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
			// �������ӳ�
			dataSource = new ComboPooledDataSource();
	
			// ������������������
			dataSource.setDriverClass(dbDriver);
			dataSource.setJdbcUrl(dbUrl);
			dataSource.setUser(dbUser);
			dataSource.setPassword(dbPassword);
			dataSource.setMaxPoolSize(20);
			dataSource.setInitialPoolSize(5);

			// �����ӳػ�ȡ���ݿ�����
			conn = dataSource.getConnection();

			// ����Ԥ���뷢��SQL�Ķ���
			String sql = "SELECT * FROM t_user WHERE id > ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, 0);

			// ��ѯ���ݲ�����
			ResultSet rs = preStatement.executeQuery();
			while( rs.next() ) {
				System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " phone: " + rs.getString("phone"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ����
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