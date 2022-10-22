package com.example.transactions.repository;

import com.example.transactions.AccountRowMapper;
import com.example.transactions.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepo {
    private final JdbcTemplate jdbc;

    public AccountRepo(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql,amount,id);
    }

    public List<Account> findAllAcounts(){
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }

}
