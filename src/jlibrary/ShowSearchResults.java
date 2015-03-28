package jlibrary;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author Darlington Moyo
 *
 */
public class ShowSearchResults extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instance attributes used in this example
		private	JPanel		topPanel;
		private	JList<String>		listbox;

		
		/**
		 * Shows Search Results
		 * 
		 * @param listData
		 */
		public ShowSearchResults(Vector<String> listData)
		{
			
			setTitle( "Your Search Results" );
			setSize(500, 300);
			setBackground( Color.gray );
			
			topPanel = new JPanel();
			getContentPane().add( topPanel );
			GridBagLayout gbl_topPanel = new GridBagLayout();
			gbl_topPanel.columnWidths = new int[]{91, 300, 0, 0};
			gbl_topPanel.rowHeights = new int[]{72, 239, 0, 0};
			gbl_topPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_topPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			topPanel.setLayout(gbl_topPanel);
			
			
						listbox = new JList<String>( listData );
						GridBagConstraints gbc_listbox = new GridBagConstraints();
						gbc_listbox.insets = new Insets(0, 0, 5, 5);
						gbc_listbox.fill = GridBagConstraints.BOTH;
						gbc_listbox.gridx = 1;
						gbc_listbox.gridy = 1;
						topPanel.add( listbox, gbc_listbox );
		}


}
