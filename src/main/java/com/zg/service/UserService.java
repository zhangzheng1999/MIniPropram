package com.zg.service;

import com.zg.po.User;
import com.zg.po.UserExample;

import java.util.List;

/**
 * <p>Title:UserService</p>
 * <p>@Description 用户service</P>
 *
 * @Author pos
 * @DATE 2020/5/6 21:21
 */
public interface UserService {
    /**
     * @Description: 添加用户信息
     * @return: void
     * @Param: [user]
     * @Date: 2020/5/6 21:18
     **/
    void insertUser(User user)throws Exception;

    /**
     * @Description: 查询所有用户
     * @return: void
     * @Param: [user]
     * @Date: 2020/5/30 23:31
     **/
    List<User> selectUser(UserExample userExample)throws Exception;

    /**
     * @Description: 根据id删除用户
     * @return: void
     * @Param: [userId]
     * @Date: 2020/5/30 23:37
     **/
    void delectUser(Integer userId)throws Exception;
}
