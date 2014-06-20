package biz.nomadsoftware.jdbi;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeArgumentTest {

	@Test
	public void test_apply() throws Exception {
		DateTime now = DateTime.now();
		PreparedStatement ps = mock(PreparedStatement.class);
		DateTimeArgument argument = new DateTimeArgument(now);
		argument.apply(1, ps, null);
		verify(ps).setTimestamp(1, new Timestamp(now.getMillis()));
	}

	@Test
	public void test_null() throws Exception {
		PreparedStatement ps = mock(PreparedStatement.class);
		DateTimeArgument argument = new DateTimeArgument(null);
		argument.apply(1, ps, null);
		verify(ps).setNull(1, Types.TIMESTAMP);
	}

}
