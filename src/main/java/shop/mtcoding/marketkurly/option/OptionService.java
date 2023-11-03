package shop.mtcoding.marketkurly.option;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception404;
import shop.mtcoding.marketkurly.option.OptionResponse.OptionSelectMainDTO;
import shop.mtcoding.marketkurly.product.ProdcutJPARepository;
import shop.mtcoding.marketkurly.product.Product;

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

}
