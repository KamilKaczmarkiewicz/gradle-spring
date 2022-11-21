package ProfessionalJavaDeveloper.character.controller;

import ProfessionalJavaDeveloper.character.dto.CreateCharacterDto;
import ProfessionalJavaDeveloper.character.dto.UpdateCharacterDto;
import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.character.mapper.CharacterMapper;
import ProfessionalJavaDeveloper.character.service.CharacterService;
import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for character resource. Doesn't return entity objects but dto objects.
 */
@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    private static final Logger logger = LogManager.getLogger(CharacterController.class.getName());

    private CharacterService characterService;
    private CharacterMapper characterMapper;

    @Autowired
    public CharacterController(CharacterService characterService,
                               CharacterMapper characterMapper){
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    /**
     * @return list of characters in JSON
     */
    @GetMapping
    public ResponseEntity getCharacters(){
        logger.info("Get all characters");
        return ResponseEntity
                .ok(characterService.findAll().stream()
                        .map(value -> characterMapper.characterToCharacterDto(value))
                        .collect(Collectors.toList()));
    }

    /**
     * @param id - id of the character
     * @return single character in JSON or 404 when user doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable("id") long id){
        logger.info("Get character with id " + id);
        Optional<Character> character = characterService.find(id);
        if (character.isPresent()){
            logger.info("Get character with id " + id + " successful");
            return ResponseEntity.ok(characterMapper.characterToCharacterDto(character.get()));
        }else {
            logger.error("Character with id " + id + " can't be found.");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @param request - new character as CreateCharacterDto
     * @return created character in JSON
     */
    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CreateCharacterDto request){
        logger.info("Create new character");
        Character character = characterMapper.createCharacterDtoToCharacter(request);
        character.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        characterService.create(character);
        logger.info("Created new character with id: " + character.getId() + " successful");
        return ResponseEntity.ok(characterMapper.characterToCharacterDto(character));
    }

    /**
     * @param id - id of the character to delete
     * @return Response OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable("id") long id){
        logger.info("Delete character with id " + id);
        Optional<Character> character = characterService.find(id);
        if (character.isPresent()){
            characterService.delete(character.get());
            logger.info("Delete character with id " + id + " successful");
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        }else {
            logger.error("Character with id " + id + " can't be found.");
            return ResponseEntity.badRequest().body("Couldn't find character with "+id+" id!");
        }
    }

    /**
     * @param request - UpdateCharacterDto
     * @param id - id of the character to update
     * @return created character in JSON
     */
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> updateCharacter(@PathVariable("id") long id,
                                                        @RequestBody UpdateCharacterDto request){
        logger.info("Update character with id " + id);
        Optional<Character> character = characterService.find(id);
        if (character.isEmpty()){
            logger.error("Character with id " + id + " can't be found.");
            return ResponseEntity.badRequest().build();
        }
        Character character1 = characterMapper.updateCharacterDtoToCharacter(character.get(), request);
        logger.info("Update character with id " + id + " successful");
        return ResponseEntity.status(HttpStatus.OK)
                .body(characterMapper.characterToCharacterDto(characterService.update(character1)));
    }
}
