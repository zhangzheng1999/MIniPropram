package com.zg.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title:DateConverter</p>
 * <p>@Description 日期转换</P>
 *
 * @Author pos
 * @DATE 2020/4/28 15:36
 */
public class DateConverter implements Converter<String, Date> {
    public static  String style = "";
    @Override
    public Date convert(String source) {

        //实现 将日期串转成日期类型(格式是yyyy-MM-dd)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);

        try {
            //转成直接返回
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //如果参数绑定失败返回null
        return null;

    }


}
