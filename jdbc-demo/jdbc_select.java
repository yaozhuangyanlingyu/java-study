package jdbc;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * jdbc数据库查询
 * @author yaoxf
 *
 */
public class jdbc_select {
	public static void main_backup(String[] args) {
		try {
			// 1.加载驱动
			// DriverManager.RegisterDriver(new Driver());	// 会导致驱动注册两次
			Class.forName("com.mysql.cj.jdbc.Driver");		// 加载驱动

			// 2.获得数据库连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccj_shop?characterEncoding=utf8&serverTimezone=GMT%2B8", "root", "root");

			// 3.操作数据库，实现增删改查
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM t_user");
			
			// 4.遍历数据
			while(rs.next()) {
				System.out.println("id: " + rs.getInt("id") + " name: " + rs.getString("name") + " age: " + rs.getInt("age"));
			}
			
			// 5.关闭连接
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}