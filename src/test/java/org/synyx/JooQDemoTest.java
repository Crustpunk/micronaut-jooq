/*
 * 07.06.2018
 */
package org.synyx;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for the jooQ Demos.
 *
 * @author Joachim Arrasz <arrasz@synyx.de>
 */
public class JooQDemoTest {

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
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testjOOQConnection() {
        String userName = "jooQDemoUser";
        String password = "jooQDemoUser";
        String url = "jdbc:mysql://localhost:3306/jooQDemo";
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            assertNotNull("Connection could not be established", conn);
        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
    @Test
    public void testReadDataFromDemoTable() {
        String userName = "jooQDemoUser";
        String password = "jooQDemoUser";
        String url = "jdbc:mysql://localhost:3306/jooQDemo";
        
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            assertNotNull("Connection could not be established", conn);
            DSLContext context = DSL.using(conn, SQLDialect.MYSQL_5_7);
            Result<Record> result = context.select().from("User").fetch();
            assertEquals(new Integer(2), new Integer(result.size()));
            assertNotNull(result);
            
        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
