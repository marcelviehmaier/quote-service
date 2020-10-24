/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hspf.schuster.rs.jax.example.Citation;
import de.hspf.schuster.rs.jax.example.QuotesLoaderBean;
import static junit.framework.Assert.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Marcel
 */
public class QuotesLoaderBeanTests {
    private QuotesLoaderBean quotesLoaderBean;
    
    public QuotesLoaderBeanTests() {
    }
    
    @BeforeEach
    public void setUp() {
        quotesLoaderBean = new QuotesLoaderBean();
        quotesLoaderBean.init();
    }

    @Test
    public void whenCreateCitation_thenCitationShouldNotBeNull() {
       Citation citationLoaded = quotesLoaderBean.createCitation("");

       assertNotNull("Citation should not be null", citationLoaded);
    }
}
