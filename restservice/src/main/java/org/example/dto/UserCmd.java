package org.example.dto;


import org.example.pojo.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserCmd {
    private String firstName;
    private String secondName;
    private String email;
    private Set<Role> role;
}
