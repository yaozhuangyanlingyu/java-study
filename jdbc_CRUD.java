package jdbc;

import jdbc.util.jdbcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * jdbc增删改查
 * @author yaoxf
 *
 */
public class jdbc_crud {
	
	public static void main_backup(String[] args) {
		// 插入数据操作
		// insertData();
		
		// 更新数据操作
		// updateData();
		
		// 删除操作
		// deleteData();
	
		// 查询数据
		selectData();
	}
	
	/**
	  *  新增数据
	 */
	public static void insertData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 获得数据库连接
			conn = jdbcUtil.getConnection();

			// 创建执行SQL语句的对象
			stmt = conn.createStatement();
			
			// 发送SQL语句
			String sql = "INSERT INTO t_user (name, age)values('曹操',  46)";
			int affectedRows = stmt.executeUpdate(sql);
			
			// 判断影响行数
			if( affectedRows > 0 ) {
				System.out.println("插入成功");
			} else {
				System.out.println("插入失败");
			}
		} catch(Exception e) {
			// 输出异常
			e.printStackTrace();
		} finally {
			// 释放资源
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * 更新操作
	 */
	public static void updateData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 获得数据库连接
			conn = jdbcUtil.getConnection();
			
			// 创建执行SQL语句的对象
			stmt = conn.createStatement();
			
			// 发送SQL语句
			String sql = "UPDATE t_user SET name = '周瑜',  age = 34 WHERE id = 5 LIMIT 1";
			int affectedRows = stmt.executeUpdate(sql);
			
			// 判断影响行数
			if( affectedRows > 0 ) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * 删除数据
	 */
	public static void deleteData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 获得数据库连接
			conn = jdbcUtil.getConnection();
			
			// 创建发送SQL语句的对象
			stmt = conn.createStatement();
			
			// 发送SQL语句
			String sql = "DELETE FROM t_user WHERE id = 5 LIMIT 1";
			int affectedRows = stmt.executeUpdate(sql);
			
			// 判断影响行数
			if( affectedRows > 0 ) {
				System.out.println("操作成功");
			} else {
				System.out.println("操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.releaseResult(stmt, conn);
		}
	}
	
	/**
	 * 查询数据
	 */
	public static void selectData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得连接
			conn = jdbcUtil.getConnection();
			
			// 创建发送SQL的对象
			stmt = conn.createStatement();
			
			// 发送SQL语句
			String sql = "SELECT * FROM t_user";
			rs = stmt.executeQuery(sql);
			
			// 便利结果集
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
