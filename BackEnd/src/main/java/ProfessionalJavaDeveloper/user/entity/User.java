package ProfessionalJavaDeveloper.user.entity;

import ProfessionalJavaDeveloper.character.entity.Character;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;


/**
 * Entity for the users.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
@Builder
@AllArgsConstructor
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    //TODO
    // add mail

    /**
     * User's login and he's representation in app.
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * User's password, encoded by bCryptPasswordEncoder.
     */
    private String password;

    /**
     * User's first name.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * User's last name.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * User's set of characters.
     */
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Character> characters;

    //TODO
    //  authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    //TODO
    //  add variables to below methods
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
