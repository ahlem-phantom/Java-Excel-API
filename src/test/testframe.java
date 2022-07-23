package test;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.util.CellRangeAddress;
import org.quinto.swing.table.model.ModelRow;

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
	 boolean valChange;
	 ModelRow changedRows[];
	 String accValue;
	 Display display;
	 dataAcquisition datac;
	 long fileSizeLimit;
	

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
		super("OCO files manager");
	//this.getContentPane().setLayout(new GridBagLayout());
		//GridBagLayout lay=new GridBagLayout();
		//GridBagConstraints c = new GridBagConstraints();//original
		this.layout=layout;
		getContentPane().setLayout(layout);
		//System.out.println("12345 "+this.getName() +" "+this.getLayout().toString());
		//System.out.println("12345 "+this.getName() +" "+this.getContentPane().getLayout().toString());
		
		//Import frer =new Import(layout,this, c);
		datac = new dataAcquisition();
		
		frame=this;
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("File");
		menuBar.add(mnFichier);
		
		JMenu mnImport = new JMenu("Import");
		mnImport.setName("Import");
		mnFichier.add(mnImport);
		
		JMenuItem mntmTemplateWithData = new JMenuItem("Template with data");
		mntmTemplateWithData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
				//Import frer =new Import();
					fileChooser(mnImport.getName());
					//System.out.println("GETNAME "+mnImport.getName());
					Import frer =new Import(layout,frame, c,path,valChange,fileSizeLimit);
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
		
		JMenuItem mntmDefineFileSize = new JMenuItem("Define file size limit");
		mntmDefineFileSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				fileSizeLimit = Long.parseLong(JOptionPane.showInputDialog(null, "Please insert the file size limit"));
			}
		});
		mnImport.add(mntmDefineFileSize);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mntmExport.setName("Export");
		mntmExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				fileChooser(mntmExport.getName());
				

				
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
				accValue=datac.IDValueIs();
//				JOptionPane.showMessageDialog(null,"Table view window test phase "+accValue);
				
	  		   //Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions,changedRows,accValue);
			    display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions,changedRows,datac);
	  			display.tableDisplay();
//	  			System.out.println("woofles2 "+layout+" 1 "+frame+" 2 "+columnHeaders+" 3 "+table+" 4 "+c+" 5 "+cellAdList+" 6 "+tabDimensions+" 7 "+tabHeaderContent[0][0]+" 8 "+tabHeaderContentDimensions); //originally operational for testing purposes
				
			
				//JTable tab = new JTable();
				
			}
		});
		
	//	thehandler handler = new thehandler();
	//	mntmRegularView.addMouseListener(handler);
		
	//	tableViewHandler tvHandler = new tableViewHandler();
		
		
		mnDisplay.add(mntmTableView);
		
		JMenu mnMore = new JMenu("More");
		menuBar.add(mnMore);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String html="<html><body width='%1s'><h1>About OCO files manager</h1>"+"This application was developped by: <br><br>"+"<p> Majdi Bahrouni <br><br>"+"<p> Ahlem Laajili <br><br>"+"<p> Syrine Ben Ahmed <br><br>"+"<p> Nourhene Abbes <br><br>"+"<p>as as the main task of their summer internhip session of 2019 at HUAWEI TECH INVESTMENT CO LTD, mentored by Nizar Shabeni.";
		//		JOptionPane.showMessageDialog(null, "This application was developped by: "+"<p> Majdi Bahrouni "+"<p> Ahlem Laajili "+"<p> Syrine Ben Ahmed "+"<p> Nourhene Abbes "+"<p>as as the main task of their summer internhip session of 2019 in HUAWEI TECH INVESTMENT CO LTD, mentored by Nizar Shabeni.");
				 int w = 175;
				 JOptionPane.showMessageDialog(null, String.format(html, w, w));
			}
		});
		mnMore.add(mntmAbout);
	
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
//			JOptionPane.showMessageDialog(null,"table view test window "+accValue);
  		//	Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions,changedRows,accValue);
			display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions,changedRows,datac);
  			display.regularDisplay();
//  			System.out.println("woofles1 "+layout+" 1 "+frame+" 2 "+columnHeaders+" 3 "+table+" 4 "+c+" 5 "+cellAdList+" 6 "+tabDimensions+" 7 "+tabHeaderContent[0][0]+" 8 "+tabHeaderContentDimensions);//originally operational for testing purposes
  			
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
			JOptionPane.showMessageDialog(null,path +" is imported, now please select the desired display option");
			
		}
		else {
			JOptionPane.showMessageDialog(null,"operation cancelled" );
		}
		
	
	}
	
	
}
