package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	static Long getLong(ResultSet rs, String columnLabel) throws SQLException {
		long l = rs.getLong(columnLabel);
		return rs.wasNull() ? null : l;
	}

}
