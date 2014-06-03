package biz.nomadsoftware.market_minder.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.market_minder.dao.AccountDAO;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource extends BaseResource {

	private final AccountDAO dao;

	public AccountResource(AccountDAO dao) {
		this.dao = dao;
	}

}
