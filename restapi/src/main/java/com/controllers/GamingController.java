package com.controllers;

import com.models.Deck;
import com.service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Porali_S on 12/14/2016.
 */
@RestController
public class GamingController {

    @Autowired
    GamingService gamingService;

    @RequestMapping(path = "/deck", method = PUT)
    @ResponseBody
    String newNamedDeck(@RequestParam String deckName) {
        try {
            this.gamingService.putNewNamedDeck(deckName);
            return "OK";
        } catch (Exception e) {
            return "Failure";
        }
    }

    @RequestMapping(path = "/shuffle", method = POST)
    @ResponseBody
    Object shuffleExistingNamedDeck(@RequestBody String deckName) {
        try {
            List<Deck> decks = this.gamingService.shuffleExistingNamedDeck(deckName);
            if ( ObjectUtils.isEmpty(decks)) {
                throw new RuntimeException("No Deck Available");
            }
            return decks.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "/decks", method = GET)
    @ResponseBody
    Object persistedDecks() {
        try {
            List<String> persistedDecks = this.gamingService.getPersistedDecks();
            if(ObjectUtils.isEmpty(persistedDecks))
                throw new RuntimeException("No Data Found");
            return persistedDecks;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "/deck", method = GET)
    @ResponseBody
    Object getNamedDeck(@RequestParam String deckName) {
        try {
            Deck namedDeck = this.gamingService.getNamedDeck(deckName);
            if (null == namedDeck)
                throw new RuntimeException("Unable to find -" + deckName);
            return namedDeck.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "/deck", method = DELETE)
    @ResponseBody
    Object deleteNamedDeck(@RequestParam String deckName) {
        try {
            if (!this.gamingService.purgeNamedDeck(deckName))
                throw new RuntimeException("Unable to delete -" + deckName);
            return "Done";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
