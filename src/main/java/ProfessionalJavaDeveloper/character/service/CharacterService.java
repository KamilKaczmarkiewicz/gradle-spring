package ProfessionalJavaDeveloper.character.service;

import ProfessionalJavaDeveloper.character.repository.CharacterRepository;
import ProfessionalJavaDeveloper.character.entity.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public List<Character> findAll() { return characterRepository.findAll(); }

    public Optional<Character> find(Long id) {
        return characterRepository.findById(id);
    }

}
