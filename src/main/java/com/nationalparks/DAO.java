package com.nationalparks;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static final ArrayList<ParkInfo> myParks = new ArrayList<>();
	
	public static void connectToSQL() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	} //connectToDB method
	
	public static void readFromTable() {
		
		connectToSQL();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM national_parks.parks;");
			
			while(RES_SET.next()) {
				
				ParkInfo parksInDB = new ParkInfo();
				
				parksInDB.setParkID(RES_SET.getInt("parks_id"));
				parksInDB.setParkName(RES_SET.getString("parks_name"));
				parksInDB.setParkCity(RES_SET.getString("parks_city"));
				parksInDB.setParkState(RES_SET.getString("parks_state"));
				parksInDB.setParkYearEst(RES_SET.getInt("parks_year"));
				parksInDB.setParkFee(RES_SET.getInt("parks_fee"));
				
				myParks.add(parksInDB);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //readFromDB method
	
	public static void writeToTable (ParkInfo park) {
		
		ParkInfo parkToAdd = new ParkInfo();
		parkToAdd = park;
		
		try {
			
			connectToSQL();
			
			PREP_STMT = CONN.prepareStatement("INSERT INTO `national_parks`.`parks`"
					+ "(`parks_name`, `parks_city`, `parks_state`,	`parks_year`, `parks_fee`)"
					+ " VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			PREP_STMT.setString(1, parkToAdd.getParkName());
			PREP_STMT.setString(2, parkToAdd.getParkCity());
			PREP_STMT.setString(3, parkToAdd.getParkState());
			PREP_STMT.setInt(4, parkToAdd.getParkYearEst());
			PREP_STMT.setInt(5, parkToAdd.getParkFee());
			
			PREP_STMT.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //writeToSQL method
	
	public static void deleteFromTable (ParkInfo park) {
		
		ParkInfo parkToDelete = new ParkInfo();
		
		parkToDelete = park;
		
		try {
			connectToSQL();
			
			PREP_STMT = CONN.prepareStatement("DELETE FROM `national_parks`.`parks`"
					+ "WHERE parks_id = ?");
			PREP_STMT.setInt(1, parkToDelete.getParkID());
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //deleteFromSQL method
	
	public static void updateTheTable(ParkInfo park) {
		
		ParkInfo parkToUpdate = new ParkInfo();
		
		parkToUpdate = park;
		
		
		try {
			connectToSQL();
			
			PREP_STMT = CONN.prepareStatement("UPDATE `national_parks`.`parks` SET"
					+ "`parks_name` = ?, `parks_city` = ?, `parks_state` = ?,"
					+ "`parks_year` = ?, `parks_fee` = ? WHERE `parks_id` = ?;");
			PREP_STMT.setString(1, parkToUpdate.getParkName());
			PREP_STMT.setString(2, parkToUpdate.getParkCity());
			PREP_STMT.setString(3, parkToUpdate.getParkState());
			PREP_STMT.setInt(4, parkToUpdate.getParkYearEst());
			PREP_STMT.setInt(5, parkToUpdate.getParkFee());
			PREP_STMT.setInt(6, parkToUpdate.getParkID());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} //updateTheTable method
	
} //class