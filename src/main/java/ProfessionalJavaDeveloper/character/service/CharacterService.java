package ProfessionalJavaDeveloper.character.service;

import ProfessionalJavaDeveloper.character.repository.CharacterRepository;
import ProfessionalJavaDeveloper.character.entity.Character;
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

    /**
     * @return List of all characters
     */
    public List<Character> findAll() { return characterRepository.findAll(); }

    /**
     * Find single character
     *
     * @param id - character's id
     * @return container with character
     */
    public Optional<Character> find(Long id) {
        return characterRepository.findById(id);
    }

}
