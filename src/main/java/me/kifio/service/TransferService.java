package me.kifio.service;

import me.kifio.model.Account;
import me.kifio.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(
            int sender,
            int receiver,
            int amount
    ) {
        Account senderAccount = accountRepository.findById(sender)
                .orElseThrow(() -> new IllegalStateException("Account not found!"));
        Account receiverAccount = accountRepository.findById(receiver)
                .orElseThrow(() -> new IllegalStateException("Account not found!"));

        int senderNewAmount = senderAccount.amount() - amount;
        int receiverNewAmount = receiverAccount.amount() + amount;

        accountRepository.changeAmount(sender, senderNewAmount);
        accountRepository.changeAmount(receiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
