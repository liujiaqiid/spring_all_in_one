package hello.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * 1. Spring Data JPA focuses on using JPA to store data in a relational database.
 * Its most compelling feature is the ability to create repository implementations automatically,
 * at runtime, from a repository interface.
 *
 * 2. In a typical Java application, you’d expect to write a class that implements CustomerRepository.
 * But that’s what makes Spring Data JPA so powerful:
 * You don’t have to write an implementation of the repository interface.
 * Spring Data JPA creates an implementation on the fly when you run the application.
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
