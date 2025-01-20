package me.kifio.repository;

import me.kifio.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(String product, BigDecimal price) {
        String sql = "INSERT INTO purchase (id, product, price) VALUES (NULL, ?, ?)";
        jdbc.update(sql, product, price);
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (rs, rowNum) -> new Purchase(
                rs.getInt("id"),
                rs.getString("product"),
                rs.getBigDecimal("price")
        );

        return jdbc.query(sql, rowMapper);
    }
}
