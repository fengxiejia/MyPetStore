package org.csu.wr.service;

import org.csu.wr.domain.Account;
import org.csu.wr.persistence.impl.SignOnDAOImpl;

public class loginService {
	public Account existAccount(String username,String password)
	{
		SignOnDAOImpl sign = new SignOnDAOImpl();
		Account account =  sign.FindUser(username,password);
		if(account != null)
		{
			return account;
		}
		else
		{
			return null;
		}
	}
	public boolean isUserExist(String username)
	{
		SignOnDAOImpl sign = new SignOnDAOImpl();
		return sign.isUserExist(username);
	}
}
