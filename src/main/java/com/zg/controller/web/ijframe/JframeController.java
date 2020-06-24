package com.zg.controller.web.ijframe;

import com.github.pagehelper.PageInfo;
import com.zg.po.Item;
import com.zg.po.ItemExample;
import com.zg.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Title:JframeController</p>
 * <p>@Description 窗口Controller</P>
 *
 * @Author pos
 * @DATE 2020/5/31 17:18
 */
@Controller
@RequestMapping("/jframe")
public class JframeController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/toData")
    public String toIndex(ItemExample itemExample, Model model)throws Exception{

        return "index/page_data";
    }

    @RequestMapping("/toUser")
    public  String toUSer(){
        return "user/page_user";
    }

    @RequestMapping("/toItem")
    public ModelAndView toInfo(HttpServletRequest request, ItemExample itemExample)throws Exception{
        int pageNum = 1;
        if(request.getParameter("pageNum")==null || "".equals(request.getParameter("page"))){
            pageNum = 1;
        }else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }

        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemStateEqualTo(1);
        PageInfo<Item> itemListPage = itemsService.findItemListPage(pageNum, itemExample);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",itemListPage.getList());
        modelAndView.addObject("pages",itemListPage.getPages());
        modelAndView.addObject("pageNum",itemListPage.getPageNum());
        System.out.println(itemListPage.getPages());
        modelAndView.setViewName("item/page_item");
        return modelAndView;
    }

    @RequestMapping("/toTip")
    public ModelAndView toTip(ItemExample itemExample) throws Exception {
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemStateEqualTo(0);
        List<Item> itemList = itemsService.findItemList( itemExample);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",itemList);
        modelAndView.addObject("itemLenth", itemList.size());
        modelAndView.setViewName("tip/page_tip");
        return modelAndView;
    }
}
