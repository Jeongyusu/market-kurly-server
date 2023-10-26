package shop.mtcoding.marketkurly.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/api/productHome")
    public ResponseEntity<?> 메인홈1(@RequestParam int page) {
        ProductResponse.ProductMainDTO response = productService.메인홈(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

}
