package biz.nomadsoftware.market_minder;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import biz.nomadsoftware.market_minder.dao.AccountDAO;
import biz.nomadsoftware.market_minder.dao.AisleDAO;
import biz.nomadsoftware.market_minder.dao.DateTimeArgumentFactory;
import biz.nomadsoftware.market_minder.dao.ItemDAO;
import biz.nomadsoftware.market_minder.dao.StoreDAO;
import biz.nomadsoftware.market_minder.dao.UserDAO;
import biz.nomadsoftware.market_minder.resources.AccountResource;
import biz.nomadsoftware.market_minder.resources.AisleResource;
import biz.nomadsoftware.market_minder.resources.ItemResource;
import biz.nomadsoftware.market_minder.resources.StoreResource;
import biz.nomadsoftware.market_minder.resources.UserResource;

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
		final UserDAO userDao = jdbi.onDemand(UserDAO.class);
		jersey.register(new UserResource(userDao));
	}

}
