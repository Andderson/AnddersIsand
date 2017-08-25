package com.kaitaiming.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.junit.Test;



/**
 * @desc 类功能描述：
 * @author 王桂元(Mike.Wong)
 * @createTime 2017年8月14日 下午6:40:37
 *
 * @version V2.0
 */
public class HiveJdbcTest {

    private static final String URLHIVE = "jdbc:hive2://172.16.101.110:10000/default";
    private static Connection connection = null;

    public static Connection getHiveConnection() {
        if (null == connection) {
            synchronized (HiveJdbcTest.class) {
                if (null == connection) {
                    try {
                        Class.forName("org.apache.hive.jdbc.HiveDriver");
                        connection = DriverManager.getConnection(URLHIVE, "hdfs", "");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    public static void createTable() throws SQLException {
        String dropTableSql = "DROP TABLE IF EXISTS h_member";
        String createMember = "CREATE EXTERNAL TABLE h_member(userId,userAccount,userName) "
                + "STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' "
                + "WITH SERDEPROPERTIES (\"hbase.columns.mapping\" = \":key,userAccount:userAccount,userName:userName\") "
                + "TBLPROPERTIES (\"hbase.table.name\" = \"member\")";
        String createFileTable = "create table deptid int,deptName string) row format delimited fields "
                + "terminated by '\t' lines terminated by '\n' stored as textfile";

        String createSelectTable = "CREATE TABLE claimreport AS SELECT col1,col2 FROM source";

        // LOAD DATA LOCAL INPATH '/home/hadoop/input/ncdc/micro-tab/sample.txt' OVERWRITE INTO TABLE records  加载文本到对应表中
        // create table logs(ts bigint,line string) partitioned by (dt String,country String); 创建表并进行分区
        // create table new_table like records;

        Statement stmt = getHiveConnection().createStatement();
        stmt.executeQuery(dropTableSql);
        stmt.executeQuery(createMember);
        stmt.executeQuery(createFileTable);
    }

    @Test
    public void selectTweet() throws SQLException {
        long aaa = System.currentTimeMillis();
       // long start = DateUtils.getNDaysAgo(DateUtils.getMidNight(), 15).getTime().getTime();
        //long end = DateUtils.getNDaysAgo(DateUtils.getMidNight(), 13).getTime().getTime();
        String sql = "select * from h_member order by key limit 10";

        Connection connection =getHiveConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setLong(1, start);
//        pstm.setLong(2, end);
//        pstm.setString(3, "2176270443");
        ResultSet rss = pstm.executeQuery();
        while (rss.next()) {
            System.out.println("1: " + rss.getString("userAccount") + "   2: " + rss.getString("userName") );
        }

        System.out.println(System.currentTimeMillis() - aaa);

        connection.close();

    }
}
