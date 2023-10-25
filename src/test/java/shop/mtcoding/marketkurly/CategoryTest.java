package shop.mtcoding.marketkurly;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryRepository;

@SpringBootTest
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void 카테고리찾기() {
        List<Category> categorys = categoryRepository.findAll();
        System.out.println("category : " + categorys);

    }
}
