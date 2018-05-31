
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/*
 * 31.05.2018
*/

/**
 * Controller for demo purposes.
 * 
 * @author Joachim Arrasz <arrasz@synyx.de>
 */
@Controller("/")
public class DemoController {
    
    @Get("/")
    public String getHello() {
        return "Hi! I'm your DemoController!";
    }
    
}
