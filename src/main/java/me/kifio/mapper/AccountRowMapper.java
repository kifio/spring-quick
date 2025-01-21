package me.kifio.mapper;

import me.kifio.model.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Account(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("amount")
        );
    }
}
