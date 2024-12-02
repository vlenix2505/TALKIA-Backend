package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiaBackend.entities.Level;
import com.upc.talkiaBackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> getQuestionsByLevel(Level level);
    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowQuestionByLevelDTO(q.id, q.description, q.iCreatedAt, q.iModifiedAt)from Question q where q.level.level=:level")
    List<ShowQuestionByLevelDTO> listQuestionsByLevel(String level);
    Question getQuestionByDescription(String description);
    List<Question> getQuestionsByDescriptionContainingIgnoreCase(String description);
}
