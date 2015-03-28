package jlibrary.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Darlington Moyo
 *
 */
public class Book extends AbstractModelObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title, author, publisher;
	private Date publicationDate;
	private double price;

	/**
	 * Constructor Method for Book
	 * 
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publicationDate
	 * @param price
	 */
	public Book(String title, String author, String publisher,
			Date publicationDate, double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	/**
	 * Default Constructor for Book Class
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the title of the book
	 * 
	 * @return Title of book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title of book
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get name of author
	 * 
	 * @return Author Name
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set name of author
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get name of publisher
	 * 
	 * @return Publisher Name
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Set name of publisher
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Get name of publisher
	 * 
	 * @return Publication Date as formated string
	 */
	public String getPublicationDate() {

		String str = new SimpleDateFormat("MMMM d, Y").format(publicationDate);
		return str;
	}
	
	
	/**
	 * Get publication date as Date Object
	 * 
	 * @return publicationDate
	 */
	public Date getPublicationDateObj() {

		return publicationDate;
	}

	/**
	 * Set publication date of Book
	 * 
	 * @param publicationDate
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Get price of book
	 * 
	 * @return Price of Book
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set price of book
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
