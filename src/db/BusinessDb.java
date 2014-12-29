package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;

import domain.Business;

public class BusinessDb {
	private Connection connection;
	private Statement statement;
	private PreparedStatement stm;

	public BusinessDb(Properties properties) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = properties.getProperty("url");
			connection = DriverManager.getConnection(url, properties);
			statement = connection.createStatement();
		} catch (Exception e) {
			throw new DbException(e.getMessage(), e);
		}
	}

	public void addUser(Business bs) {
		try {
			stm = connection.prepareStatement("INSERT INTO r0436334.munt VALUES (?, ?, ?, ?)");
			stm.setString(1, bs.getName());
			stm.setString(2, bs.getType());
			stm.setString(3, bs.getAddress().getStreet());
			stm.setString(4, bs.getAddress().getNumber());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
	}

	public List<Business> getBusinesses() {
		List<Business> bss = new ArrayList<>();
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT * FROM r0436334.munt");
			while(result.next()){
				 String name = result.getString("naam");
				 String type = result.getString("type");
				 String straat = result.getString("straat");
				 String nummer = result.getString("nummer");
				 String url = result.getString("url");
				 String tel = result.getString("tel");
				 String img = result.getString("image");
				 String slogan = result.getString("slogan");
				 bss.add(new Business(name, type, straat, nummer, url, tel, img, slogan));
		 	 }
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
		return bss;
	}
	
	public JSONArray getBusinessesAsJson() {
		ResultSet result;
		try {
			result = statement.executeQuery("SELECT * FROM r0436334.munt");
			return ResultSetConverter.convert(result);
		}catch (SQLException | JSONException e) {
			throw new DbException(e.getMessage(), e);
		}
	}

	public Business getBusiness(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(String name) {
		// TODO Auto-generated method stub

	}

	public void update(String previousId, Business newBs) {
		// TODO Auto-generated method stub

	}

	public void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}
	}

	public boolean exists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public JSONArray getFilteredByType(String type) {
		ResultSet result;
		try {
			stm = connection.prepareStatement("SELECT * FROM r0436334.munt WHERE type = ?");
			stm.setString(1, type);
			result = stm.executeQuery();
			return ResultSetConverter.convert(result);
		}catch (SQLException | JSONException e) {
			throw new DbException(e.getMessage(), e);
		}
	}

}
