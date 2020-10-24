/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marcel
 */
public class QuotesServiceTest {
    
    public QuotesServiceTest() {
    }

    @Test
    public void whenMarkAsFavorite_thenFavoriteShouldBeReturned() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/quotes/favorite");
        Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Entity.json(""), Response.class);

        assertEquals("Response status should be 200", 200, response.getStatus());
    }
}
