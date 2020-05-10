package com.cyblogs.transaction.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with springcloud-learn
 *
 * @description:
 * @author: chenyuan
 * @date: 2020/5/10
 * @time: 9:59 下午
 */
@Service
public class TransactionService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = NullPointerException.class)
    public void saveTest(int id) {
        saveWitharamters(id, "luozhou@gmail.com");
        saveWitharamters(id + 10, "luozhou@gmail.com");
        int aa = id / 0;
    }

    private void saveWitharamters(int id, String email) {
        String sql = "insert into tb_test values(" + id + ", '" + email + "'" + ")";
        jdbcTemplate.execute(sql);
    }
}
