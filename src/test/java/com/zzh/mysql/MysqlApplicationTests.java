package com.zzh.mysql;

import com.zzh.mysql.dao.AuthUser;
import com.zzh.mysql.model.Demo01;
import com.zzh.mysql.repository.AuthUserRepository;
import com.zzh.mysql.service.Demo01Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Test
    public void mySqlTest(){
        String sql = "select column_1,column_2,column_3 from demo01";
        List<Demo01> demo01List = (List<Demo01>) jdbcTemplate.query(sql, new RowMapper<Demo01>() {
            @Override
            public Demo01 mapRow(ResultSet resultSet, int i) throws SQLException {
                Demo01 demo01 = new Demo01();
                demo01.setColumn_1(resultSet.getString("column_1"));
                demo01.setColumn_2(resultSet.getString("column_2"));
                demo01.setColumn_3(resultSet.getString("column_3"));
                return demo01;
            }
        });
        System.out.println("查询成功：");
        for (Demo01 demo01:
             demo01List) {
            System.out.println("column_01: " + demo01.getColumn_1() + "; column_02: " + demo01.getColumn_2() + "; column_03: " + demo01.getColumn_3());
        }
        String sql2 = "INSERT INTO demo01 (`column_1`, `column_2`, `column_3`) VALUES ('6', '66', '666')";
        jdbcTemplate.execute(sql2);
    }

    @Resource
    private Demo01Service demo01Service;
    @Test
    public void testRepository(){
        List<Demo01> demo01List = demo01Service.finaAll();
        System.out.println("所有结果数量：" + demo01List.size());
        for (Demo01 demo01:
             demo01List) {
            System.out.println(demo01.getColumn_1() + " " + demo01.getColumn_2() + " " + demo01.getColumn_3());
        }

        Optional<Demo01> demo01 = demo01Service.findByColumn_1("3");
        System.out.println(demo01.get().getColumn_1() + " " + demo01.get().getColumn_2() + " " + demo01.get().getColumn_3());

        Demo01 demo011 = new Demo01();
        demo011.setColumn_1("7");
        demo011.setColumn_2("77");
        demo011.setColumn_3("777");
        demo01Service.save(demo011);

        demo01Service.delete("7");

    }

    @Autowired
    private AuthUserRepository authUserRepository;

    @Before
    public void before(){
        AuthUser authUser = new AuthUser();
        authUser.setId(1L);
        authUser.setName("风清扬");
        authUser.setAccount("fengqy");
        authUser.setPassword("123456");
        authUser.setId(3L);
        authUser.setName("东方不败");
        authUser.setAccount("dongfbb");
        authUser.setPassword("234567");
        authUser.setId(5L);
        authUser.setName("令狐冲");
        authUser.setAccount("linghc");
        authUser.setPassword("345678");
    }

    @Test
    public void testAdd(){
        AuthUser authUser = new AuthUser();
        authUser.setId(2L);
        authUser.setName("任我行");
        authUser.setAccount("renwx");
        authUser.setPassword("456789");
        authUser.setId(4L);
        authUser.setName("向问天");
        authUser.setAccount("xiangwt");
        authUser.setPassword("567890");
    }

    @After
    public void after(){
        authUserRepository.deleteById(1L);
        authUserRepository.deleteById(3L);
        authUserRepository.deleteById(5L);
    }
}
