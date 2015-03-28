package jlibrary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jlibrary.model.Book;
import jlibrary.model.FictionalBook;
import jlibrary.model.HistoryBook;
import jlibrary.model.Library;
import jlibrary.model.TextBook;

import java.awt.Dialog.ModalExclusionType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Darlington Moyo
 *
 */
public class EditBookWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component JLibrary = null;
	private JTextField editTitle;
	private JTextField editAuthor;
	private JTextField editPub;
	private JTextField editDate;
	private JTextField editPrice;
	private JTextField editOption;
	private JLabel lblAuthor;
	private JLabel lblNewLabel;
	private JLabel lblDateOfPub;
	private JLabel lblNewLabel_1;
	private JButton btnSaveBook;
	private JButton btnCancel;

	/**
	 * Allows users to edit a book selected from the list
	 * 
	 * 
	 * @param library 
	 * @param book
	 */
	public EditBookWindow(final Library library, final Book book) {

		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		JPanel panel = new JPanel();
		setSize(500, 300);
		panel.setMinimumSize(getSize());

		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 102, 269, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		panel.add(lblTitle, gbc_lblTitle);

		editTitle = new JTextField();
		GridBagConstraints gbc_editTitle = new GridBagConstraints();
		gbc_editTitle.insets = new Insets(0, 0, 5, 5);
		gbc_editTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_editTitle.gridx = 2;
		gbc_editTitle.gridy = 1;
		panel.add(editTitle, gbc_editTitle);
		editTitle.setColumns(10);
		editTitle.setText(book.getTitle());

		lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 1;
		gbc_lblAuthor.gridy = 2;
		panel.add(lblAuthor, gbc_lblAuthor);

		editAuthor = new JTextField();
		GridBagConstraints gbc_editAuthor = new GridBagConstraints();
		gbc_editAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_editAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_editAuthor.gridx = 2;
		gbc_editAuthor.gridy = 2;
		panel.add(editAuthor, gbc_editAuthor);
		editAuthor.setColumns(10);
		editAuthor.setText(book.getAuthor());

		lblNewLabel = new JLabel("Publisher");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		editPub = new JTextField();
		GridBagConstraints gbc_editPub = new GridBagConstraints();
		gbc_editPub.anchor = GridBagConstraints.NORTH;
		gbc_editPub.insets = new Insets(0, 0, 5, 5);
		gbc_editPub.fill = GridBagConstraints.HORIZONTAL;
		gbc_editPub.gridx = 2;
		gbc_editPub.gridy = 3;
		panel.add(editPub, gbc_editPub);
		editPub.setColumns(10);
		editPub.setText(book.getPublisher());

		lblDateOfPub = new JLabel("Date Of Pub");
		GridBagConstraints gbc_lblDateOfPub = new GridBagConstraints();
		gbc_lblDateOfPub.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfPub.gridx = 1;
		gbc_lblDateOfPub.gridy = 4;
		panel.add(lblDateOfPub, gbc_lblDateOfPub);

		editDate = new JTextField();
		GridBagConstraints gbc_editDate = new GridBagConstraints();
		gbc_editDate.insets = new Insets(0, 0, 5, 5);
		gbc_editDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_editDate.gridx = 2;
		gbc_editDate.gridy = 4;
		panel.add(editDate, gbc_editDate);
		editDate.setColumns(10);
		editDate.setText(book.getPublicationDate());

		lblNewLabel_1 = new JLabel("Price");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		editPrice = new JTextField();
		GridBagConstraints gbc_editPrice = new GridBagConstraints();
		gbc_editPrice.anchor = GridBagConstraints.NORTH;
		gbc_editPrice.insets = new Insets(0, 0, 5, 5);
		gbc_editPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_editPrice.gridx = 2;
		gbc_editPrice.gridy = 5;
		panel.add(editPrice, gbc_editPrice);
		editPrice.setColumns(10);
		String price = String.valueOf(book.getPrice());
		editPrice.setText(price);

		editOption = new JTextField();
		GridBagConstraints gbc_editOption = new GridBagConstraints();
		gbc_editOption.insets = new Insets(0, 0, 5, 5);
		gbc_editOption.fill = GridBagConstraints.HORIZONTAL;
		gbc_editOption.gridx = 2;
		gbc_editOption.gridy = 6;
		panel.add(editOption, gbc_editOption);
		editOption.setColumns(10);
		if (book instanceof TextBook) {
			TextBook bookX = (TextBook) book;
			editOption.setText(bookX.getSubject());
		} else if (book instanceof FictionalBook) {
			FictionalBook bookX = (FictionalBook) book;
			editOption.setText(bookX.getGenre());
		} else if (book instanceof HistoryBook) {
			HistoryBook bookX = (HistoryBook) book;
			editOption.setText(bookX.getPeriod());
		}

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 8;
		panel.add(btnCancel, gbc_btnCancel);

		btnSaveBook = new JButton("Save Book");
		btnSaveBook.addActionListener(new ActionListener() {

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {

				try {
					String date = editDate.getText();
					DateFormat format = new SimpleDateFormat("MMM d, yyyy",
							Locale.ENGLISH);
					Date fDate = format.parse(date);
					String price = editPrice.getText();
					double fPrice = Double.parseDouble(price);

					String title = editTitle.getText();
					String author = editAuthor.getText();
					String publisher = editPub.getText();
					String option = editOption.getText();

					library.saveBookEdit(book, title, author, publisher, fDate,
							fPrice, option);
					JOptionPane.showMessageDialog(JLibrary, title
							+ " Edited And Saved");
					dispose();
				} catch (NumberFormatException e) {

					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(JLibrary,
							"Edit Not Saved! \n Price Format Incorrect");
					return;
				} catch (ParseException e) {

					JOptionPane.showMessageDialog(JLibrary,
							"Edit Not Saved! \n Date Format Incorrect");
					return;
				}
			}
		});
		GridBagConstraints gbc_btnSaveBook = new GridBagConstraints();
		gbc_btnSaveBook.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveBook.gridx = 2;
		gbc_btnSaveBook.gridy = 8;
		panel.add(btnSaveBook, gbc_btnSaveBook);
	}

}
