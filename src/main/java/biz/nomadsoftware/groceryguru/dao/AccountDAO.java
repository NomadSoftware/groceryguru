package biz.nomadsoftware.groceryguru.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import biz.nomadsoftware.groceryguru.model.Account;

@RegisterMapper(AccountMapper.class)
public interface AccountDAO {

	@SqlUpdate("--TODO insert into accounts () values () returning *")
	Account create(@BindBean Account account);

	@SqlUpdate("--TODO update accounts set blah = blah where id = :id and version = :version returning *")
	Account update(@BindBean Account account);

	@SqlQuery("select * from accounts where id = :id")
	Account read(@Bind("id") Long id);

	@SqlUpdate("delete * from accounts where id = :id")
	int delete(@Bind("id") Long id);
}
