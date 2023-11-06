package shop.mtcoding.marketkurly.address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressJPARepository extends JpaRepository<Address, Integer> {

    List<Address> findByUserId(Integer userId);

    @Query(value = "update ADDRESS_TB set IS_DEFAULT_ADDRESS = false;", nativeQuery = true)
    Integer updateDefaultAddress();

    @Query("select a from Address a where a.user.id = :userId and a.isDefaultAddress = true")
    Optional<Address> findDefaultAddressByUserId(Integer userId);

}
