package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.dtos.queries.QuizzesQuestionCompleteDTO;
import com.upc.talkiaBackend.dtos.queries.ShowQuestionsByQuizDTO;
import com.upc.talkiaBackend.entities.QuizzesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizzesQuestionRepository extends JpaRepository<QuizzesQuestion, Integer> {
    @Query("select avg(q.totalPoints) " +
            "from Quiz q " +
            "where q.user.id=:userId")
    public Double getAveragePoints(@Param("userId") int userId);

    @Query("select sum(q.totalPoints) " +
            "from Quiz q " +
            "where q.user.id=:userId")
    public Double getTotalPoints(@Param("userId") int userId);

    @Query("SELECT COUNT(qq) " +
            "FROM QuizzesQuestion qq " +
            "WHERE qq.is_correct = true " +
            "AND qq.quiz.user.id = :userId")
    public Double countCorrectAnswersByUser(@Param("userId") int userId);

    @Query("SELECT COUNT(qq) " +
            "FROM QuizzesQuestion qq " +
            "WHERE qq.quiz.user.id = :userId")
    public Double countTotalAnswersByUser(@Param("userId") int userId);

    @Query("select avg(q.totalPoints) " +
            "from Quiz q " +
            "where q.user.level.id=:levelId")
    public Double getAveragePointsTotal(@Param("levelId") int levelId);

    @Query("select count(distinct qq.quiz.id) from QuizzesQuestion qq  where qq.quiz.user.id=:userId")
    public Long getTotalQuizzesCompleted(@Param("userId") int userId);

    @Query("select count(distinct qq.quiz.id) from QuizzesQuestion qq where qq.question.level.id=:levelId")
    public Long getTotalQuizzesCompletedGeneral(@Param("levelId") int levelId);

    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId")
    public Long getTotalQuestions(@Param("userId") int userId);


    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId and qq.is_correct = true")
    public Long getTotalCorrectAnswers(@Param("userId") int userId);

    QuizzesQuestion getQuizzesQuestionById(Integer id);

    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.id=:quizId and qq.is_correct=true")
    public Integer getCorrectAnswersCount(@Param("quizId") int quizId);



    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.id=:quizId and qq.attempt=2 and qq.is_correct=true")
    public Integer getSecondAttemptCorrectAnswers(@Param("quizId") int quizId);

    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowQuestionsByQuizDTO(qq.id ,qq.question.id, qq.question.description)" +
            "from QuizzesQuestion qq where qq.quiz.id =:quizId")
    List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(@Param("quizId") int quizId);

    @Query("select new com.upc.talkiaBackend.dtos.queries.QuizzesQuestionCompleteDTO(qq.id ,qq.question, qq.quiz, qq.attempt, ans.description ,qq.is_correct)" +
            "from QuizzesQuestion qq JOIN Question q on qq.question.id = q.id " +
            "JOIN Answer ans on q.id = ans.question.id where qq.quiz.id =:quizId and ans.isCorrect = true")
    public List<QuizzesQuestionCompleteDTO> getQuizzesQuestionsByQuizId(int quizId);
}
