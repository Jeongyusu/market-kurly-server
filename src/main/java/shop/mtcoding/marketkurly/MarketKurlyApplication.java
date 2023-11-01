package shop.mtcoding.marketkurly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.user.User;

@SpringBootApplication
public class MarketKurlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketKurlyApplication.class, args);

	}
}
