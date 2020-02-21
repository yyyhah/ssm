package com.itcast;

import com.itcast.dao.IEmpDao;
import com.itcast.domain.Employee;
import com.itcast.service.IEmpService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
//指定注解配置类
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {

    private IEmpService service;
    private InputStream is;
    private SqlSession sqlSession;
    @Test
    public void testEmpService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IEmpService empService = applicationContext.getBean("empService", IEmpService.class);
        empService.doFindAll();
        empService.doSave(new Employee());
    }
    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        sqlSession = factory.openSession();

    }
    @Test
    public void testDoSave(){
        IEmpDao mapper = sqlSession.getMapper(IEmpDao.class);
        Employee employee = new Employee();
        employee.setAge(25);
        employee.setName("贾静雯");
        employee.setDepartId(5);
        mapper.doSave(employee);
    }

    @Test
    public void testDoFindAll() {
        IEmpDao mapper = sqlSession.getMapper(IEmpDao.class);
        System.out.println(mapper.doFindAll());
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
}
