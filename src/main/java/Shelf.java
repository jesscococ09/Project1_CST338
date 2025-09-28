import Utilities.Code;

import java.util.HashMap;

/**
 * [Brief one-sentence description of what this class does.]
 *
 * @author Jessika Torrealba
 * @version 0.1.0
 * @since 9/28/2025
 */
public class Shelf {
    public final int SHELF_NUMBER=0;
    public final int SUBJECT_=1;

    private final HashMap<Book, Integer> books;
    private final int selfNumber;
    private final String subject;
//deprecated constructor
    public Shelf() {
        this.books = new HashMap<>();
        this.selfNumber=-1;
        this.subject= null;

    }
    public Shelf(int selfNumber, String subject) {
        this.selfNumber = selfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }

    public int getBookCount(Book book) {
        return books.getOrDefault(book, 0);
    }
    public Code addBook(Book book) {
        if(book==null){
            return Code.UNKNOWN_ERROR;
        }
        if(!book.getSubject().equals(subject)){
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }
        books.put(book, getBookCount(book) + 1);
        return Code.SUCCESS;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public int getSelfNumber() {
        return selfNumber;
    }

    public String getSubject() {
        return subject;
    }
    public void setBooks(HashMap<Book, Integer> books) {

    }
    public void setSelfNumber(int selfNumber) {

    }
    public void setSubject(String subject) {

    }
}
