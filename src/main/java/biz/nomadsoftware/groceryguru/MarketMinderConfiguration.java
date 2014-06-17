package biz.nomadsoftware.groceryguru;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketMinderConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty
	private final JdbiDataSourceFactory database = new JdbiDataSourceFactory();

	public JdbiDataSourceFactory getJdbiDataSourceFactory() {
		return database;
	}
}
