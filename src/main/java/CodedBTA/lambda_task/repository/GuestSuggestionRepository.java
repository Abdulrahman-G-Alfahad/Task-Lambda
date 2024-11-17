package CodedBTA.lambda_task.repository;

import CodedBTA.lambda_task.entity.GuestSuggestionEntity;
import CodedBTA.lambda_task.util.SuggestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long> {
    public List<GuestSuggestionEntity> findByStatus(SuggestionStatus status);
}
