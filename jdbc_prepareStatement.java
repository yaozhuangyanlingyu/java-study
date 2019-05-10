package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.jdbcUtil;

/**
 * PreparedStatement可以解决SQL注入问题
 * @author yaoxf
 * @date 2019/05/10
 * 
 */
public class jdbc_prepareStatement {
	public static void main_backup(String[] args) {
		if( login("13661290405", "654321") ) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
	}

	/**
	 * 根据手机号登录
	 * @param phone			// 手机号
	 * @param password		// 密码
	 * @return
	 */
	public static boolean login(String phone, String password) {
		Connection conn = null;
		PreparedStatement preStatement = null;
		ResultSet rs = null;
		boolean flag = false;

		try {
			// 获得数据库连接
			conn = jdbcUtil.getConnection();
			
			// 创建发送SQL的对象
			String sql = "SELECT name, age FROM t_user WHERE phone = ? and password = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, phone);
			preStatement.setString(2, password);
			
			// 遍历结果
			rs = preStatement.executeQuery();
			if( rs.next() ) {
				flag = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(rs, preStatement, conn);
		}
		return flag;
	}
}