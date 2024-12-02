package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.QuizzesQuestionCompleteDTO;
import com.upc.talkiaBackend.dtos.queries.ShowQuestionsByQuizDTO;
import com.upc.talkiaBackend.entities.Question;
import com.upc.talkiaBackend.entities.Quiz;
import com.upc.talkiaBackend.entities.QuizzesQuestion;
import com.upc.talkiaBackend.repositories.AnswerRepository;
import com.upc.talkiaBackend.repositories.QuizRepository;
import com.upc.talkiaBackend.repositories.QuizzesQuestionRepository;
import com.upc.talkiaBackend.repositories.UserRepository;
import com.upc.talkiaBackend.security.entities.User;
import com.upc.talkiaBackend.services.QuizzesQuestionService;
import com.upc.talkiaBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizzesQuestionServiceImpl implements QuizzesQuestionService {
    @Autowired
    private QuizzesQuestionRepository qqRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    UserService userService;


    List<Double> pointsByLevel = Arrays.asList(20.0, 12.0, 10.0);

    @Override
    @Transactional
    public String answerQuestion(int qqId, String userAnswer) {
        QuizzesQuestion qq = qqRepository.getQuizzesQuestionById(qqId);
        Question question = qq.getQuestion();
        Double points = qq.getPointsEarned();
        Double pointsQuiz = qq.getQuiz().getTotalPoints();

        if (qq.getAttempt() < 2 && !qq.getIs_correct()) {
            qq.setUserAnswer(userAnswer);
            qq.setAttempt(qq.getAttempt() + 1);

            if (answerRepository.getCorrectAnswerByQuestionId(question.getId()).getDescription().equals(userAnswer)) {
                double gainedPoints = 0.0;
                if (qq.getAttempt() == 1) {
                    gainedPoints = pointsByLevel.get(question.getLevel().getId() - 1);
                } else if (qq.getAttempt() == 2) {
                    gainedPoints = pointsByLevel.get(question.getLevel().getId() - 1) / 2.0;
                }

                points += gainedPoints;
                qq.setPointsEarned(points);
                qq.setIs_correct(true);
                pointsQuiz += gainedPoints;
                qq.getQuiz().setTotalPoints(pointsQuiz);

                if(qqId % 4 == 0){
                    finalizeQuiz(qq.getQuiz().getId());
                }


                return qq.getAttempt() == 1
                        ? "Correct! Haz ganado " + gainedPoints + " puntos"
                        : "Now is correct! Haz ganado " + gainedPoints + " puntos";
            }

            return "Incorrect. " + question.getFeedback();
        }

        return "Has llegado al límite de intentos permitidos";
    }

    @Override
    public void finalizeQuiz(int quizId) {
        Quiz quiz = quizRepository.getQuizById(quizId);
        Double totalQuizPoints = quiz.getTotalPoints();
        User user = quiz.getUser();
        Double updatedUserPoints = user.getTotalPoints() + totalQuizPoints;

        user.setTotalPoints(updatedUserPoints);
        userRepository.save(user);
        userService.updateLevelUser(user.getId());
    }

    @Override
    public List<QuizzesQuestionCompleteDTO> listQuizzesQuestionByQuizId(int quizId) {
        return qqRepository.getQuizzesQuestionsByQuizId(quizId);
    }
    @Override
    public Double getAveragePoints(int userId) {
        return qqRepository.getAveragePoints(userId);
    }
    @Override
    public Double getAveragePointsTotal(int levelId){ return qqRepository.getAveragePointsTotal(levelId); }
    @Override
    public Long getTotalQuizzesCompleted(int userId) {
        return qqRepository.getTotalQuizzesCompleted(userId);
    }

    @Override
    public Double getAverageCorrectAnswers(int userId) {
        Long totalQuestions = qqRepository.getTotalQuestions(userId);
        Long correctAnswers = qqRepository.getTotalCorrectAnswers(userId);

        if (totalQuestions == 0) {
            return 0.0;
        }
        return correctAnswers * 1.0 / totalQuestions;
    }

    @Override
    public Integer getSecondAttemptCorrectAnswers(int quizId) {
        return qqRepository.getSecondAttemptCorrectAnswers(quizId);
    }



    @Override
    public Integer getCorrectAnswersCount(int quizId) {
        return qqRepository.getCorrectAnswersCount(quizId);
    }

    @Override
    public Double getPercentageCorrectAnswers(int quizId) {
        double correctAnswers = 1.0 * qqRepository.getCorrectAnswersCount(quizId);

        return correctAnswers/4.0;
    }

    @Override
    public List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(int quizId) {
        return qqRepository.listQuestionsByQuizId(quizId);
    }

    @Override
    public Double getTotalPoints(int userId){
        return qqRepository.getTotalPoints(userId);
    }



    @Override
    public Long getTotalQuizzesCompletedGeneral(int levelId) {
        return qqRepository.getTotalQuizzesCompletedGeneral(levelId);
    }
}
