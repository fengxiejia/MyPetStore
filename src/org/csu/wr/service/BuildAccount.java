package org.csu.wr.service;

import org.csu.wr.persistence.SignOnDAO;
import org.csu.wr.persistence.impl.AccountDAOImpl;
import org.csu.wr.persistence.impl.SignOnDAOImpl;
import org.csu.wr.web.servlets.BuildUserServlet;

public class BuildAccount {
	public void bulid_Account(String username,String password,String email,String firstName,String lastName,String address1,String address2,String city,String state,String zip,String country,String phone)
	{
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		SignOnDAOImpl signOnDAO = new SignOnDAOImpl();
		accountDAO.insert_Account(username, email, firstName, lastName,  address1, address2, city, state, zip, country, phone);
		signOnDAO.build_User(username,password);
	}

//	public static void main(String[] args) {
//		BuildAccount account = new BuildAccount();
//		account.bulid_Account("1","wewq","ada","asda","asd","asd","asd","asd","asd","asd","asd","asd");
//	}
}
