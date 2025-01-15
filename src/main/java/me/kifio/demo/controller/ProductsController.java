package me.kifio.demo.controller;

import me.kifio.demo.model.dto.Product;
import me.kifio.demo.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {
        return products(model);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product p = new Product(name, price);
        productService.addProduct(p);

        return products(model);
    }

    private String products(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

}
