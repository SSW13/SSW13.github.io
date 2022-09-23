package M;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.GlobalData;

public class CompanyInfoDB
{
	
	public int id;
	public String company_name;
	public String address;
	public String phone;
	public String email;
	
	public CompanyInfoDB()
	{

	}

	public CompanyInfoDB(int xid, String xcompany_name, String xaddress, String xphone,String xemail)
	{
		id = xid;
		company_name = xcompany_name;
		address = xaddress;
		phone = xphone;
		email = xemail;
	}
}
