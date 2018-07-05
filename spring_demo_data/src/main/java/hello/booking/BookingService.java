package hello.booking;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1. Your application has actually zero configuration.
 * Spring Boot will detect spring-jdbc on the classpath and h2 and will create a DataSource and a JdbcTemplate for you automatically.
 * Because such infrastructure is now available and you have no dedicated configuration, a DataSourceTransactionManager will also be created for you:
 * this is the component that intercepts the @Transactional annotated method (e.g. the book on BookingService).
 * The BookingService is detected via classpath scanning.
 *
 * 2. Another Spring Boot feature demonstrated in this guide is the ability to initialize the schema on startup:
 *    "src/main/resources/schema.sql"
 */
@Component
public class BookingService {

    private final static Logger logger = LoggerFactory.getLogger(BookingService.class);

    private final JdbcTemplate jdbcTemplate;

    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * This method is tagged with @Transactional,
     * meaning that any failure causes the entire operation to roll back to its previous state,
     * and to re-throw the original exception.
     * This means that none of the people will be added to BOOKINGS if one person fails to be added.
     *
     * @param persons
     */
    @Transactional
    public void book(String... persons) {
        for (String person : persons) {
            logger.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
        }
    }

    public List<String> findAllBookings() {
        return jdbcTemplate.query("select FIRST_NAME from BOOKINGS",
                (rs, rowNum) -> rs.getString("FIRST_NAME"));
    }

}
