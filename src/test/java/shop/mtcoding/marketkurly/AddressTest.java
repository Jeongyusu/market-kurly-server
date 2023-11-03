package shop.mtcoding.marketkurly;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.address.AddressJPARepository;
import shop.mtcoding.marketkurly.address.AddressService;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryRepository;
import shop.mtcoding.marketkurly.category.CategoryService;
import shop.mtcoding.marketkurly.orderedoption.OrderOptionJAPRepository;
import shop.mtcoding.marketkurly.product.Product;

// test환경에서는 Autowired해주지 않으면 매개변수 인식을 못함
// @RequiredArgsConstructor
@SpringBootTest
public class AddressTest {


    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressJPARepository addressJPARepository;
    @Autowired
    private OrderOptionJAPRepository orderOptionJAPRepository;


    @Autowired
    private AddressService addressService;

    private Integer userid = 1;


    @Test
    public void 주소찾기() {
        List<Address> addresses = addressJPARepository.findByUserId(userid);
    }


     @Test
     public ResponseEntity<?> 모든카테고리찾기() {
     List<Category> categorys = categoryService.모든카테고리찾기();
     return ResponseEntity.ok().body(ApiUtils.success(categorys));
     }

    @Test
    public Page<Product> 주문옵션찾기() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Order.desc("fieldName")));

        Page<Product> products = orderOptionJAPRepository.findBestProducts(pageable);
        System.out.println(products);
        return products;
    }

}
