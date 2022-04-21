package az.unibank.springbootbookstore.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(nullable = false)
    String tittle;

    @Column(name = "isbn",nullable = false,unique = true)
    Long isbn;

    @Column(name = "total_pages")
    Integer totalPages;

    @Column(name = "rating")
    Double rating;

    @ManyToMany(fetch = EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"))
    Set<UserProfile> authors = new HashSet<>();

}
