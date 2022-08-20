package ProfessionalJavaDeveloper.user.service;

import ProfessionalJavaDeveloper.user.entity.User;
import ProfessionalJavaDeveloper.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for all business actions regarding user entity.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * @return List of all users
     */
    public List<User> findAll() { return userRepository.findAll(); }

    /**
     * Find single user by ID
     *
     * @param id - user's id
     * @return container with user
     */
    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Create new user.
     *
     * @param user - new user
     */
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }
}
