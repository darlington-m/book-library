package jlibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Darlington Moyo
 *
 */
public class Library extends AbstractModelObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Book> books = new ArrayList<Book>();

	private String libraryName;

	/**
	 * Default constructor for Library Class
	 */
	public Library() {
	}

	/**
	 * Constructor for Library
	 * 
	 * @param name
	 */
	public Library(String name) {
		libraryName = name;
	}

	/**
	 * @return
	 */
	public String getName() {
		return libraryName;
	}

	/**
	 * Set library name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		String oldValue = libraryName;
		libraryName = name;
		firePropertyChange("name", oldValue, libraryName);
	}

	/**
	 * Add book to library
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		List<Book> oldValue = books;
		books = new ArrayList<Book>(books);
		books.add(book);
		firePropertyChange("books", oldValue, books);
		firePropertyChange("booksCount", oldValue.size(), books.size());
	}

	/**
	 * Remove book from library
	 * 
	 * @param book
	 */
	public void removeBook(Book book) {
		List<Book> oldValue = books;
		books = new ArrayList<Book>(books);
		books.remove(book);
		firePropertyChange("books", oldValue, books);
		firePropertyChange("booksCount", oldValue.size(), books.size());
	}

	/**
	 * Get all books from library
	 * 
	 * @return
	 */
	public List<Book> getBooks() {
		return books;
	}
	
	
	/**
	 * Get book by selected index
	 * 
	 * @param index
	 * @return book
	 */
	public Book getBook(int index) {
		
		Book book = books.get(index);
		return book;
	}
	
	/**
	 * Get number of books in library
	 * 
	 * @return int size
	 */
	public int getBookCount() {
		return books.size();
	}

	/**
	 * Replace books in library
	 * 
	 * @param newBooks
	 */
	public void replaceBooks(List<Book> newBooks) {
		List<Book> oldValue = books;
		books = newBooks;
		firePropertyChange("books", oldValue, books);
		firePropertyChange("booksCount", oldValue.size(), books.size());
	}
	
	
	/**
	 * Save an edited book
	 * 
	 * @param book
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publicationDate
	 * @param price
	 * @param option
	 */
	public void saveBookEdit(Book book,String title, String author, String publisher, Date publicationDate, double price, String option) {
		
		List<Book> oldValue = books;
		books = new ArrayList<Book>(books);
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPublicationDate(publicationDate);
		book.setPrice(price);
		if (book instanceof TextBook) {
			((TextBook) book).setSubject(option);
		} else if (book instanceof FictionalBook) {
			((FictionalBook) book).setGenre(option);
		} if (book instanceof HistoryBook) {
			((HistoryBook) book).setPeriod(option);
		}
		
		firePropertyChange("books", oldValue, books);
		firePropertyChange("booksCount", oldValue.size(), books.size());
		
		
	}
	
}