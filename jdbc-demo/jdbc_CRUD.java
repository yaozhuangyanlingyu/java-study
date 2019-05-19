package jdbc;

import jdbc.util.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * jdbc��ɾ�Ĳ�
 * @author yaoxf
 *
 */
public class jdbc_crud {
	
	public static void main_backup(String[] args) {
		// �������ݲ���
		// insertData();
		
		// �������ݲ���
		// updateData();
		
		// ɾ������
		// deleteData();
	
		// ��ѯ����
		selectData();
	}
	
	/**
	  *  ��������
	 */
	public static void insertData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// ������ݿ�����
			conn = jdbcUtil.getConnection();

			// ����ִ��SQL���Ķ���
			stmt = conn.createStatement();
			
			// ����SQL���
			String sql = "INSERT INTO t_user (name, age)values('�ܲ�',  46)";
			int affectedRows = stmt.executeUpdate(sql);
			
			// �ж�Ӱ������
			if( affectedRows > 0 ) {
				System.out.println("����ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
		} catch(Exception e) {
			// ����쳣
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * ���²���
	 */
	public static void updateData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// ������ݿ�����
			conn = jdbcUtil.getConnection();
			
			// ����ִ��SQL���Ķ���
			stmt = conn.createStatement();
			
			// ����SQL���
			String sql = "UPDATE t_user SET name = '���',  age = 34 WHERE id = 5 LIMIT 1";
			int affectedRows = stmt.executeUpdate(sql);
			
			// �ж�Ӱ������
			if( affectedRows > 0 ) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * ɾ������
	 */
	public static void deleteData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// ������ݿ�����
			conn = jdbcUtil.getConnection();
			
			// ��������SQL���Ķ���
			stmt = conn.createStatement();
			
			// ����SQL���
			String sql = "DELETE FROM t_user WHERE id = 5 LIMIT 1";
			int affectedRows = stmt.executeUpdate(sql);
			
			// �ж�Ӱ������
			if( affectedRows > 0 ) {
				System.out.println("�����ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * ��ѯ����
	 */
	public static void selectData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// �������
			conn = jdbcUtil.getConnection();
			
			// ��������SQL�Ķ���
			stmt = conn.createStatement();
			
			// ����SQL���
			String sql = "SELECT * FROM t_user";
			rs = stmt.executeQuery(sql);
			
			// ���������
			while( rs.next() ) {
				System.out.println("id : " + rs.getInt("id") + " name: " + rs.getString("name") + " age: " + rs.getInt("age"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(rs, stmt, conn);
		}
	}
}
