package org.csu.wr.service;

import org.csu.wr.domain.Category;
import org.csu.wr.domain.Product;
import org.csu.wr.domain.Item;
import org.csu.wr.persistence.CategoryDAO;
import org.csu.wr.persistence.ItemDAO;
import org.csu.wr.persistence.ProductDAO;
import org.csu.wr.persistence.impl.CategoryDAOImpl;
import org.csu.wr.persistence.impl.ItemDAOImpl;
import org.csu.wr.persistence.impl.ProductDAOImpl;

import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public class CatalogService
{
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;

    public CatalogService()
    {
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }


    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }


    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }

}
