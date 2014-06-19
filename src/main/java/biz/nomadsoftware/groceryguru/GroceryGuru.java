package biz.nomadsoftware.groceryguru;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.tweak.ArgumentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biz.nomadsoftware.groceryguru.dao.AccountDAO;
import biz.nomadsoftware.groceryguru.dao.AisleDAO;
import biz.nomadsoftware.groceryguru.dao.DeviceDAO;
import biz.nomadsoftware.groceryguru.dao.ItemDAO;
import biz.nomadsoftware.groceryguru.dao.StoreDAO;
import biz.nomadsoftware.groceryguru.resources.AccountResource;
import biz.nomadsoftware.groceryguru.resources.AisleResource;
import biz.nomadsoftware.groceryguru.resources.DeviceResource;
import biz.nomadsoftware.groceryguru.resources.ItemResource;
import biz.nomadsoftware.groceryguru.resources.StoreResource;

import com.codahale.metrics.jdbi.InstrumentedTimingCollector;

public class GroceryGuru extends Application<GroceryGuruConfiguration> {

	private static final Logger log = LoggerFactory.getLogger(GroceryGuru.class);

	public static void main(String[] args) throws Exception {
		new GroceryGuru().run(args);
	}

	@Override
	public void initialize(Bootstrap<GroceryGuruConfiguration> bootstrap) {
		//
	}

	@Override
	public void run(GroceryGuruConfiguration config, Environment env) throws Exception {
		JdbiDataSourceFactory dsf = config.getJdbiDataSourceFactory();
		final DBI jdbi = setupJdbi(dsf, env);
		JerseyEnvironment jersey = env.jersey();
		registerResources(jdbi, jersey);
	}

	private DBI setupJdbi(JdbiDataSourceFactory dsf, Environment env) throws ReflectiveOperationException {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, dsf, "postgresql");
		if (dsf.isTimingEnabled()) {
			jdbi.setTimingCollector(new InstrumentedTimingCollector(env.metrics()));
		}
		for (String argumentFactoryClassName : dsf.getArgumentFactories()) {
			@SuppressWarnings("unchecked")
			Class<ArgumentFactory<?>> argumentFactoryClass = (Class<ArgumentFactory<?>>) Class
			.forName(argumentFactoryClassName);
			ArgumentFactory<?> argumentFactory = argumentFactoryClass.newInstance();
			log.info("registering JDBI argument factory {}", argumentFactory.getClass().getName());
			jdbi.registerArgumentFactory(argumentFactory);
		}
		return jdbi;
	}

	private void registerResources(final DBI jdbi, JerseyEnvironment jersey) {
		final AccountDAO accountDao = jdbi.onDemand(AccountDAO.class);
		jersey.register(new AccountResource(accountDao));
		final AisleDAO aisleDao = jdbi.onDemand(AisleDAO.class);
		jersey.register(new AisleResource(aisleDao));
		final DeviceDAO deviceDao = jdbi.onDemand(DeviceDAO.class);
		jersey.register(new DeviceResource(deviceDao));
		final ItemDAO itemDao = jdbi.onDemand(ItemDAO.class);
		jersey.register(new ItemResource(itemDao));
		final StoreDAO storeDao = jdbi.onDemand(StoreDAO.class);
		jersey.register(new StoreResource(storeDao));
	}

}
