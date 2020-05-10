package com.cyblogs.transaction.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with springcloud-learn
 *
 * @description:
 * @author: chenyuan
 * @date: 2020/5/10
 * @time: 10:00 下午
 */
@Component
public class DataSourceConnectHolder {

    @Autowired
    private DataSource dataSource;
    /**
     * 线程绑定对象
     */
    ThreadLocal<Connection> resources = new NamedThreadLocal<>("Transactional resources");

    public Connection getConnection() {
        Connection con = resources.get();
        if (con != null) {
            return con;
        }
        try {
            con = dataSource.getConnection();
            //为了体现事务，全部设置为手动提交事务
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resources.set(con);
        return con;
    }

    public void cleanHolder() {
        Connection con = resources.get();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resources.remove();
    }
}
