package M;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import common.GlobalData;

public class ProductManager
{
	public static ArrayList<ProductDB> getAllProduct()
	{
		ArrayList<ProductDB> list = new ArrayList<ProductDB>();
		try
		{
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
					+ GlobalData.DATABASE_DATABASE_NAME;
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM products";

			// create the java statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			{
				int pid = rs.getInt("product_id");
				String pname = rs.getString("product_name");
				double pprice = rs.getDouble("price_per_unit");
				String pdesc = rs.getString("product_description");
				byte[] img_byte = rs.getBytes("product_image");
				BufferedImage bufferedimg = null;
				if (img_byte == null || img_byte.length == 0)
				{

				} else
				{

					ByteArrayInputStream bais = new ByteArrayInputStream(img_byte);
					bufferedimg = ImageIO.read(bais);
					bais.close();
				}
				ProductDB cc = new ProductDB(pid, pname, pprice, pdesc, bufferedimg);
				list.add(cc);
				// print the results

			}
			st.close();
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return list;
	}

	public static void saveNewProduct(ProductDB x)
	{

		try
		{
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
					+ GlobalData.DATABASE_DATABASE_NAME;
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "INSERT INTO products VALUE (0,?,?,?,? )";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, x.product_name);
			st.setDouble(2, x.price_per_unit);
			st.setString(3, x.product_description);
			if (x.product_image != null)
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(x.product_image, "png", baos);
				byte[] buffer = baos.toByteArray();
				st.setBytes(4, buffer);
			} else
			{
				byte[] buffer = new byte[0];
				st.setBytes(4, buffer);
			}
			st.executeUpdate();
			st.close();
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public static void editProduct(ProductDB x)
	{
		try
		{
			
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
					+ GlobalData.DATABASE_DATABASE_NAME;
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "UPDATE products SET product_name = ? , price_per_unit = ? , product_description = ? , product_image  = ? WHERE product_id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, x.product_name);
			st.setDouble(2, x.price_per_unit);
			st.setString(3, x.product_description);
			if (x.product_image != null)
			{
				System.out.println("xx");
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(x.product_image, "png", baos);
				byte[] buffer = baos.toByteArray();
				st.setBytes(4, buffer);
			} else
			{
				byte[] buffer = new byte[0];
				st.setBytes(4, buffer);
			}
			st.setInt(5, x.product_id);
			
			int i = st.executeUpdate();
			System.out.println(i);
			st.close();
			System.out.println("xxx");
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public static void editProduct111(ProductDB x)
	{
		ArrayList<ProductDB> list = new ArrayList<ProductDB>();
		try
		{
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
					+ GlobalData.DATABASE_DATABASE_NAME;
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// our SQL SELECT query.


			String query = "SELECT * FROM products WHERE product_id = "+x.product_id;
			
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				int pid = rs.getInt("product_id");
				String pname = rs.getString("product_name");
				double pprice = rs.getDouble("price_per_unit");
				String pdesc = rs.getString("product_description");
				byte[] img_byte = rs.getBytes("product_image");
				BufferedImage bufferedimg = null;
				if (img_byte == null || img_byte.length == 0)
				{

				} else
				{

					ByteArrayInputStream bais = new ByteArrayInputStream(img_byte);
					bufferedimg = ImageIO.read(bais);
					bais.close();
				}
				ProductDB cc = new ProductDB(pid, pname, pprice, pdesc, bufferedimg);
				list.add(cc);
				// print the results

			}
			st.close();
			System.out.println(list);
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		
	}
	
	
	public static void deleteProduct(ProductDB x) {
		try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+GlobalData.DATABASE_LOCATION+":"+GlobalData.DATABASE_PORT+"/"+GlobalData.DATABASE_DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "DELETE  FROM products WHERE product_id = "+x.product_id+" ";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      st.executeUpdate(query);
	      
	      // iterate through the java resultset
	      
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}
	
	public static ArrayList<ProductDB> searchProduct(String s)
	{
		ArrayList<ProductDB> list = new ArrayList<ProductDB>();
		try
		{
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://" + GlobalData.DATABASE_LOCATION + ":" + GlobalData.DATABASE_PORT + "/"
					+ GlobalData.DATABASE_DATABASE_NAME;
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM products WHERE product_name LIKE '"+s+"'";

			// create the java statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			{
				int pid = rs.getInt("product_id");
				String pname = rs.getString("product_name");
				double pprice = rs.getDouble("price_per_unit");
				String pdesc = rs.getString("product_description");
				byte[] img_byte = rs.getBytes("product_image");
				BufferedImage bufferedimg = null;
				if (img_byte == null || img_byte.length == 0)
				{

				} else
				{

					ByteArrayInputStream bais = new ByteArrayInputStream(img_byte);
					bufferedimg = ImageIO.read(bais);
					bais.close();
				}
				ProductDB cc = new ProductDB(pid, pname, pprice, pdesc, bufferedimg);
				list.add(cc);
				// print the results

			}
			st.close();
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return list;
	}
	
}
