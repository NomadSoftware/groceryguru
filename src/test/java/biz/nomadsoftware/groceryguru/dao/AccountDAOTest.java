package biz.nomadsoftware.groceryguru.dao;

public class AccountDAOTest extends BaseDAOTest {

	private final AccountDAO dao = jdbi.onDemand(AccountDAO.class);

}
