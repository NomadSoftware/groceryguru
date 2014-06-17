package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import biz.nomadsoftware.groceryguru.model.Device;

public class DeviceMapper implements ResultSetMapper<Device> {

	@Override
	public Device map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return map(r);
	}

	public static Device map(ResultSet r) {
		Device d = new Device();
		// TODO
		return d;
	}

}
