package biz.nomadsoftware.market_minder.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.market_minder.dao.StoreDAO;

@Path("/accounts/{account_id}/stores")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource extends BaseResource {

	private final StoreDAO dao;

	public StoreResource(StoreDAO dao) {
		this.dao = dao;
	}

}
