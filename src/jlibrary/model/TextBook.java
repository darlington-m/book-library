package jlibrary.model;

import java.util.Date;

/**
 * @author user
 *
 */
public class TextBook extends Book{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subject;
	
	
	/**
	 * Constructor for TextBook
	 * 
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publicationDate
	 * @param price
	 * @param subject
	 */
	public TextBook(String title, String author, String publisher,
			Date publicationDate, double price, String subject) {
		super( title, author, publisher, publicationDate, price);
		this.subject = subject;
	}


	/**
	 * Get book subject
	 * 
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * Set book subject
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
