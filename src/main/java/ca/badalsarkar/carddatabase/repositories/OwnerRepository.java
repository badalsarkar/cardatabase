package ca.badalsarkar.carddatabase.repositories;

import ca.badalsarkar.carddatabase.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
