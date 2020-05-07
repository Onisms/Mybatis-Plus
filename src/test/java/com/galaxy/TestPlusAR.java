package com.galaxy;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.galaxy.entity.Emp;
import com.galaxy.entity.Emp2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class TestPlusAR {

    @Test
    public void insert() {
        Emp2 emp2 = new Emp2(0, "test", "222@qq.com", 1, 2);
//        boolean insert = emp2.insert();
        //insertOrUpdate:如果传递的对象，有id的值。会按照id去做更新操作
        //如果该id在数据库中查不到，泽进行新增操作
        boolean insert = emp2.insertOrUpdate();
        System.out.println(insert);
        System.out.println(emp2);
    }


    @Test
    public void testArUpdate() {
        Emp2 emp2 = new Emp2(2, "更新", "@qq.com", 2, 2);
        boolean b = emp2.updateById();
        System.out.println(b);
    }
    @Test
    public void testArSelect() {
        Emp2 emp2 = new Emp2();
        //1、根据id查询
//        Emp2 selectById = emp2.selectById(2);
//        System.out.println(selectById);
        //或者用这种方法
        emp2.setId(2);
        Emp2 emp21 = emp2.selectById();
        System.out.println(emp21);

    }

        @Test
        public  void testArSelect2(){
            //2、查询所有
//        List<Emp2> emp2s = emp2.selectAll();
//        emp2s.forEach(System.out::println);
        }

        @Test
        public  void testArSelect3(){
            Emp2 emp2 = new Emp2();
            //3、根据条件查询
            List<Emp2> emp2List = emp2.selectList(new EntityWrapper<Emp2>().like("user_name", "小"));
            emp2List.forEach(System.out::println);
        }

        @Test
        public  void testArSelect4(){
        //4、查询符合条件的
            Emp2 emp2 = new Emp2();
            int result = emp2.selectCount(new EntityWrapper<Emp2>().eq("gender",1));
            System.out.println(result);
        }

        @Test
        public  void testArDelete(){
            Emp2 emp2 = new Emp2();
            //删除数据库中不存在的数据也是返回true
            //1.根据id删除数据
          //  boolean deleteById = emp2.deleteById(4);

            //获取id也行
//            emp2.setId(3);
//            boolean deleteById = emp2.deleteById();
//            System.out.println(deleteById);

            //2.根据条件删除----模糊删除
            boolean age = emp2.delete(new EntityWrapper<Emp2>().like("age", "2"));
            System.out.println(age);
        }
}


