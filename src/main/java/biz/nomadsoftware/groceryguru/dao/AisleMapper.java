package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import biz.nomadsoftware.groceryguru.model.Aisle;

public class AisleMapper implements ResultSetMapper<Aisle> {

	@Override
	public Aisle map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return map(r);
	}

	public static Aisle map(ResultSet r) {
		Aisle a = new Aisle();
		// TODO
		return a;
	}
}
