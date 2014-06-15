package biz.nomadsoftware.groceryguru.dao;

import org.joda.time.base.BaseDateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;
import org.skife.jdbi.v2.tweak.ArgumentFactory;

public class DateTimeArgumentFactory implements ArgumentFactory<BaseDateTime> {

	@Override
	public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
		return value instanceof BaseDateTime;
	}

	@Override
	public Argument build(Class<?> expectedType, BaseDateTime value, StatementContext ctx) {
		return new DateTimeArgument(value);
	}

}
