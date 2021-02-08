package org.csu.wr.persistence.impl;

import org.csu.wr.domain.Account;
import org.csu.wr.persistence.AccountDAO;
import org.csu.wr.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO {
	public String getUserIdString;
	public String getEmailString;
	public String getFirstNameString;
	public String getLastNameString;
	public String getStatusString;
	public String getAddr1String;
	public String getAddr2String;
	public String getCityString;
	public String getStateString;
	public String getZipString;
	public String getCountyString;
	public String getPhoneString;
	private final String FIND_ACCOUNT = "select * from account where userid = ?";
	private final String BUILD_ACCOUNT = "insert into account(userid,email,firstname,lastname,addr1,addr2,city,state,zip,country,phone) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_ACCOUNT = "update account set email = ?,firstname = ?,lastname = ?,addr1 = ?,addr2 = ?,city = ?, state = ?, zip = ?, country = ?, phone = ? where userid = ?";
	public Account getAccount(String id)
	{
		Account account = null;
		try
		{
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT);
			preparedStatement.setString(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				String username = id;
				String email = resultSet.getString(2);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				String status = resultSet.getString(5);
				String address1 = resultSet.getString(6);
				String address2 = resultSet.getString(7);
				String city = resultSet.getString(8);
				String state = resultSet.getString(9);
				String zip = resultSet.getString(10);
				String country = resultSet.getString(11);
				String phone = resultSet.getString(12);
				account = new Account(username,email,firstName,lastName,status,address1,address2,city,state,zip,country,phone);
				return account;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return account;
	}
	public void insert_Account(String username,String email,String firstName,String lastName,String address1,String address2,String city,String state,String zip,String country,String phone)
	{
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(BUILD_ACCOUNT);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,firstName);
			preparedStatement.setString(4,lastName);
			preparedStatement.setString(5,address1);
			preparedStatement.setString(6,address2);
			preparedStatement.setString(7,city);
			preparedStatement.setString(8,state);
			preparedStatement.setString(9,zip);
			preparedStatement.setString(10,country);
			preparedStatement.setString(11,phone);
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void Change_Account(String username,String email,String firstName,String lastName,String address1,String address2,String city,String state,String zip,String country,String phone)
	{
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,firstName);
			preparedStatement.setString(3,lastName);
			preparedStatement.setString(4,address1);
			preparedStatement.setString(5,address2);
			preparedStatement.setString(6,city);
			preparedStatement.setString(7,state);
			preparedStatement.setString(8,zip);
			preparedStatement.setString(9,country);
			preparedStatement.setString(10, phone);
			preparedStatement.setString(11,username);
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public String getUserId() {
		return null;
	}

	@Override
	public String getEmail() {
		return null;
	}

	@Override
	public String getFirstName() {
		return null;
	}

	@Override
	public String getLastName() {
		return null;
	}

	public static void main(String[] args)
	{
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		accountDAO.insert_Account("wr","asdsad","sadas","sadas","sadas","sadas","sadas","sadas","sadas","sadas","sadas");
	}
	@Override
	public String getStatus() {
		return null;
	}

	@Override
	public String getAddr1() {
		return null;
	}

	@Override
	public String getAddr2() {
		return null;
	}

	@Override
	public String getCity() {
		return null;
	}

	@Override
	public String getState() {
		return null;
	}

	@Override
	public String getZip() {
		return null;
	}

	@Override
	public String getCounty() {
		return null;
	}

	@Override
	public String getPhone() {
		return null;
	}
}
