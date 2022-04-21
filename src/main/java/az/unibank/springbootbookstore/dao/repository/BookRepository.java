package az.unibank.springbootbookstore.dao.repository;

import az.unibank.springbootbookstore.dao.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByRating(Double rating, Pageable pageable);
}
