package app.ooreedo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.quinto.swing.table.model.IModelFieldGroup;
import org.quinto.swing.table.model.ModelData;
import org.quinto.swing.table.model.ModelField;
import org.quinto.swing.table.model.ModelFieldGroup;
import org.quinto.swing.table.model.ModelRow;
import org.quinto.swing.table.view.JBroTable;

public class Display {
	
	LayoutManager layout;
	JFrame frame;
	JTable jTable11;
	String[] tab;
	String[][] fullTable;
	JPanel tablePane;
	GridBagConstraints c;
	List<CellRangeAddress> cellAdList = new ArrayList<CellRangeAddress>();
	int tabDimensions[]= new int[4];
	String [][] tabHeaderContent;
	int tabHeaderContentDimensions[]= new int[2];
	int textFieldSize= 10;
	JBroTable tableb;
	
	ListSelectionModel model;
	
	public Display(LayoutManager layout,JFrame frame,String[] tab, String[][] fullTable, GridBagConstraints c, List<CellRangeAddress> cellAdList, int tabDimensions[], String tabHeaderContent[][], int tabHeaderContentDimensions[]) {
		this.layout=layout;
		this.frame=frame;
		this.tab=tab;
		this.fullTable=fullTable;
		//this.c=c;
		this.cellAdList=cellAdList;
		this.tabDimensions=tabDimensions;
		this.tabHeaderContent=tabHeaderContent;
		this.tabHeaderContentDimensions=tabHeaderContentDimensions;
		
		
		
		frame.setLayout(layout);
	}
	public void tableDisplay() {
		
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
    	    ModelRow rows[] = new ModelRow [tabDimensions[0]- tabDimensions[2]];
    	    
    	    System.out.println("Delta "+rows.length+" "+fields.length+ " dim "+ tabDimensions[0]+" "+tabDimensions[1]+" "+tabHeaderContentDimensions[0]+" "+tabDimensions[2]);
    	   
    	    /*
    	    for ( int i = tabHeaderContentDimensions[0]; i < tabDimensions[0]; i++ ) {
      	      rows[ i- tabHeaderContentDimensions[0] ] = new ModelRow( tabDimensions[1] );
      	      for ( int j = 0; j < tabDimensions[1]; j++ )
      	        rows[ i- tabHeaderContentDimensions[0] ].setValue( j, fullTable[i][j] );
    	    }
    	    */
    	    for ( int i = tabDimensions[2]; i < tabDimensions[0]; i++ ) {
    	    	System.out.println("golf "+i+" "+tabDimensions[0]);
        	      rows[ i- tabDimensions[2] ] = new ModelRow( tabDimensions[1] );
        	      for ( int j = 0; j < tabDimensions[1]; j++ )
        	        rows[ i- tabDimensions[2] ].setValue( j, fullTable[i][j] );
      	    }
    	    
    	    System.out.println("echo");
    	    
    	    
    	    // Table.
    	    ModelData datab = new ModelData( groups );
    	    datab.setRows( rows );
    	   // JBroTable tableb = new JBroTable( datab );//orignally operational
    	    tableb = new JBroTable( datab );
    	    tableb.setName("frr");
    	    
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
		c.weighty=0;
		c.gridheight=1;
		c.gridwidth=1;
	//	c.ipadx=100;
		//c.ipady=10;

	    
	    JPanel stationDetails = new JPanel();
	    
		cp1.gridx=0;
		cp1.gridy=0;
		cp1.weightx=0;
		cp1.weighty=0;
		cp1.gridheight=1;
		cp1.gridwidth=1;
		JLabel stationId = new JLabel ("Station ID");
		stationDetails.add(stationId,cp1);
		
		frame.add(stationDetails,c);
		
	    
	    
		
		
		
		c.gridx=0;
		c.gridy=1;
		c.weightx=0.1;
		c.weighty=0;
		c.gridheight=1;
		c.gridwidth=1;
		c.ipady=500;
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
	jTable11=tableb;
	
	frame.add(remarksPanel,c);
	
	
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
	
	model = tableb.getSelectionModel();
	tabtestlistener listener = new tabtestlistener();
	model.addListSelectionListener(listener);
	
	
    }
    catch (Exception e)
    {
    	System.out.println("System crash "+e.toString());
    }
	
	
//	while(l.hasNext()) {
		
//	}
	
	
}

public void regularDisplay() {
	
c = new GridBagConstraints();

frame.getContentPane().removeAll();
//frame.getContentPane().revalidate();
//frame.getContentPane().repaint();

JTextField [] fieldsList= new JTextField [2*tabDimensions[3]];

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
	JLabel stationId = new JLabel ("Station ID Regular");
	//stationId.setLayout(new GridBagLayout());
	frame.add(stationId,c);
	
	
	c.fill = GridBagConstraints.VERTICAL;
	//c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=1;
	c.weightx=0.1;
	c.weighty=0.1;
	c.gridheight=1;
	c.gridwidth=1;
	
	c.ipadx=2500;
	//c.ipady=500;

	//frame.setVisible(true);
	//frame.add(button,c);
	
	
   // JTextField inputs[] =new JTextField[tabHeaderContentDimensions[1]];
	  JLabel inputs[] =new JLabel[(tabHeaderContentDimensions[1]+1)*2];
    JPanel stationDetails = new JPanel();
    JScrollPane scrollstationDetails = new JScrollPane(stationDetails);
    
  //  scrollstationDetails.setMinimumSize(scrollstationDetails.setpr);
    
    JPanel stationDetailListing[]= new JPanel[tabHeaderContentDimensions[1]*2];
    System.out.println("jpan "+(tabDimensions[3])+" "+(tabHeaderContentDimensions[1]*2));
   
    
    
    stationDetails.setLayout(new GridBagLayout());
    
    
    stationDetails.setBackground(Color.RED);
    
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
	
   
    
    int l=0;
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
	cp1.weightx=0.1;
	cp1.weighty=0.1;
	cp1.gridheight=1;
	cp1.gridwidth=1;
	System.out.println("showingcp "+tabHeaderContent[0][i]+" "+inputs[l].getText());
	stationDetailListing[i*2].add(inputs[l],cp1);
	System.out.println("pov");
	stationDetails.add(stationDetailListing[i*2],cp1);//originally operational
	
	l++;
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
    	 fieldsList[l]= new JTextField(textFieldSize);
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
	stationDetailListing[i*2+1].add(fieldsList[l],cp1);
	//stationDetailListing[i*2+1].add(button,cp1);
	
	j++;
	m++;
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
    	 fieldsList[l]= new JTextField(textFieldSize);
    	 cp1.anchor=(GridBagConstraints.FIRST_LINE_START);
    	cp1.gridx=0;
    	cp1.gridy=0;
    	cp1.weightx=0.1;
    	cp1.weighty=0.1;
    	cp1.gridheight=1;
    	cp1.gridwidth=1;
    	System.out.println("putting button");
    	//stationDetailListing[i*2+1].add(button,cp1);//originally operational for testing purposes
    	stationDetailListing[i*2+1].add(fieldsList[l],cp1);
    	System.out.println("pov2");
    	
    	
    	cp1.gridx=1;
    	cp1.gridy=i;
    	cp1.weightx=0.1;
    	cp1.weighty=0.1;
    	cp1.gridheight=1;
    	cp1.gridwidth=1;
    	stationDetails.add(stationDetailListing[(i*2)+1],cp1);
    	
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

	

	

	
}


private class tabtestlistener implements ListSelectionListener {@Override
public void valueChanged(ListSelectionEvent e) {
	if (! model.isSelectionEmpty()) {
		//
		int selrow=model.getMinSelectionIndex();
		JOptionPane.showMessageDialog(null, "selected row "+selrow);

		
	}
	// TODO Auto-generated method stub
	
}

	
}

public JBroTable getJBrotableTable() {
	return tableb;
}

}
