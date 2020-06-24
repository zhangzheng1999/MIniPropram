package com.zg.service.impl;

import com.zg.mapper.UserMapper;
import com.zg.po.User;
import com.zg.po.UserExample;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title:UserServiceImpl</p>
 * <p>@Description 类注释</P>
 *
 * @Author pos
 * @DATE 2020/5/6 21:21
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * @Description: 添加用户
     * @return: void
     * @Param: [user]
     * @Date: 2020/5/6 21:22
     **/
    @Override
    public void insertUser(User user) throws Exception {
        userMapper.insert(user);
    }

    /**
     * @Description: 查询所有用户
     * @return: java.util.List<com.zg.po.User>
     * @Param: [userExample]
     * @Date: 2020/5/30 23:37
     **/
    @Override
    public List<User> selectUser(UserExample userExample) throws Exception {
        List<User> userList = userMapper.selectByExample(userExample);
        return userList;
    }

    /**
     * @Description: 根据id删除用户
     * @return: void
     * @Param: [userId]
     * @Date: 2020/5/30 23:37
     **/
    @Override
    public void delectUser(Integer userId) throws Exception {
        userMapper.deleteByPrimaryKey(userId);
    }
}
