package biz.nomadsoftware.groceryguru.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import biz.nomadsoftware.groceryguru.model.Item;

public class ItemMapper implements ResultSetMapper<Item> {

	@Override
	public Item map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return map(r);
	}

	public static Item map(ResultSet r) {
		Item i = new Item();
		// TODO
		return i;
	}

}
