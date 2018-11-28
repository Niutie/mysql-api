package com.zzh.mysql;

import com.zzh.mysql.model.Demo01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                demo01.setColumn_1(resultSet.getInt("column_1"));
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
    }
}
