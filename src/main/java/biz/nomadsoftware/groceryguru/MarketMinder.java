package biz.nomadsoftware.groceryguru;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import biz.nomadsoftware.groceryguru.dao.AccountDAO;
import biz.nomadsoftware.groceryguru.dao.AisleDAO;
import biz.nomadsoftware.groceryguru.dao.DateTimeArgumentFactory;
import biz.nomadsoftware.groceryguru.dao.ItemDAO;
import biz.nomadsoftware.groceryguru.dao.StoreDAO;
import biz.nomadsoftware.groceryguru.dao.DeviceDAO;
import biz.nomadsoftware.groceryguru.resources.AccountResource;
import biz.nomadsoftware.groceryguru.resources.AisleResource;
import biz.nomadsoftware.groceryguru.resources.ItemResource;
import biz.nomadsoftware.groceryguru.resources.StoreResource;
import biz.nomadsoftware.groceryguru.resources.DeviceResource;

import com.codahale.metrics.jdbi.InstrumentedTimingCollector;

public class MarketMinder extends Application<MarketMinderConfiguration>{

	public static void main(String[] args) throws Exception {
		new MarketMinder().run(args);
	}

	@Override
	public void initialize(Bootstrap<MarketMinderConfiguration> bootstrap) {
		//
	}

	@Override
	public void run(MarketMinderConfiguration config, Environment env) throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");
		jdbi.setTimingCollector(new InstrumentedTimingCollector(env.metrics()));
		jdbi.registerArgumentFactory(new DateTimeArgumentFactory());
		JerseyEnvironment jersey = env.jersey();
		final AccountDAO accountDao = jdbi.onDemand(AccountDAO.class);
		jersey.register(new AccountResource(accountDao));
		final AisleDAO aisleDao = jdbi.onDemand(AisleDAO.class);
		jersey.register(new AisleResource(aisleDao));
		final ItemDAO itemDao = jdbi.onDemand(ItemDAO.class);
		jersey.register(new ItemResource(itemDao));
		final StoreDAO storeDao = jdbi.onDemand(StoreDAO.class);
		jersey.register(new StoreResource(storeDao));
		final DeviceDAO userDao = jdbi.onDemand(DeviceDAO.class);
		jersey.register(new DeviceResource(userDao));
	}

}
