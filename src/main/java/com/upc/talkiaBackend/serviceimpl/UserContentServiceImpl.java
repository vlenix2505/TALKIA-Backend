package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkiaBackend.entities.Content;

import com.upc.talkiaBackend.entities.UserContent;
import com.upc.talkiaBackend.repositories.ContentRepository;
import com.upc.talkiaBackend.repositories.UserContentRepository;
import com.upc.talkiaBackend.repositories.UserRepository;
import com.upc.talkiaBackend.security.entities.User;
import com.upc.talkiaBackend.services.UserContentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContentServiceImpl implements UserContentService {

    @Autowired
    UserContentRepository userContentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentRepository contentRepository;

    @Transactional
    @Override
    public Integer insertUserContent(Integer contentId, Integer UserId) {

        User user = userRepository.findById(UserId).get();
        Content content = contentRepository.findById(contentId).get();
        UserContent userContent = new UserContent();

        userContent.setUser(user);
        userContent.setContent(content);
        userContentRepository.save(userContent);
        return 1;
    }

    @Override
    public List<ShowHistorialContentDTO> listUserContent(){
        return userContentRepository.listUserContent();
    }

    @Override
    public List<ShowContentHistoryDTO> ListUserContentByUser(int userId) {
        return userContentRepository.ListUserContentByUser(userId);
    }

    @Override
    public List<ShowHistorialContentDTO> listUserContentByUsername(String username) {
        return userContentRepository.listUserContentByUsername(username);
    }

    @Override
    public List<ShowHistorialContentDTO> listUserContentByContent(String content) {
        return userContentRepository.listUserContentByContent(content);
    }
}
