package ca.badalsarkar.carddatabase.repositories;

import ca.badalsarkar.carddatabase.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Performs database operation on Car model.
 */
public interface CarRepositories extends PagingAndSortingRepository<Car, Long> {
    List<Car> findByColor(String color);
    List<Car> findByYear(int year);
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByBrandOrColor(String brand, String color);
    List<Car> findByBrandOrderByYearAsc(String brand);
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
    // returns first 20 items. To change the number of items
    // set a query string "limit=number"
    Page<Car> findAll(Pageable pageable);
}
