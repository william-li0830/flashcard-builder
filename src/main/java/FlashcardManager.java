
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class FlashcardManager {

    private static final String FILE_NAME = "flashcards.txt";
    private static final String DELIMITER = "^^";
    private static final String DELIMITER_REGEX = "\\^\\^";

    private final ArrayList<Flashcard> flashcards = new ArrayList<>();

    private final FileRead fileRead = new FileRead();
    private final FileWrite fileWrite = new FileWrite();

    public FlashcardManager() {
    }

    public void addCard(Flashcard card) {
        flashcards.add(card);
        saveToFile();
    }

    public void removeCard(int index) {
        flashcards.remove(index);
        saveToFile();
    }

    public ArrayList<Flashcard> getCards() {
        return flashcards;
    }

    public void loadFromFile() {
        ArrayList<String> contents = fileRead.retrieveDataListFromFile(FILE_NAME);

        for (String combined : contents) {
            String[] separated = combined.split(DELIMITER_REGEX);
            if (separated.length < 2) {
                break;
            }
            String front = separated[0];
            String back = separated[1];
            
            Flashcard card = new Flashcard(front, back);
            flashcards.add(card);
        }
    }

    public void saveToFile() {
        ArrayList<String> contents = new ArrayList<>();

        for (Flashcard card : flashcards) {
            String front = card.getFront();
            String back = card.getBack();
            String combined = front + DELIMITER + back;

            contents.add(combined);
        }

        fileWrite.writeContentsToFile(FILE_NAME, contents, false);
    }
}
