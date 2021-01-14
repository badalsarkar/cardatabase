package ca.badalsarkar.carddatabase.repositories;

import ca.badalsarkar.carddatabase.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Performs database operation on Car model.
 */
@RepositoryRestResource
public interface CarRepositories extends PagingAndSortingRepository<Car, Long> {
    List<Car> findByColor(@Param("color") String color);
    List<Car> findByYear(@Param("year") int year);
    List<Car> findByBrandAndModel(@Param("brand") String brand, @Param("model") String model);
    List<Car> findByBrandOrColor(@Param("brand") String brand, @Param("color") String color);
    List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(@Param("brand") String brand);
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(@Param("brand") String brand);
    // returns first 20 items. To change the number of items
    // set a query string "limit=number"
    Page<Car> findAll(Pageable pageable);
}
