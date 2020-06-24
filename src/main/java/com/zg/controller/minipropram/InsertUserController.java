package com.zg.controller.minipropram;

import com.zg.po.User;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * <p>Title:InsertUser</p>
 * <p>@Description 小程序添加用户</P>
 *
 * @Author pos
 * @DATE 2020/5/6 21:14
 */
@Controller
public class InsertUserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/addUser")
    @ResponseBody
    public User addUser(User user, HttpServletRequest request, @RequestParam(value = "userInfo",required = false)MultipartFile avatarUrl) throws Exception {
        //----------------上传图片---------------,
        //                        @RequestParam(value = "userInfo",required = false)MultipartFile avatarUrl
        //获取原始名称
        String originalFilename = avatarUrl.getOriginalFilename();

        //上传图片  && originalFilename!=null && originalFilename.length()>0
        if (avatarUrl != null) {
            //储存图片的物理路径
            String pic_path = "C:\\Users\\pos\\Pictures\\tomcat\\pic\\userAvatar\\";
            //新的图片名称
            String newPicName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            System.out.println(newPicName);
            //新图片
            File newFile = new File(pic_path + newPicName);
            //将内存中的数据写入磁盘
            avatarUrl.transferTo(newFile);
            //将新图片名称写到User中
            user.setUserAvatar(newPicName);
        }

        String userAvatar = request.getParameter("userAvatar");
        System.out.println(userAvatar);
        userService.insertUser(user);
        return  user;
    }
}
