package biz.nomadsoftware.jdbi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeArgumentFactoryTest {

	@Test
	public void test_accepts() throws Exception {
		DateTimeArgumentFactory factory = new DateTimeArgumentFactory();
		assertThat(factory.accepts(null, DateTime.now(), null), is(true));
	}

	@Test
	public void test_denies() throws Exception {
		DateTimeArgumentFactory factory = new DateTimeArgumentFactory();
		assertThat(factory.accepts(null, new Date(), null), is(false));
	}

}
