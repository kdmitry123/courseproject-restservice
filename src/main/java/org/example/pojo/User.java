package org.example.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    private String firstName;

    private String secondName;

    @Id
    private String email;

    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_email"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Collection> collectionList;

    public User(String firstName, String secondName, String email, String password, Set<Role> role, List<Collection> collectionList) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.collectionList = collectionList;
    }
}
