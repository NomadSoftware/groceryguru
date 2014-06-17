package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.joda.time.DateTime;

public class JdbcUtil {

	static Long getLong(ResultSet r, String columnLabel) throws SQLException {
		long l = r.getLong(columnLabel);
		return r.wasNull() ? null : l;
	}

	static Integer getInt(ResultSet r, String columnLabel) throws SQLException {
		int i = r.getInt(columnLabel);
		return r.wasNull() ? null : i;
	}

	static DateTime getDateTime(ResultSet r, String columnLabel) throws SQLException {
		Timestamp t = r.getTimestamp(columnLabel);
		return t == null ? null : new DateTime(t.getTime());
	}

}
