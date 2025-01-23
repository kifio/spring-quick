package me.kifio;

import me.kifio.model.Account;
import me.kifio.repository.AccountRepository;
import me.kifio.service.TransferService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TransferServiceUnitTests {

    @Test
    public void transferMoneyHappyPath() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account(1, "sender", 100);
        Account receiver = new Account(2, "receiver", 100);

        given(accountRepository.findById(sender.id())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.id())).willReturn(Optional.of(receiver));

        transferService.transferMoney(sender.id(), receiver.id(), 50);

        verify(accountRepository).changeAmount(sender.id(), 50);
        verify(accountRepository).changeAmount(receiver.id(), 150);
    }

    @Test
    public void transferMoneyAccountNotFound() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        TransferService transferService = new TransferService(accountRepository);

        int senderId = 1;
        int receiverId = 2;

        Account sender = new Account(senderId, "sender", 100);

        given(accountRepository.findById(senderId)).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiverId)).willReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () ->
        transferService.transferMoney(senderId, receiverId, 100));

        verify(accountRepository, never()).changeAmount(anyInt(), anyInt());
    }
}
