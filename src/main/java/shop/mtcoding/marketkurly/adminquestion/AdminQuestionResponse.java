package shop.mtcoding.marketkurly.adminquestion;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.mtcoding.marketkurly.adminreply.AdminReply;
import shop.mtcoding.marketkurly.user.User;

public class AdminQuestionResponse {

    @ToString
    @Getter
    @Setter
    public static class AdminQuestionListDTO {

        List<AdminQuestionDTO> adminQuestionAnsweredDTOs;
        List<AdminQuestionDTO> adminQuestionWaitingDTOs;

        public AdminQuestionListDTO(List<AdminQuestion> adminQuestions) {
            this.adminQuestionAnsweredDTOs = adminQuestions.stream()
                    .filter(adminQuestion -> Boolean.TRUE.equals(adminQuestion.getInAnswered()))
                    .map(t -> new AdminQuestionDTO(t))
                    .collect(Collectors.toList());

            this.adminQuestionWaitingDTOs = adminQuestions.stream()
                    .filter(adminQuestion -> Boolean.FALSE.equals(adminQuestion.getInAnswered()))
                    .map(t -> new AdminQuestionDTO(t))
                    .collect(Collectors.toList());
        }

        @ToString
        @Getter
        @Setter
        public class AdminQuestionDTO {

            private Integer id;
            private Integer userId;
            private String adminQuestionType;
            private String username;
            private String adminQuestionTitle;
            private Boolean inAnswered;
            private Boolean isEmailAccepted;
            private LocalDate adminQuestionCreatedAt;

            public AdminQuestionDTO(AdminQuestion t) {
                this.id = t.getId();
                this.userId = t.getUser().getId();
                this.adminQuestionType = t.getAdminQuestionType();
                this.username = t.getUser().getUsername();
                this.adminQuestionTitle = t.getAdminQuestionTitle();
                this.inAnswered = t.getInAnswered();
                this.isEmailAccepted = t.getIsEmailAccepted();
                this.adminQuestionCreatedAt = t.getAdminQuestionCreatedAt().toLocalDateTime().toLocalDate();
            }

        }
    }

    @ToString
    @Getter
    @Setter
    public static class AdminQuestionDetailDTO {

        AdminQuestionDTO adminQuestionDTO;
        List<AdminReplyDTO> adminReplyDTOs;

        public AdminQuestionDetailDTO(AdminQuestion adminQuestion) {
            this.adminQuestionDTO = new AdminQuestionDTO(adminQuestion);
            this.adminReplyDTOs = adminQuestion.getAdminReplies().stream().map(t -> new AdminReplyDTO(t))
                    .collect(Collectors.toList());
        }

        @ToString
        @Getter
        @Setter
        public class AdminQuestionDTO {

            private Integer id;
            private String adminQuestionType;
            private String username;
            private String adminQuestionTitle;
            private String adminQuestionContent;
            private Boolean inAnswered;
            private Boolean isEmailAccepted;
            private LocalDate adminQuestionCreatedAt;

            public AdminQuestionDTO(AdminQuestion t) {
                this.id = t.getId();
                this.adminQuestionType = t.getAdminQuestionType();
                this.username = t.getUser().getUsername();
                this.adminQuestionTitle = t.getAdminQuestionTitle();
                this.adminQuestionContent = t.getAdminQuestionContent();
                this.inAnswered = t.getInAnswered();
                this.isEmailAccepted = t.getIsEmailAccepted();
                this.adminQuestionCreatedAt = t.getAdminQuestionCreatedAt().toLocalDateTime().toLocalDate();
            }

        }

        @ToString
        @Getter
        @Setter
        public class AdminReplyDTO {

            private Integer id;
            private String aReplyContent;

            public AdminReplyDTO(AdminReply t) {
                this.id = t.getId();
                this.aReplyContent = t.getAReplyContent();
            }

        }
    }
}
