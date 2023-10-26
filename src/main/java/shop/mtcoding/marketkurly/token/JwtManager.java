package shop.mtcoding.marketkurly.token;

public interface JwtManager {

    Payload parse(String token);

    boolean verifyAtk(String token);

    String buildAtk(Integer id, String username, String role);
}
