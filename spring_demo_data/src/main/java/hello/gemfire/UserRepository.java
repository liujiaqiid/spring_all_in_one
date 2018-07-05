package hello.gemfire;

import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    @Trace
    User findByName(String name);

    @Trace
    Iterable<User> findByAgeGreaterThan(int age);

    @Trace
    Iterable<User> findByAgeLessThan(int age);

    @Trace
    Iterable<User> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);

}
