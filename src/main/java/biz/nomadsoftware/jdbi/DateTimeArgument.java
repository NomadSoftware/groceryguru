package biz.nomadsoftware.jdbi;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.joda.time.base.BaseDateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.Argument;

public class DateTimeArgument implements Argument {

	private final BaseDateTime value;

	public DateTimeArgument(BaseDateTime value) {
		this.value = value;
	}

	@Override
	public void apply(int position, PreparedStatement statement,
			StatementContext ctx) throws SQLException {
		if (value != null) {
			statement.setTimestamp(position, new Timestamp(value.getMillis()));
		} else {
			statement.setNull(position, Types.TIMESTAMP);
		}
	}
}
