package shop.mtcoding.marketkurly.adminreply;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.adminquestion.AdminQuestion;
import shop.mtcoding.marketkurly.adminquestion.AdminQuestionJPARepository;
import shop.mtcoding.marketkurly.adminreply.AdminReplyRequest.AReplySaveDTO;

@Service
@RequiredArgsConstructor
public class AdminReplyService {

    private final AdminQuestionJPARepository adminQuestionJPARepository;
    private final AdminReplyJPARepository adminReplyJPARepository;

    public void 답변저장(AReplySaveDTO aReplySaveDTO) {

        AdminQuestion adminQuestion = adminQuestionJPARepository.findById(aReplySaveDTO.getAdminQuestionId()).get();
        AdminReply adminReply = AdminReply.builder()
                .adminQuestion(adminQuestion)
                .aReplyContent(aReplySaveDTO.getReplyContent())
                .build();
        adminReplyJPARepository.save(adminReply);
    }

}
