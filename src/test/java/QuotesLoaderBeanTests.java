/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hspf.schuster.rs.jax.example.Citation;
import de.hspf.schuster.rs.jax.example.QuotesLoaderBean;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Marcel
 */
@ExtendWith(MockitoExtension.class)
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

    @ParameterizedTest
    @ValueSource(strings = {"c", "citation", "this is a citation"})
    void whenCreateCitation_thenCitationShouldNotBeEmpty(String text) {
        Citation citationLoaded = quotesLoaderBean.createCitation(text);

        assertTrue(!citationLoaded.getQuote().isEmpty());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void whenCreateCitationWithInput_thenCitationShouldNotBeEmpty(String text) {
        Citation citationLoaded = quotesLoaderBean.createCitation(text);

        assertTrue(!citationLoaded.getQuote().isEmpty());
    }

    @Test
    public void whenCreateCitationWithQuote_thenCitationShouldHaveQuote() {
        Citation citation = mock(Citation.class);
        Citation citationLoaded = quotesLoaderBean.createCitation("This is just a test quote");
        when(citation.getQuote()).thenReturn("This is just a test quote");

        assertEquals("Citations should contain the same quote", citationLoaded.getQuote(), citation.getQuote());
    }

    @Test
    public void whenCreateCitation_thenCitationShouldBeReturned() {
        Citation citationLoaded = quotesLoaderBean.createCitation("This is just a test quote");

        assertTrue(Citation.class.isInstance(citationLoaded));
    }

}
