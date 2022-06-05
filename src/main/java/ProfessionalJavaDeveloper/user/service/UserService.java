package ProfessionalJavaDeveloper.user.service;

import ProfessionalJavaDeveloper.user.entity.User;
import ProfessionalJavaDeveloper.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    //@Transactional// co to jest?
    public void create(User user) {
        userRepository.save(user);
    }
}
