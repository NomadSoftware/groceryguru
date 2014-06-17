package biz.nomadsoftware.groceryguru;

import io.dropwizard.db.DataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JdbiDataSourceFactory extends DataSourceFactory {

	private String[] argumentFactories = {};
	private boolean timingEnabled = true;

	@JsonProperty
	public void setArgumentFactories(String[] argumentFactories) {
		this.argumentFactories = argumentFactories;
	}

	@JsonProperty
	public String[] getArgumentFactories() {
		return argumentFactories;
	}

	@JsonProperty
	public void setTimingEnabled(boolean timingEnabled) {
		this.timingEnabled = timingEnabled;
	}

	@JsonProperty
	public boolean isTimingEnabled() {
		return timingEnabled;
	}

}
