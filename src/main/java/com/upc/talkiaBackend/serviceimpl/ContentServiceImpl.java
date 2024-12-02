package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.ShowContentByDayDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByIdDTO;
import com.upc.talkiaBackend.dtos.queries.UrlDTO;
import com.upc.talkiaBackend.entities.Content;
import com.upc.talkiaBackend.repositories.ContentRepository;
import com.upc.talkiaBackend.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content updateContent(Content content) {
        if(contentRepository.existsById(content.getId())){
            return contentRepository.save(content);
        }
        return null;
    }

    @Override
    public List<ShowContentByFilterDTO> filterContent(String level, String type, String theme) {
        return contentRepository.findByFilters(level, type, theme);
    }

    @Override
    public Content insertContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByLevels(String level) {
        return contentRepository.listContentByLevels(level);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(String level, String type) {
        return contentRepository.listContentByLevelsAndTypes(level, type);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByTypes(String type) {
        return contentRepository.listContentByTypes(type);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(String level, String theme) {
        return contentRepository.listContentByLevelsAndTheme(level, theme);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByAllFilters(String theme, String type, String level) {
        return contentRepository.listContentByAllFilters(theme, type, level);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByThemeAndTypes(String theme, String type) {
        return contentRepository.listContentByThemeAndTypes(theme, type);
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByTheme(String theme) {
        return contentRepository.listContentByTheme(theme);
    }

    @Override
    public List<Content> listAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public List<ShowContentByFilterDTO> listContentByTitle(String title){
        return contentRepository.listContentByTitle(title);
    }
    @Override
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc(){
        return contentRepository.listContentOrderByDateOfPublicationAsc();
    }

    @Override
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc(){
        return contentRepository.listContentOrderByDateOfPublicationDesc();
    }

    @Override
    public List<UrlDTO> listContentByLink(String title) {
        return contentRepository.listContentByLink(title);
    }
    @Override
    public void deleteContent(int id) {
        if(contentRepository.existsById(id)){
            contentRepository.deleteById(id);
        }
    }

    @Override
    public List<Content> findByTitleContainsIgnoreCase(String title) {
        return contentRepository.findByTitleContainsIgnoreCase(title);
    }

    @Override
    public Content getContentById(Integer id) {
        if(contentRepository.findById(id).isPresent()){
            return contentRepository.findById(id).get();
        }
        return null;

    }

    @Override
    public List<ShowContentByIdDTO> listContentById(int id) {
        return contentRepository.listContentById(id);
    }

}
