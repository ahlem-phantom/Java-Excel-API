package test;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;
import java.awt.BorderLayout;




public class tt extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNew, mntmClose, mntmImport, mntmExport, mntmExit;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    }
	    catch (ClassNotFoundException e) {
	    }
	    catch (InstantiationException e) {
	    }
	    catch (IllegalAccessException e) {
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt frame = new tt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	//Image Insertion
	private static ImageIcon loadImageIcon(String fileName)
	{
		return new ImageIcon(tt.class.getResource("images/" + fileName));
	}
	*/
	

	//Import 
	private void Import(Object sender, EventObject e)
	{
		JFileChooser dlg = new JFileChooser();
		dlg.addChoosableFileFilter(new FileNameExtensionFilter("Excel .xlsx", ".xlsx"));
		dlg.setDialogTitle("Import Worksheet");
		if (dlg.showDialog(this, "Import") == JFileChooser.APPROVE_OPTION)
		{
			final int lastIndexOfDot = dlg.getSelectedFile().getPath().lastIndexOf('.');
			String ext = lastIndexOfDot == -1 ? ((FileNameExtensionFilter)dlg.getFileFilter()).getExtensions()[0] :
					dlg.getSelectedFile().getPath().substring(lastIndexOfDot).toLowerCase();
			String filepath = lastIndexOfDot == -1 ? dlg.getSelectedFile().getPath():
				dlg.getSelectedFile().getPath().substring(0, lastIndexOfDot);
			try
			{
				if  (ext.equals(".xlsx"))
				{}
			
				else
				{
				}
			}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(this, 
							String.format("Import failed.%s%s", "\n\r", ex.toString()),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
	}
	}
	
	
	/*
	//Export 
	private void export(Object sender, EventObject e)
	{
		JFileChooser dlg = new JFileChooser();
		dlg.addChoosableFileFilter(new FileNameExtensionFilter("Excel .xlsx", ".xlsx"));
		dlg.setDialogTitle("Export Worksheet");
		if (dlg.showDialog(this, "Export") == JFileChooser.APPROVE_OPTION)
		{
			final int lastIndexOfDot = dlg.getSelectedFile().getPath().lastIndexOf('.');
			String ext = lastIndexOfDot == -1 ? ((FileNameExtensionFilter)dlg.getFileFilter()).getExtensions()[0] :
					dlg.getSelectedFile().getPath().substring(lastIndexOfDot).toLowerCase();
			String filepath = lastIndexOfDot == -1 ? dlg.getSelectedFile().getPath():
				dlg.getSelectedFile().getPath().substring(0, lastIndexOfDot);
			try {
				if (ext.equals(".pdf"))
				{}
				else if (ext.equals(".xlsx"))
				{}
				else if (ext.equals(".ods"))
				{}
				else if (ext.equals(".xhtml"))
				{
				}
				else if (ext.equals(".mhtml"))
				{
					
				}
				else
				{
				}
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(this, 
					String.format("Import failed.%s%s", "\n\r", ex.toString()),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	*/
	
	
	
	//Exit 
	private void onExit(Object sender, EventObject e)
	{
		this.dispose();
	}


	private void onNewWorkbook(Object sender, EventObject e)
	{
		int result = JOptionPane.showConfirmDialog(this, 
				"This will discard all data in the present workbook." + System.lineSeparator() + "Are you sure you want to continue?", 
				"Warning", JOptionPane.YES_NO_OPTION);
	}

	// Close 
	private void onCloseWorkbook(Object sender, EventObject e)
	{
	}
	
	public tt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 620);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
	//	mntmNew.setIcon(loadImageIcon("DocumentHS.png"));
		mntmNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mntmNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				onNewWorkbook(mntmNew, e);
			}
		});
		mnNewMenu.add(mntmNew);
		
		mnNewMenu.addSeparator();
		
		JMenuItem mntmClose = new JMenuItem("Close ");
		mntmClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				onCloseWorkbook(e.getSource(), e);
			}
		});
		mnNewMenu.add(mntmClose);
		
		mnNewMenu.addSeparator();
		
		//**//
		JMenuItem mntmImport = new JMenuItem("Import ...");
		mntmImport.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Import(mntmImport, e);
			}
		});
		mnNewMenu.add(mntmImport);
		
		mnNewMenu.addSeparator();
		//**//
		JMenuItem mntmExport = new JMenuItem("Export ...");
		mntmExport.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			//	export(mntmExport, e);
			}
		});
		mnNewMenu.add(mntmExport);
		
		mnNewMenu.addSeparator();
		
		//**//
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				onExit(mntmExit, e);
			}
		});
		mnNewMenu.add(mntmExit);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);
	}
	

}
