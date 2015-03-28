package jlibrary;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import jlibrary.model.Book;
import jlibrary.model.FictionalBook;
import jlibrary.model.HistoryBook;
import jlibrary.model.Library;
import jlibrary.model.TextBook;

import javax.swing.JList;

/**
 * @author Darlington Moyo
 *
 */
public class ViewReports extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField booksTotal;
	private JTextField authorsTotal;
	private JTextField histTotal;
	private JTextField textTotal;
	private JTextField fictTotal;
	private JTextField valueTotal;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JList<String> list;

	/**
	 * @param library
	 */
	public ViewReports(Library library) {

		DefaultListModel<String> listModel = new DefaultListModel<String>();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		setSize(500, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		tabbedPane.setMaximumSize(getSize());
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("General Totals", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 100, 100, 0, 0 };
		gbl_panel.rowHeights = new int[] { 65, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		List<String> authorsL = new ArrayList<String>();
		Set<String> uniqueAuthors = new HashSet<String>(authorsL);

		int totalBooks = library.getBookCount();
		double totalV = 0.0;
		int totalText = 0, totalHist = 0, totalFict = 0;

		for (Book book : library.getBooks()) {

			listModel.addElement(book.getPublisher());
			authorsL.add(book.getAuthor());
			totalV += book.getPrice();
			if (book instanceof HistoryBook) {
				totalHist++;
			} else if (book instanceof TextBook) {
				totalText++;
			} else if (book instanceof FictionalBook) {
				totalFict++;
			}
		}

		DecimalFormat df = new DecimalFormat("#.##");

		String totalAuths = String.valueOf(uniqueAuthors.size());
		String totalBooksF = String.valueOf(totalBooks);
		String totalVF = String.valueOf(df.format(totalV));
		String totalHistF = String.valueOf(totalHist);
		String totalTextF = String.valueOf(totalText);
		String totalFictV = String.valueOf(totalFict);

		JLabel lblTotalBooks = new JLabel("Total Books");
		GridBagConstraints gbc_lblTotalBooks = new GridBagConstraints();
		gbc_lblTotalBooks.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalBooks.gridx = 1;
		gbc_lblTotalBooks.gridy = 1;
		panel.add(lblTotalBooks, gbc_lblTotalBooks);

		booksTotal = new JTextField();
		GridBagConstraints gbc_booksTotal = new GridBagConstraints();
		gbc_booksTotal.insets = new Insets(0, 0, 5, 5);
		gbc_booksTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_booksTotal.gridx = 2;
		gbc_booksTotal.gridy = 1;
		panel.add(booksTotal, gbc_booksTotal);
		booksTotal.setColumns(10);
		booksTotal.setText(totalBooksF);

		JLabel lblNewLabel = new JLabel("Authors");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		authorsTotal = new JTextField();
		GridBagConstraints gbc_authorsTotal = new GridBagConstraints();
		gbc_authorsTotal.insets = new Insets(0, 0, 5, 5);
		gbc_authorsTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_authorsTotal.gridx = 2;
		gbc_authorsTotal.gridy = 2;
		panel.add(authorsTotal, gbc_authorsTotal);
		authorsTotal.setColumns(10);
		authorsTotal.setText(totalAuths);

		JLabel lblNewLabel_1 = new JLabel("History Books");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		histTotal = new JTextField();
		GridBagConstraints gbc_histTotal = new GridBagConstraints();
		gbc_histTotal.insets = new Insets(0, 0, 5, 5);
		gbc_histTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_histTotal.gridx = 2;
		gbc_histTotal.gridy = 3;
		panel.add(histTotal, gbc_histTotal);
		histTotal.setColumns(10);
		histTotal.setText(totalHistF);

		lblNewLabel_2 = new JLabel("Text Books");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textTotal = new JTextField();
		GridBagConstraints gbc_textTotal = new GridBagConstraints();
		gbc_textTotal.anchor = GridBagConstraints.SOUTH;
		gbc_textTotal.insets = new Insets(0, 0, 5, 5);
		gbc_textTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotal.gridx = 2;
		gbc_textTotal.gridy = 4;
		panel.add(textTotal, gbc_textTotal);
		textTotal.setColumns(10);
		textTotal.setText(totalTextF);

		lblNewLabel_3 = new JLabel("Fiction Books");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		fictTotal = new JTextField();
		GridBagConstraints gbc_fictTotal = new GridBagConstraints();
		gbc_fictTotal.insets = new Insets(0, 0, 5, 5);
		gbc_fictTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_fictTotal.gridx = 2;
		gbc_fictTotal.gridy = 5;
		panel.add(fictTotal, gbc_fictTotal);
		fictTotal.setColumns(10);
		fictTotal.setText(totalFictV);

		lblNewLabel_4 = new JLabel("Total Value ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		valueTotal = new JTextField();
		GridBagConstraints gbc_valueTotal = new GridBagConstraints();
		gbc_valueTotal.insets = new Insets(0, 0, 5, 5);
		gbc_valueTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_valueTotal.gridx = 2;
		gbc_valueTotal.gridy = 6;
		panel.add(valueTotal, gbc_valueTotal);
		valueTotal.setColumns(10);
		valueTotal.setText("£" + totalVF);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Publisher List", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 100, 305, 100, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		list = new JList<String>(listModel);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 0;
		panel_1.add(list, gbc_list);
	}

}
