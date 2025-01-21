package me.kifio.service;

import me.kifio.model.Account;
import me.kifio.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Account senderAccount = accountRepository.findAccount(sender);
        Account receiverAccount = accountRepository.findAccount(receiver);

        int senderNewAmount = senderAccount.amount() - amount;
        int receiverNewAmount = receiverAccount.amount() + amount;

        accountRepository.changeAmount(sender, senderNewAmount);
        accountRepository.changeAmount(receiver, receiverNewAmount);

        throw new IllegalStateException("Oh no!!, something went wrong!");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
