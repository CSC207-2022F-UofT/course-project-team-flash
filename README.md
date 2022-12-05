# WhipFlash
WhipFlash is a flashcard program that can aid with learning new material.

## Features
- Create multiple types of flashcards
- Quiz yourself on self-chosen flashcard decks.
- Importing and Exporting a decks of flashcards
- Make changes to cards, decks, and quizzes during the process

## Prerequisites

Make sure you have Java 11 installed on your computer.

## How to Use

Download the source code and run Main.java

### Decks
To start off, create a new deck by clicking on the "Deck" button and then "New Deck" on the top right.\
Here you have the option to create a new deck or to import one from a file. \
Once you've created a deck, you can modify it by clicking on settings button on the right of it. \
There you can rename it, delete it, and even export it to a file.

### Flashcards

Click on the deck to view the cards it contains. To add new cards to a deck, click on the "New Card" button on the top right.\
To modify a card, click on it and a menu to edit or to delete it will pop up.

### Quizzes

Once you've got a deck, you can head over to the quiz screen and create a quiz.

To create a quiz click on the "New Quiz" button on the top right of the window. \
Enter the name you want the quiz to have and check off the decks to be included. \
Once happy with the quiz, click on "Create Quiz".
If you want to rename or delete the quiz, press the settings button.

### Starting a Quiz
To start a quiz, simply click it and a menu will pop up. \
Choose whether you want the card questions to be randomized and then start the quiz!

## Limitations
 - Questions and answers cannot be too long as question and answer fields are not dynamic
 - Decks and quizzes can only have their names edited not their contents directly
 - Only decks support importing/exporting and not individual cards or quizzes
 - Limited number of decks and cards can be created as no scrollable feature has been implemented

## Future Plans
### Technical Changes
 - View model is in violation of code smells such as bloaters, and switch statements. However, with limited time \
   and without a clear understanding of how to start, the switch statement provided a simple and easy way for \ 
   everyone to connect their use cases to the view.
 - Minor duplicate code chunks occur throughout the screens. All these code chunks can be extracted into a public \ 
   helper function that all these classes can use.
 - Removing use of static variables to store information, such as all flashcards, decks, and quizzes. Using a static \
   map allowed the team to access entities quickly and easily. However, during the testing process, an issue that arose \
   was that entities created in previous tests were affecting the current tests. For example, a created flashcard would \
   still be stored in the static map. The fix to this was to clear the map after each class of test case ran. In the future \
   it would be helpful to store these entities using serialization to avoid such problems.
   
### Implementation Extensions
  - Dynamic question and answer fields to allow for flexibility of length.
  - More editting features to make acts such as removing groups of questions from a quiz simpler.
  - Scrollable feature to allow for greater number of decks, and cards in each deck.
  - More user friendly import/export system to allow users to visually select a filepath rather than typing it out
  - Extensions to types of flashcard to include select-all type questions
  - More interactive quizzing to allow users to answer questions by checking off boxes for relavant types of cards

## Testing Coverage

## Credits
Albert Yan\
Aldo Bani\
Andrew Nguyen\
Derrick Cho\
Jamie Chew\
Jasmine Tsoi\
Jay Kanchankoti

Special Thanks: Kevin Pu
