package me.kifio.controller;

import me.kifio.model.Account;
import me.kifio.service.TransferService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import me.kifio.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    record TransferRequest(
        int sender,
        int receiver,
        int amount
    ) {

    }

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(Model model) {
        return transferService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public void makePurchase(
            @RequestBody TransferRequest request,
            Model model
    ) {
        transferService.transferMoney(
                request.sender(),
                request.receiver(),
                request.amount()
        );
    }

}
