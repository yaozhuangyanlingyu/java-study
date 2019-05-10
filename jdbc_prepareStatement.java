package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.jdbcUtil;

public class jdbc_prepareStatement {
	public static void main_backup(String[] args) {
		if( login("zhangfei", 33) ) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
	}
	
	public static boolean login(String username, int password) {
		Connection conn = null;
		PrepareStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 获得数据库连接
			conn = jdbcUtil.getConnection();
			
			// 创建发送SQL的对象
			sql = "SELECT name, age FROM t_user WHERE name = ? and age = ?";
			stat = conn.prepareStatement(sql);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(rs, stmt, conn);
		}
		
	}
}