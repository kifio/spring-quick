package me.kifio.controller;

import me.kifio.model.Purchase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import me.kifio.repository.PurchaseRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/purchase")
    public List<Purchase> getPurchase(Model model) {
        return purchaseRepository.findAll();
    }

    @PostMapping("/purchase")
    public void makePurchase(
            @RequestParam String product,
            @RequestParam BigDecimal price,
            Model model
    ) {
        purchaseRepository.save(product, price);
    }

}
