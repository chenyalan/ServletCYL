package com.cn.yk.db;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * ����ResultSet�Ľӿ�
 * @author CYL
 *
 */
public interface IResultSetUtil {
	public Object doHandler(ResultSet rs) throws SQLException;
}
