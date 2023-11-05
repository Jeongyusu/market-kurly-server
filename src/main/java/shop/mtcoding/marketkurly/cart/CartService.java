package shop.mtcoding.marketkurly.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final CartJPARepository cartJPARepository;

    public CartResponse.FindAllDTO 장바구니목록조회(Integer memberId) {
        List<Cart> carts = cartJPARepository.findByUser_Id(memberId);
        return new CartResponse.FindAllDTO(carts);
    }
}
