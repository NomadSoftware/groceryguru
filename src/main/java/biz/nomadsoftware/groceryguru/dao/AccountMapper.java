package biz.nomadsoftware.groceryguru.dao;

import static biz.nomadsoftware.groceryguru.dao.JdbcUtil.intValue;
import static biz.nomadsoftware.groceryguru.dao.JdbcUtil.longValue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import biz.nomadsoftware.groceryguru.model.Account;

public class AccountMapper implements ResultSetMapper<Account> {

	@Override
	public Account map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return map(r);
	}

	static Account map(ResultSet r) throws SQLException {
		Account a = new Account();
		a.setId(longValue(r, "id"));
		a.setParent(longValue(r, "parent_id"));
		a.setVersion(intValue(r, "version"));
		// TODO
		return a;
	}

}
