package me.kifio.repository;

import me.kifio.model.Account;
import org.komamitsu.spring.data.sqlite.SqliteRepository;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;

public interface AccountRepository extends SqliteRepository<Account, Integer> {

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    public void changeAmount(int id, int amount);
}
