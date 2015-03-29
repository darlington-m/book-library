package jlibrary;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import jlibrary.model.Book;
import jlibrary.model.FictionalBook;
import jlibrary.model.HistoryBook;
import jlibrary.model.Library;
import jlibrary.model.TextBook;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 * @author Darlington Moyo
 * 
 */
public class JLibrary extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8371568592952121534L;

	private JSplitPane contentPane;
	private JTextField txtAuthor;

	private Library library = new Library();
	private JList list;
	private JTextField txtPublisher;
	private JTextField txtDateOfPub;
	private JTextField txtPrice;
	private JTextField txtTitle;

	/**
	 * Main method for application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					JLibrary frame = new JLibrary();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for the Library Application
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public JLibrary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Book Libray App");
		setSize(800, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFromFile();
			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveToFile();
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAbout();
			}
		});
		mnFile.add(mntmAbout);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		mnFile.add(mntmClose);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmReports = new JMenuItem("View Library Report");
		mntmReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				openViewReports();
			}
		});
		mnView.add(mntmReports);

		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);

		JMenuItem mntmByDate = new JMenuItem("Search By Date");
		mntmByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				openSearchByDate();
			}
		});
		mnSearch.add(mntmByDate);

		JMenuItem mntmByTitle = new JMenuItem("Search By Title");
		mntmByTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				openSearchByTitle();
			}
		});
		mnSearch.add(mntmByTitle);

		JMenuItem mntmByAuthor = new JMenuItem("Search By Author");
		mntmByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				openSearchByAuthor();
			}
		});
		mnSearch.add(mntmByAuthor);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmReadMe = new JMenuItem("Read Me");
		mntmReadMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ProcessBuilder pb = new ProcessBuilder("Notepad.exe",
						"readme.txt");
				try {
					pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		mnHelp.add(mntmReadMe);

		contentPane = new JSplitPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel leftPanel = new JPanel();
		contentPane.setLeftComponent(leftPanel);
		JPanel rightPanel = new JPanel();
		contentPane.setRightComponent(rightPanel);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[] { 69, 0 };
		gbl_leftPanel.rowHeights = new int[] { 35, 174, 0 };
		gbl_leftPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_leftPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		leftPanel.setLayout(gbl_leftPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		leftPanel.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnAdd = new JButton("Add Book");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// addBook();
				openAddForm();
			}
		});
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete Book");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() > -1) {
					removeBook(library.getBooks().get(list.getSelectedIndex()));
				}
			}
		});

		JButton btnEdit = new JButton("Edit Book");
		btnEdit.addActionListener(new ActionListener() {
			private Object book;

			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedIndex() > -1) {
					this.book = library.getBook(list.getSelectedIndex());
					openEditForm((Book) this.book);
				}

			}
		});
		panel.add(btnEdit);
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		leftPanel.add(scrollPane, gbc_scrollPane);

		list = new JList();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		GridBagLayout gbl_rightPanel = new GridBagLayout();
		gbl_rightPanel.columnWidths = new int[] { 139, 264, 0 };
		gbl_rightPanel.rowHeights = new int[] { 0, 40, 4, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_rightPanel.columnWeights = new double[] { 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_rightPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		rightPanel.setLayout(gbl_rightPanel);

		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		rightPanel.add(lblTitle, gbc_lblTitle);

		txtTitle = new JTextField();
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.gridx = 1;
		gbc_txtTitle.gridy = 2;
		rightPanel.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);

		JLabel lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 3;
		rightPanel.add(lblAuthor, gbc_lblAuthor);

		txtAuthor = new JTextField();
		GridBagConstraints gbc_txtAuthor = new GridBagConstraints();
		gbc_txtAuthor.insets = new Insets(0, 0, 5, 0);
		gbc_txtAuthor.fill = GridBagConstraints.BOTH;
		gbc_txtAuthor.gridx = 1;
		gbc_txtAuthor.gridy = 3;
		rightPanel.add(txtAuthor, gbc_txtAuthor);
		txtAuthor.setColumns(10);

		JLabel lblValue = new JLabel("Publisher");
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 4;
		rightPanel.add(lblValue, gbc_lblValue);

		txtPublisher = new JTextField();
		GridBagConstraints gbc_txtPublisher = new GridBagConstraints();
		gbc_txtPublisher.insets = new Insets(0, 0, 5, 0);
		gbc_txtPublisher.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPublisher.gridx = 1;
		gbc_txtPublisher.gridy = 4;
		rightPanel.add(txtPublisher, gbc_txtPublisher);
		txtPublisher.setColumns(10);

		JLabel lblNewLabel = new JLabel("Date");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		rightPanel.add(lblNewLabel, gbc_lblNewLabel);

		txtDateOfPub = new JTextField();
		GridBagConstraints gbc_txtDateOfPub = new GridBagConstraints();
		gbc_txtDateOfPub.insets = new Insets(0, 0, 5, 0);
		gbc_txtDateOfPub.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateOfPub.gridx = 1;
		gbc_txtDateOfPub.gridy = 5;
		rightPanel.add(txtDateOfPub, gbc_txtDateOfPub);
		txtDateOfPub.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 6;
		rightPanel.add(lblPrice, gbc_lblPrice);

		txtPrice = new JTextField();
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrice.anchor = GridBagConstraints.NORTH;
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.gridx = 1;
		gbc_txtPrice.gridy = 6;
		rightPanel.add(txtPrice, gbc_txtPrice);
		txtPrice.setColumns(10);

		// pack();
		String date1 = "June 15, 1986";
		String date2 = "February 4, 2002";
		String date3 = "August 18, 2010";
		String date4 = "December 14, 1999";
		String date5 = "September 30, 2012";

		DateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
		Date date11 = null, date22 = null, date33 = null, date44 = null, date55 = null;
		try {
			date11 = format.parse(date1);
			date22 = format.parse(date2);
			date33 = format.parse(date3);
			date44 = format.parse(date4);
			date55 = format.parse(date5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Book fict = new FictionalBook("The DaVinci Code", "Dan Brown",
				"Penguin Books", date11, 10.95, "Thriller");
		Book hist = new HistoryBook("Learn History", "Sam Childs",
				"Render Publishing", date22, 21.99, "World Affairs Since 1900");
		Book text = new TextBook("Micro Organisms", "Sarah Chapman",
				"Willow Books", date33, 35.99, "Biology");
		Book fict2 = new FictionalBook("50 Shades Of Grey", "Linda Hayes",
				"Penguin Books", date44, 5.59, "Romance");
		Book text2 = new TextBook("Swing Basics", "Stefan Pletschacher",
				"Newton", date55, 15.95, "Programming");
		library.addBook(fict);
		library.addBook(text);
		library.addBook(hist);
		library.addBook(fict2);
		library.addBook(text2);

		initDataBindings();

	}

	/**
	 * Opens the View Reports Window that shows all books in Library
	 * 
	 */
	protected void openViewReports() {

		ViewReports report = new ViewReports(library);
		report.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		report.setVisible(true);
	}

	/**
	 * Opens the Add Book Window
	 */
	protected void openAddForm() {

		AddBookWindow add = new AddBookWindow(library);
		add.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.setVisible(true);
		initDataBindings();

	}

	/**
	 * Opens the Edit Book Windows that allows
	 * 
	 * @param book
	 */
	protected void openEditForm(Book book) {

		EditBookWindow edit = new EditBookWindow(library, book);
		edit.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		edit.setVisible(true);
		initDataBindings();
	}

	/**
	 * Open Books from a invetory.ser text file
	 * 
	 */
	protected void openFromFile() {

		FileDialog fileBox = new FileDialog(this, "Select File",
				FileDialog.LOAD);
		fileBox.setDirectory("C:\\");
		fileBox.setVisible(true);
		String fileName = fileBox.getFile();

		try {
			LibraryReaderWriter libraryReaderWriter = new LibraryReaderWriter(
					fileName);

			Library tmpInventory = null;
			tmpInventory = libraryReaderWriter.read();

			library.replaceBooks(tmpInventory.getBooks());

		} catch (IOException | ClassNotFoundException | NullPointerException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No file chosen", "Error",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	/**
	 * Save Books from a invetory.ser text file
	 * 
	 */
	protected void saveToFile() {

		FileDialog fileBox = new FileDialog(this, "Select File",
				FileDialog.SAVE);
		fileBox.setDirectory("C:\\");
		fileBox.setVisible(true);
		String fileName = fileBox.getFile();

		try {

			LibraryReaderWriter libraryReaderWriter = new LibraryReaderWriter(
					fileName);
			libraryReaderWriter.write(library);
		} catch (IOException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Save Not Successfull. Try Again", "Errot",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Remove Book from library
	 * 
	 * @param book
	 */
	protected void removeBook(Book book) {
		library.removeBook(book);
	}

	/**
	 * Add Book to Library
	 */
	protected void addBook() {
		library.addBook(new Book());
	}

	/**
	 * Show current Application Version
	 * 
	 */
	public void showAbout() {
		JOptionPane.showMessageDialog(this, "Library App Version 0.1"
				+ "\n Author: Darlington Moyo");
	}

	/**
	 * 
	 * OPen Search By Date Dialog Window
	 * 
	 */
	public void openSearchByDate() {
		// TODO Auto-generated method stub

		String firstDate = null;
		String secondDate = null;

		String s = (String) JOptionPane.showInputDialog(this,
				"Input Date From \n" + "(e.g January 2010)");

		// If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
			firstDate = s;
		}

		String t = (String) JOptionPane.showInputDialog(this,
				"Input Date To \n" + "(e.g January 2010)");

		// If a string was returned, say so.
		if ((t != null) && (t.length() > 0)) {
			secondDate = t;
		}

		DateFormat format = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
		try {
			Date fDate = format.parse(firstDate);
			Date sDate = format.parse(secondDate);

			Vector<String> temp = new Vector<String>();

			for (Book book : library.getBooks()) {
				if (book.getPublicationDateObj().compareTo(fDate) > 0
						&& book.getPublicationDateObj().compareTo(sDate) < 0) {
					temp.add(book.getTitle() + " - " + book.getAuthor());
				}
			}

			ShowSearchResults results = new ShowSearchResults(temp);
			results.setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			results.setVisible(true);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			JOptionPane.showMessageDialog(this,
					"Please Input dates in format: \n (January 2010)",
					"Wrong Date Format", JOptionPane.WARNING_MESSAGE);
			return;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			JOptionPane.showMessageDialog(this,
					"Please Input dates in format: \n (January 2010)",
					"No Dates Entered", JOptionPane.WARNING_MESSAGE);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			JOptionPane.showMessageDialog(this,
					"Please Input dates in format: \n (January 2010)",
					"Something Went Wrong", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	/**
	 * Open Search By Author Dialog Window
	 * 
	 */
	public void openSearchByAuthor() {
		// TODO Auto-generated method stub

		String author = (String) JOptionPane.showInputDialog(this,
				"Enter Author Name");

		try {

			// If a string was returned, say so.
			if ((author.length() < 0)) {
				JOptionPane.showMessageDialog(this,
						"Please Enter Author's Name)", "No Input",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			Vector<String> temp = new Vector<String>();
			author = author.toLowerCase();

			for (Book book : library.getBooks()) {
				String authorX = book.getAuthor().toLowerCase();
				if (authorX.contains(author)) {
					temp.add(book.getTitle() + " - " + book.getAuthor());
				}
			}

			ShowSearchResults results = new ShowSearchResults(temp);
			results.setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			results.setVisible(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			JOptionPane.showMessageDialog(this, "Oops, Something Went Wrong.)",
					"Unknown Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	/**
	 * Open Search By Title Dialog Window
	 * 
	 */
	public void openSearchByTitle() {
		// TODO Auto-generated method stub

		String title = (String) JOptionPane.showInputDialog(this,
				"Enter Book Title");

		try {

			// If a string was returned, say so.
			if ((title.length() < 0)) {
				JOptionPane.showMessageDialog(this, "Please Enter Book Title)",
						"No Input", JOptionPane.WARNING_MESSAGE);
				return;
			}

			Vector<String> temp = new Vector<String>();
			title = title.toLowerCase();

			for (Book book : library.getBooks()) {

				String titleX = book.getTitle().toLowerCase();
				if (titleX.contains(title)) {
					temp.add(book.getTitle() + " - " + book.getAuthor());
				}
			}

			ShowSearchResults results = new ShowSearchResults(temp);
			results.setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			results.setVisible(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			JOptionPane.showMessageDialog(this, "Oops, Something Went Wrong.)",
					"Unknown Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	/**
	 * Initialise Data Bindings
	 */
	protected void initDataBindings() {
		BeanProperty<Library, List<Book>> libraryBeanProperty = BeanProperty
				.create("books");
		JListBinding<Book, Library, JList> jListBinding = SwingBindings
				.createJListBinding(UpdateStrategy.READ, library,
						libraryBeanProperty, list);
		//
		ELProperty<Book, Object> bookEvalutionProperty = ELProperty
				.create("${title} - ${author}");
		jListBinding.setDetailBinding(bookEvalutionProperty);
		//
		jListBinding.bind();
		//
		BeanProperty<JList, String> jListBeanProperty = BeanProperty
				.create("selectedElement.title");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty
				.create("text");
		AutoBinding<JList, String, JTextField, String> autoBinding = Bindings
				.createAutoBinding(UpdateStrategy.READ, list,
						jListBeanProperty, txtTitle, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<JList, String> jListBeanProperty_1 = BeanProperty
				.create("selectedElement.author");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty
				.create("text");
		AutoBinding<JList, String, JTextField, String> autoBinding_1 = Bindings
				.createAutoBinding(UpdateStrategy.READ, list,
						jListBeanProperty_1, txtAuthor,
						jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<JList, String> jListBeanProperty_2 = BeanProperty
				.create("selectedElement.publisher");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty
				.create("text");
		AutoBinding<JList, String, JTextField, String> autoBinding_2 = Bindings
				.createAutoBinding(UpdateStrategy.READ, list,
						jListBeanProperty_2, txtPublisher,
						jTextFieldBeanProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<JList, Double> jListBeanProperty_4 = BeanProperty
				.create("selectedElement.price");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty
				.create("text");
		AutoBinding<JList, Double, JTextField, String> autoBinding_4 = Bindings
				.createAutoBinding(UpdateStrategy.READ, list,
						jListBeanProperty_4, txtPrice, jTextFieldBeanProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<JList, String> jListBeanProperty_3 = BeanProperty
				.create("selectedElement.publicationDate");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty
				.create("text");
		AutoBinding<JList, String, JTextField, String> autoBinding_3 = Bindings
				.createAutoBinding(UpdateStrategy.READ, list,
						jListBeanProperty_3, txtDateOfPub,
						jTextFieldBeanProperty_3);
		autoBinding_3.bind();
	}
}