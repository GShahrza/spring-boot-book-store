package az.unibank.springbootbookstore.dao.repository;

import az.unibank.springbootbookstore.dao.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    Optional<UserProfile> findByFirstNameAndLastName(String firstName,String lastName);
}
