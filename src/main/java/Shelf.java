import Utilities.Code;

import java.util.HashMap;
import java.util.Objects;

/**
 * [Brief one-sentence description of what this class does.]
 *
 * @author Jessika Torrealba
 * @version 0.1.0
 * @since 9/28/2025
 */
public class Shelf {
    public static final int SHELF_NUMBER=0;
    public static final int SUBJECT_=1;

    private HashMap<Book, Integer> books;
    private int selfNumber;
    private String subject;

//deprecated constructor
    public Shelf() {
    }
    public Shelf(int selfNumber, String subject) {
        this.selfNumber = selfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getSelfNumber() {
        return selfNumber;
    }

    public void setSelfNumber(int selfNumber) {
        this.selfNumber = selfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return getSelfNumber() == shelf.getSelfNumber() && Objects.equals(getSubject(), shelf.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSelfNumber(), getSubject());
    }

    @Override
    public String toString() {
        return selfNumber+" : "+ subject;
    }
    public int getBookCount(Book book) {
        if(book==null || !books.containsKey(book)){
            return -1;
        }
        return books.get(book);
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


}
