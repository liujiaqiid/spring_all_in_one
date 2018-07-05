package hello.customer;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // Spring Data JPA also allows you to define other query methods by simply declaring their method signature
    List<Customer> findByLastName(String lastName);
}
