package shop.mtcoding.marketkurly.adminquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminQuestionJPARepository extends JpaRepository<AdminQuestion, Integer> {

    @Modifying
    @Query(value = "UPDATE ADMIN_QUESTION_TB SET IS_ANSWERED = true WHERE id = :id", nativeQuery = true)
    void updateStateById(@Param("id") Integer adminQuestionId);

}
