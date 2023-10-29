package shop.mtcoding.marketkurly.review;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.notice.Notice;
import shop.mtcoding.marketkurly.notice.NoticeRepository;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.review.ReviewResponse.ReviewMainDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewJPARepository reivewJPARepository;
    private final NoticeRepository noticeJPARepository;

    public ReviewMainDTO 상품리뷰메인페이지() {

        // TODO findByProduct 매개변수 Product 타입이 아닌 ProductId 로 찾기
        List<Review> reviews = reivewJPARepository.findByProduct(new Product());
        List<Notice> Notices = noticeJPARepository.findByNoticeType("공지");

        return new ReviewResponse.ReviewMainDTO(Notices, reviews);
    }
}
