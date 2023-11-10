package shop.mtcoding.marketkurly.cart;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.address.AddressJPARepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartService {

    private final CartJPARepository cartJPARepository;
    private final AddressJPARepository addressJPARepository;

    public CartResponse.FindAllDTO 장바구니목록조회(Integer memberId) {

        Address address = addressJPARepository.기본배송지찾기(memberId).get();
        List<Cart> carts = cartJPARepository.findByUser_Id(memberId);
        return new CartResponse.FindAllDTO(carts, address);
    }

    public void 장바구니주문() {
    }

    public void 장바구니담기() {
    }
}
