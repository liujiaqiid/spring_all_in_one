package hello.hateoas;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hi extends ResourceSupport {

    private final String content;

    /**
     * @JsonCreator - signal on how Jackson can create an instance of this POJO
     * @JsonProperty - clearly marks what field Jackson should put this constructor argument into
     *
     * @param content
     */
    @JsonCreator
    public Hi(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
