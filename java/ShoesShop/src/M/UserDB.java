package M;

public class UserDB
{
	public int id;
	public String user_name;
	public String user_password;
	public String usertype;

	public UserDB()
	{

	}

	public UserDB(int xid, String xuser_name, String xuser_password, String xusertype)
	{
		id = xid;
		user_name = xuser_name;
		user_password = xuser_password;
		usertype = xusertype;
	}
	
	
}
