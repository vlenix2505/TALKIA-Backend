package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkiaBackend.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UserContentController {

    @Autowired
    private UserContentService userContentService;

    @PostMapping("/user_content/{contentId}/{userId}")
    public Integer InsertUserContent(@PathVariable(name="contentId") Integer contentId,
                                     @PathVariable(name = "userId") Integer userId) {
        return userContentService.insertUserContent(contentId, userId);
    }

    @GetMapping("/user_content/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ShowHistorialContentDTO> listUserContent(){
        return userContentService.listUserContent();
    }

    @GetMapping("/content_history_by_user/{userId}")
    public List<ShowContentHistoryDTO> ListUserContentByUser(@PathVariable int userId){
        return userContentService.ListUserContentByUser(userId);
    }

    @GetMapping("/user_content/username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ShowHistorialContentDTO> listUserContentByUsername(@PathVariable String username){
        return userContentService.listUserContentByUsername(username);
    }

    @GetMapping("/user_content/content/{content}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ShowHistorialContentDTO> listUserContentByContent(@PathVariable String content){
        return userContentService.listUserContentByContent(content);
    }
}