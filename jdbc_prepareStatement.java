package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.jdbcUtil;

/**
 * PreparedStatement���Խ��SQLע������
 * @author yaoxf
 * @date 2019/05/10
 * 
 */
public class jdbc_prepareStatement {
	public static void main_backup(String[] args) {
		if( login("13661290405", "654321") ) {
			System.out.println("��¼�ɹ�");
		} else {
			System.out.println("��¼ʧ��");
		}
	}

	/**
	 * �����ֻ��ŵ�¼
	 * @param phone			// �ֻ���
	 * @param password		// ����
	 * @return
	 */
	public static boolean login(String phone, String password) {
		Connection conn = null;
		PreparedStatement preStatement = null;
		ResultSet rs = null;
		boolean flag = false;

		try {
			// ������ݿ�����
			conn = jdbcUtil.getConnection();
			
			// ��������SQL�Ķ���
			String sql = "SELECT name, age FROM t_user WHERE phone = ? and password = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, phone);
			preStatement.setString(2, password);
			
			// �������
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