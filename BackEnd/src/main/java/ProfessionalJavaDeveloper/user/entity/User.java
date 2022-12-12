package ProfessionalJavaDeveloper.user.entity;

import ProfessionalJavaDeveloper.character.entity.Character;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


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

    /**
     * User's e-mail address.
     */
    @Column(name = "mail")
    private String mail;

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
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    @Builder.Default
    private Set<Character> characters = new HashSet<>();

    //TODO
    // is FetchType.EAGER ok here?
    /**
     * User's roles
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    /**
     *
     * Indicates whether the user's account has expired.
     */
    @Column(name = "is_account_non_expired")
    @Builder.Default
    private Boolean isAccountNonExpired = true;

    /**
     * Indicates whether the user is locked or unlocked.
     */
    @Column(name = "is_account_non_locked")
    @Builder.Default
    private Boolean isAccountNonLocked = true;

    /**
     * Indicates whether the user's credentials (password) has expired.
     */
    @Column(name = "is_credential_non_expired")
    @Builder.Default
    private Boolean isCredentialsNonExpired = true;

    /**
     * Indicates whether the user is enabled or disabled.
     */
    @Column(name = "is_enabled")
    @Builder.Default
    private Boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
