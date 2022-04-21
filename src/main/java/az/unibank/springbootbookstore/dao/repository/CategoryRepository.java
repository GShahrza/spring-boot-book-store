package az.unibank.springbootbookstore.dao.repository;

import az.unibank.springbootbookstore.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
