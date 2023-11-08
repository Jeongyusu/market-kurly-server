package shop.mtcoding.marketkurly.option;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.option.OptionResponse.OptionSelectMainDTO;
import shop.mtcoding.marketkurly.product.ProdcutJPARepository;
import shop.mtcoding.marketkurly.product.ProductResponse.ProductDetailListDTO;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final ProdcutJPARepository prodcutJPARepository;
    private final OptionJPARepository optionJPARepository;

    public OptionSelectMainDTO 상품옵션목록() {

        System.out.println("option 서비스 호출");
        List<Option> options = optionJPARepository.findByProductId(1);

        System.out.println("option 서비스 options : " + options);
        return new OptionSelectMainDTO(options);
    }

    public ProductDetailListDTO 대기상품디테일(Integer productId) {
        List<Option> options = optionJPARepository.findByProductId(productId);
        System.out.println("대기상품 디테일 서비스 : " + options);
        return new ProductDetailListDTO(options);
    }

}
