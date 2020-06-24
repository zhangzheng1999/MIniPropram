package com.zg.controller.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zg.controller.converter.DateConverter;
import com.zg.po.Item;
import com.zg.po.ItemExample;
import com.zg.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Title:ClientController</p>
 * <p>@Description web端商品的controller</P>
 *
 * @Author pos
 * @DATE 2020/5/30 17:40
 */
@Controller
@RequestMapping("/web")
public class ClientItemController {
    @Autowired
    private ItemsService itemsService;

    @Autowired
    private DateConverter dateConverter;


    /**
     * @Description: 后台分页查询所有商品列表返回jsp
     * @return: java.lang.String
     * @Param: [itemExample, modelAndView]
     * @Date: 2020/5/30 17:52
     **/
    @RequestMapping(value = "/queryItems",method = RequestMethod.POST)
    public String queryItems(HttpServletRequest request,ItemExample itemExample, Model model) throws Exception {
//        int pageNum = 1;
//        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
//            pageNum=1;
//        }else{
//            pageNum=Integer.parseInt(request.getParameter("pageNum"));
//        }
//        PageInfo<Item> itemList = itemsService.findItemListPage(pageNum,itemExample);
//        model.addAttribute("itemList",itemList);
        return "item/page_item";
    }

    /**
     * @Description: 后台搜索商品
     * @return: java.lang.String
     * @Param: [searchName, itemExample, model]
     * @Date: 2020/5/30 18:01
     **/
    @RequestMapping(value = "/selectItemsByName",method = RequestMethod.POST)
    public String selectItemsByName(@RequestParam(value ="searchName") String searchName, ItemExample itemExample, Model model) throws Exception {
        List<Item> itemList = itemsService.findItemByName(itemExample, searchName);
        if (itemList.size()==0){
            model.addAttribute("mesg","商品不存在！");
        }
        model.addAttribute("itemList",itemList);
        return "item/page_item";
    }

    /**
     * @Description: 后台删除商品
     * @return: java.lang.String
     * @Param: [itemId]
     * @Date: 2020/5/30 18:02
     **/
    @RequestMapping("/deleteItem")
    public String deleteItem(@RequestParam(value = "itemId")Integer itemId) throws Exception {
        itemsService.deleteItem(itemId);
        return "item/page_item";
    }

    /**
     * @Description: 后台根据id修改商品的状态
     * @return: java.lang.String
     * @Param: [itemId, item]
     * @Date: 2020/6/18 19:43
     **/
    @RequestMapping("/updateItem")
    public String updateItem(@RequestParam(value = "itemId")Integer itemId,Item item,Integer itemState)throws Exception{
        itemsService.updateItemWeb(item,itemId,itemState);
        return "tip/page_tip";
    }
}
