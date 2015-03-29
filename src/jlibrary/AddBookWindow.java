package jlibrary;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import jlibrary.model.Book;
import jlibrary.model.HistoryBook;
import jlibrary.model.FictionalBook;
import jlibrary.model.TextBook;
import jlibrary.model.Library;

/**
 * @author Darlington Moyo
 *
 */
public class AddBookWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component JLibrary = null;

	private JTabbedPane tabbedPane;
	private JTextField titleTxt;
	private JTextField authorTxt;
	private JTextField pubTxt;
	private JTextField dateTxt;
	private JTextField priceTxt;
	private JTextField periodTxt;
	private Library library;
	private JTextField fictTitle;
	private JTextField fictAuthor;
	private JTextField fictPub;
	private JTextField fictPrice;
	private JTextField fictDateOfPub;
	private JTextField fictGenre;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JTextField textPub;
	private JTextField textDate;
	private JTextField textPrice;
	private JTextField textSubj;

	/**
	 * Opens a Windows that allows users to add a new book to the library
	 * Take a parameter of Library object
	 * 
	 * @param lib
	 */
	public AddBookWindow(Library lib) {

		tabbedPane = new JTabbedPane();
		setSize(800, 600);
		setContentPane(tabbedPane);
		library = lib;
		Date dateX = new Date();
		String dateF = new SimpleDateFormat("MMMM d, Y").format(dateX);

		JPanel historyPanel = new JPanel();
		tabbedPane.addTab("History Book", historyPanel);
		GridBagLayout gbl_historyPanel = new GridBagLayout();
		gbl_historyPanel.columnWidths = new int[] { 0, 102, 256, 0, 0 };
		gbl_historyPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				24, 0 };
		gbl_historyPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_historyPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		historyPanel.setLayout(gbl_historyPanel);

		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 2;
		historyPanel.add(lblTitle, gbc_lblTitle);

		titleTxt = new JTextField();
		GridBagConstraints gbc_titleTxt = new GridBagConstraints();
		gbc_titleTxt.insets = new Insets(0, 0, 5, 5);
		gbc_titleTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleTxt.gridx = 2;
		gbc_titleTxt.gridy = 2;
		historyPanel.add(titleTxt, gbc_titleTxt);
		titleTxt.setColumns(10);

		JLabel lblNewLabel = new JLabel("Author");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		historyPanel.add(lblNewLabel, gbc_lblNewLabel);

		authorTxt = new JTextField();
		GridBagConstraints gbc_authorTxt = new GridBagConstraints();
		gbc_authorTxt.insets = new Insets(0, 0, 5, 5);
		gbc_authorTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_authorTxt.gridx = 2;
		gbc_authorTxt.gridy = 3;
		historyPanel.add(authorTxt, gbc_authorTxt);
		authorTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Publisher");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		historyPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		pubTxt = new JTextField();
		GridBagConstraints gbc_pubTxt = new GridBagConstraints();
		gbc_pubTxt.insets = new Insets(0, 0, 5, 5);
		gbc_pubTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_pubTxt.gridx = 2;
		gbc_pubTxt.gridy = 4;
		historyPanel.add(pubTxt, gbc_pubTxt);
		pubTxt.setColumns(10);

		JLabel lblDateOfPub = new JLabel("Date Of Pub");
		GridBagConstraints gbc_lblDateOfPub = new GridBagConstraints();
		gbc_lblDateOfPub.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfPub.gridx = 1;
		gbc_lblDateOfPub.gridy = 5;
		historyPanel.add(lblDateOfPub, gbc_lblDateOfPub);

		dateTxt = new JTextField();
		dateTxt.setToolTipText("e.g January 15, 2006");
		GridBagConstraints gbc_dateTxt = new GridBagConstraints();
		gbc_dateTxt.insets = new Insets(0, 0, 5, 5);
		gbc_dateTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateTxt.gridx = 2;
		gbc_dateTxt.gridy = 5;
		historyPanel.add(dateTxt, gbc_dateTxt);
		dateTxt.setColumns(10);
		dateTxt.setText(dateF);

		JLabel lblNewLabel_2 = new JLabel("Price");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		historyPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		priceTxt = new JTextField();
		GridBagConstraints gbc_priceTxt = new GridBagConstraints();
		gbc_priceTxt.insets = new Insets(0, 0, 5, 5);
		gbc_priceTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceTxt.gridx = 2;
		gbc_priceTxt.gridy = 6;
		historyPanel.add(priceTxt, gbc_priceTxt);
		priceTxt.setColumns(10);

		JLabel lblPeriod = new JLabel("Period");
		GridBagConstraints gbc_lblPeriod = new GridBagConstraints();
		gbc_lblPeriod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriod.gridx = 1;
		gbc_lblPeriod.gridy = 7;
		historyPanel.add(lblPeriod, gbc_lblPeriod);

		periodTxt = new JTextField();
		GridBagConstraints gbc_periodTxt = new GridBagConstraints();
		gbc_periodTxt.insets = new Insets(0, 0, 5, 5);
		gbc_periodTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_periodTxt.gridx = 2;
		gbc_periodTxt.gridy = 7;
		historyPanel.add(periodTxt, gbc_periodTxt);
		periodTxt.setColumns(10);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		GridBagConstraints gbc_cancelBtn = new GridBagConstraints();
		gbc_cancelBtn.insets = new Insets(0, 0, 5, 5);
		gbc_cancelBtn.gridx = 1;
		gbc_cancelBtn.gridy = 9;
		historyPanel.add(cancelBtn, gbc_cancelBtn);

		JButton saveBtn = new JButton("Add History Book");
		saveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					String date = dateTxt.getText();
					DateFormat format = new SimpleDateFormat("MMM d, yyyy",
							Locale.ENGLISH);
					Date fDate = format.parse(date);
					String price = priceTxt.getText();
					double fPrice = Double.parseDouble(price);

					String title = titleTxt.getText();
					String author = authorTxt.getText();
					String publisher = pubTxt.getText();
					String period = periodTxt.getText();

					Book hist = new HistoryBook(title, author, publisher,
							fDate, fPrice, period);
					library.addBook(hist);

					JOptionPane.showMessageDialog(JLibrary,
							"Book Added to Library!");
					dispose();

				} catch (NumberFormatException e) {

					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(JLibrary,
							"Book Not Saved! \n Price Format Incorrect");
					return;
				} catch (ParseException e) {

					JOptionPane.showMessageDialog(JLibrary,
							"Book Not Saved! \n Date Format Incorrect");
					return;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(JLibrary,
							"Opps, Something Went Wrong \n"
							+ "Review Your Input");
					return;
				}

			}
		});
		GridBagConstraints gbc_saveBtn = new GridBagConstraints();
		gbc_saveBtn.insets = new Insets(0, 0, 5, 5);
		gbc_saveBtn.gridx = 2;
		gbc_saveBtn.gridy = 9;
		historyPanel.add(saveBtn, gbc_saveBtn);

		JPanel textPanel = new JPanel();
		tabbedPane.addTab("Text Book", textPanel);
		GridBagLayout gbl_textPanel = new GridBagLayout();
		gbl_textPanel.columnWidths = new int[] { 0, 102, 256, 0, 0 };
		gbl_textPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_textPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_textPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		textPanel.setLayout(gbl_textPanel);

		JLabel lblNewLabel_4 = new JLabel("Title");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 1;
		textPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textTitle = new JTextField();
		GridBagConstraints gbc_textTitle = new GridBagConstraints();
		gbc_textTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTitle.gridx = 2;
		gbc_textTitle.gridy = 1;
		textPanel.add(textTitle, gbc_textTitle);
		textTitle.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Author");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		textPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textAuthor = new JTextField();
		GridBagConstraints gbc_textAuthor = new GridBagConstraints();
		gbc_textAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_textAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAuthor.gridx = 2;
		gbc_textAuthor.gridy = 2;
		textPanel.add(textAuthor, gbc_textAuthor);
		textAuthor.setColumns(10);

		JLabel lblPublisher_1 = new JLabel("Publisher");
		GridBagConstraints gbc_lblPublisher_1 = new GridBagConstraints();
		gbc_lblPublisher_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublisher_1.gridx = 1;
		gbc_lblPublisher_1.gridy = 3;
		textPanel.add(lblPublisher_1, gbc_lblPublisher_1);

		textPub = new JTextField();
		GridBagConstraints gbc_textPub = new GridBagConstraints();
		gbc_textPub.insets = new Insets(0, 0, 5, 5);
		gbc_textPub.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPub.gridx = 2;
		gbc_textPub.gridy = 3;
		textPanel.add(textPub, gbc_textPub);
		textPub.setColumns(10);

		JLabel lblDateOfPub_2 = new JLabel("Date Of Pub");
		GridBagConstraints gbc_lblDateOfPub_2 = new GridBagConstraints();
		gbc_lblDateOfPub_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfPub_2.gridx = 1;
		gbc_lblDateOfPub_2.gridy = 4;
		textPanel.add(lblDateOfPub_2, gbc_lblDateOfPub_2);

		textDate = new JTextField();
		GridBagConstraints gbc_textDate = new GridBagConstraints();
		gbc_textDate.insets = new Insets(0, 0, 5, 5);
		gbc_textDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDate.gridx = 2;
		gbc_textDate.gridy = 4;
		textPanel.add(textDate, gbc_textDate);
		textDate.setColumns(10);
		textDate.setText(dateF);

		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 5;
		textPanel.add(lblPrice, gbc_lblPrice);

		textPrice = new JTextField();
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 2;
		gbc_textPrice.gridy = 5;
		textPanel.add(textPrice, gbc_textPrice);
		textPrice.setColumns(10);

		JLabel lblSubject = new JLabel("Subject");
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject.gridx = 1;
		gbc_lblSubject.gridy = 6;
		textPanel.add(lblSubject, gbc_lblSubject);

		textSubj = new JTextField();
		GridBagConstraints gbc_textSubj = new GridBagConstraints();
		gbc_textSubj.insets = new Insets(0, 0, 5, 5);
		gbc_textSubj.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSubj.gridx = 2;
		gbc_textSubj.gridy = 6;
		textPanel.add(textSubj, gbc_textSubj);
		textSubj.setColumns(10);

		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel_1 = new GridBagConstraints();
		gbc_btnCancel_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel_1.gridx = 1;
		gbc_btnCancel_1.gridy = 8;
		textPanel.add(btnCancel_1, gbc_btnCancel_1);

		JButton btnAddTextBook = new JButton("Add Text Book");
		btnAddTextBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					String date = textDate.getText();
					DateFormat format = new SimpleDateFormat("MMM d, yyyy",
							Locale.ENGLISH);
					Date fDate1 = format.parse(date);
					String price1 = textPrice.getText();
					double fPrice1 = Double.parseDouble(price1);

					String title = textTitle.getText();
					String author = textAuthor.getText();
					String publisher = textPub.getText();
					String subj = textSubj.getText();

					Book textB = new TextBook(title, author, publisher, fDate1,
							fPrice1, subj);
					library.addBook(textB);
					JOptionPane.showMessageDialog(JLibrary,
							"Book Added to Library!");
					dispose();

				} catch (NumberFormatException e) {

					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(JLibrary,
							"Book Not Saved! \n Price Format Incorrect");
					return;
				} catch (ParseException e) {

					JOptionPane.showMessageDialog(JLibrary,
							"Book Not Saved! \n Date Format Incorrect");
					return;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(JLibrary,
							"Opps, Something Went Wrong \n"
							+ "Review Your Input");
					return;
				}

			}
		});
		GridBagConstraints gbc_btnAddTextBook = new GridBagConstraints();
		gbc_btnAddTextBook.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddTextBook.gridx = 2;
		gbc_btnAddTextBook.gridy = 8;
		textPanel.add(btnAddTextBook, gbc_btnAddTextBook);
		
				JPanel fictionPanel = new JPanel();
				tabbedPane.addTab("Fiction Book", fictionPanel);
				GridBagLayout gbl_fictionPanel = new GridBagLayout();
				gbl_fictionPanel.columnWidths = new int[] { 126, 244, 363, 0 };
				gbl_fictionPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_fictionPanel.columnWeights = new double[] { 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				gbl_fictionPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				fictionPanel.setLayout(gbl_fictionPanel);
				
						JLabel lblTitle_1 = new JLabel("Title");
						GridBagConstraints gbc_lblTitle_1 = new GridBagConstraints();
						gbc_lblTitle_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblTitle_1.gridx = 1;
						gbc_lblTitle_1.gridy = 1;
						fictionPanel.add(lblTitle_1, gbc_lblTitle_1);
						
								fictTitle = new JTextField();
								GridBagConstraints gbc_fictTitle = new GridBagConstraints();
								gbc_fictTitle.insets = new Insets(0, 0, 5, 0);
								gbc_fictTitle.fill = GridBagConstraints.HORIZONTAL;
								gbc_fictTitle.gridx = 2;
								gbc_fictTitle.gridy = 1;
								fictionPanel.add(fictTitle, gbc_fictTitle);
								fictTitle.setColumns(10);
								
										JLabel lblAuthor = new JLabel("Author");
										GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
										gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
										gbc_lblAuthor.gridx = 1;
										gbc_lblAuthor.gridy = 2;
										fictionPanel.add(lblAuthor, gbc_lblAuthor);
										
												fictAuthor = new JTextField();
												GridBagConstraints gbc_fictAuthor = new GridBagConstraints();
												gbc_fictAuthor.anchor = GridBagConstraints.NORTH;
												gbc_fictAuthor.insets = new Insets(0, 0, 5, 0);
												gbc_fictAuthor.fill = GridBagConstraints.HORIZONTAL;
												gbc_fictAuthor.gridx = 2;
												gbc_fictAuthor.gridy = 2;
												fictionPanel.add(fictAuthor, gbc_fictAuthor);
												fictAuthor.setColumns(10);
												
														JLabel lblPublisher = new JLabel("Publisher");
														GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
														gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
														gbc_lblPublisher.gridx = 1;
														gbc_lblPublisher.gridy = 3;
														fictionPanel.add(lblPublisher, gbc_lblPublisher);
														
																fictPub = new JTextField();
																GridBagConstraints gbc_fictPub = new GridBagConstraints();
																gbc_fictPub.insets = new Insets(0, 0, 5, 0);
																gbc_fictPub.fill = GridBagConstraints.HORIZONTAL;
																gbc_fictPub.gridx = 2;
																gbc_fictPub.gridy = 3;
																fictionPanel.add(fictPub, gbc_fictPub);
																fictPub.setColumns(10);
																
																		JLabel lblDateOfPub_1 = new JLabel("Date Of Pub");
																		GridBagConstraints gbc_lblDateOfPub_1 = new GridBagConstraints();
																		gbc_lblDateOfPub_1.insets = new Insets(0, 0, 5, 5);
																		gbc_lblDateOfPub_1.gridx = 1;
																		gbc_lblDateOfPub_1.gridy = 4;
																		fictionPanel.add(lblDateOfPub_1, gbc_lblDateOfPub_1);
																		
																				fictDateOfPub = new JTextField();
																				GridBagConstraints gbc_fictDateOfPub = new GridBagConstraints();
																				gbc_fictDateOfPub.insets = new Insets(0, 0, 5, 0);
																				gbc_fictDateOfPub.fill = GridBagConstraints.HORIZONTAL;
																				gbc_fictDateOfPub.gridx = 2;
																				gbc_fictDateOfPub.gridy = 4;
																				fictionPanel.add(fictDateOfPub, gbc_fictDateOfPub);
																				fictDateOfPub.setColumns(10);
																				fictDateOfPub.setText(dateF);
																				
																						JLabel lblNewLabel_3 = new JLabel("Price");
																						GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
																						gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
																						gbc_lblNewLabel_3.gridx = 1;
																						gbc_lblNewLabel_3.gridy = 5;
																						fictionPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
																						
																								fictPrice = new JTextField();
																								GridBagConstraints gbc_fictPrice = new GridBagConstraints();
																								gbc_fictPrice.insets = new Insets(0, 0, 5, 0);
																								gbc_fictPrice.fill = GridBagConstraints.HORIZONTAL;
																								gbc_fictPrice.gridx = 2;
																								gbc_fictPrice.gridy = 5;
																								fictionPanel.add(fictPrice, gbc_fictPrice);
																								fictPrice.setColumns(10);
																								
																										JLabel lblGenre = new JLabel("Genre");
																										GridBagConstraints gbc_lblGenre = new GridBagConstraints();
																										gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
																										gbc_lblGenre.gridx = 1;
																										gbc_lblGenre.gridy = 6;
																										fictionPanel.add(lblGenre, gbc_lblGenre);
																										
																												fictGenre = new JTextField();
																												GridBagConstraints gbc_fictGenre = new GridBagConstraints();
																												gbc_fictGenre.insets = new Insets(0, 0, 5, 0);
																												gbc_fictGenre.fill = GridBagConstraints.HORIZONTAL;
																												gbc_fictGenre.gridx = 2;
																												gbc_fictGenre.gridy = 6;
																												fictionPanel.add(fictGenre, gbc_fictGenre);
																												fictGenre.setColumns(10);
																												
																														JButton btnNewButton = new JButton("Add Fiction Book");
																														btnNewButton.addActionListener(new ActionListener() {

																															public void actionPerformed(ActionEvent arg0) {

																																try {
																																	String date = fictDateOfPub.getText();
																																	DateFormat format = new SimpleDateFormat("MMM d, yyyy",
																																			Locale.ENGLISH);
																																	Date fDate = format.parse(date);
																																	String price = fictPrice.getText();
																																	double fPrice = Double.parseDouble(price);

																																	String title = fictTitle.getText();
																																	String author = fictAuthor.getText();
																																	String publisher = fictPub.getText();
																																	String genr = fictGenre.getText();

																																	Book fict = new FictionalBook(title, author, publisher,
																																			fDate, fPrice, genr);
																																	library.addBook(fict);
																																	JOptionPane.showMessageDialog(JLibrary,
																																			"Book Added to Library!");
																																	dispose();

																																} catch (NumberFormatException e) {

																																	// TODO Auto-generated catch block
																																	JOptionPane.showMessageDialog(JLibrary,
																																			"Book Not Saved! \n Price Format Incorrect");
																																	return;
																																} catch (ParseException e) {

																																	JOptionPane.showMessageDialog(JLibrary,
																																			"Book Not Saved! \n Date Format Incorrect");
																																	return;
																																} catch (Exception e) {
																																	JOptionPane.showMessageDialog(JLibrary,
																																			"Opps, Something Went Wrong \n"
																																			+ "Review Your Input");
																																	return;
																																} 

																															}
																														});
																														
																																JButton btnCancel = new JButton("Cancel");
																																btnCancel.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent arg0) {

																																		dispose();
																																	}
																																});
																																GridBagConstraints gbc_btnCancel = new GridBagConstraints();
																																gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
																																gbc_btnCancel.gridx = 1;
																																gbc_btnCancel.gridy = 8;
																																fictionPanel.add(btnCancel, gbc_btnCancel);
																																GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
																																gbc_btnNewButton.gridx = 2;
																																gbc_btnNewButton.gridy = 8;
																																fictionPanel.add(btnNewButton, gbc_btnNewButton);

	}
}
