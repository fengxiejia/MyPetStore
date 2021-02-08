package org.csu.wr.persistence.impl;

import org.csu.wr.domain.Category;
import org.csu.wr.persistence.CategoryDAO;
import org.csu.wr.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public class CategoryDAOImpl implements CategoryDAO
{
    private static final String getCategoryListString = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
    private static final String getCategoryString = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID=?";

    @Override
    public List<Category> getCategoryList() {
        List<Category> result = new ArrayList<Category> ();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(getCategoryListString);
            ResultSet resultSet = statement.executeQuery(getCategoryListString);

            while(resultSet.next())
            {
                Category category = new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
                result.add(category);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category getCategory(String categoryId) {
        Category category = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(getCategoryString);
            pStatement.setString(1, categoryId);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                category = new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
