package shop.mtcoding.marketkurly.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.marketkurly.notice.Notice;
import shop.mtcoding.marketkurly.reviewpic.ReviewPic;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class NoticeResponse {
    @ToString
    @Getter
    @NoArgsConstructor
    public static class NoticeMainDTO {

        private List<NoticeDTO> noticeDTOs;

        public NoticeMainDTO(List<Notice> notices) {
            this.noticeDTOs = notices.stream().map(t -> new NoticeDTO(t)).collect(Collectors.toList());
        }

        @ToString
        @Getter
        @NoArgsConstructor
        public class NoticeDTO {
            private Integer noticeId;
            private String noticeTitle;
            private String noticeType;
            private String noticeWriter = "MarketKurly";
            private LocalDate noticeCreatedAt;

            public NoticeDTO(Notice notice) {
                this.noticeId = notice.getId();
                this.noticeTitle = notice.getNoticeTitle();
                this.noticeType = notice.getNoticeType();
                this.noticeCreatedAt = notice.getNoticeCreatedAt().toLocalDateTime().toLocalDate();
            }
        }
    }

}