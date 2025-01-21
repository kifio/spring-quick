package me.kifio.repository;

import me.kifio.mapper.AccountRowMapper;
import me.kifio.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;
    private final AccountRowMapper accountRowMapper;

    public AccountRepository(
            JdbcTemplate jdbc,
            AccountRowMapper accountRowMapper
    ) {
        this.jdbc = jdbc;
        this.accountRowMapper = accountRowMapper;
    }

    public Account findAccount(int id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbc.queryForObject(sql, accountRowMapper, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, accountRowMapper);
    }

    public void changeAmount(int id, int amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }
}
