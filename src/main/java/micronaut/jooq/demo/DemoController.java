/*
 * 31.05.2018
 */
package micronaut.jooq.demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Controller for all demo purposes.
 *
 * @author Joachim Arrasz <arrasz@synyx.de>
 */
@Controller("/")
public class DemoController {

    @Get("/")
    public String index() {
        return "Hi! I'm your Democontroller";
    }

}
