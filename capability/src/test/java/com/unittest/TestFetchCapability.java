package com.unittest;

import com.capability.Create;
import com.capability.Fetch;
import com.init.TestRunner;
import com.models.Deck;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by Porali_S on 12/15/2016.
 */
public class TestFetchCapability extends TestRunner {

    @Autowired
    Create create;

    @Autowired
    Fetch fetch;

    @Test
    public void test_Dependency_Injection() {
        assertNotNull(create);
        assertNotNull(fetch);
    }

    @Test
    public void fetch_Named_Deck_Many_Times() {
        try {
            create.createStandardDeckWithName("TestingDeck");
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
        }catch (Exception e){
            fail("Unexpected exception occurred with error message : " +  e.getMessage());
        }
    }

}
