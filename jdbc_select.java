package jdbc;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * jdbc���ݿ��ѯ
 * @author yaoxf
 *
 */
public class jdbc_select {
	public static void main_backup(String[] args) {
		try {
			// 1.��������
			// DriverManager.RegisterDriver(new Driver());	// �ᵼ������ע������
			Class.forName("com.mysql.cj.jdbc.Driver");		// ��������

			// 2.������ݿ�����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccj_shop?characterEncoding=utf8&serverTimezone=GMT%2B8", "root", "root");

			// 3.�������ݿ⣬ʵ����ɾ�Ĳ�
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM t_user");
			
			// 4.��������
			while(rs.next()) {
				System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " age: " + rs.getInt("age"));
			}
			
			// 5.�ر�����
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}