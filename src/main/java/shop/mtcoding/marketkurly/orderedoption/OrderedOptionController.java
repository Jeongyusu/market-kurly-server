package shop.mtcoding.marketkurly.orderedoption;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.product.Product;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderedOptionController {

    private final OrderOptionJAPRepository orderOptionJAPRepository;

    @GetMapping("/api/test/selectoo")
    public Page<Product> 주문옵션찾기() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Order.desc("fieldName")));

        Page<Product> products = orderOptionJAPRepository.findBestProducts(pageable);
        System.out.println(products);
        return products;
    }

}
