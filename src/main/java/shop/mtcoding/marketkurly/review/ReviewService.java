package shop.mtcoding.marketkurly.review;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.notice.Notice;
import shop.mtcoding.marketkurly.notice.NoticeJPARepository;
import shop.mtcoding.marketkurly.product.Product;
import shop.mtcoding.marketkurly.review.ReviewResponse.ReviewMainDTO;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewJPARepository reivewJPARepository;
    private final NoticeJPARepository noticeJPARepository;

    public ReviewMainDTO 상품리뷰메인() {

        System.out.println("상품리뷰메인 호출");
        // TODO findByProduct 매개변수 Product 타입이 아닌 ProductId 로 찾기
        List<Review> reviews = reivewJPARepository.findByProductId(1);
        List<Notice> Notices = noticeJPARepository.findByNoticeType("공지");

        return new ReviewResponse.ReviewMainDTO(Notices, reviews);
    }
}
