package shop.mtcoding.marketkurly.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public Long allProductCount() {

        Long query = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
        return query;
    }

    public List<ProductStarDTO> findListByStarCount() {
        TypedQuery<ProductStarDTO> query = em.createQuery(
                "SELECT NEW shop.mtcoding.marketkurly.product.ProductStarDTO(p, AVG(r.starCount)) " +
                        "FROM Product p " +
                        "JOIN Review r ON r.product = p " +
                        "GROUP BY p " +
                        "ORDER BY AVG(r.starCount) DESC",
                ProductStarDTO.class).setMaxResults(8);

        List<ProductStarDTO> productDTOs = query.getResultList();
        return productDTOs;
    }

    public List<ProductDiscountDTO> findListByDiscountRate() {
        TypedQuery<ProductDiscountDTO> query = em.createQuery(
                "SELECT NEW shop.mtcoding.marketkurly.product.ProductDiscountDTO(p, AVG(r.starCount)) " +
                        "FROM Product p " +
                        "JOIN Review r ON r.product = p " +
                        "GROUP BY p " +
                        "ORDER BY p.discountRate DESC",
                ProductDiscountDTO.class).setMaxResults(8);
        List<ProductDiscountDTO> productDTOs = query.getResultList();

        return productDTOs;
    }

    public List<ProductRandomDTO> findListByRandom(String numbers) {
        TypedQuery<ProductRandomDTO> query = em.createQuery(
                "SELECT NEW shop.mtcoding.marketkurly.product.ProductRandomDTO(p, AVG(r.starCount))" +
                        " FROM Product p" +
                        " JOIN Review r ON r.product = p" +
                        " WHERE p.id IN " + numbers +
                        " GROUP BY p",
                ProductRandomDTO.class);

        List<ProductRandomDTO> productDTOs = query.getResultList();

        return productDTOs;
    }

    public List<ProductStarDTO> findListBySearch(String keyword) {
        System.out.println("테스트 keyword : " + keyword);
        System.out.println("테스트 keyword : " + keyword);
        System.out.println("테스트 keyword : " + keyword);
        System.out.println("테스트 keyword : " + keyword);
        System.out.println("테스트 keyword : " + keyword);
        TypedQuery<ProductStarDTO> query = em.createQuery(
                "SELECT NEW shop.mtcoding.marketkurly.product.ProductStarDTO(p, AVG(r.starCount))" +
                        " FROM Product p" +
                        " JOIN Review r ON r.product = p" +
                        " WHERE p.productName LIKE :keyword" +
                        " GROUP BY p",
                ProductStarDTO.class);

        query.setParameter("keyword", "%" + keyword + "%");

        List<ProductStarDTO> productDTOs = query.getResultList();
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        System.out.println("테스트 : " + productDTOs);
        return productDTOs;
    }

}
