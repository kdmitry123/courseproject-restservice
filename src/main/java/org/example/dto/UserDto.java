package org.example.dto;

import lombok.*;
import org.example.pojo.Role;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {
    private String firstname;
    private String secondname;
    private String email;
    private String password;
    private Set<Role> role;
}
