package org.steri.Library.entity;

import jakarta.persistence.*;

import lombok.Data;

import org.steri.Library.enums.RoleEnum;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

}
