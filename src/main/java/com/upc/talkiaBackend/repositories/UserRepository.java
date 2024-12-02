package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.dtos.queries.ShowSuscriptionDetailsDTO;

import com.upc.talkiaBackend.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int userId);

    @Query("select u from User u where u.iCreatedAt between :startDate and :endDate")
    List<User> listUsersByRegisterDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

//    @Query("select sh.user from SuscriptionsHistory sh " +
//            "where ( sh.status = :status and sh.endDate>=current date ) " +
//            "or (sh.status = :status and sh.endDate>current date ) " +
//            "and not exists (select 1 from SuscriptionsHistory sh2 where sh2.user = sh.user and sh2.status ='Activado' and sh.startDate>current date )")
@Query("select sh.user from SuscriptionsHistory sh " +
        "where (:status = 'Activado' and sh.status = 'Activado' and sh.endDate >= current date) " +
        "or (:status = 'Finalizado' and sh.status = 'Finalizado' and sh.endDate < current date " +
        "and not exists ( " +
        "    select 1 from SuscriptionsHistory sh2 " +
        "    where sh2.user = sh.user and sh2.status = 'Activado' and sh2.endDate>=current date" +
        "))")

    List<User> listUsersByStatus(@Param("status") String status);

    @Query("select sh.status from SuscriptionsHistory sh where sh.user.id =:userId order by sh.startDate desc limit 1")
    public String getStatusByUser(@Param("userId") int userId);

    @Query("SELECT u FROM User u WHERE u.role.id = 2")
    public List<User> listUsersAdmin();


    Optional<User> findByUserName(String username);

    @Query("select (u.level.id) from User u where u.userName =:userName")
    Integer getLevelIdByUsername(@Param("userName") String username);


    List<User> getUsersByUserNameContainingIgnoreCase(String username);

    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowSuscriptionDetailsDTO(sh.suscription.name, sh.payment.amount) from SuscriptionsHistory sh where sh.user.id =:userId and sh.status= 'Activado'")
    public ShowSuscriptionDetailsDTO getCurrentSuscription(@Param("userId") int userId);


}

