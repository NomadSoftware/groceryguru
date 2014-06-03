package biz.nomadsoftware.market_minder.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.market_minder.dao.UserDAO;

@Path("/accounts/{account_id}/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	private final UserDAO dao;

	public UserResource(UserDAO dao) {
		this.dao = dao;
	}

}
