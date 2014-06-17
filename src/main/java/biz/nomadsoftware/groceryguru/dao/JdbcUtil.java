package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	static Long longValue(ResultSet r, String columnLabel) throws SQLException {
		long l = r.getLong(columnLabel);
		return r.wasNull() ? null : l;
	}

	static Integer intValue(ResultSet r, String columnLabel) throws SQLException {
		int i = r.getInt(columnLabel);
		return r.wasNull() ? null : i;
	}

}
