package org.csu.wr.service;

import org.csu.wr.persistence.impl.AccountDAOImpl;
import org.csu.wr.persistence.impl.SignOnDAOImpl;

public class ChangeInformation {
    public void change_Account(String username,String password,String email,String firstName,String lastName,String address1,String address2,String city,String state,String zip,String country,String phone)
    {
        AccountDAOImpl accountDAO = new AccountDAOImpl();
        SignOnDAOImpl signOnDAO = new SignOnDAOImpl();
        accountDAO.Change_Account(username,email,firstName,lastName,address1,address2,city,state,zip,country,phone);
        signOnDAO.change_account(username,password);
    }
}
