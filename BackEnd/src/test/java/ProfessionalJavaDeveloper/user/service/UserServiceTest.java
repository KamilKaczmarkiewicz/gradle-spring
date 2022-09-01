package ProfessionalJavaDeveloper.user.service;

import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.user.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    private static final long USER_ID = 1;
    private static final long FAKE_USER_ID = 100;
    private static final String NAME = "noweImie";
    private static final String LAST_NAME = "noweNazwisko";
    private static final String USER_NAME = "noweUserName";
    private static final String USER_PASSWORD = "pass";
    private static final Set<Character> CHARACTERS = Collections.emptySet();

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        List<User> output =userService.findAll();
        Assertions.assertTrue(output.size() > 1);
    }

    @Test
    void find() {
        Optional<User> output = userService.find(USER_ID);
        Optional<User> output2 = userService.find(FAKE_USER_ID);

        assertTrue(output.isPresent());
        assertTrue(output2.isEmpty());
    }

    @Test
    void create() {
        User user = User.builder()
                .name(NAME)
                .lastName(LAST_NAME)
                .userName(USER_NAME)
                .password(USER_PASSWORD)
                .characters(CHARACTERS)
                .build();
        User output = userService.create(user);

        Assertions.assertEquals(output.getName(), NAME);
        Assertions.assertEquals(output.getCharacters(), CHARACTERS);
        Assertions.assertEquals(output.getLastName(), LAST_NAME);
    }
}