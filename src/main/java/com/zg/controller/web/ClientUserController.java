package com.zg.controller.web;

import com.zg.po.User;
import com.zg.po.UserExample;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>Title:ClientUserController</p>
 * <p>@Description web端用户的controller</P>
 *
 * @Author pos
 * @DATE 2020/5/30 23:28
 */
@Controller
@RequestMapping("/web")
public class ClientUserController {

    @Autowired
    private UserService userService;
    /**
     * @Description: 查询所有用户
     * @return: java.lang.String
     * @Param: [userExample, model]
     * @Date: 2020/5/30 23:35
     **/
    @RequestMapping("/selectUser")
    public String selectUser(UserExample userExample, Model model) throws Exception {
        List<User> userList = userService.selectUser(userExample);
        model.addAttribute("userList",userList);
        return "user/page_selectUser";
    }

    /**
     * @Description: 根据id删除用户
     * @return: java.lang.String
     * @Param: [userId]
     * @Date: 2020/5/30 23:40
     **/
    @RequestMapping("/delectUser")
    public String delectUser(Integer userId)throws Exception{
        userService.delectUser(userId);
        return "user/page_user";
    }
}
