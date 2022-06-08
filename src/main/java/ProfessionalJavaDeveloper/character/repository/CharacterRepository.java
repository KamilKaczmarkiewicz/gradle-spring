package ProfessionalJavaDeveloper.character.repository;

import ProfessionalJavaDeveloper.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
