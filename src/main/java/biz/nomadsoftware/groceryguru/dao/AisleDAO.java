package biz.nomadsoftware.groceryguru.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

import biz.nomadsoftware.groceryguru.model.Aisle;

public interface AisleDAO {

	@SqlQuery("select * from aisles where account_id = :accountId and store_id = :storeId order by order_sequence")
	List<Aisle> findAllForStore(@Bind("accountId") Long accountId, @Bind("storeId") Long storeId);

}
