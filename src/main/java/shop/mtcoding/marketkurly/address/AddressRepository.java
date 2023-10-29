package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByUserId(Integer userId);

}
