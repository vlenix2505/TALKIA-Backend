package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.entities.Suscription;
import com.upc.talkiaBackend.repositories.SuscriptionRepository;
import com.upc.talkiaBackend.services.SuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuscriptionServiceImpl implements SuscriptionService {

    @Autowired
    private SuscriptionRepository suscriptionRepository;

    @Override
    public List<Suscription> listSuscriptions() {
        return suscriptionRepository.findAll();
    }

    @Override
    public Suscription getSuscriptionById(int susId) {
        return suscriptionRepository.getSuscriptionById(susId);
    }
}
