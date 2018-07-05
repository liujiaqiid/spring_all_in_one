package hello.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PeopleItemProcessor implements ItemProcessor<People, People> {

    private static final Logger log = LoggerFactory.getLogger(PeopleItemProcessor.class);

    @Override
    public People process(final People person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final People transformedPerson = new People(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
