package domain;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;

import db.BusinessDb;
import db.DbException;

public class BusinessSystem {
	private BusinessDb db;
	
	public BusinessSystem(Properties properties){
		db = new BusinessDb(properties);
	}
	
	public void create(Business bs) {
		try {
			db.addUser(bs);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}

	public List<Business> getBusinesses() {
		try {
			return db.getBusinesses();
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public JSONArray getBusinessesAsJson() {
		try {
			return db.getBusinessesAsJson();
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public JSONArray getFilteredByType(String type){
		try {
			return db.getFilteredByType(type);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public Business getBusiness(String name){
		try {
			return db.getBusiness(name);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public void delete(String name){
		try {
			db.deleteUser(name);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public void update(String previousId, Business newBs){
		try {
			db.update(previousId, newBs);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
	
	public boolean exists(String name){
		try {
			return db.exists(name);
		} catch (DbException e) {
			throw new DomainException(e.getMessage(), e);
		}
	}
}
