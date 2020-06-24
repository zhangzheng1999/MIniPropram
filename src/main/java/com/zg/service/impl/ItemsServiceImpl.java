package com.zg.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zg.mapper.ItemMapper;
import com.zg.po.Item;
import com.zg.po.ItemExample;
import com.zg.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:ItemsImpl</p>
 * <p>@Description 类注释</P>
 *
 * @Author pos
 * @DATE 2020/4/20 15:38
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemMapper itemMapper;

    /**
     * @Description: 根据name模糊查询多条商品信息
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [itemName]
     * @Date: 2020/5/22 10:08
     **/
    @Override
    public List<Item> findItemByName(ItemExample itemExample, String itemName) throws Exception {
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemNameLike("%"+itemName+"%");
        criteria.andItemStateEqualTo(1);
        return itemMapper.selectByExampleWithBLOBs(itemExample);
    }

    /**
     * @Description: 小程序端查询通过审核的商品信息
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [itemExample]
     * @Date: 2020/6/6 23:32
     **/
    @Override
    public List<Item> findItemList(ItemExample itemExample)throws  Exception{
        itemExample.setOrderByClause("item_id desc");
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemStateEqualTo(1);
        return  itemMapper.selectByExampleWithBLOBs(itemExample);
    }

    /**
     * @Description: 后台分页查询通过审核的商品信息
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [itemExample]
     * @Date: 2020/4/27 19:19
     **/
    @Override
    public PageInfo<Item> findItemListPage(Integer pageNum,ItemExample itemExample) throws Exception {
        PageHelper.startPage(pageNum, 5);
        //根据id倒序返回商品列表
        itemExample.setOrderByClause("item_id desc");
//        ItemExample.Criteria criteria = itemExample.createCriteria();
//        criteria.andItemStateEqualTo(1);
        List<Item> items = itemMapper.selectByExampleWithBLOBs(itemExample);
        return new PageInfo<Item>(items);
    }

    /**
     * @Description: 小程序提交商品信息
     * @return: void
     * @Param: [item]
     * @Date: 2020/4/27 19:22
     **/
    @Override
    public void insertItems(Item item){
        itemMapper.insert(item);

    }


    /**
     * @Description: 小程序根据id修改商品信息
     * @return: void
     * @Param: [item]
     * @Date: 2020/5/26 10:53
     **/
    @Override
    public void updateItem(Item item,Integer itemId) throws Exception {
        item.setItemId(itemId);
        itemMapper.updateByPrimaryKeyWithBLOBs(item);
    }
    /**
     * @Description: 后台根据id修改商品状态
     * @return: void
     * @Param: [item, itemId, itemState]
     * @Date: 2020/6/18 23:33
     **/
    @Override
    public void updateItemWeb(Item item,Integer itemId,Integer itemState)throws Exception{
        item.setItemId(itemId);
        if (itemState != null){
            item.setItemState(itemState);
        }
        itemMapper.updateByPrimaryKeySelective(item);
    }

    /**
     * @Description: 小程序根据id删除商品
     * @return: void
     * @Param: [item, itemId]
     * @Date: 2020/5/27 13:35
     **/
    @Override
    public void deleteItem(Integer itemId) throws Exception {
        itemMapper.deleteByPrimaryKey(itemId);
    }
}
