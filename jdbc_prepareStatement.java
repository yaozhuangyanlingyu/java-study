package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.jdbcUtil;

public class jdbc_prepareStatement {
	public static void main_backup(String[] args) {
		if( login("zhangfei", 33) ) {
			System.out.println("��¼�ɹ�");
		} else {
			System.out.println("��¼ʧ��");
		}
	}
	
	public static boolean login(String username, int password) {
		Connection conn = null;
		PrepareStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// ������ݿ�����
			conn = jdbcUtil.getConnection();
			
			// ��������SQL�Ķ���
			sql = "SELECT name, age FROM t_user WHERE name = ? and age = ?";
			stat = conn.prepareStatement(sql);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(rs, stmt, conn);
		}
		
	}
}