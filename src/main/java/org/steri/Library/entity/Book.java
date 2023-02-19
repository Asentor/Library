package org.steri.Library.entity;


import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String description;
    @NonNull
    private LocalDate publishedDate;
    @NonNull
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private LibraryUser libraryUser;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Book(String title, String author, String description, LocalDate publishedDate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
        this.available = true;
    }
}
