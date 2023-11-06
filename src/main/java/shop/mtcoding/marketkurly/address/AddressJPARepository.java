package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressJPARepository extends JpaRepository<Address, Integer> {

    List<Address> findByUserId(Integer userId);

    @Query(value = "update ADDRESS_TB set IS_DEFAULT_ADDRESS = false", nativeQuery = true)
    Integer updateDefaultAddress();

}
