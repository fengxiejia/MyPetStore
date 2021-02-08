package org.csu.wr.persistence.impl;

import org.csu.wr.persistence.DBUtil;
import org.csu.wr.persistence.LogDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogDAOImpl implements LogDAO {
    private static final String INSERT = "insert into log (userid,loginformation) values(?,?)";
    @Override
    public void insertLog(String username, String logInfo) {
        try
        {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,logInfo);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
