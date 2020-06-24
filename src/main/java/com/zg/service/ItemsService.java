package com.zg.service;

import com.github.pagehelper.PageInfo;
import com.zg.po.Item;
import com.zg.po.ItemExample;

import java.util.List;

/**
 * <p>Title:Items</p>
 * <p>@Description 接口注释</P>
 *
 * @Author pos
 * @DATE 2020/4/20 15:37
 */
public interface ItemsService {

    /**
     * @Description: 根据name模糊查询多条商品信息
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [item, itemName]
     * @Date: 2020/5/22 15:39
     **/
    List<Item> findItemByName(ItemExample itemExample, String itemName) throws Exception;

    /**
     * @Description: 小程序查询所有商品信息
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [ItemExample]
     * @Date: 2020/4/20 22:59
     **/
    List<Item> findItemList(ItemExample itemExample)throws Exception;

    /**
     * @Description: 后台分页查询
     * @return: com.github.pagehelper.PageInfo<com.zg.po.Item>
     * @Param: [pageNum, itemExample]
     * @Date: 2020/6/6 23:30
     **/
    PageInfo<Item>findItemListPage(Integer pageNum,ItemExample itemExample)throws Exception;

    /**
     * @Description: 小程序提交商品信息
     * @return: void
     * @Param: []
     * @Date: 2020/4/27 19:24
     **/
    void insertItems(Item item);

    /**
     * @Description:  小程序根据id修改商品信息
     * @return: void
     * @Param: [item]
     * @Date: 2020/5/26 10:53
     **/
    void updateItem(Item item,Integer itemId)throws Exception;

    /**
     * @Description: 后台根据id修改商品状态
     * @return: void
     * @Param: [item, itemId, itemState]
     * @Date: 2020/6/18 22:35
     **/
    void updateItemWeb(Item item,Integer itemId,Integer itemState) throws Exception;

    /**
     * @Description: 小程序根据id删除商品
     * @return: void
     * @Param: [item, itemId]
     * @Date: 2020/5/27 13:34
     **/
    void deleteItem(Integer itemId)throws Exception;

}
