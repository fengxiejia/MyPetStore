package org.csu.wr.persistence;

import org.csu.wr.domain.Category;
import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public interface CategoryDAO
{
    //Select All Categories
    List<Category> getCategoryList();

    //Select a Category By ID
    Category getCategory(String categoryId);
}
