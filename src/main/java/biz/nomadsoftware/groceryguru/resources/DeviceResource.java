package biz.nomadsoftware.groceryguru.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import biz.nomadsoftware.groceryguru.dao.DeviceDAO;

@Path("/accounts/{account_id}/users")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource extends BaseResource {

	private final DeviceDAO dao;

	public DeviceResource(DeviceDAO dao) {
		this.dao = dao;
	}

}
