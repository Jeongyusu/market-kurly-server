package shop.mtcoding.marketkurly.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

    @GetMapping("/test")
    void test() {
    log.info("인포");
    log.debug("디버그");
    log.trace("트레이스");
    log.warn("경고");
    log.error("에러");
    }

    @PostMapping("/api/productHome")
    public ResponseEntity<?> 메인홈(@RequestBody ProductRequest.ProductMainDTO
    ProductMainDTO)
    pr

}
