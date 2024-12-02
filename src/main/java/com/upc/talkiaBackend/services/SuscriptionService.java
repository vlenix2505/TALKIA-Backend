package com.upc.talkiaBackend.services;


import com.upc.talkiaBackend.entities.Suscription;

import java.util.List;
public interface SuscriptionService {
    public List<Suscription> listSuscriptions();
    public Suscription getSuscriptionById(int susId);

}
