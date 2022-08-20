package ProfessionalJavaDeveloper.character.controller;

import ProfessionalJavaDeveloper.character.mapper.CharacterMapper;
import ProfessionalJavaDeveloper.character.service.CharacterService;
import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * REST controller for character resource. Doesn't return entity objects but dto objects.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/characters")
public class CharacterController {

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
        return ResponseEntity
                .ok(characterService.findAll().stream()
                        .map(value -> characterMapper.convertCharacterToCharacterDto(value))
                        .collect(Collectors.toList()));
    }

    /**
     * @param id - id of the character
     * @return single character in JSON or 404 when user doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable("id") long id){
        return characterService.find(id)
                .map(value -> ResponseEntity
                        .ok(characterMapper.convertCharacterToCharacterDto(value)))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }
}
