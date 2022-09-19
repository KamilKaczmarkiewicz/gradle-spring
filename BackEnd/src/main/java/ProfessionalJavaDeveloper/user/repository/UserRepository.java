package ProfessionalJavaDeveloper.user.repository;

import ProfessionalJavaDeveloper.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @Query("select distinct u from User u left join fetch u.characters")
    List<User> findAll();

    Optional<User> findByUserName(String userName);


}
