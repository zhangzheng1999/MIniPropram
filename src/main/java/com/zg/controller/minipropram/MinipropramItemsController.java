package com.zg.controller.minipropram;

import com.zg.controller.converter.DateConverter;
import com.zg.po.Item;
import com.zg.po.ItemExample;
import com.zg.service.ItemsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * <p>Title:ItemsController</p>
 * <p>@Description 小程序端</P>
 * @Author pos
 * @DATE 2020/4/20 17:21
 */
@Controller
@RequestMapping("/minipropram")
public class MinipropramItemsController {

    private Logger logger = Logger.getLogger(MinipropramItemsController.class);

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private DateConverter dateConverter;

    /**
     * @Description: 查询所有商品
     * @return: java.lang.String
     * @Param: [item, model]
     * @Date: 2020/4/20 17:37
     **/
    @RequestMapping(value = "/queryItems",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    //请求json（商品信息），输出json
    //@RequestBody将json串转成java对象（Item）
    //@ResponseBody将java对象（Item）转成json串
    public @ResponseBody List<Item> queryItems(ItemExample itemExample) throws Exception {
        try {
            List<Item> list = itemsService.findItemList(itemExample);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 搜索框进行模糊查询
     * @return: java.util.List<com.zg.po.Item>
     * @Param: [request, item, itemName]
     * @Date: 2020/5/22 15:53
     **/
    @RequestMapping(value = "/selectItemByName",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody List<Item> selectItemByName(String itemName,ItemExample itemExample) throws Exception {
            List<Item> list = itemsService.findItemByName(itemExample,itemName);
            return list;
    }

    /**
     * @Description: 发布商品
     * @return: com.zg.po.Item
     * @Param: [request, item, itemImg]
     * @Date: 2020/5/26 19:00
     **/
    @RequestMapping(value = "/insertItem")
    @ResponseBody
    public Item insertItem(HttpServletRequest request,
                            Item item,
                            @RequestParam(value = "pic", required = false) MultipartFile itemImg) throws Exception {
        request.setCharacterEncoding("utf-8");
        //购买日期的格式
        DateConverter.style="yyyy-MM-dd";
        //获取购买时间
        String itemBuytime = request.getParameter("itemBuyTime");
        //添加购买日期
        item.setItemBuyTime(dateConverter.convert(itemBuytime));
        //商品创建时间的格式
        DateConverter.style="yyyy-MM-dd HH:mm:ss";
        //获取商品创建时间
        String itemCreateTime = request.getParameter("itemCreateTime");
        //添加创建时间
        item.setItemCreateTime(dateConverter.convert(itemCreateTime));
        //----------------上传图片---------------
        //获取原始名称
        String originalFilename = itemImg.getOriginalFilename();
        logger.info("获取原始名称");
        //上传图片  && originalFilename!=null && originalFilename.length()>0
        if (itemImg != null) {
            //储存图片的物理路径
            String pic_path = "C:\\Users\\pos\\Pictures\\tomcat\\pic\\itemPic\\";
            //新的图片名称
            String newPicName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path + newPicName);
            //将内存中的数据写入磁盘
            itemImg.transferTo(newFile);
            //将新图片名称写到Item中
            item.setItemPic(newPicName);
        }

        itemsService.insertItems(item);
        return item;
    }


    /**
     * @Description: 修改商品
     * @return: com.zg.po.Item
     * @Param: [item, itemId]
     * @Date: 2020/5/26 19:01
     **/
    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    @ResponseBody
    public Item updateItem(HttpServletRequest request, Item item,Integer itemId,
                           @RequestParam(value = "pic", required = false) MultipartFile itemImg) throws Exception {
        DateConverter.style="yyyy-MM-dd";
        //获取购买时间
        String itemBuytime = request.getParameter("itemBuyTime");
        //添加购买日期
        item.setItemBuyTime(dateConverter.convert(itemBuytime));
        //商品创建时间的格式
        DateConverter.style="yyyy-MM-dd HH:mm:ss";
        //获取商品创建时间
        String itemCreateTime = request.getParameter("itemCreateTime");
        //添加创建时间
        item.setItemCreateTime(dateConverter.convert(itemCreateTime));

        //----------------上传图片---------------
        //获取原始名称
        String originalFilename = itemImg.getOriginalFilename();
        logger.info("获取原始名称");
        //上传图片  && originalFilename!=null && originalFilename.length()>0
        if (itemImg != null) {
            //储存图片的物理路径
            String pic_path = "C:\\Users\\pos\\Pictures\\tomcat\\pic\\itemPic\\";
            //新的图片名称
            String newPicName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path + newPicName);
            //将内存中的数据写入磁盘
            itemImg.transferTo(newFile);
            //将新图片名称写到Item中
            item.setItemPic(newPicName);
        }
        itemsService.updateItem(item,itemId);
        return item;
    }

    @RequestMapping("/deleteItem")
    public Item  deleteItem(Integer itemId) throws Exception {
        itemsService.deleteItem(itemId);
        return null;
    }
}

