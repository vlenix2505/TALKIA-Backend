package com.upc.talkiaBackend.repositories;


import com.upc.talkiaBackend.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findById(int RoleId);
}
