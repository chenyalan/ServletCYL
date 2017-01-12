package com.cn.yk.db;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil  {
	/**
	 * ��C3P0�������ӳ��л�ȡ���ݿ����Ӷ���
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=ConnectionManager.getInstance().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ͷ���Դ
	 * @param connection
	 * @param psmt
	 * @param resultSet
	 */
	public static void close(Connection connection,PreparedStatement psmt,ResultSet resultSet){
		try {
			if(resultSet!=null){
				resultSet.close();
			}if(psmt!=null){
				psmt.close();
			}if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ɾ�Ĳ�
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int executeUpdate(String sql,Object...objects){
		int result=0;
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(sql);
			if(objects!=null){
				for(int i=0;i<objects.length;i++){
					psmt.setObject(i+1, objects[i]);//�±��1��ʼ
				}
			}
			result=psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(conn,psmt,null);
		}
		return result;
	}
	
	
	/**
	 * ��ѯͨ�õķ���
	 * @param sql
	 * @param rsHandler
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql,IResultSetUtil rsHandler,Object...objects){
		Connection connection =null;
	    PreparedStatement preparedStatement =null;
	    ResultSet resultSet=null;
	    try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(sql);
			if(objects!=null){
				for(int i=0;i<objects.length;i++){
					preparedStatement.setObject(i+1, objects[i]);
				}
			}
			resultSet=preparedStatement.executeQuery();
			return rsHandler.doHandler(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(connection,preparedStatement,resultSet);
		}
	    return null;
	}
	
	
	/**
	 * ��ѯ�����ֶ�ֵ�ķ���
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql,Object...objects){
		return executeQuery(sql, new IResultSetUtil(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Object object=null;
				if(rs.next()){
					object=rs.getObject(1);
				}
				return object;
			}
			
		},objects);
	}
}

