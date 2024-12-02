package com.upc.talkiaBackend.repositories;


import com.upc.talkiaBackend.dtos.queries.ShowContentHistoryDTO;
import com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkiaBackend.entities.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Long> {
    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO(uc.user.name, uc.content.title, uc.iViewedAt)" +
            "from UserContent uc")
    List<ShowHistorialContentDTO> listUserContent();
    //Rol admin
    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowContentHistoryDTO(uc.user.userName, uc.content.title, uc.iViewedAt)" +
            "from UserContent uc where uc.user.id = :userId")
    public List<ShowContentHistoryDTO> ListUserContentByUser(@Param("userId") int userId);

    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO(uc.user.name, uc.content.title, uc.iViewedAt) " +
            "from UserContent uc where uc.user.userName like concat('%', :userName, '%')")
    List<ShowHistorialContentDTO> listUserContentByUsername(@Param("userName") String userName);

    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowHistorialContentDTO(uc.user.name, uc.content.title, uc.iViewedAt) " +
            "from UserContent uc where LOWER(uc.content.title) like concat('%', LOWER(:content),'%')")
    List<ShowHistorialContentDTO> listUserContentByContent(@Param("content") String content);


}
