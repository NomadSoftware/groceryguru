package biz.nomadsoftware.groceryguru.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class BaseMapperTest {

	protected final DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:");

}
