package org.csu.wr.persistence;

import org.csu.wr.domain.Item;

import java.util.List;
import java.util.Map;

/**
 * Created by songtie on 2015/4/21.
 */
public interface ItemDAO
{
    void updateInventoryQuantity(Map<String, Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productId);

    Item getItem(String itemId);
}
