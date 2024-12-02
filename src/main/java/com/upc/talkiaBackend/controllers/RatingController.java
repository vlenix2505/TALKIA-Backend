package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.RatingDTO;
import com.upc.talkiaBackend.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkiaBackend.entities.Rating;
import com.upc.talkiaBackend.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/rating/{id_content}/{id_user}/{score}")
    @PreAuthorize("hasRole('USER')")
    public Integer insertRating(@PathVariable int id_content, @PathVariable int id_user,
                                @PathVariable int score){
        return ratingService.insertRating(id_content, id_user, score);
    }

    @GetMapping("/ratingByContentAndUser/{id_content}/{id_user}")
    public boolean isRated(@PathVariable int id_content, @PathVariable int id_user){
        return ratingService.isRated(id_content, id_user);
    }

    @GetMapping("avgRatingByContent/{contentId}")
    public double avgRatingByContent(@PathVariable int contentId){
        return ratingService.avgRatingByContent(contentId);
    }

    @GetMapping("/ratingsContentByScore")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<ShowRatingByContentDTO> listContentOrderByScore(){
        return ratingService.listContentOrderByScore();
    }

    @GetMapping("/ratingsByUser/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RatingDTO> listRatingByUser(@PathVariable int userId){
        List<Rating> ratings = ratingService.listRatingByUser(userId);
        List<RatingDTO> ratingsDTO = modelMapper.map(ratings,List.class);
        return ratingsDTO;
    }

    @GetMapping("/ratingsByContent/{contentId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RatingDTO> listRatingByContent(@PathVariable int contentId){
        List<Rating> ratings = ratingService.listRatingByContent(contentId);
        List<RatingDTO> ratingsDTO = modelMapper.map(ratings,List.class);
        return ratingsDTO;
    }
}
