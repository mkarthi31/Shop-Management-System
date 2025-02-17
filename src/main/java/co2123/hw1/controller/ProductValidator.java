package co2123.hw1.controller;

import co2123.hw1.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "", "Manufacturer is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "website", "", "Website is required");

        if (!("Bread".equals(product.getGoods()) || "Cake".equals(product.getGoods()) || "Biscuits".equals(product.getGoods()))) {
            errors.rejectValue("goods", "", "Goods must be 'Bread', 'Cake', or 'Biscuits'");
        }

        if (product.getPrice() < 5 || product.getPrice() > 40) {
            errors.rejectValue("price", "", "Price must be between 5 and 40");
        }
    }
}
