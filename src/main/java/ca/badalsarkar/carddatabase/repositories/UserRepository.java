package ca.badalsarkar.carddatabase.repositories;

import ca.badalsarkar.carddatabase.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername (String username);
}
