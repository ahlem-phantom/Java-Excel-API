package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.commons.math3.genetics.SelectionPolicy;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.quinto.swing.table.model.IModelFieldGroup;
import org.quinto.swing.table.model.ModelData;
import org.quinto.swing.table.model.ModelField;
import org.quinto.swing.table.model.ModelFieldGroup;
import org.quinto.swing.table.model.ModelRow;
import org.quinto.swing.table.view.JBroTable;

public class Display {
	
	LayoutManager layout;
	JFrame frame;
	JTable table;
	String[] tab;
	String[][] fullTable;
	JPanel tablePane;
	GridBagConstraints c;
	List<CellRangeAddress> cellAdList = new ArrayList<CellRangeAddress>();
	int tabDimensions[]= new int[4];
	String [][] tabHeaderContent;
	int tabHeaderContentDimensions[]= new int[2];
	int textFieldSize= 20;
	 JPanel stationDetailListing[];
	 JTextField [] fieldsList;
	 String x=null;
	 boolean bol;
	 int col;
	 ModelRow rows[];
	 boolean valChange;
	 ModelRow changedRows[];
	 String accValue;
	 dataAcquisition datac;
	 JBroTable tableb;
	 JTextField StationIdValue = new JTextField(20);
	
	ListSelectionModel model;
	
	public Display(LayoutManager layout,JFrame frame,String[] tab, String[][] fullTable, GridBagConstraints c, List<CellRangeAddress> cellAdList, int tabDimensions[], String tabHeaderContent[][], int tabHeaderContentDimensions[], ModelRow changedRows[],dataAcquisition datac) {
		this.layout=layout;
		this.frame=frame;
		this.tab=tab;
		this.fullTable=fullTable;
		//this.c=c;
		this.cellAdList=cellAdList;
		this.tabDimensions=tabDimensions;
		this.tabHeaderContent=tabHeaderContent;
		this.tabHeaderContentDimensions=tabHeaderContentDimensions;
		this.changedRows=changedRows;
		//this.accValue=accValue;
		this.datac=datac;
		
		
		
		frame.setLayout(layout);
	}
	
	public void tableDisplay() {
byte rgb[]=new byte[] {(byte)255,(byte)0,(byte)0};
//Color col = new Color(255, 0, 0);
//JOptionPane.showMessageDialog(null, "coloris "+(((XSSFColor)IndexedColors.BLUE.getIndex()).getARGBHex());

		if (fullTable==null)
			JOptionPane.showMessageDialog(null, "There is no data imported!");
		else {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		c =new GridBagConstraints();
		
	//  frame.removeAll();
	//    frame.revalidate();
	//    frame.repaint();
		
	JButton button = new JButton("frer");
//	System.out.println("moufrer "+ tab.length+" "+ tab[0]);
//	System.out.println("moufrer "+ fullTable.length+" "+ fullTable[0][0]);
//	for(int j=0;j<5;j++)//loop causing troubles, to be deleted
	
//	System.out.println(tab[j]);
//	Iterator<CellRangeAddress> l= cellAdList.iterator();
	
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
	
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	
	
	/*
	//original operating grid
	c.gridx=0;
	c.gridy=0;
	c.weightx=1;
	c.weighty=1;
	c.anchor=(GridBagConstraints.FIRST_LINE_START);
	frame.add(button,c);
	*/
	
	
	//CellReference cr = new CellReference("A1","B1");
	
	
	
	
//	System.out.println("moufrerdisp "+fullTable.length + " "+tabDimensions.toString());
	String[] col =new String[tabDimensions[1]];
	for (int i=0;i<tabDimensions[1];i++)
		col[i]="";
		
	
//	table = new JTable(data,tab);
//	DefaultTableModel model = new DefaultTableModel();
    JTable table2 = new JTable(fullTable,col);
    
    
 //   for (int i=0;i<fullTable.
    
    
//	table.setFillsViewportHeight(true);
	table2.setFillsViewportHeight(true);
    table2.setPreferredSize(new Dimension(250, 200));
	//table2.setauto
	
     JScrollPane scrollPane = new JScrollPane(table2);
     scrollPane.setPreferredSize(new Dimension(250, 200));
   // table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	//table.setVisible(true);
	//table2.setVisible(true);
	//frame.add(table.getTableHeader(), BorderLayout.PAGE_START);//operational
	//frame.add(table, BorderLayout.CENTER);
	
	
	//button.setSize(200, 50);
	//button.setVisible(true);
	//frame.add(button,BorderLayout.CENTER);
	//frame.add(table,BorderLayout.CENTER);//operational
//	frame.add(table2,BorderLayout.CENTER);
//	System.out.println("moufrerdisp dm");
//	frame.add(button,BorderLayout.SOUTH);
	
	
	
	/*DefaultTableModel dm = new DefaultTableModel();
	dm.setDataVector(fullTable, col);
	JTable testab = new JTable (dm) {
		protected JTableHeader CreateDefaultTableHeader () {return new GroupableTableHeader(columnModel);}
	};
	
	GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();*///original unfinished trial
	
/*	DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(new Object[][]{
      {"119","foo","bar","ja","ko","zh"},
      {"911","bar","foo","en","fr","pt"}},
    new Object[]{"SNo.","1","2","Native","2","3"});

    System.out.println("moufrerdisp dm in");
    
	JTable table = new JTable( dm ) {
	      protected JTableHeader createDefaultTableHeader() {
	          return new GroupableTableHeader(columnModel);
	      }
	    };*///original working prototype
	
	DefaultTableModel dm = new DefaultTableModel();
//	dm.setDataVector(fullTable, col);
	dm.setDataVector(fullTable, new Object[]{"SNo.","1","2","Native","2"});
	//dm.setDataVector(fullTable, new Object[]{"SNo.","1","2","Native","2","3"});
	JTable table = new JTable (dm) {
		protected JTableHeader createDefaultTableHeader () {return new GroupableTableHeader(columnModel);}
	};
	
	//working up until this point
	TableColumnModel cm = table.getColumnModel();
    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
    ColumnGroup headerTopLine[]=new ColumnGroup[tabHeaderContentDimensions[1]];
  
    try {
   // 	   UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
/*
    	    // Hierarchically create columns and column groups.
    	    // Each node of columns tree is an instance of IModelFieldGroup.
    	    // Leafs are always ModelFields.
    	    // Roots can be either ModelFields or ModelFieldGroups.
    	    IModelFieldGroup groups[] = new IModelFieldGroup[] {
    	      new ModelFieldGroup( "A", "A" )
    	        .withChild( new ModelField( "B", "B" ) )
    	        .withChild( new ModelField( "C", "C" ).withRowspan( 2 ) ), // Custom rowspan set.
    	      new ModelFieldGroup( "D", "D" )
    	        .withChild( new ModelField( "E", "E" ) )
    	        .withChild( new ModelField( "F", "F" ) ),
    	      new ModelField( "G", "G" ),
    	      new ModelFieldGroup( "H", "H" )
    	        .withChild( new ModelFieldGroup( "I", "I" )
    	                      .withChild( new ModelField( "J", "J" ) ) )
    	        .withChild( new ModelField( "K", "K" ) )
    	        .withChild( new ModelFieldGroup( "L", "L" )
    	                      .withChild( new ModelField( "M", "M" ) )
    	                      .withChild( new ModelField( "N", "N" ) ) )
    	    };
*/
    	
    	/*
	    IModelFieldGroup groups[] = new IModelFieldGroup[] {
	    	      new ModelFieldGroup( "A", "A" ).withChild( new ModelField( "E", "E" ) )
	    	        .withChild( new ModelField( "F", "F" ) ).withChild( new ModelField( "G", "G" ) )
	    	        .withChild( new ModelField( "Q", "Q" ) )    	        .withChild( new ModelField( "Z", "Z" ) )
	    	        .withChild( new ModelField( "R", "Fu" ) )    	        .withChild( new ModelField( "C", "C" ) )
	    	        .withChild( new ModelField( "J", "J" ) )    	        .withChild( new ModelField( "H", "H" ) )
	    	        .withChild( new ModelField( "N", "N" ) )    	        .withChild( new ModelField( "U", "U" ) )
	    	        .withChild( new ModelField( "M", "Fu" ) )    	        .withChild( new ModelField( "O", "O" ) )
	    	        .withChild( new ModelField( "PO", "Fu" ) )

	    	    };
    	*/
    	
    	/*// operational
    	ModelFieldGroup mod = new ModelFieldGroup ("A","A");
    	mod.withChild( new ModelField( "1", "caption" ) );
    	mod.withChild( new ModelField( "2", "oh" ) );
    	mod.withChild( new ModelField( "3", "ya" ) );
    	mod.withChild( new ModelField( "4", "3alem" ) );
    	mod.withChild( new ModelField( "5", "caption" ) );
    	mod.withChild( new ModelField( "6", "caption" ) );
    	mod.withChild( new ModelField( "7", "caption" ) );
    	ModelFieldGroup mod2 = new ModelFieldGroup ("B","Alcool");
    	mod2.withChild( new ModelField( "8", "caption" ) );
    	mod2.withChild( new ModelField( "9", "caption" ) );
    	mod2.withChild( new ModelField( "10", "caption" ) );
    	mod2.withChild( new ModelField( "11", "caption" ) );
    	mod2.withChild( new ModelField( "12", "caption" ) );
    	mod2.withChild( new ModelField( "13", "caption" ) );
    	ModelFieldGroup mod3[]= new ModelFieldGroup[2];
    	mod3[0]=mod;
    	mod3[1]=mod2;
   	 IModelFieldGroup groups[] = mod3 ;//same
    	// IModelFieldGroup groups[] = new IModelFieldGroup[] {mod,mod2};//same
    	 
    	*/
    	//ModelFieldGroup mod[]=new ModelFieldGroup[tabHeaderContentDimensions[1]];
    	//Object mod[]=new ModelFieldGroup[tabHeaderContentDimensions[1]];//obselete
    	
    	 IModelFieldGroup groups[]= new IModelFieldGroup [tabHeaderContentDimensions[1]];
    	ModelFieldGroup mod[]=new ModelFieldGroup[tabHeaderContentDimensions[1]];
    	for (int i=0;i<=tabHeaderContentDimensions[1];i++) {
    		System.out.println("ALPHA ");
    		
    		if(tabHeaderContent[0][i]!=null) {
 //   			System.out.println(tabHeaderContent[0][i]+" tabhdr "+ tabHeaderContentDimensions[0]+" "+tabHeaderContentDimensions[1]);//original
    			int j=1;
    			System.out.println("ALPHA2 "+tabHeaderContent[0][i]);
    	//		mod[i]= new ModelFieldGroup(tabHeaderContent[0][i],tabHeaderContent[0][i]);
    			//System.out.println(tabHeaderContent[j][i]+" tabhdr "+ tabHeaderContentDimensions[0]+" "+tabHeaderContentDimensions[1]);
    			if ((tabHeaderContent[j][i]!=null)) {
    				//mod[i]= new ModelFieldGroup(tabHeaderContent[0][i],tabHeaderContent[0][i]);
    				System.out.println("BRAVO6 "+tabHeaderContent[j][i]);
    				ModelFieldGroup mod2=new ModelFieldGroup(tabHeaderContent[0][i],tabHeaderContent[0][i]);
    			while((tabHeaderContent[j][i]!=null)&(j<=tabHeaderContentDimensions[0]+1)) {
    				
    				
    				System.out.println("stuck in while "+tabHeaderContent[j][i]+" j "+j+" dim "+ tabHeaderContentDimensions[0]+" "+i+" "+j);
    				System.out.println("putting "+tabHeaderContent[j][i]+" as child of "+ tabHeaderContent[0][i]);
    				mod2.withChild(new ModelField(i+tabHeaderContent[j][i]+j,tabHeaderContent[j][i]));
    				j++;
    				
    				if((j>tabHeaderContentDimensions[0]+1))
    					break;
    				
    				
    			}
    			groups[i]=mod2;
    		}
    			else
    			{
    				System.out.println(tabHeaderContent[0][i]+" tabhdr "+ tabHeaderContentDimensions[0]+" "+tabHeaderContentDimensions[1]);
    				groups[i]=new ModelField(tabHeaderContent[0][i],tabHeaderContent[0][i]);
    			//	mod[i]= new ModelField(tabHeaderContent[0][i],tabHeaderContent[0][i]);
    //			System.out.println(tabHeaderContent[j][i]+" tabhdr2 "+ tabHeaderContentDimensions[0]+" "+tabHeaderContentDimensions[1]);
    			}
    			}
    			
    		
        	}
    	 //IModelFieldGroup groups[] = mod ;//same
    	
    	System.out.println("Charlie");
    	
    	
    	    // Get leafs of columns tree.
    	    ModelField fields[] = ModelFieldGroup.getBottomFields( groups );

    	    
    	    /*
    	    // Sample data.
    	    ModelRow rows[] = new ModelRow[ 10 ];
    	    for ( int i = 0; i < rows.length; i++ ) {
    	      rows[ i ] = new ModelRow( fields.length );
    	      for ( int j = 0; j < fields.length; j++ )
    	        rows[ i ].setValue( j, fields[ j ].getCaption() + i );
    	    }
    	    */
    	    
    	//    ModelRow rows[] = new ModelRow [tabDimensions[0]- tabHeaderContentDimensions[0]]; //original
    	   // ModelRow rows[] = new ModelRow [tabDimensions[0]- tabDimensions[2]];//originally operational;
    	    System.out.println("bolbol is "+valChange);
    	    if (valChange)
    	    	rows=changedRows;
    	    else
    	    	rows = new ModelRow [tabDimensions[0]- tabDimensions[2]];
    	    
    	    System.out.println("Delta "+rows.length+" "+fields.length+ " dim "+ tabDimensions[0]+" "+tabDimensions[1]+" "+tabHeaderContentDimensions[0]+" "+tabDimensions[2]);
    	    System.out.println("Delta2 "+(tabDimensions[0]- tabDimensions[2]));
    	    
    	    /*
    	    for ( int i = tabHeaderContentDimensions[0]; i < tabDimensions[0]; i++ ) {
      	      rows[ i- tabHeaderContentDimensions[0] ] = new ModelRow( tabDimensions[1] );
      	      for ( int j = 0; j < tabDimensions[1]; j++ )
      	        rows[ i- tabHeaderContentDimensions[0] ].setValue( j, fullTable[i][j] );
    	    }
    	    */
    	    for ( int i = tabDimensions[2]; i < tabDimensions[0]; i++ ) {
  //  	    	System.out.println("golf "+i+" "+tabDimensions[0]);
        	      rows[ i- tabDimensions[2] ] = new ModelRow( tabDimensions[1] );
        	    //  System.out.println("postgolf");
        	      for ( int j = 0; j < tabDimensions[1]; j++ ) {
        	    //	  System.out.println("pregeorge "+i+" "+j);
        	    //	  System.out.println("george "+j +" "+fullTable[i][j]);
        	        rows[ i- tabDimensions[2] ].setValue( j, fullTable[i][j] );
        	        }
      	    }
    	    
    	    System.out.println("echo");
    	    
    	    
    	    // Table.
    	    ModelData datab = new ModelData( groups );
    	    datab.setRows( rows );
    	    //JBroTable tableb = new JBroTable( datab );//originally operational
    	    tableb = new JBroTable( datab );
    	    
    	    tableb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //	    tableb.setEnabled(false);
    	    
    	    frame.add( new JScrollPane( tableb ) );
    	    JScrollPane scrollPane2 = new JScrollPane(tableb);
   
    	    /*//obselete
    	    String text=("System.out.println(\"ROBOT\");");
    	    Robot robot= new Robot();
    	    for (char c : text.toCharArray()) {
    	        int keyEvent = KeyEvent.getExtendedKeyCodeForChar(c);
    	        robot.keyPress(keyEvent);
    	        }
    	     */

  /*  
	for (int i=0;i<tabHeaderContentDimensions[1];i++) {
		
//		ColumnGroup g_name = new ColumnGroup(tabHeaderContent[0][i]);
//System.out.println(tabHeaderContent[0][i]+" tnt");
	//    header.addColumnGroup(g_name);
int j=1;
headerTopLine[i] = new ColumnGroup(tabHeaderContent[0][i]);
//if()
//System.out.println(tabHeaderContent[0][i]+" tnt");
headerTopLine[i].add(cm.getColumn(i+1));
//headerTopLine[i].add(cm.getColumn(1));
//headerTopLine[i].add(cm.getColumn(2));
//headerTopLine[i].add(cm.getColumn(3));
//headerTopLine[i].add(cm.getColumn(4));
header.addColumnGroup(headerTopLine[i]);

		}
/*	
	ColumnGroup g_name = new ColumnGroup("Name");
	g_name.add(cm.getColumn(1));
	header.addColumnGroup(g_name);
	ColumnGroup others = new ColumnGroup("Name");
others.add(cm.getColumn(3));
	header.addColumnGroup(others);*/
	
	/*
	
	for (int i=0;i<tabHeaderContentDimensions[1];i++) {
		
//		ColumnGroup g_name = new ColumnGroup(tabHeaderContent[0][i]);
System.out.println(headerTopLine[i].getHeaderValue()+" tnt");
	//    header.addColumnGroup(g_name);

//headerTopLine[i] = new ColumnGroup(tabHeaderContent[0][i]);
//System.out.println(tabHeaderContent[0][i]+" tnt");
headerTopLine[i].add(cm.getColumn(0));
//headerTopLine[i].add(cm.getColumn(1));
//headerTopLine[i].add(cm.getColumn(2));
//headerTopLine[i].add(cm.getColumn(3));
//headerTopLine[i].add(cm.getColumn(4));
header.addColumnGroup(headerTopLine[i]);

		}
	
	/*

		
	/*
	    TableColumnModel cm = table.getColumnModel();
	    ColumnGroup g_name = new ColumnGroup("Name");
	    System.out.println("moufrerdisp dm in");
//	    g_name.add(cm.getColumn(1));
//	    g_name.add(cm.getColumn(2));
	    g_name.add(cm.getColumn(0));
	    g_name.add(cm.getColumn(1));
	    g_name.add(cm.getColumn(2));
	    g_name.add(cm.getColumn(3));
	    g_name.add(cm.getColumn(4));
	 //   ColumnGroup g_lang = new ColumnGroup("Language");
//	    g_lang.add(cm.getColumn(3));
	//    g_lang.add(cm.getColumn(4));
//	    ColumnGroup g_other = new ColumnGroup("Others");
//	    g_other.add(cm.getColumn(4));
//	    g_other.add(cm.getColumn(5));
//	    g_lang.add(g_other);
	    */
		
//	    System.out.println("moufrerdisp dm in 2");
	    
//	    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();//operational
//	    header.addColumnGroup(g_name);//operational
	//    header.addColumnGroup(g_lang);
	 //   header.addColumnGroup(g_other);//manually added
	    JScrollPane scroll = new JScrollPane( table );
	   // getContentPane().add( scroll );
	   // setSize( 400, 120 );   
	    
	    
	 //   frame.removeAll();
	 //   frame.revalidate();
	 //   frame.repaint();
	  
//	    System.out.println("moufrerdisp dm in 3");
	    GridBagConstraints cp1=new GridBagConstraints();
	
		c.anchor=(GridBagConstraints.FIRST_LINE_START);
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.1;
	//	c.weighty=0.1;
		c.gridheight=1;
		c.gridwidth=1;
		c.ipadx=250;
	//	c.ipady=10;
	//	c.fill = GridBagConstraints.HORIZONTAL;
		

	    
	    JPanel stationDetails = new JPanel();
	    stationDetails.setLayout(new GridBagLayout());
//	    stationDetails.setBackground(Color.RED);
	    cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
		cp1.gridx=0;
		cp1.gridy=0;
		//cp1.weightx=0.1;
		//cp1.weighty=0;
		//cp1.gridheight=1;
		//cp1.gridwidth=1;
		JLabel stationId = new JLabel ("Station ID ");
		stationDetails.add(stationId,cp1);
		
		//frame.add(stationDetails,c);
		
	    
		cp1.gridx=1;
		cp1.gridy=0;
		//cp1.weightx=0.1;
		//cp1.weighty=0;
		//cp1.gridheight=1;
		//cp1.gridwidth=1;
		

		stationDetails.add(StationIdValue,cp1);
		stationDetails.setVisible(true);
		frame.add(stationDetails,c);
		
		tabIdHandler tabidhandler =new tabIdHandler();
		StationIdValue.addActionListener(tabidhandler);
		
		c.gridx=0;
		c.gridy=1;
		c.weightx=0.1;
		c.weighty=0.1;
		c.gridheight=1;
		c.gridwidth=1;
		c.ipady=750;
		c.fill = GridBagConstraints.HORIZONTAL;

		
		frame.add(scrollPane2,c);
	
		
		
		
		
		
		
		c.fill = GridBagConstraints.NONE;	
	c.anchor=(GridBagConstraints.FIRST_LINE_START);
	c.gridx=0;
	c.gridy=2;
	c.weightx=0.1;
	c.weighty=0.1;
	c.gridheight=1;
	c.gridwidth=1;

	//c.ipady=10;
	
	

	
	
	
	JPanel remarksPanel = new JPanel();
//	GridBagConstraints cp1=new GridBagConstraints();//original
	remarksPanel.setLayout(new GridBagLayout());
	cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
	
	JLabel lastModified = new JLabel("Last Modified: ");
	cp1.fill = GridBagConstraints.HORIZONTAL;
	
	cp1.gridx=0;
	cp1.gridy=0;
//	cp1.weightx=0.5;
//	cp1.weighty=0.1;
//	cp1.gridheight=1;
//	cp1.gridwidth=1;
	//cp1.ipadx=1;
	//cp1.ipady=1;


	lastModified.setVisible(true);
	remarksPanel.add(lastModified,cp1);

	
	cp1.gridx=0;
	cp1.gridy=1;
//	cp1.weightx=0.5;
//	cp1.weighty=0.1;
//	cp1.gridheight=1;
//	cp1.gridwidth=1;
	//cp1.ipadx=1;
	//cp1.ipady=1;
	JLabel byUser = new JLabel("By user: ");
	cp1.fill = GridBagConstraints.HORIZONTAL;
//	byUser.setVisible(true);
	remarksPanel.add(byUser,cp1);
//	remarksPanel.add(lastModified,cp1);
	
	cp1.gridx=0;
	cp1.gridy=2;
//	cp1.weightx=0.5;
//	cp1.weighty=0.1;
//	cp1.gridheight=1;
//	cp1.gridwidth=1;
	//cp1.ipadx=1;
	//cp1.ipady=1;
	JLabel contentModified = new JLabel("Content modified: ");
	cp1.fill = GridBagConstraints.HORIZONTAL;
//	byUser.setVisible(true);
	remarksPanel.add(contentModified,cp1);
	
	
//	frame.add(remarksPanel,c);
	
	
//	frame.add(button,c);
	
	/*
	c.gridx=1;
	c.gridy=0;
	c.weightx=0;
	c.weighty=0;
	c.gridheight=0;
	c.gridwidth=2;
	c.ipadx=100;
	//c.ipady=10;
*/
	//frame.add(table2,c);
	//frame.add(table2,BorderLayout.CENTER);
	
//	c.gridx=1;
//	c.gridy=0;
//	c.weightx=0;
//	c.weighty=0;
//	c.gridheight=1;
//	c.gridwidth=1;
//	c.ipadx=10;
	//c.ipady=10;

	//frame.add(scrollPane,c);//original operational
  //  frame.add( tableb.getScrollPane() );
  //  frame.pack();
   // frame.setLocationRelativeTo( null );
	//frame.add(scrollPane2,c);
	
//	frame.setVisible(true);
//	    frame.revalidate();
	 //   frame.repaint();
	frame.setVisible(true);	
	
	//model = tableb.getSelectionModel();
	tabtestlistener listener = new tabtestlistener();
	//model.addListSelectionListener(listener);
	//tableb.getModel().addTableModelListener(listener);
	tableb.addMouseListener(listener);
	accValue=datac.IDValueIs();
	if (accValue!=null) {
	//	JOptionPane.showMessageDialog(null, "notempty "+accValue);
		int val=datac.selectedRowIS();
		tableb.setRowSelectionInterval(val-tabDimensions[2], val-tabDimensions[2]);
	}
	
	
    }
    catch (Exception e)
    {
    	System.out.println("System crash "+e.toString());
    }
	
	
//	while(l.hasNext()) {
		
//	}
	
	}
}
	
public void regularDisplay() {
	if (fullTable==null)
		JOptionPane.showMessageDialog(null, "There is no data imported!");
	else {
	accValue=datac.IDValueIs();
//	JOptionPane.showMessageDialog(null, " accvalue is  "+datac.IDValueIs());
/*	 if (accValue!=null) {
	JOptionPane.showMessageDialog(null, " accvalue2 is  "+accValue);
	listFill(accValue);
}
*/
	
c = new GridBagConstraints();

frame.getContentPane().removeAll();
//frame.getContentPane().revalidate();
//frame.getContentPane().repaint();

 fieldsList= new JTextField [2*tabDimensions[3]];

//frame.removeAll();
//frame.revalidate();
//frame.repaint();
	
    GridBagConstraints cp1=new GridBagConstraints();
	
	//frame.setBackground(Color.RED);
    

	JButton button = new JButton ("test");

	c.anchor=(GridBagConstraints.FIRST_LINE_START);
//	cp1.fill = GridBagConstraints.HORIZONTAL;
	
	c.gridx=0;
	c.gridy=0;
	c.weightx=0.1;
	c.weighty=0.1;
	c.gridheight=1;
	c.gridwidth=1;
	c.fill=GridBagConstraints.VERTICAL;
	
	c.ipadx=2500;
	//c.ipady=500;

	//frame.setVisible(true);
	//frame.add(button,c);
	
	
   // JTextField inputs[] =new JTextField[tabHeaderContentDimensions[1]];
	  JLabel inputs[] =new JLabel[(tabHeaderContentDimensions[1]+1)*2];
    JPanel stationDetails = new JPanel();
    JScrollPane scrollstationDetails = new JScrollPane(stationDetails);
    
  //  scrollstationDetails.setMinimumSize(scrollstationDetails.setpr);
    
   // JPanel stationDetailListing[]= new JPanel[tabHeaderContentDimensions[1]*2];//originally operational
     stationDetailListing= new JPanel[tabHeaderContentDimensions[1]*2];
    System.out.println("jpan "+(tabDimensions[3])+" "+(tabHeaderContentDimensions[1]*2));
   
    
    
    stationDetails.setLayout(new GridBagLayout());
    
    
 //   stationDetails.setBackground(Color.RED);//originally operational for testing purposes
    
    /*
	cp1.gridx=0;
	cp1.gridy=0;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	JLabel stationId2 = new JLabel ("Station ID Regular2");
	stationDetails.add(stationId2,cp1);
	*/
	
   
    
    int l=0,idc=0;
     for(int i=0;i<tabHeaderContentDimensions[1];i++) {
    //int i=0;
    //while(i<=tabHeaderContentDimensions[1]) {
    	stationDetailListing[i*2]= new JPanel();
    	stationDetailListing[i*2].setLayout(new GridBagLayout());
    	//inputs[l]= new JLabel();
    	

    	
    	//inputs[i]= new JTextField();
    	System.out.println("abah "+tabHeaderContent[0][i]+" "+tabHeaderContentDimensions[1]+" el "+l);
    	//inputs[l].setText(tabHeaderContent[0][i]);
    	inputs[l]= new JLabel(tabHeaderContent[0][i]);
    	
    	cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
	cp1.gridx=0;
	cp1.gridy=i;
	cp1.weightx=0;
	cp1.weighty=1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	System.out.println("showingcp "+tabHeaderContent[0][i]+" "+inputs[l].getText());
	stationDetailListing[i*2].add(inputs[l],cp1);
	System.out.println("pov "+l);
	stationDetails.add(stationDetailListing[i*2],cp1);//originally operational
	
	//l++;
   // }/*
	int j=1,k=1;
	
    if (tabHeaderContent[k][i]!=null) {
    	
    	stationDetailListing[i*2+1]= new JPanel();
    	stationDetailListing[i*2+1].setLayout(new GridBagLayout());
    	
    	System.out.println("kinit "+k+" "+tabHeaderContent[k][i]+" "+tabHeaderContentDimensions[0]);
    	while ((tabHeaderContent[k][i]!=null)&(k<=tabHeaderContentDimensions[0]+1)) {
    		System.out.println("kis "+k+" "+tabHeaderContent[k][i]+" "+tabHeaderContentDimensions[0]);
    		
    	//while((tabHeaderContent[j][i]!=null)&(j<=tabHeaderContentDimensions[0])) {
    	//	k++;
    		if ((tabHeaderContent[k][i]==null)|(k>tabHeaderContentDimensions[0]))
    			break;
    		k++;
    	}
    	System.out.println("kfinal is "+k+" "+(tabHeaderContentDimensions[0]+1)+" l "+l+" "+ (tabHeaderContentDimensions[1]+1));


    	
    	int m=0;
    	while((tabHeaderContent[j][i]!=null)&(j<=k)) {
    		System.out.println("jis "+j+" "+k+" "+l+" "+tabHeaderContent[j][i] );
    	inputs[m]= new JLabel();
    	// button = new JButton ("test");//originally placed for testing purposes
    	 fieldsList[idc]= new JTextField(textFieldSize);
    	 //fieldsList[idc].setName(i+tabHeaderContent[j][i]);//originally operational
    	 fieldsList[idc].setName(Integer.toString(idc));
    	 
    	 System.out.println("handlerg "+fieldsList[idc].getName()+" "+l);

  //      	if( fieldsList[idc].getName()==tabHeaderContent[0][1]) {
          		idHandler idhandler = new idHandler();
          		System.out.println("handler0 "+tabHeaderContent[0][1]);
          		fieldsList[idc].addActionListener(idhandler);
   //       	}
    	 
    	//inputs[i]= new JTextField();
    	System.out.println("abah2 "+tabHeaderContent[j][i]+" "+tabDimensions[3]);
    	inputs[m].setText(tabHeaderContent[j][i]);
    	cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
	cp1.gridx=0;
	cp1.gridy=m;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	stationDetailListing[i*2+1].add(inputs[m],cp1);
//	stationDetails.add(stationDetailListing[i*2+1],cp1);
	
	
	cp1.gridx=1;
	cp1.gridy=m;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	stationDetailListing[i*2+1].add(fieldsList[idc],cp1);
	//stationDetailListing[i*2+1].add(button,cp1);
	
	j++;
	m++;
	idc++;
	
	if (j>k)
		break;
		
	
    	}
    cp1.gridx=1;
	cp1.gridy=i;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
    	stationDetails.add(stationDetailListing[(i*2)+1],cp1);
    	
    	l++;
    }
    else {
    	
    	stationDetailListing[i*2+1]= new JPanel();
    	stationDetailListing[i*2+1].setLayout(new GridBagLayout());
    	 button = new JButton ("test2");
    	 fieldsList[idc]= new JTextField(textFieldSize);
    	// fieldsList[idc].setName(tabHeaderContent[0][i]);// originally operational
    	 fieldsList[idc].setName(Integer.toString(idc));
    	 System.out.println("handlerg "+fieldsList[idc].getName()+" "+l);
    	 
    //   	if(fieldsList[idc].getName()==tabHeaderContent[0][1]) {
      		idHandler idhandler = new idHandler();
      		System.out.println("handler0 "+tabHeaderContent[0][1]);
      		fieldsList[idc].addActionListener(idhandler);
   //   	}
    	 
    	 cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
    	cp1.gridx=0;
    	cp1.gridy=0;
    	cp1.weightx=0.1;
    	cp1.weighty=0.1;
    	cp1.gridheight=1;
    	cp1.gridwidth=1;
    	System.out.println("putting button");
    	//stationDetailListing[i*2+1].add(button,cp1);//originally operational for testing purposes
    	stationDetailListing[i*2+1].add(fieldsList[idc],cp1);
    	System.out.println("pov2 "+l);
    	
    	
    	cp1.gridx=1;
    	cp1.gridy=i;
    	cp1.weightx=0.1;
    	cp1.weighty=0.1;
    	cp1.gridheight=1;
    	cp1.gridwidth=1;
    	stationDetails.add(stationDetailListing[(i*2)+1],cp1);
    	
    	l++;
    	idc++;
    }
	
    
	//stationDetails.add(inputs[i],cp1);
    
	
	

	
	
	
	
	//if (i>tabHeaderContentDimensions[1])
	//	break;
    }
    
    /*
	cp1.gridx=0;
	cp1.gridy=2;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	JLabel stationId2 = new JLabel ("Station ID Regular2");
	stationDetails.add(stationId2,cp1);
	*/
	
  //  frame.add(stationDetails,c);
    
    
    
//	JLabel stationId = new JLabel ("Station ID Regular");
//	stationDetails.add(stationId,cp1);
//	stationDetails.setBackground(Color.RED);
	//JButton button = new JButton ("test");
	//stationDetails.add(button,cp1);

	/*
	cp1.gridx=1;
	cp1.gridy=0;
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	JLabel stationId2 = new JLabel ("Station ID Regular2");
	stationDetails.add(stationId2,cp1);
	stationDetails.setBackground(Color.RED);
	*/
    
	//	frame.add(stationDetails,c);//original
		frame.add(scrollstationDetails,c);
	//	frame.pack();
	//	frame.repaint();
		
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.setVisible(true);

	
		 if (accValue!=null) {
//				JOptionPane.showMessageDialog(null, " accvalue2 is  "+accValue);
				listFill(accValue);
				datac.getIDValue(accValue);
			}
	
	
}
}



/*private class tabtestlistener implements ListSelectionListener {@Override
public void valueChanged(ListSelectionEvent e) {

	if (! model.isSelectionEmpty()) {
		//
		Object[] options = {"Get ID",
				"Edit" , "Cancel" };
				
				Object[] option = {"Yes ! Delete","No" ,
			    "Cancel" };
		int selrow=model.getMinSelectionIndex();
		
		JOptionPane.showMessageDialog(null, "selected row "+selrow);
		
		int selection = JOptionPane.showOptionDialog(frame, "Choose what action you will perform", null, JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
		String input  ;
		String siteID ;
		ListSelectionModel model = null;
		
		//récuperation du siteID 
		//int rowIndex = ; 
		//int columnIndex = ;
		//siteID = model.getValueAt(int rowIndex , int columnIndex) ;

		
	//la position de la cellule sélectionnée 
		//int row = ; 
		// int column = ; 
		

	if (selection == JOptionPane.YES_OPTION)
	{
	    // Code to use when Edit is PRESSED.
		   
		//	JOptionPane.showMessageDialog(null, "Selected Option is Edit");//obselete
		    
		    
		String  accValue = JOptionPane.showInputDialog(null, "new value");
		  
		JOptionPane.showMessageDialog(null, accValue);
		  //code de modification de la valeur ancienne par la nouvelle valeur 
		
		
	}
	else if (selection == JOptionPane.NO_OPTION) {
		datac.getIDValue(accValue);
	}
	}
	// TODO Auto-generated method stub
	
}
	
}*////


private class tabtestlistener implements MouseListener{
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//JBroTable tableb;//for testing purposes
		int selrow=tableb.getSelectedRow();
		int selcol=tableb.getSelectedColumn();
//		JOptionPane.showMessageDialog(null, "selected row "+selrow+" selected column "+selcol);
		
		Object[] options = {"Get ID",
				"Edit" , "Cancel" };
				
				Object[] option = {"Yes ! Delete","No" ,
			    "Cancel" };
		
//		JOptionPane.showMessageDialog(null, "selected row "+selrow);
		
		int selection = JOptionPane.showOptionDialog(frame, "Choose what action you will perform", null, JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
		String input  ;
		String siteID ;
		ListSelectionModel model = null;
		
		//récuperation du siteID 
		//int rowIndex = ; 
		//int columnIndex = ;
		//siteID = model.getValueAt(int rowIndex , int columnIndex) ;

		
	//la position de la cellule sélectionnée 
		//int row = ; 
		// int column = ; 
		

	if (selection == JOptionPane.YES_OPTION)
	{
	    // Code to use when Edit is PRESSED.
		   
		//	JOptionPane.showMessageDialog(null, "Selected Option is Edit");//obselete
		    
		accValue=fullTable[selrow+tabDimensions[2]][1];
		datac.getIDValue(accValue);
		StationIdValue.setText(accValue);
		    

		  //code de modification de la valeur ancienne par la nouvelle valeur 
		
		
	}
	else if (selection == JOptionPane.NO_OPTION) {
		String  accValue = JOptionPane.showInputDialog(null, "new value");
		  fullTable[selrow+tabDimensions[2]][selcol]=accValue;

		  tableDisplay();
		  
//		JOptionPane.showMessageDialog(null, accValue);
	}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


private class idHandler implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	/*
	if (e.getSource()==fieldsList[1])
	{
		x=e.getActionCommand();
		JOptionPane.showMessageDialog(null, " athe value inserted is "+x);
		listFill(x);
	}
	*/
	
         if (e.getSource()==fieldsList[1]) {
		 accValue=e.getActionCommand();
//			JOptionPane.showMessageDialog(null, " athe value inserted is "+datac.IDValueIs());
			listFill(accValue);
			datac.getIDValue(accValue);
	 }
	 
	
	for (int i=0;i<tabDimensions[3];i++) {
		if (i==0) {
		/*	if (e.getSource()==fieldsList[1])//original
			{
				//x=e.getActionCommand();//original
				accValue=e.getActionCommand();
				JOptionPane.showMessageDialog(null, " athe value inserted is "+accValue);
				listFill(accValue);
			}*/
		}
		if (e.getSource()==fieldsList[1])//original
		{
			
		}
		else if (e.getSource()==fieldsList[i])
		{
			x=e.getActionCommand();
//			JOptionPane.showMessageDialog(null, " athe value inserted is "+x);
			//listFill(x);
			listEdit(x,col,fieldsList[i].getName());
	}
	/*	else if (accValue!=null) {
			JOptionPane.showMessageDialog(null, " athe value inserted is "+accValue);
			listFill(accValue);
		}*/
	}
	
}
}

private class tabIdHandler implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {

         if (e.getSource()==StationIdValue) {
        	 
        	 accValue=e.getActionCommand();

 			
 			
        	 
        		for (int i=0;i<tabDimensions[0];i++) {
        			
        			if (accValue.equals(fullTable[i][1])) {
        			//y=x;
        				
        				bol=true;
        				System.out.println("xis "+(fullTable[i][1])+" "+x);
        				col=i;
        				datac.getSelectedRow(i);
        			}
        		}
        			
        			if (bol)
        			{
        				JOptionPane.showMessageDialog(null, accValue+" is found");
        				int val=datac.selectedRowIS();
        				tableb.setRowSelectionInterval(val-tabDimensions[2], val-tabDimensions[2]);
        				datac.getIDValue(accValue);
        			}
        			else
        				JOptionPane.showMessageDialog(null, "the value "+accValue+" is not found");
        			
        			
        			
        	 
		
	 }
	 
}
}


private void listFill (String x) {
	//boolean bol=false;//original
	bol=false;
	String listDisp[]= new String[tabDimensions[3]];
	//int col=0;
	col=0;
	
	for (int i=0;i<tabDimensions[0];i++) {
		
		if (x.equals(fullTable[i][1])) {
		//y=x;
			JOptionPane.showMessageDialog(null, "found "+x);
			bol=true;
			System.out.println("xis "+(fullTable[i][1])+" "+x);
			col=i;
			datac.getSelectedRow(i);
		}
		
	}
	if (bol==true) {
//		JOptionPane.showMessageDialog(null, "found "+x);
		for (int j=0;j<tabDimensions[3];j++) {
		//	if ((fullTable[col][j]!=null)) {
				System.out.println("placing "+fullTable[col][j]+" at "+fieldsList[j].getName()+" "+j+" "+tabDimensions[3]);
			fieldsList[j].setText(fullTable[col][j]);//originally operational
			
	//		stationDetailListing[j].setVisible(true);//erroneous
		//	fieldsList[j].repaint();
	//	fieldsList[j].setVisible(true);
	//		}//if closure
		//	bol=false;
		}
		
	}
	else {
		JOptionPane.showMessageDialog(null, "not found "+x);
/*	//unsettled business
	int n = JOptionPane.showConfirmDialog(
		    frame,
		    "This Site ID does not exist, would you like to add it?",
		    "Site ID not found",
		    JOptionPane.YES_NO_OPTION);
	if (n==JOptionPane.YES_OPTION) {
		valChange=true;
	//	tabHeaderContentDimensions[0]++;
		int newTabDimensions[]=new int[2];
		newTabDimensions[0]=tabDimensions[0]+1;
		newTabDimensions[1]=tabDimensions[1];
		System.out.println("freer0 " +newTabDimensions[0]+" "+ tabDimensions[0]);
		String newFullTable[][]=new String[newTabDimensions[0]][newTabDimensions[1]];
		for (int cnt=0;cnt<tabDimensions[0];cnt++){
			for (int cntc=0;cntc<tabDimensions[1];cntc++) {
				newFullTable[cnt][cntc]=fullTable[cnt][cntc];
			}
			System.out.println("freer " +newTabDimensions[0]+" "+ tabDimensions[0]);
			newFullTable[newTabDimensions[0]-1][1]="freer";//needsref
			System.out.println("freer1 " +newFullTable[newTabDimensions[0]-1][1]);

		}
		
		
		tabDimensions[0]=newTabDimensions[0];
		tabDimensions[1]=newTabDimensions[1];
	//	tabDimensions[0]++;
		
		fullTable= new String[newTabDimensions[0]][newTabDimensions[1]];
		for (int cnt=0;cnt<tabDimensions[0];cnt++){
			for (int cntc=0;cntc<tabDimensions[1];cntc++) {
				fullTable[cnt][cntc]=newFullTable[cnt][cntc];
				System.out.println("ftab "+fullTable[cnt][cntc]);
			}
		}
		//fullTable=newFullTable;//appears to be inop
		
		changedRows = rows = new ModelRow [tabDimensions[0]- tabDimensions[2]];
	}*///end of unsettled business
}
}

private void listEdit(String change, int col, String name) {
	if(bol) {
	JOptionPane.showMessageDialog(null, "Changing "+fullTable[col][Integer.valueOf(name)]+" to "+change);
	//fullTable[col][j]=x;
	
	fullTable[col][Integer.valueOf(name)]=change;
	//	fieldsList[Integer.valueOf(name)].setText(fullTable[col][Integer.valueOf(name)]);//for testing purposes
	
	
	}
	
	else
		JOptionPane.showMessageDialog(null,"Can not change value, ID not chosen");
	
}




}
