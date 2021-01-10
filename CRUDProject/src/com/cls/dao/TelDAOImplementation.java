package com.cls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cls.model.Tel;
import com.cls.util.DBUtil;

public class TelDAOImplementation implements TelDAO {
	
	private Connection conn;

	public TelDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	@Override
	public void addTel( Tel tel ) {
		try {
			String query = "insert into tel (firstName, lastName, address, num) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, tel.getFirstName() );
			preparedStatement.setString( 2, tel.getLastName() );
			preparedStatement.setString( 3, tel.getAddress() );
			preparedStatement.setInt( 4, tel.getNum() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteTel( int telId ) {
		try {
			String query = "delete from tel where telId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, telId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateTel( Tel tel ) {
		try {
			String query = "update tel set firstName=?, lastName=?, address=?, num=? where telId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, tel.getFirstName() );
			preparedStatement.setString( 2, tel.getLastName() );
			preparedStatement.setString( 3, tel.getAddress() );
			preparedStatement.setInt( 4, tel.getNum() );
			preparedStatement.setInt(5, tel.getTelId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Tel> getAllTels() {
		List<Tel> tels = new ArrayList<Tel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from tel" );
			while( resultSet.next() ) {
				Tel tel = new Tel();
				tel.setTelId( resultSet.getInt( "telId" ) );
				tel.setFirstName( resultSet.getString( "firstName" ) );
				tel.setLastName( resultSet.getString( "lastName" ) );
				tel.setAddress( resultSet.getString( "address" ) );
				tel.setNum( resultSet.getInt( "num" ) );
				tels.add(tel);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tels;
	}
	@Override
	public Tel getTelById(int telId) {
		Tel tel = new Tel();
		try {
			String query = "select * from tel where telId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, telId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				tel.setTelId( resultSet.getInt( "telId" ) );
				tel.setFirstName( resultSet.getString( "firstName" ) );
				tel.setLastName( resultSet.getString( "LastName" ) );
				tel.setAddress( resultSet.getString( "address" ) );
				tel.setNum( resultSet.getInt( "num" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tel;
	}

}