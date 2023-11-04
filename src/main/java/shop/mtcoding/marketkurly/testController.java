package shop.mtcoding.marketkurly;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.testController.ProductDTO;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly._core.vo.MyPath;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryJPARepository;
import shop.mtcoding.marketkurly.category.CategoryService;
import shop.mtcoding.marketkurly.option.Option;
import shop.mtcoding.marketkurly.product.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequiredArgsConstructor
public class testController {

    private final CategoryService categoryService;

    @GetMapping({ "/", "/login" })
    public String main() {
        System.out.println("테스트 : 로그인 호출");
        return "loginForm";
    }

    @GetMapping("/join")
    public String join() {
        System.out.println("테스트 : 조인 호출");
        return "joinForm";
    }

    @GetMapping("/seller")
    public String sellerMain() {
        System.out.println("테스트 : sellerMain 호출");
        return "seller/sellerMain";
    }

    // @GetMapping("/seller/product")
    // public String sellerProduct() {
    // System.out.println("테스트 : sellerProduct 호출");
    // return "seller/sellerProduct";
    // }

    @GetMapping("/seller/product/submit")
    public String sellerProductSubmit(HttpServletRequest request) {
        List<Category> categorys = categoryService.모든카테고리찾기();
        request.setAttribute("categorys", categorys);
        return "seller/sellerProductSubmit";
    }

    @PostMapping("/test/cat")
    public void catPic(ResumeDTO resumeDTO) {
        System.out.println("테스트 : catPic 호출");
        System.out.println("테스트 : resumeDTO :" + resumeDTO.productName);
        System.out.println("테스트 : resumeDTO :" + resumeDTO.getProductContent());
        System.out.println("테스트 : resumeDTO :" + resumeDTO.getCategoryNum());
        System.out.println("테스트 : resumeDTO :" + resumeDTO.getCatPic());

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + resumeDTO.getCatPic().getOriginalFilename();

        // 자바에서 받은 파일을 저장할 경로를 상대경로로 지정(IMG_PATH의 ./는 현재위치를 의미)
        // 현재 경로 Desktop/WS/workspace/project/blogV2
        // 배포 시 해당 실행 파일 경로에 images 폴더가 필요함
        Path filePath = Paths.get(MyPath.PRODUCTDETAIL_PATH + fileName);
        System.out.println("테스트 : filePath :" + filePath);

        // 파일 쓰기 write(경로, 바이트파일)
        try {
            Files.write(filePath, resumeDTO.getCatPic().getBytes());
        } catch (Exception e) {
            e.getStackTrace();
        }

        // DB에 저장P
        Product product = Product.builder().productDetailPic(fileName)
                .build();
        System.out.println("테스트 : product.getProductDetailPic() :" + product.getProductDetailPic());
    }

    @Getter
    @Setter
    public static class ResumeDTO {
        private MultipartFile catPic;
        private String productName;
        private String productContent;
        private Integer categoryNum;
    }

    @PostMapping("/product/save")
    public ResponseEntity<?> saveTest(
            @RequestParam("productThumbnail") MultipartFile productThumbnail,
            @RequestParam("productDetailPic") MultipartFile productDetailPic,
            @RequestParam("productName") String productName,
            @RequestParam("productContent") String productContent,
            @RequestParam("discountRate") Integer discountRate,
            @RequestParam("discountExpiredAt") String discountExpiredAt,
            @RequestParam("categoryId") long categoryId,
            @RequestParam("optionList") String optionListJson) {

        // productThumbnail과 productDetailPic 파일 처리
        // productName, productContent, discountRate, discountExpiredAt, categoryId 처리
        // optionListJson은 JSON 문자열로 받습니다.

        // optionListJson JSON 문자열을 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        List<Option> optionList;

        System.out.println("productThumbnail : " + productThumbnail);
        System.out.println("productDetailPic : " + productDetailPic);
        System.out.println("productName : " + productName);
        System.out.println("productContent : " + productContent);
        System.out.println("discountRate : " + discountRate);
        System.out.println("discountExpiredAt : " + discountExpiredAt);
        System.out.println("categoryId : " + categoryId);

        try {
            optionList = objectMapper.readValue(optionListJson, new TypeReference<List<Option>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid optionList JSON");
        }

        System.out.println("optionList : " + optionList.get(0).getOptionName());
        return ResponseEntity.ok("Product saved successfully");
    }

    @Getter
    @Setter
    @ToString
    public static class ProductDTO {
        private String productName;
        private String productContent;
        private Integer discountRate;
        private Timestamp discountExpiredAt;
        private Integer categoryId;
        private MultipartFile productThumbnail;
        private MultipartFile productDetailPic;
        private String optionList;
    }

}
