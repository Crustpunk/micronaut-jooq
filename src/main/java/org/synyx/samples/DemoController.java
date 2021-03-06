/*
 * 31.05.2018
 */
package org.synyx.samples;

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
        return "Hi!, I'm your DemoController!";
    }

    @Get("/jooqDemo")
    public String getJooQDemo() {
        return "Not Implemented yet!";
    }

    @Get("/tests")
    public String getTestData() {
        return "test";
    }
}
