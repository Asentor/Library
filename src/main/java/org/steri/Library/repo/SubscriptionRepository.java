package org.steri.Library.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.steri.Library.entity.Subscription;

    @Repository
    public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
        Optional<Subscription> findById(Long id);

        List<Subscription> findAll();

        void delete(Subscription subscription);

        List<Subscription> findAllByEndDateBefore(LocalDate expirationDate);




    }
