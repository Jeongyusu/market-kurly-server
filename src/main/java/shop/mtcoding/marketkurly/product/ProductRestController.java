package shop.mtcoding.marketkurly.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/api/product/bestProduct")
    public ResponseEntity<?> 베스트(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.베스트(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/product/category")
    public ResponseEntity<?> 카테고리(@RequestParam int page, @RequestParam Integer categoryId) {
        ProductResponse.ProductListDTO response = productService.카테고리필터링(page, categoryId);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/product/newProdcut")
    public ResponseEntity<?> 신상품(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.신상품(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));

    }

    @GetMapping("/api/product/home")
    public ResponseEntity<?> 컬리추천(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.컬리추천(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/product/event")
    public ResponseEntity<?> 금주혜택() {
        List<String> imageUrls = List.of(
                "http://localhost:8080/images/list/Screenshot_1.jpg",
                "http://localhost:8080/images/list/Screenshot_2.jpg",
                "http://localhost:8080/images/list/Screenshot_3.jpg",
                "http://localhost:8080/images/list/Screenshot_4.jpg");
        return ResponseEntity.ok().body(ApiUtils.success(Map.of("imageUrls", imageUrls)));
    }
}