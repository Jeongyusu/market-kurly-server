package shop.mtcoding.marketkurly.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    List<Notice> findByNoticeType(String noticeType);
}
