import Utilities.Code;

import java.util.HashMap;
import java.util.Map;
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
    private int shelfNumber;
    private String subject;

//deprecated constructor
    public Shelf() {
        this.books = new HashMap<>();
    }
    public Shelf(int selfNumber, String subject) {
        this.shelfNumber = selfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }
    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int selfNumber) {
        this.shelfNumber = selfNumber;
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
        return getShelfNumber() == shelf.getShelfNumber() && Objects.equals(getSubject(), shelf.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShelfNumber(), getSubject());
    }

    @Override
    public String toString() {
        return shelfNumber+" : "+ subject;
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
        int count=getBookCount(book);
        if(count==-1){
            books.put(book,1);
        }else{
            books.put(book,count+1);
        }
        System.out.printf("%s %s %s",book.toString()," added to shelf " ,this.toString());
        return Code.SUCCESS;
    }
    public Code removeBook(Book book) {
        if(book==null){
            return Code.UNKNOWN_ERROR;
        }
        if(!books.containsKey(book)){
            System.out.printf("%s %s %s",book.getTitle(),"is not on shelf",subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        if(getBookCount(book)==0){
            System.out.printf("%s %s %s %s","No copies of ",book.getTitle()," remain on the self ",subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        books.put(book, getBookCount(book) - 1);
        System.out.printf("%s %s %s",book.getTitle(),"successfully removed from shelf ",subject);
        return Code.SUCCESS;
    }
    public String listBooks(){
        StringBuilder sb = new StringBuilder();
        String plural;
        int total=0;
        for(Book book:books.keySet()){
            total+=books.get(book);
        }
        if(total==1){
            plural = "book";
        }else{
            plural = "books";
        }
        sb.append(total).append(" ").append(plural)
                .append(" on shelf: ").append(shelfNumber)
                .append(" : ").append(subject).append("\n");
        for(Map.Entry<Book, Integer> entry:books.entrySet()){
            Book book = entry.getKey();
            int copies = entry.getValue();
            sb.append(book.toString()).append(" ").append(copies).append("\n");
        }
        return sb.toString();
    }

}
