package com.zhaoyang.restaurant.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.zhaoyang.restaurant.utils.JDBCDruidUtils;

public class BasicDAO<T> {
	
	private QueryRunner qr=new QueryRunner();
	
	
	public int update(String sql,Object...paras){
		
		Connection connection=null;
		
		try {
			connection=JDBCDruidUtils.getConnection();
			int update=qr.update(connection, sql,paras);
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCDruidUtils.close(null, null, connection);
		}
	}
	
	public List<T> queryMultiple(Class<T> clazz,String sql,Object...paras){

		Connection connection=null;
		
		try {
			connection=JDBCDruidUtils.getConnection();
			return qr.query(connection, sql, new BeanListHandler<T>(clazz), paras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCDruidUtils.close(null, null, connection);
		}
	}
	
	public T querySingle(Class<T> clazz, String sql, Object...paras){
		Connection connection=null;
		
		try {
			connection=JDBCDruidUtils.getConnection();
			return qr.query(connection,sql,new BeanHandler<T>(clazz),paras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCDruidUtils.close(null, null, connection);
		}
	}
	
	public Object queryScalar(String sql, Object...paras) {
		Connection connection=null;
		
		try {
			connection=JDBCDruidUtils.getConnection();
			return qr.query(connection,sql,new ScalarHandler<T>(),paras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			JDBCDruidUtils.close(null, null, connection);
		}
	}
}
