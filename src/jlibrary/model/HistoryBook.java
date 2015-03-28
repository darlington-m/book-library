package jlibrary.model;

import java.util.Date;

public class HistoryBook extends Book {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String period;
	
	
	/**
	 * Constructor for History Book objects
	 * 
	 * @param title
	 * @param author
	 * @param publisher
	 * @param publicationDate
	 * @param price
	 * @param period
	 */
	public HistoryBook(String title, String author, String publisher,
			Date publicationDate, double price, String period) {
		super( title, author, publisher, publicationDate, price);
		this.period = period;
	}
	
	/**
	 * @return
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
