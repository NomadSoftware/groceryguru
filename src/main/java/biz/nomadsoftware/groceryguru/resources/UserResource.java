package biz.nomadsoftware.groceryguru.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.groceryguru.dao.UserDAO;

@Path("/accounts/{account_id}/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	private final UserDAO dao;

	public UserResource(UserDAO dao) {
		this.dao = dao;
	}

}
