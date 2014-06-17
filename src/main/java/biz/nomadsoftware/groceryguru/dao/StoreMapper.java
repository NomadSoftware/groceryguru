package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import biz.nomadsoftware.groceryguru.model.Store;

public class StoreMapper implements ResultSetMapper<Store> {

	@Override
	public Store map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return map(r);
	}

	public static Store map(ResultSet r) {
		Store s = new Store();
		// TODO
		return s;
	}

}
