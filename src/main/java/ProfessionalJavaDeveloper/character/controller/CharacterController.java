package ProfessionalJavaDeveloper.character.controller;

import ProfessionalJavaDeveloper.character.mapper.CharacterMapper;
import ProfessionalJavaDeveloper.character.service.CharacterService;
import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
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

    @GetMapping
    public ResponseEntity getCharacters(){
        return ResponseEntity
                .ok(characterService.findAll().stream()
                        .map(value -> characterMapper.convertCharacterToCharacterDto(value))
                        .collect(Collectors.toList()));
    }

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
