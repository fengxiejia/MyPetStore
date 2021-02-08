package org.csu.wr.persistence.impl;

import org.csu.wr.domain.Account;
import org.csu.wr.persistence.DBUtil;
import org.csu.wr.persistence.SignOnDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignOnDAOImpl implements SignOnDAO {
	private static final String FIND_USER= "select * from signon where username = ? and password = ?";
	private static final String EXIST_USER= "select * from signon where username = ?";
	private static final String BUILD_USER = "insert into signon (username,password) values (?,?)";
	private final String UPDATE_ACCOUNT = "update signon set password = ? where username = ?";
	public boolean ExistUser(String username)
	{
		boolean b = true;
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EXIST_USER);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			} else {
				b =  false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	public void change_account(String username,String password)
	{
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
			preparedStatement.setString(1,password);
			preparedStatement.setString(2,username);
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void build_User(String username,String password)
	{
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(BUILD_USER);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public Account FindUser(String username, String password)  {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				AccountDAOImpl accountDAO = new AccountDAOImpl();
				Account account = accountDAO.getAccount(username);
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
		return null;
	}
	public  boolean isUserExist(String username)
	{
		try
		{
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EXIST_USER);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
