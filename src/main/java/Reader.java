import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * library reader with personal details and a list of checked-out books, providing methods to add,
 * remove, and check for books while handling success and error codes.
 *
 * @author Jessika Torrealba
 * @version 0.1.0
 * @since 9/18/2025
 */
public class Reader {
    public final int CARD_NUMBER_=0;
    public final int NAME_=1;
    public final int PHONE_=2;
    public final int BOOK_COUNT_=3;
    public final int BOOK_START_=4;

    private int cardNumber;
    private String name;
    private String phone;
    private List<Book> books;

    public Reader(int cardNumber, String name, String phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;
        this.books = new ArrayList<>();
    }
    /*
    @return true if book is not null and book in the array
     */
    public boolean hasBook(Book book) {
        return books!=null && books.contains(book);
    }
    /*
    @returns checks if book is null or book is not there, then returns error code,
    removes book if there, if not sends error code
     */

    public Code removeBook(Book book) {
        if (books==null) {
            return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
        }
        if(!books.contains(book)) {
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        boolean removed = books.remove(book);
        if (removed) {
            return Code.SUCCESS;
        }else{
            return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
        }
    }
    /*
    The method checks if the book is already in the reader’s list and adds it only if it’s not,
    returning an appropriate success or error code.
     */
    public Code  addBook(Book book) {
        if (books==null) {
            books=new ArrayList<>();
        }
        if(hasBook(book)) {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }
        books.add(book);
        return Code.SUCCESS;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return cardNumber == reader.cardNumber && Objects.equals(name, reader.name) && Objects.equals(phone, reader.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, name, phone);
    }

    @Override
    public String toString() {
        //Bob Barker (#2187) has checked out {Book1, Book2}
        return name+" (#"+cardNumber+") has checked out "+books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBookCount() {
        return books.size();
    }
}
