# Shuffler
Shuffler is an application to stimulate the Random shuffle and Hand shuffle of a deck.

###Components
Shuffler has modularised components which encourages de coupling and plug and play approach
  1. Models
  2. Persistence
  3. Capability
  4. RestAPI
  
###To Build Jar
Follow below steps to generate jar
  1. Navigate to ```<projectrootdir>\shuffler\restapi```
  2. RUN ```gradle build```

  
###To Run Jar
Follow below steps to generate jar
  1. Navigate to ```<projectrootdir>\shuffler\restapi\build\libs```
  2. RUN ```java -Dspring.profiles.active=complex -jar restapi.jar```

Valid profiles are
  1. simple
  2. complex

###Swagger
This service is swagger enabled
  1. Once service starts up hit [swager-ui.html](http://loacalhost:8080/swager-ui.html)

###Capability Included
  1. Create new sorted deck with a name
  2. Fetch the deck by name
  3. Fetch all persisted decks
  4. Delete a named deck
  5. Shuffle with Simple logic
  6. Shuffle with Complex logic