package com.galaxy;

import com.baomidou.mybatisplus.plugins.Page;
import com.galaxy.dao.EmpDao;
import com.galaxy.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class testMp {

    @Autowired
    private DataSource dataSource;

    @Resource
    private EmpDao empDao;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void insert(){
        Emp emp1 = new Emp(0, "小泽", "idea!123.com", 1, 20,1);
        Emp emp2 = new Emp(0, "小雷", "idea!123.com", 1, 20,1);
        Emp emp3 = new Emp(0, "小裴", "idea!123.com", 1, 20,1);
        Emp emp4 = new Emp(0, "小闫", "idea!123.com", 1, 20,1);
        Emp emp5 = new Emp(0, "小建", "idea!123.com", 1, 20,1);
        Emp emp6 = new Emp(0, "小梁", "idea!123.com", 1, 20,1);
        empDao.insert(emp1);
        empDao.insert(emp2);
        empDao.insert(emp3);
        empDao.insert(emp4);
        empDao.insert(emp5);
        empDao.insert(emp6);
        //mybatisPlus会自动把当前插入对象在数据库中的id歇会到改实体中
//        System.out.println(emp);
//
//        Emp emp2 = new Emp();
//        emp2.setUserName("Tomcat");
//        emp2.setGender(2);
//        empDao.insertAllColumn(emp2);
    }

    @Test
    public void update(){
//        Emp emp = new Emp(2, "测试", "idea@123.com", 123, 20);
//        empDao.updateById(emp);
//        System.out.println(emp);

        Emp emp2 = new Emp();
        emp2.setId(4);
        emp2.setUserName("测试4444");
        emp2.setAge(111233);
//        empDao.updateById(emp2);
        empDao.updateAllColumnById(emp2);
        System.out.println(emp2);
    }



    @Test
    public void selectOne(){
//        Emp emp = new Emp();
//        emp.setEmail("idea!123.com");
//        Emp selectOne = empDao.selectOne(emp);
//        System.out.println(selectOne);

        Map<String, Object> map = new HashMap<>();
        map.put("email","idea!123.com");
        List<Emp> emps = empDao.selectByMap(map);
        System.out.println(emps);
    }

    @Test
    public void selectBatchIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        ids.add(6);
        ids.add(7);
        ids.add(8);
        List<Emp> emps = empDao.selectBatchIds(ids);
        System.out.println(emps);
    }

    @Test
    public void selectPage(){
        List<Emp> selectPage = empDao.selectPage(new Page<>(2, 5), null);
        selectPage.forEach(System.out::println);
    }

    @Test
    public void deleteByMap(){
//        Integer emp = empDao.deleteById(4);
//        System.out.println(emp);
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name","测试2");
        empDao.deleteByMap(columnMap);
    }

    /*批量删除*/
    @Test
    public void deleteBatchIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        ids.add(8);
        empDao.deleteBatchIds(ids);

    }

}
