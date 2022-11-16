package ProfessionalJavaDeveloper.user.service;

import ProfessionalJavaDeveloper.user.entity.User;
import ProfessionalJavaDeveloper.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for all business actions regarding user entity.
 */
@Service
public class UserService implements UserDetailsService {

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
     * Find single user by ID
     *
     * @param username - user's username
     * @return container with user
     */
    public Optional<User> find(String username) {
        return userRepository.findByUserName(username);
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

    //TODO check it
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUserName(username);
        if (user.isEmpty()) {//ToDo make it nicer
            throw new UsernameNotFoundException("");
        }
        return user.get();
    }
}
