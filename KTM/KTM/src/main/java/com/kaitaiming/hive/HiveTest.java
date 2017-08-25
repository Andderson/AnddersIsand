package com.kaitaiming.hive;



import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveClient;
import org.springframework.data.hadoop.hive.HiveClientFactory;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @desc 类功能描述：
 * @author 王桂元(Mike.Wong)
 * @createTime 2017年8月14日 下午5:38:26
 *
 * @version V2.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-*.xml" })
public class HiveTest {

    @Autowired
    private HiveTemplate hiveTemplate;

    @Test
    public void findAllTables() {
        System.out.println(hiveTemplate.query("show tables"));
    }

    @Test
    public void count() {
        String tableName = "h_member";
        long rowCount = hiveTemplate.
                queryForLong("select count(*) from " + tableName);

        System.out.println(rowCount);

    }

    @Test
    public void hivePage(){
        String hql = "select * from h_member order by key asc limit 10";


        System.out.println(hiveTemplate.query(hql));
    }

}
