package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowContentByDayDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByIdDTO;
import com.upc.talkiaBackend.dtos.queries.UrlDTO;
import com.upc.talkiaBackend.entities.Content;

import java.util.List;

public interface ContentService {
    public Content insertContent(Content content);
    public List<Content> listAllContent();
    public List<ShowContentByFilterDTO> listContentByLevels(String level);
    public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(String level, String type);
    public List<ShowContentByFilterDTO> listContentByTypes(String type);
    public List<ShowContentByFilterDTO> listContentByTitle(String title);
    public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(String level, String theme);
    public List<ShowContentByFilterDTO> listContentByAllFilters(String theme, String type, String level);
    public List<ShowContentByFilterDTO> listContentByThemeAndTypes(String theme, String type);
    public List<ShowContentByFilterDTO> listContentByTheme(String theme);
    public Content updateContent(Content content);
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc();
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc();
    public List<UrlDTO> listContentByLink(String title);
    public void deleteContent(int id);
    public Content getContentById(Integer id);
    public List<ShowContentByIdDTO> listContentById(int id);
    //ADD
    public List<Content> findByTitleContainsIgnoreCase(String title);
    public List<ShowContentByFilterDTO> filterContent(String level, String type, String theme);
}
