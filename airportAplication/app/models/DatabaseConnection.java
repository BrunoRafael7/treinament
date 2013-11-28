package models;

import javax.sql.DataSource;

import play.db.*;

public class DatabaseConnection{
	
	DataSource db = DB.getDataSource();
	
}
