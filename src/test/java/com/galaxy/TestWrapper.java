package com.galaxy;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.galaxy.dao.EmpDao;
import com.galaxy.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestWrapper {

    @Resource
    private EmpDao empDao;

    @Test
    public void testPage(){
//        EntityWrapper<Emp> wrapper = new EntityWrapper<>();
//        wrapper.between("age",18,50);
//        List<Emp> empList = empDao.selectPage(new Page<Emp>(1, 2), wrapper);
//        empList.forEach(System.out::println);
       List<Emp> empList = empDao.selectPage(new Page<Emp>(1,2),
                new EntityWrapper<Emp>()
                .between("age",16,30)
                .eq("gender",1));
       empList.forEach(System.out::println);
    }

    @Test
    public void testPage2(){
       List<Emp> empList = empDao.selectPage(new Page<Emp>(1,2),
                new EntityWrapper<Emp>()
                .eq("gender",1)
                .like("user_name","小")
                .or()
                .like("email","x"));
       empList.forEach(System.out::println);

    }

    @Test
    public void testPage3(){
       List<Emp> empList = empDao.selectList(
                new EntityWrapper<Emp>()
                .eq("gender",1)
                .orderBy("age")
                .last("desc limit 0,5"));
       empList.forEach(System.out::println);

    }

    @Test
    public void testPage4(){
       List<Emp> empList = empDao.selectPage(new Page<Emp>(1,3),
               Condition.create()
               .between("age",19,50)
               .eq("gender",1)
               .orderBy("age")
//               .eq("user_name","小燕")
               .like("user_name","小")
               );
       empList.forEach(System.out::println);

    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setEmail("240@qq.com");
        empDao.update(emp,
                new EntityWrapper<Emp>()
                .like("email","!")
        );

    }

    @Test
    public void testDelete(){
        empDao.delete(
          new EntityWrapper<Emp>()
                    .like("email","@")
        );
    }

    @Test
    public void testPages(){
        //配置分页插件后，还是和以前一样的使用selectPage方法
        //但是现在就是真正的物理分页了，sql语句中有limit了
        Page<Emp> page = new Page<>(1,2);
        List<Emp> empList = empDao.selectPage(page, null);
        empList.forEach(System.out::println);
        System.out.println("=============想关分页信息=============");
        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页数：" +page.getCurrent() );
        System.out.println("总页数：" + page.getPages());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("是否有上一页" + page.hasPrevious());
        System.out.println("是否有下一页" + page.hasNext());
        //将可以查询的结果set进page对象中
        page.setRecords(empList);
    }

    @Test
    public void testSqlExplain(){
        //条件为null就是删除权标，执行分析插件会终止该操作
        empDao.delete(null);
    }

    @Test
    public void testLoginDelete(){
        Integer integer = empDao.deleteById(25);
        System.out.println(integer);
    }

    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setUserName("哈哈哈");
        emp.setAge(3);
        emp.setEmail("sdfsdkf@qq.com");
        Integer insert = empDao.insert(emp);
        System.out.println(emp);
        System.out.println(insert);
    }

}
