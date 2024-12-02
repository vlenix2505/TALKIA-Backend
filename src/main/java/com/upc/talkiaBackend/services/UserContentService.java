package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO;

import java.util.List;

public interface UserContentService {

    public Integer insertUserContent(Integer contentId, Integer userId);
    public List<ShowHistorialContentDTO> listUserContent();
    public List<ShowContentHistoryDTO> ListUserContentByUser(int userId);
    public List<ShowHistorialContentDTO> listUserContentByUsername(String username);
    public List<ShowHistorialContentDTO> listUserContentByContent(String content);
}
