package myapp.service.impl;

import myapp.model.User;
import myapp.repository.UserRepository;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer userId) {
        Optional<User> rep = userRepository.findById(userId);
        //System.out.println("JSUIS DANS LE COLO :"+rep.toString());
        return rep.get();
    }
}
