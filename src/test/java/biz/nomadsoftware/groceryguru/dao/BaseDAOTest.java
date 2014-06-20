package biz.nomadsoftware.groceryguru.dao;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import biz.nomadsoftware.jdbi.DateTimeArgumentFactory;

public abstract class BaseDAOTest {

	protected final DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:");
	protected final DBI jdbi = new DBI(dataSource);

	protected BaseDAOTest() {
		jdbi.registerArgumentFactory(new DateTimeArgumentFactory());
	}

	// TODO use generics to instantiate the DAO

}
