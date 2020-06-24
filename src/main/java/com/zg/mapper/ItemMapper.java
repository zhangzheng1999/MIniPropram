package com.zg.mapper;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zg.po.Item;
import com.zg.po.ItemExample;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExampleWithBLOBs(ItemExample example);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExampleWithBLOBs(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKeyWithBLOBs(Item record);

    int updateByPrimaryKey(Item record);
}