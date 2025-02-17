package co2123.hw1;

import co2123.hw1.domain.Product;
import co2123.hw1.domain.Shop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Hw1Application implements CommandLineRunner {

    public static List<Shop> shops;
    public static List<Product> products;

    public static void main(String[] args) {

        SpringApplication.run(Hw1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        shops = new ArrayList<>();

        Shop s = new Shop();
        s.setId(1);
        s.setName("KN Express");
        s.setOwner("Abdul");
        s.setProducts(new ArrayList<>());

        Product product1 = new Product();
        product1.setManufacturer("Ferrero");
        product1.setWebsite("https://www.ferrero.com/int/en/");
        product1.setGoods("Buiscuits");
        product1.setPrice(600); //Price given in pennies since int

        Product product2 = new Product();
        product2.setManufacturer("Cadbury");
        product2.setWebsite("https://www.cadbury.co.uk/");
        product2.setGoods("Cake");
        product2.setPrice(450); //Price given in pennies since int

        s.getProducts().add(product1);
        s.getProducts().add(product2);

        shops.add(s);

    }
}
