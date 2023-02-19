package org.steri.Library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.steri.Library.entity.Role;
import org.steri.Library.enums.RoleEnum;

import java.util.Optional;

    @Repository
    public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(RoleEnum name);
    }
