package jlibrary.model;

import java.util.Date;

/**
 * @author Darlington Moyo
 *
 */
public class FictionalBook extends Book {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String genre;
	
	
	
	/**
	 * 
	 * Constructor for Fiction Book Objects
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publicationDate
	 * @param price
	 * @param genre
	 */
	public FictionalBook(String title, String author, String publisher,
			Date publicationDate, double price, String genre) {
		super( title, author, publisher, publicationDate, price);
		this.genre = genre;
	}

	
	/**
	 * Get genre of book
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
	
	
	/**
	 * Set genre of book
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
