package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.entities.Suscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionRepository extends JpaRepository<Suscription, Integer> {
    public Suscription getSuscriptionById(int susId);


}
