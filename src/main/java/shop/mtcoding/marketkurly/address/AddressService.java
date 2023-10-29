package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> 모든주소찾기(Integer userId) {
        log.info("addressService 호출됨");
        List<Address> addresses = addressRepository.findByUserId(userId);
        return addresses;
    }

}
