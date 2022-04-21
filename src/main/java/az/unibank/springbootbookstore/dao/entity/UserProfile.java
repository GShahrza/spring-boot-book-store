package az.unibank.springbootbookstore.dao.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    String firstName;

    @Column(name = "last_name", nullable = false, length = 25)
    String lastName;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account = new Account();

    @ManyToMany(fetch = EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    Set<Book> books = new HashSet<>();
}
