package ProfessionalJavaDeveloper.user.controller;

import ProfessionalJavaDeveloper.user.dto.CreateUserDto;
import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.entity.User;
import ProfessionalJavaDeveloper.user.mapper.UserMapper;
import ProfessionalJavaDeveloper.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.stream.Collectors;

/**
 * REST controller for user resource. Doesn't return entity objects but dto objects.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger("UserController");

    private UserService userService;

    private UserMapper userMapper;

    //TODO check when to encode password
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
        logger.info("I am some log, because someone asked for all users");
        return ResponseEntity
                .ok(userService.findAll().stream()
                        .map(value -> userMapper.convertUserToUserDto(value))
                        .collect(Collectors.toList()));
    }

    /**
     * @param id - id of the user
     * @return single user in JSON or 404 when user doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") long id){
        return userService.find(id)
                .map(value -> ResponseEntity
                        .ok(userMapper.convertUserToUserDto(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    //TODO add comments
    //TODO add logs

    //TODO make it nicer
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto request) {
        User user = User.builder()
                .userName(request.getUserName())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build();
        user = userService.create(user);
        return ResponseEntity
                .ok(userMapper.convertUserToUserDto(user));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(Principal principal){
        return userService.find(principal.getName())
                .map(value -> ResponseEntity
                        .ok(userMapper.convertUserToUserDto(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @GetMapping("/my-name")
    public String getCurrentUserName(Principal principal){
        return principal.getName();
    }

}
