package hello.person;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 *
 * 1. This repository is an interface and will allow you to perform various operations involving Person objects.
 * It gets these operations by extending MongoRepository,
 * which in turn extends the PagingAndSortingRepository interface defined in Spring Data Commons.
 *
 * 2. At runtime, Spring Data REST will create an implementation of this interface automatically.
 * Then it will use the @RepositoryRestResource annotation to direct Spring MVC to create RESTFul endpoints at /people.
 *
 * 3. @RepositoryRestResource is not required for a repository to be exported.
 * It is only used to change the export details, such as using /people instead of the default value of /persons.
 *
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(@Param("name") String name);
    String a = "abc";

}