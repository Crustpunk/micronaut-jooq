/*
 * 31.05.2018
 */
package org.synyx;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Test for demo purposes.
 * 
 * @author Joachim Arrasz <arrasz@synyx.de>
 */
public class DemoControllerTest {
   
    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass 
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server
                    .getApplicationContext()
                    .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass 
    public static void stopServer() {
        if(server != null) {
            server.stop();
        }
        if(client != null) {
            client.stop();
        }
    }

    @Test
    public void testIssue() throws Exception {
        String body = client.toBlocking().retrieve("/tests"); 
        assertNotNull(body);
        assertEquals(body, "test");
    }
    
    
    
    
}
