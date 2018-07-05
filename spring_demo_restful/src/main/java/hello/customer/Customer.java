package hello.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    // The Customer’s id property is annotated with @Id so that JPA will recognize it as the object’s ID.
    // The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically.
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    // The other two properties, firstName and lastName are left unannotated.
    // It is assumed that they’ll be mapped to columns that share the same name as the properties themselves.
    private String firstName;
    private String lastName;



    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
