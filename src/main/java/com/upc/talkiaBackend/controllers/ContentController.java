package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.ContentDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByDayDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkiaBackend.dtos.queries.ShowContentByIdDTO;
import com.upc.talkiaBackend.dtos.queries.UrlDTO;
import com.upc.talkiaBackend.entities.Content;
import com.upc.talkiaBackend.services.ContentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ContentController {

    @Autowired
    private ContentService contentService;

    ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/content")
    public ContentDTO insertContent(@RequestBody ContentDTO contentDTO){
        Content content = modelMapper.map(contentDTO, Content.class);
        content = contentService.insertContent(content);
        return modelMapper.map(content, ContentDTO.class);
    }

    @GetMapping("/contents/filter")
    public List<ShowContentByFilterDTO> filterContent(
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String theme) {

        List<ShowContentByFilterDTO> filteredContent = contentService.filterContent(level, type, theme);
        return filteredContent;
    }

    @GetMapping("/content/id/{id}")
    public ContentDTO getContentById(@PathVariable Integer id) {
        Content content = contentService.getContentById(id);
        return modelMapper.map(content, ContentDTO.class);
    }


    @GetMapping("/content_level/{level}")
    public List<ShowContentByFilterDTO> listContentByLevels(@PathVariable String level) {
        return contentService.listContentByLevels(level);
    }
    @GetMapping("/content_level_type/{level}/{type}")
    public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(@PathVariable String level, @PathVariable String type) {
        return contentService.listContentByLevelsAndTypes(level, type);
    }

    @GetMapping("/content_type/{type}")
    public List<ShowContentByFilterDTO> listContentByTypes(@PathVariable String type) {
        return contentService.listContentByTypes(type);
    }

    @GetMapping("/content_theme_level/{level}/{theme}")
    public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(@PathVariable String level, @PathVariable String theme) {
        return contentService.listContentByLevelsAndTheme(level, theme);
    }
    @GetMapping("/content_theme_level_type/{type}/{theme}/{level}")
    public List<ShowContentByFilterDTO> listContentByAllFilters(@PathVariable String theme, @PathVariable String type, @PathVariable String level) {
        return contentService.listContentByAllFilters(theme, type, level);
    }

    @GetMapping("/content_theme_type/{theme}/{type}")
    public List<ShowContentByFilterDTO> listContentByThemeAndTypes( @PathVariable String theme, @PathVariable String type) {
        return contentService.listContentByThemeAndTypes(theme, type);
    }
    @GetMapping("/content_theme/{theme}")
    public List<ShowContentByFilterDTO> listContentByTheme(@PathVariable String theme) {
        return contentService.listContentByTheme(theme);
    }

    @GetMapping("/contents")
    public List<ContentDTO> listContent() {
        List<Content> contents = contentService.listAllContent();
        ModelMapper modelMapper = new ModelMapper();
        List<ContentDTO> contentDTOs = modelMapper.map(contents, List.class);
        return contentDTOs;
    }

    @GetMapping("/content/title/{title}")
    public List<ShowContentByFilterDTO> listContentByTitle(@PathVariable String title) {
        return contentService.listContentByTitle(title);
    }

    @GetMapping("/content_fechaAsc")
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc() {
        return contentService.listContentOrderByDateOfPublicationAsc();
    }

    @GetMapping("/contents/title/{title}")
    public List<ContentDTO> listContentByTitleAdmin(@PathVariable String title) {
        List<Content> contents = contentService.findByTitleContainsIgnoreCase(title);
        ModelMapper modelMapper = new ModelMapper();
        List<ContentDTO> contentDTOS = modelMapper.map(contents, List.class);
        return contentDTOS;
    }

    @GetMapping("/content_fechaDesc")
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc() {
        return contentService.listContentOrderByDateOfPublicationDesc();
    }
    @PutMapping("/content")
    public ContentDTO updateContent(@RequestBody ContentDTO contentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Content content = modelMapper.map(contentDTO, Content.class);
        content = contentService.updateContent(content);
        return modelMapper.map(content, ContentDTO.class);
    }


    @GetMapping("/contentperid/{id}")
    public List<ShowContentByIdDTO> listContentById(@PathVariable int id) {
        return contentService.listContentById(id);
    }

    @GetMapping("/content_url/{title}")
    public List<UrlDTO> listContentByUrl(@PathVariable String title) {
        return contentService.listContentByLink(title);
    }
    @DeleteMapping("/content/{id}")

    public void deleteContent(@PathVariable int id){
        contentService.deleteContent(id);
    }


}
