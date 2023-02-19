package org.steri.Library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.steri.Library.entity.LibraryUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<LibraryUser, Long> {
    Optional<LibraryUser> findByUsername(String username);
}
