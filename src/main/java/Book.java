import java.time.LocalDate;
import java.util.Objects;

/**
 * Defines a book object with key attributes
 * and methods for comparison, access, and display
 *
 * @author Jessika Torrealba
 * @version 0.1.0
 * @since 9/18/2025
 */
public class Book {
    public static final int ISBN_=0;
    public static final int TITLE_=1;
    public static final int SUBJECT_=2;
    public static final int PAGE_COUNT_=3;
    public static final int AUTHOR_=4;
    public static final int DUE_DATE_=5;

    private String author;
    private LocalDate dueDate;
    private String ISBN;
    private int pageCount;
    private String subject;
    private String title;

    public Book(String ISBN, String title, String subject, int pageCount, String author, LocalDate dueDate) {
        this.author = author;
        this.dueDate = dueDate;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.subject = subject;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount && Objects.equals(author, book.author) && Objects.equals(ISBN, book.ISBN) && Objects.equals(subject, book.subject) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, ISBN, pageCount, subject, title);
    }

    @Override
    public String toString() {
        return title+" by "+author+" ISBN: "+ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
