package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkiaBackend.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    public Integer insertRating(int id_content, int id_user, int rating);
    public List<ShowRatingByContentDTO> listContentOrderByScore();
    public List<Rating> listRatingByUser(int userId);
    public List<Rating> listRatingByContent(int contentId);
    public boolean isRated(int id_content, int id_user);
    public double avgRatingByContent(int contentId);
}
