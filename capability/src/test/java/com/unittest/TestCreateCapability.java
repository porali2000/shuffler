package com.unittest;

import com.capability.Create;
import com.capability.Fetch;
import com.capability.FetchImpl;
import com.init.TestRunner;
import com.models.Deck;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Porali_S on 12/15/2016.
 */
public class TestCreateCapability extends TestRunner {

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
    public void create_Named_Deck_And_Verify() {
        try {
            create.createStandardDeckWithName("TestingDeck");
            Deck testingDeck = fetch.fetchDeckWithName("TestingDeck");
            assertNotNull(testingDeck);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void create_NamedDeck_With_SameName_And_Verify() {
        try {
            create.createStandardDeckWithName("TestingDeck");
            create.createStandardDeckWithName("TestingDeck");
            create.createStandardDeckWithName("TestingDeck");
            create.createStandardDeckWithName("TestingDeck");
            Deck testingDeck = fetch.fetchDeckWithName("TestingDeck");
            assertNotNull(testingDeck);
        }catch (Exception e){
            fail("Unexpected exception occurred with error message : " +  e.getMessage());
        }
    }

    @Test
    public void create_NamedDeck_With_Different_Name_And_Verify() {
        try {
            create.createStandardDeckWithName("TestingDeck");
            create.createStandardDeckWithName("TestingDeck2");
            create.createStandardDeckWithName("TestingDeck3");
            create.createStandardDeckWithName("TestingDeck4");
            assertNotNull(fetch.fetchDeckWithName("TestingDeck"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck2"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck3"));
            assertNotNull(fetch.fetchDeckWithName("TestingDeck4"));
        }catch (Exception e){
            fail("Unexpected exception occurred with error message : " +  e.getMessage());
        }
    }
}
