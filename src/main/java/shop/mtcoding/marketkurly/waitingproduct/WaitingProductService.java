package shop.mtcoding.marketkurly.waitingproduct;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception500;
import shop.mtcoding.marketkurly._core.vo.MyPath;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryJPARepository;
import shop.mtcoding.marketkurly.product.ProductResponse.SellerProductListDTO;
import shop.mtcoding.marketkurly.user.User;
import shop.mtcoding.marketkurly.user.UserJPARepository;
import shop.mtcoding.marketkurly.waitingoption.WaitingOption;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionJPARepository;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionRequest.WOptionSaveDTO;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductRequest.WProductDTO;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductResponse.WaitingProductListDTO;

@Service
@RequiredArgsConstructor
public class WaitingProductService {

    private final CategoryJPARepository categoryJPARepository;
    private final WaitingProductJPARepository waitingProductJPARepository;
    private final WaitingOptionJPARepository waitingOptionJPARepository;
    private final UserJPARepository userJPARepository;

    @Transactional
    public void 상품승인요청(WProductDTO wProductDTO, Integer userId) {

        UUID uuid = UUID.randomUUID();
        String ProductThumbnailName = uuid + "_" + wProductDTO.getProductThumbnail().getOriginalFilename();
        String ProductDetailPicName = uuid + "_" + wProductDTO.getProductDetailPic().getOriginalFilename();

        // 자바에서 받은 파일을 저장할 경로를 상대경로로 지정(IMG_PATH의 ./는 현재위치를 의미)
        // 현재 경로 Desktop/WS/workspace/project/blogV2
        // 배포 시 해당 실행 파일 경로에 images 폴더가 필요함
        Path ProductThumbnailPath = Paths.get(MyPath.WAITINGPRODUCTTHUMB_PATH + ProductThumbnailName);
        Path ProductDetailPicPath = Paths.get(MyPath.WAITINGPRODUCTDETAIL_PATH + ProductDetailPicName);

        // 파일 쓰기 write(경로, 바이트파일)
        try {
            Files.write(ProductThumbnailPath, wProductDTO.getProductThumbnail().getBytes());
            Files.write(ProductDetailPicPath, wProductDTO.getProductDetailPic().getBytes());
        } catch (Exception e) {
            throw new Exception500("사진 저장 실패");
        }

        Category category = categoryJPARepository.findById(wProductDTO.getCategoryId()).get();
        User user = userJPARepository.findById(userId).get();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate wDiscountExpiredAt = LocalDate.parse(wProductDTO.getDiscountExpiredAt(), formatter);

        WaitingProduct waitingProduct = WaitingProduct.builder()
                .wProductName(wProductDTO.getProductName())
                .wProductThumbnail((MyPath.WAITINGPRODUCTTHUMB_PATH + ProductThumbnailName).substring(1))
                .wProductDetailPic((MyPath.WAITINGPRODUCTDETAIL_PATH + ProductDetailPicName).substring(1))
                .wProductContent(wProductDTO.getProductContent())
                .wDiscountRate(wProductDTO.getDiscountRate())
                .wDiscountExpiredAt(wDiscountExpiredAt)
                .wProductUploadedAt(new Timestamp(new Date().getTime()))
                .category(category)
                .seller(user)
                .build();

        waitingProductJPARepository.save(waitingProduct);

        ObjectMapper objectMapper = new ObjectMapper();
        List<WOptionSaveDTO> optionDTOList;

        try {
            optionDTOList = objectMapper.readValue(wProductDTO.getOptionList(),
                    new TypeReference<List<WOptionSaveDTO>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new Exception500("WOptionSaveDTO Json파싱 실패");
        }

        for (WOptionSaveDTO wOptionSaveDTO : optionDTOList) {

            WaitingOption waitingOption = WaitingOption.builder()
                    .wOptionName(wOptionSaveDTO.getOptionName())
                    .wOptionPrice(wOptionSaveDTO.getOptionPrice())
                    .wOptionStack(wOptionSaveDTO.getOptionStack())
                    .waitingProduct(waitingProduct)
                    .build();

            waitingOptionJPARepository.save(waitingOption);
        }

    }

    public WaitingProductListDTO 대기상품목록(Integer userId) {
        List<WaitingProduct> waitingProducts = waitingProductJPARepository.findBySellerId(userId);
        return new WaitingProductListDTO(waitingProducts);
    }

}
