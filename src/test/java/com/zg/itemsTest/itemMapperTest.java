package com.zg.itemsTest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title:item</p>
 * <p>@Description 类注释</P>
 *
 * @Author pos
 * @DATE 2020/4/20 15:44
 */
public class itemMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private ApplicationContext applicationContext;
    @Before
    public void setUp()throws Exception {
//        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
    }
//    @Test
//    public void findItemsById(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ItemMapper itemMapper = sqlSession.getMapper(ItemMapper.class);
//        Item item = itemMapper.selectByPrimaryKey(1);
//        System.out.println(item);
//    }

//    @Test
//    public void findItemsByIdSpring(){
//        ItemMapper itemMapper = (ItemMapper) applicationContext.getBean("itmMapper");
//        Item item = itemMapper.selectByPrimaryKey(1);
//        System.out.println(item);
//    }

}
