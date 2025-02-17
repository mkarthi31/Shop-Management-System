package co2123.hw1.controller;


import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Shop;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ShopValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Shop.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Shop shop = (Shop) target;

        for (Shop s : Hw1Application.shops){
            if (s.getId() == shop.getId()){
                errors.rejectValue("id", "","ID Already Exists");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name is required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "", "Owner is required");


    }
}
