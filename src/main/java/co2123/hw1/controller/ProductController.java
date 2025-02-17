package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Product;
import co2123.hw1.domain.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ProductController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidator());
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(@RequestParam("shop") int shopId, Model model) {
        Shop shop = Hw1Application.shops.stream()
                .filter(s -> s.getId() == shopId)
                .findFirst()
                .orElse(null);

        if (shop != null) {
            model.addAttribute("products", shop.getProducts());
            model.addAttribute("shopId", shopId);
            model.addAttribute("shopName", shop.getName());
        }

        return "products/list";
    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    public String showNewProductForm(@RequestParam("shop") int shopId, Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("shopId", shopId);
        return "products/form";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestParam("shop") int shopId,
                             @ModelAttribute("product") Product product,
                             BindingResult result, Model model) {

        new ProductValidator().validate(product, result);

        if (result.hasErrors()) {
            model.addAttribute("shopId", shopId);
            return "products/form";
        }

        Hw1Application.shops.stream()
                .filter(s -> s.getId() == shopId)
                .findFirst()
                .ifPresent(shop -> {
                    if (shop.getProducts() == null) {
                        shop.setProducts(new ArrayList<>());
                    }
                    shop.getProducts().add(product);
                });

        return "redirect:/shops";
    }
}
