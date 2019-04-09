package myapp.service.impl;

import myapp.model.User;
import myapp.repository.UserRepository;
import myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(Integer userId) throws Exception {
        Optional<User> rep = userRepository.findById(userId);
        if(rep.isPresent()){
            return rep.get();
        }else{
            throw new Exception();
        }
    }
}
