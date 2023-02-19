package org.steri.Library.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private LibraryUser libraryUser;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> loans;

    private LocalDate endDate;
}
