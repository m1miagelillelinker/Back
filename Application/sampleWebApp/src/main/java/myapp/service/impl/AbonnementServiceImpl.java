package myapp.service.impl;

import myapp.model.Abonnement;
import myapp.model.User;
import myapp.repository.AbonnementRepository;
import myapp.service.AbonnementService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonnementServiceImpl implements AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;
    
    @Override
    public List<Abonnement> getFollowersByFollows(String userId) {
        Optional<List<Abonnement>> rep = abonnementRepository.findAllByFollower(userId);
        System.out.println("test getFollowersById :"+rep.toString());
        return rep.get();
    }

	@Override
	public List<Abonnement> getFollowsByFollower(String userId) {
        Optional<List<Abonnement>> rep = abonnementRepository.findAllByFollows(userId);
        System.out.println("test getFollowersById :"+rep.toString());
        return rep.get();
	}

	@Override
	public Abonnement follow(String follower, String follows) {
		Abonnement abonnement = new Abonnement(follower, follows, new Date(), new Date());
		return abonnementRepository.save(abonnement);
	}

	@Override
	public void unfollow(String follower, String follows) {
		Abonnement abonnement = abonnementRepository.findByFollowerAndFollows(follower, follows).get();
		abonnementRepository.delete(abonnement);
		
	}

}
