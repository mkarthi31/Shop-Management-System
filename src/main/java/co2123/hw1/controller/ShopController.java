package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Shop;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ShopValidator());
    }

    @RequestMapping("/shops")
    public String shop(Model model){
        model.addAttribute("shops", Hw1Application.shops);
        return "shops/list";
    }

    @RequestMapping("newShop")
    public String newShop(Model model){
        model.addAttribute("shop", new Shop());
        return "shops/form";
    }

    @RequestMapping("addShop")
    public String addShop(@Valid @ModelAttribute Shop shop, BindingResult result){
        if(result.hasErrors()){
            return "shops/form";
        }
        Hw1Application.shops.add(shop);
        return "redirect:/shops";
    }

}
