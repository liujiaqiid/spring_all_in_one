package hello.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@SuppressWarnings("unused")
public class GreetingController {

    /**
     *
     * The @MessageMapping annotation ensures that if a message is sent to destination "/hello",
     * then the greeting() method is called.
     *
     * The payload of the message is bound to a HelloMessage object which is passed into greeting().
     *
     * The return value is broadcast to all subscribers to "/topic/greetings" as specified in the @SendTo annotation.
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
