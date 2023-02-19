package org.steri.Library.entity;



import lombok.Data;


import org.springframework.security.core.GrantedAuthority;
import org.steri.Library.enums.RoleEnum;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Override
    public String getAuthority() {
        return name.toString();
    }
}
