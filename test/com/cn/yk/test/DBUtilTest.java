package com.cn.yk.test;

import com.cn.yk.db.DBUtil;
import com.cn.yk.pojo.User;

public class DBUtilTest {
	public static void main(String[] args) {
		//�ܹ���ȡ�����Ӷ���
		System.out.println(DBUtil.getConnection());
		//����һ�²�ѯ
		System.out.println(DBUtil.executeQuery("select name from t_user where id=1"));
		//�����޸�
		String sql="select name,pass,age from t_user where id=1";
	}}
