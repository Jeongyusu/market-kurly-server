package shop.mtcoding.marketkurly;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryRepository;
import shop.mtcoding.marketkurly.category.CategoryService;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
public class CategoryTest {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @Test
    public void 카테고리찾기() {
        List<Category> categorys = categoryRepository.findAll();
        System.out.println("category : " + categorys);
    }

    @Test
    public ResponseEntity<?> 모든카테고리찾기() {
        List<Category> categorys = categoryService.모든카테고리찾기();
        return ResponseEntity.ok().body(ApiUtils.success(categorys));
    }
}
