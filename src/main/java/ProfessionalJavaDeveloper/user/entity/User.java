package ProfessionalJavaDeveloper.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder//czym się różni od @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;
}
