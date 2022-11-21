package ProfessionalJavaDeveloper.user.controller;

import ProfessionalJavaDeveloper.user.dto.CreateUserDto;
import ProfessionalJavaDeveloper.user.dto.UpdateUserDto;
import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.entity.User;
import ProfessionalJavaDeveloper.user.mapper.UserMapper;
import ProfessionalJavaDeveloper.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for user resource. Doesn't return entity objects but dto objects.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    private UserService userService;

    private UserMapper userMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService,
                          UserMapper userMapper,
                          BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = userService;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * @return list of users in JSON
     */
    @GetMapping
    public ResponseEntity getUsers(){
        logger.info("Get all users");
        return ResponseEntity
                .ok(userService.findAll().stream()
                        .map(value -> userMapper.userToUserDto(value))
                        .collect(Collectors.toList()));
    }

    /**
     * @param id - id of the user
     * @return single user in JSON or 404 when user doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long id){
        logger.info("Get user with id " + id);
        Optional<User> user = userService.find(id);
        if (user.isPresent()){
            logger.info("Get user with id " + id + " successful");
            return ResponseEntity.ok(userMapper.userToUserDto(user.get()));
        }else {
            logger.error("User with id " + id + " can't be found.");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The user's password is encoded using bCryptPasswordEncoder
     * @param request - new user as CreateUserDto
     * @return created user in JSON
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto request) {
        logger.info("Create new user");
        User user = userMapper.createUserDtoToUser(request);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userService.create(user);
        logger.info("Created new user with id: " + user.getId() + " successful");
        return ResponseEntity
                .ok(userMapper.userToUserDto(user));
    }

    /**
     * @param id - id of the user to delete
     * @return Response OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        logger.info("Delete user with id " + id);
        Optional<User> user = userService.find(id);
        if (user.isPresent()){
            userService.delete(user.get());
            logger.info("Delete user with id " + id + " successful");
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        }else {
            logger.error("User with id " + id + " can't be found.");
            return ResponseEntity.badRequest().body("Couldn't find user with "+id+" id!");
        }
    }

    /**
     * @param request - UpdateUserDto
     * @param id - id of the user to update
     * @return created user in JSON
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id,
                                                        @RequestBody UpdateUserDto request){
        logger.info("Update user with id " + id);
        Optional<User> user = userService.find(id);
        if (user.isEmpty()){
            logger.error("User with id " + id + " can't be found.");
            return ResponseEntity.badRequest().build();
        }
        User user1 = userMapper.updateUserDtoToUser(user.get(), request);
        user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
        logger.info("Update user with id " + id + " successful");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.userToUserDto(userService.update(user1)));
    }

    /**
     * @return UserDto of the logged-in user
     */
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(Principal principal){
        return userService.find(principal.getName())
                .map(value -> ResponseEntity
                        .ok(userMapper.userToUserDto(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    /**
     * @return the name of the logged-in user
     */
    @GetMapping("/my-name")
    public String getCurrentUserName(Principal principal){
        return principal.getName();
    }

}
