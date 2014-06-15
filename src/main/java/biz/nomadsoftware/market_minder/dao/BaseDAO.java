package biz.nomadsoftware.market_minder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {

	protected static Long getLong(ResultSet rs, String columnLabel) throws SQLException {
		long l = rs.getLong(columnLabel);
		return rs.wasNull() ? null : l;
	}

}
