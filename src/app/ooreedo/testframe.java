package app.ooreedo;

//import java.awt.BorderLayout;
import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.quinto.swing.table.view.JBroTable;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
//import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

public class testframe extends JFrame {

	LayoutManager layout;
	
//	Import frer =new Import();
	List<String> tab= new ArrayList<String>();
	//private JTable table;//obselete


	 String columnHeaders[];
	 String table [][]=null;
	 List<CellRangeAddress> cellAdList;
	 int tabDimensions[];
	 String tabHeaderContent[][]=null;
	 int tabHeaderContentDimensions[];
	 JFrame frame;
	 GridBagConstraints c = new GridBagConstraints();
	 String path;
	JTable jTable11;
	JBroTable tableb;
	String[][] fullTable;
	CellStyle cs ;
	//String fullTable[][];

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testframe frame = new testframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public testframe(LayoutManager layout) {
	//this.getContentPane().setLayout(new GridBagLayout());
		//GridBagLayout lay=new GridBagLayout();
		//GridBagConstraints c = new GridBagConstraints();//original
		this.layout=layout;
		getContentPane().setLayout(layout);
		//System.out.println("12345 "+this.getName() +" "+this.getLayout().toString());
		//System.out.println("12345 "+this.getName() +" "+this.getContentPane().getLayout().toString());
		
		//Import frer =new Import(layout,this, c);
		frame=this;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("File");
		menuBar.add(mnFichier);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New template");
		mnFichier.add(mntmNewMenuItem);
		
		JMenu mnImport = new JMenu("Import");
		mnImport.setName("Import");
		mnFichier.add(mnImport);
		
		JMenuItem mntmTemplate = new JMenuItem("Template");
		mnImport.add(mntmTemplate);
		
		JMenuItem mntmTemplateWithData = new JMenuItem("Template with data");
		mntmTemplateWithData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
				//Import frer =new Import();
					fileChooser(mnImport.getName());
					//System.out.println("GETNAME "+mnImport.getName());
					Import frer =new Import(layout,frame, c,path);
				frer.imprt();
				
				columnHeaders=frer.getColumnHeaders();
				table=frer.getTable();
				cellAdList=frer.getCellAdList();
				tabDimensions=frer.getTabDimensions();
				tabHeaderContent=frer.getTabHeaderContent();
				tabHeaderContentDimensions=frer.getTabHeaderContentDimensions();
				
				
				
				}
				catch(Exception r){
					System.out.println("frrrrr "+r.toString());
					
				}
			}
		});



		
		mnImport.add(mntmTemplateWithData);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mntmExport.setName("Export");
		mntmExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				fileChooser(mntmExport.getName());
				System.out.println("tableb "+tableb.getName());
			export exp=new export(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions,path);
			try {
			exp.export();
			}
					catch (Exception e) {
						System.out.println("TestFrame export erreur "+e);
						}
			
				
			}
		});
		mnFichier.add(mntmExport);
		
		JMenu mnDisplay = new JMenu("Display");
		menuBar.add(mnDisplay);
		
		JMenuItem mntmRegularView = new JMenuItem("Regular view");
		
		//mntmRegularView.addMouseListener(handler);
		mnDisplay.add(mntmRegularView);
		thehandler handler = new thehandler();
		mntmRegularView.addMouseListener(handler);
		/*
		mntmRegularView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Row row row you boat the fuck away from me");
				JOptionPane.showMessageDialog(null,"Row row row your boat the fuck away from me");
	  			Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions);
	  			display.regularDisplay();
				
			
				//JTable tab = new JTable();
				
			}});*/
		
		JMenuItem mntmTableView = new JMenuItem("Table view");

		
		
		mntmTableView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
//				System.out.println("Row row row you boat the fuck away from me");
				JOptionPane.showMessageDialog(null,"Table view window test phase");
	  			Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions);
	  			display.tableDisplay();
	  			tableb=display.getJBrotableTable();
	  			System.out.println("woofles2 "+layout+" 1 "+frame+" 2 "+columnHeaders+" 3 "+table+" 4 "+c+" 5 "+cellAdList+" 6 "+tabDimensions+" 7 "+tabHeaderContent[0][0]+" 8 "+tabHeaderContentDimensions);
				
			
				//JTable tab = new JTable();
				
			}
		});
		
	//	thehandler handler = new thehandler();
	//	mntmRegularView.addMouseListener(handler);
		
	//	tableViewHandler tvHandler = new tableViewHandler();
		
		
		mnDisplay.add(mntmTableView);
	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		System.out.println("12345 "+ this.getContentPane().getLayout().toString());
		
		
		
		

		


		
		
		

		

	}
	
	private class thehandler implements MouseListener {
		
		
		public void mouseClicked (MouseEvent event) {
			//System.out.println("It worked! My time machine worked!");
			//JOptionPane.showMessageDialog(null,"It worked! My time machine worked!");
			
		}
		
		public void mouseEntered (MouseEvent event) {
		//	System.out.println("It worked! My time machine worked!");
			//JOptionPane.showMessageDialog(null,"It worked! My time machine worked!");
		}
		public void mouseExited (MouseEvent event){
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub			
//			System.out.println("It worked! My time machine worked!");
			JOptionPane.showMessageDialog(null,"table view test window");
  			Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions);
  			display.regularDisplay();
  			System.out.println("woofles1 "+layout+" 1 "+frame+" 2 "+columnHeaders+" 3 "+table+" 4 "+c+" 5 "+cellAdList+" 6 "+tabDimensions+" 7 "+tabHeaderContent[0][0]+" 8 "+tabHeaderContentDimensions);
  			
		}
		
	}
	
	
	private class tableViewHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "abah");
			
		}
		public tableViewHandler() {
			// TODO Auto-generated constructor stub
		}
		
		
		
	}
	
	public void fileChooser (String operationName) {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Excel .xlsx", ".xlsx"));
		//fc.setDialogTitle("Import");//original
		//if (fc.showDialog(null, "Import") == JFileChooser.APPROVE_OPTION) {//original
		
		fc.setDialogTitle(operationName);
		if (fc.showDialog(null, operationName) == JFileChooser.APPROVE_OPTION) {
		
			//String path = fc.getSelectedFile().toString();
			path = fc.getSelectedFile().getPath();
			JOptionPane.showMessageDialog(null,path );
			
		}
		else {
			JOptionPane.showMessageDialog(null,"operation cancelled" );
		}
		
	
	}
	
	
}
