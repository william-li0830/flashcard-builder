
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class FlashcardManager {

    private ArrayList<Flashcard> flashcards = new ArrayList<>();

    public FlashcardManager() {

    }
    
    public void addCard(Flashcard card){
        flashcards.add(card);
    }
    
    public void removeCard(Flashcard card){
        flashcards.remove(card);
    }
        
    public void removeCard(int index){
        flashcards.remove(index);
    }
    
    public ArrayList<Flashcard> getCards(){
        return flashcards;
    }
}