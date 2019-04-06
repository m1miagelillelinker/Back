package myapp.service.impl;

import myapp.model.Abonnement;
import myapp.model.User;
import myapp.repository.AbonnementRepository;
import myapp.service.AbonnementService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonnementServiceImpl implements AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;
    
    @Override
    public List<Abonnement> getFollowersById(Integer userId) {
        Optional<List<Abonnement>> rep = abonnementRepository.findAllByFollower(userId);
        System.out.println("test getFollowersById :"+rep.toString());
        return rep.get();
    }

}
