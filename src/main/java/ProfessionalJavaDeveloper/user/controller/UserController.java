package ProfessionalJavaDeveloper.user.controller;

import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.mapper.UserMapper;
import ProfessionalJavaDeveloper.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * REST controller for user resource. Doesn't return entity objects but dto objects.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService,
                          UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * @return list of users in JSON
     */
    @GetMapping
    public ResponseEntity getUsers(){
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

}
