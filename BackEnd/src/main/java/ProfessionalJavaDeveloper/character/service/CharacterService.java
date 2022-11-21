package ProfessionalJavaDeveloper.character.service;

import ProfessionalJavaDeveloper.character.repository.CharacterRepository;
import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for all business actions regarding character entity.
 */
@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    private final UserRepository userRepository;

    /**
     * @return List of all characters
     */
    public List<Character> findAll() { return characterRepository.findAll(); }

    /**
     * Find a single character
     *
     * @param id - character's id
     * @return container with character
     */
    public Optional<Character> find(Long id) {
        return characterRepository.findById(id);
    }

    /**
     * Creates new character
     *
     * @param character - new character
     */
    public void create(Character character) {
        characterRepository.save(character);
    }

    /**
     * Updates the character
     *
     * @param character - updated character
     */
    public Character update(Character character){
        return characterRepository.save(character);
    }

    /**
     * Deletes the character
     *
     * @param character - character to be deleted
     */
    public void delete(Character character){
        characterRepository.delete(character);
    }

}
