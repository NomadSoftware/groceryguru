package biz.nomadsoftware.groceryguru.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.groceryguru.dao.ItemDAO;

@Path("/accounts/{account_id}/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource extends BaseResource {

	private final ItemDAO dao;

	public ItemResource(ItemDAO dao) {
		this.dao = dao;
	}

}
