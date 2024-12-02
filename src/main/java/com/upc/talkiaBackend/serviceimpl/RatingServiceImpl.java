package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkiaBackend.entities.Content;
import com.upc.talkiaBackend.entities.Rating;

import com.upc.talkiaBackend.repositories.ContentRepository;
import com.upc.talkiaBackend.repositories.RatingRepository;
import com.upc.talkiaBackend.repositories.UserRepository;
import com.upc.talkiaBackend.security.entities.User;
import com.upc.talkiaBackend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Integer insertRating(int id_content, int id_user, int score){
        User user = userRepository.findById(id_user).get();
        Content content = contentRepository.findById(id_content).get();
        Rating rating = new Rating();
        rating.setUser(user);
        rating.setContent(content);
        rating.setScore(score);
        ratingRepository.save(rating);
        return 1;
    }

    @Override
    public boolean isRated(int id_content, int id_user) {
        Rating rating = ratingRepository.getRatingByContentIdAndUserId(id_content, id_user);
        return rating != null;
    }

    @Override
    public double avgRatingByContent(int contentId) {
        List<Rating> list = ratingRepository.listRatingByContent(contentId);
        double sum = 0;
        if(!list.isEmpty()){
            for (Rating rating : list) {
                sum += rating.getScore();
            }
            sum = sum / list.size();
        }
        return sum;
    }

    @Override
    public List<ShowRatingByContentDTO> listContentOrderByScore(){
        return ratingRepository.listContentOrderByScore();
    }

    @Override
    public List<Rating> listRatingByUser(int userId){
        return ratingRepository.listRatingByUser(userId);
    }
    @Override
    public List<Rating> listRatingByContent(int contentId){
        return ratingRepository.listRatingByContent(contentId);
    }

}
