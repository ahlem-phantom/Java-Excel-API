package app.ooreedo;

//import java.awt.Color;
import java.awt.GridBagConstraints;
//import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Import {
	
	LayoutManager layout;
	JFrame frame;
	GridBagConstraints c;
	 int rowMax=0, columnMax=0, redRow=0, redColumn=0;


	 String columnHeaders[];
	 String table [][]=null;
	 List<CellRangeAddress> cellAdList;
	 int tabDimensions[];
	 String tabHeaderContent[][]=null;
	 int tabHeaderContentDimensions[];
     String path;
	 
	 
	 String importedTab[][];
	
	public Import (LayoutManager layout, JFrame frame, GridBagConstraints c, String path) {
		this.layout=layout;
		this.frame=frame;
		this.c=c;
		this.path=path;
	}
	

	public void imprt() throws Exception {
	
		
		
		
	List<String> tab =new ArrayList<String>();
	//String table[][]= new String[][];
	//String table[][];
	 JTable tb= new JTable();
	// String columnHeaders[];//original placement
	// String table [][]=null;//original placement
//	 String importedTab[][];
	 String importedTabContent[][];
	 String testTab[][];
//	 int rowMax=0, columnMax=0;
//	 String tabHeaderContent[][]=null;//original placement

	 
	 
	int i,j,h;
	  Row row;
      Cell cell;
    //  List<CellRangeAddress> cellAdList = new ArrayList<CellRangeAddress>();//original
      cellAdList = new ArrayList<CellRangeAddress>();

     // Sheet sheet;
   //         File fl = new File("frr.xlsx");//actual
    //     File fl = new File("New-Microsoft-Excel-Worksheet-6.xlsx");//operational
     //   File fl = new File("Global-Besoin-Materiel-LTE-ooredoo-18072019-update-RFI-Power-Solution.xlsx");
   //   File fl = new File("Global-Besoin-Materiel-LTE-ooredoo-18072019-update-RFI-Power-Solution - Copy.xlsx");
      
     File fl = new File(path);
      
      
      
      
            FileInputStream fis = new FileInputStream(fl);
            
         
            //
          XSSFWorkbook workbook = new XSSFWorkbook(fis);
          CellStyle cs ;
            //HSSFWorkbook workbook = new HSSFWorkbook(fis);
           //System.out.println(fis);
           // Workbook workbook = WorkbookFactory.create(fis);
          // Sheet sheet= workbook.getSheetAt(0);//operational
           Sheet sheet= workbook.getSheetAt(0);//operational
          //XSSFSheet sheet= workbook.getSheet("tab");
            //HSSFSheet sheet= workbook.getSheetAt(0);
            int rownum=sheet.getLastRowNum();
             //String table[][]= new String[rownum+1][rownum+1];
           // String table[][]= new String[200][200];//operational, just for testing purposes, to be eliminated
            //int col.sheet.get// for testing purposes
             cs=sheet.getRow(0).getCell(0).getCellStyle();
             Color color = cs.getFillForegroundColorColor();
             cellAdList=sheet.getMergedRegions();
             
             Iterator<CellRangeAddress> l= cellAdList.iterator();
            // System.out.println(rownum+" rownum "+ sheet.getNumMergedRegions()+" "+sheet.getMergedRegions()+" "+((XSSFColor)color).getARGBHex()+" hasnext "+ l.hasNext() );//operational
            // System.out.println(rownum+" rownum "+ cellAdList+" celladlist "+cellAdList+" "+((XSSFColor)color).getARGBHex()+" hasnext "+ l.hasNext() );
       
             
             
             
             
             
             
             
             
             
             
              for(CellRangeAddress k :cellAdList) {
            	
            	  int o,p;
              	o=k.getFirstRow();
              	p=k.getFirstColumn();
              	
              	
//              	System.out.println("Row "+o+" lrow "+k.getLastRow()+" Column "+p +" 3ar3ara "+k.getLastColumn()+" lactual "+k.toString());

              	
             	
              	if (k.getLastRow()>rowMax)
              		rowMax=k.getLastRow();
              				if (k.getLastColumn()>columnMax)
                          		columnMax=k.getLastColumn();
              				
            	  
            	  //sheet.removeMergedRegion(k);
            	  
            }
              
              /*
              while (sheet.getNumMergedRegions()!=0)
              for(int v=0;v<sheet.getNumMergedRegions();v++) {
            	  sheet.removeMergedRegion(v);
            	  System.out.println("number of merged regions is "+sheet.getNumMergedRegions());
              }
              */
              
              
              
             // System.out.println("number of merged regions is "+sheet.getNumMergedRegions());
              
 //             System.out.println("rowMax "+rowMax+" columnMax "+columnMax +" getrow "+sheet.getRow(rowMax).getCell(0)+" merged regions "+sheet.getMergedRegions()+" "+sheet.getLastRowNum());
              
          /*    for(CellRangeAddress k :cellAdList) {
              	
            	  int o,p;
              	o=k.getFirstRow();
              	p=k.getFirstColumn();
              	
              	
             
            }
            */
              
//            Iterator<Row> rowIt=sheet.iterator();
        	 // Iterator<Cell> cellIt=row.cellIterator();
            columnHeaders=new String[rownum];
            
            int w=sheet.getLastRowNum();
          //  sheet.iterator().
           /* while(l.hasNext()) {
            	
            	int o,p;
            	o=l.next().getFirstRow();
            	p=l.next().getFirstColumn();
            	
            	
            	System.out.println("Row "+o+" Column "+p +" 3ar3ara "+l.next().getLastColumn()+" lactual "+l.next());
            }*/
 
 //           rowMax=0;
 //           columnMax=0;
            //table creation
            try {
            	Iterator<Row> rowIt=sheet.iterator();
            while (rowIt.hasNext()) {
            	  row=rowIt.next();
            	
            	  Iterator<Cell> cellIt=row.cellIterator();
//            	  System.out.println("lastcellfirstrow "+ row.getLastCellNum()+" hasnext "+cellIt.hasNext());
            	  while (cellIt.hasNext()){
            		  cell=cellIt.next();
            		  
                      cs=sheet.getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()).getCellStyle();
                      color = cs.getFillForegroundColorColor();
                   //   table[cell.getRowIndex()][cell.getColumnIndex()]=cell.toString();
       //     		  System.out.println("tablecell "+ table[cell.getRowIndex()][cell.getColumnIndex()]+" "+cell.getRowIndex()+" "+cell.getColumnIndex());//instruction lethal to the program
       //               System.out.println("redrow "+ rowMax+" actualrow "+cell.getRowIndex()+" redcolumn "+ columnMax+" actualcolumn "+cell.getColumnIndex() +" color "+((XSSFColor)color).getARGBHex().equals("FFFF0000"));
      //                System.out.println("redrow "+ rowMax+" actualrow "+cell.getRowIndex()+" redcolumn "+ columnMax+" actualcolumn "+cell.getColumnIndex());

                      //original color check placement
//                         System.out.println("colour check "+color);
                         
                         
                         if (color==null);
                         else if (((XSSFColor)color).getARGBHex().equals("FFFF0000")) {
//                    	  System.out.println("passredrow "+ rowMax+" actualrow "+cell.getRowIndex()+" redcolumn "+ columnMax+" actualcolumn "+cell.getColumnIndex() );
                    	  
//            			  System.out.println("colour check 2");  
            			  
            			  if(redRow<cell.getRowIndex())
                    		  redRow=cell.getRowIndex();
            			  else if(redColumn<cell.getColumnIndex())
                    		  redColumn=cell.getColumnIndex();
                      }
                       
                      
                      
                      
                      
                	  if(rowMax<cell.getRowIndex())
                		  rowMax=cell.getRowIndex();
                	  else if(columnMax<cell.getColumnIndex())
                		  columnMax=cell.getColumnIndex();
//                	  System.out.println("actualrow "+cell.getRowIndex()+"actualcell "+cell.getColumnIndex());
                	  
            		  
                       
            		  
            	  }
            }
            
           
   //               System.out.println("redrowactual "+ rowMax+" columnred "+columnMax );
            	  }
            
            catch (Exception ex) {
            System.out.println("crash redrow "+ rowMax+" columnred "+columnMax  );
            }
            
            System.out.println("actual redrow "+ redRow+" columnred "+redColumn  );
            System.out.println("actual rowmax "+ rowMax+ " actual columnMax "+ columnMax);
            
            table= new String[rowMax+1][columnMax+1];
          //  table= new String[rowMax][columnMax];
            System.out.println("inserting variables");
          
            /*
            int tabDimensions[]= new int[2];//originals
            
            tabDimensions[0]=rowMax+1;//originals
            tabDimensions[1]=columnMax+1;//originals
            */
            tabDimensions= new int[4];//original
            
            tabDimensions[0]=rowMax+1;
            tabDimensions[1]=columnMax+1;
            tabDimensions[2]=redRow+1;
            tabDimensions[3]=redColumn+1;
            
            
           // int o=0,p=0;
            
            //CellAddress tabHeader [][]=new CellAddress[rowMax*3][];
            //int tabHeader [][]=new int[rowMax*3][25];
            String tabHeader [][]=new String[rowMax*3+1][columnMax+1];
            h=0;
            try {
            	Iterator<Row> rowIt=sheet.iterator();
             rowIt=sheet.iterator();
            while (rowIt.hasNext()) {
          	  row=rowIt.next();
          	Cell previousCell=null;
          	
          	System.out.println("lastcell2 "+ row.getLastCellNum());
          	  Iterator<Cell> cellIt=row.cellIterator();
          	  
          	int g=0,o=0,p=0;
          	
          	  while (cellIt.hasNext()){

          		  
          		  
          		  cell=cellIt.next();
                  cs=sheet.getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()).getCellStyle();
                  color = cs.getFillForegroundColorColor();
          		  
                  
               //   int t=cell.getRowIndex()+1;
                  int t=cell.getRowIndex()*3;
               //   int t2=cell.getColumnIndex();
//                  System.out.println("getrowindex "+t);
                  
   //               System.out.println("tabHeader "+g + " tabheaderValue "+ tabHeader[cell.getRowIndex()*2][o]+ " tabheaderValueEnd "+ p);		 
                 // System.out.println("tabHeaderrow "+cell.getRowIndex()*2+" tabheadercolumn "+(cell.getRowIndex()*2+1) +" extra "+tabHeader[cell.getRowIndex()*2][o]+" double extra "+ tabHeader[(cell.getRowIndex()*2+1)][o]+"triple extra "+ o+" quadruple "+tabHeader[1][o]);		 
                  //  System.out.println("tabHeaderrow "+cell.getRowIndex()*3+" tabheadercolumn "+(t) +" extra "+tabHeader[t-1][o]+" double extra "+ tabHeader[t][o]+"triple extra "+ o+" quadruple "+tabHeader[t][o]);		 

                  
          		//System.out.println( row.getLastCellNum());
          		//  System.out.println(cell.toString()+"  ;  ");
          		  table[cell.getRowIndex()][cell.getColumnIndex()]=cell.toString();
         // 		  System.out.println( table[cell.getRowIndex()][cell.getColumnIndex()]+" "+cell.getRowIndex()+" "+cell.getColumnIndex()+" table ");
          		  

                 if (color==null);
//                	 System.out.println("Colour is null");
                 else if (((XSSFColor)color).getARGBHex().equals("FFFF0000")) {
//            	  System.out.println("passredrow "+ rowMax+" actualrow "+cell.getRowIndex()+" redcolumn "+ columnMax+" actualcolumn "+cell.getColumnIndex() );
            	  
    			  System.out.println("colour check 3");  
    		/*	  
    			  if(redRow<cell.getRowIndex())
            		  redRow=cell.getRowIndex();
    			  else if(redColumn<cell.getColumnIndex())
            		  redColumn=cell.getColumnIndex();
    			  
    			  
    			  System.out.println("crash?!");
    			  System.out.println("cell is "+cell.toString());
    			  */
    			  
    			  
    			  
           		/* if (cell.getColumnIndex()==0) {
           			
          			// tabHeader[1][g]=cell.getAddress();
           			
           			
           			System.out.println("newtab2 "+tabHeader[t-1][o]);
   //            	 tabHeader[cell.getRowIndex()*2][o]=g;
               	 tabHeader[t-1][o]=Integer.toString(g);
            	 
  //          	 tabHeader[t][0]=Integer.toString(p);
            	 tabHeader[t+1][o]=cell.toString();
            	 
            	 
          			 
          			 
System.out.println("crash?! 2 ");
          		 }*/
          		 // if ((cell.getColumnIndex()!=0)&(cell.getColumnIndex()<=columnMax))
    			 // if (cell.getColumnIndex()<=columnMax)//original
    			  if (cell.getColumnIndex()<=redColumn)
          		 {
          			 if (cell.toString()=="") {
          				 System.out.println("cell is null");
     //     				tabHeader[t+1][o]=Integer.toString(cell.getColumnIndex()-1);
          				

          				
          				 o++;
          			 }
          			 
          			 else {
          			//	tabHeader[0][g]=cell.getAddress();
          		//		tabHeader[1][g]=cell.getAddress();
          		//		tabHeader[2][g]=previousCell.getAddress();
          				 
          				
 //         				System.out.println("newtab");
          	//			o++;
                    //	 tabHeader[t-1][o]=Integer.toString(g);
                    	 
                    //	 tabHeader[t][o-1]=Integer.toString(p);
                    //	 tabHeader[t+1][o]=cell.toString();
          				
          			/*	
          				
                        	 tabHeader[t][o]=Integer.toString(cell.getColumnIndex());
                       // 	 tabHeader[t+1][o-1]=Integer.toString(cell.getColumnIndex()-1);
                        	 tabHeader[t+2][o]=cell.toString();
                        	 o++;
                        	 tabHeader[t+1][o-1]=Integer.toString(cell.getColumnIndex()-1);
                    		 
          			//	tabHeader[cell.getRowIndex()*2][o]=g;//used for testing purposes
                    	 System.out.println("newtab2 "+tabHeader[t][o]+" t "+(t)+ " " +o);
                    	 System.out.println("newtab2r "+tabHeader[t+2][o]+" t+2 "+(t+2)+ " " +o);
                   	     System.out.println("newtab2 "+tabHeader[t+1][o-1]+" t+1 "+(t+1)+ " " +(o-1));
         
                    	*/
          				 tabHeader[t][g]=Integer.toString(cell.getColumnIndex());
          				 tabHeader[t+2][g]=cell.toString();
//                    	 System.out.println("newtab2 "+tabHeader[t][o]+" t "+(t)+ " o " +o+ " g "+g);
                    //	 System.out.println("newtab2r "+tabHeader[t+2][o]+" t+2 "+(t+2)+ " " +o);
                    	// o++;
                    	 if ((cell.getColumnIndex()==0)|g==0){
                    		 
                    		 tabHeader[t+1][g]=Integer.toString(cell.getColumnIndex());
//                    		 System.out.println("==0");
                    		 
                    	 }
                    	 else {
//                    		 System.out.println("!=0");
                    	 tabHeader[t+1][g-1]=Integer.toString(cell.getColumnIndex()-1);

//                  	 System.out.println("newtab2b "+tabHeader[t][o]+" t "+(t)+ " " +o);

//                 	     System.out.println("newtab2e "+tabHeader[t+1][o-1]+" tp "+(t+1)+ " " +(o-1));
//                    	 System.out.println("newtab2r "+tabHeader[t+2][o]+" t+2 "+(t+2)+ " " +o);
                    	 
                    	 
                    	 }
                    	 o++;
              //      	 System.out.println("newtab2b "+tabHeader[t+1][g-1]+" t+1 "+(t+1)+ " " +(o-1));
                    	 
          				
                        // System.out.println("tabHeader "+g + " tabheaderValue "+ tabHeader[cell.getRowIndex()*2][o]+ " tabheaderValueEnd "+ tabHeader[cell.getRowIndex()*2+1][o]);		 
                       //  System.out.println("tabHeaderrow "+cell.getRowIndex()*2+" tabheadercolumn "+o +" extra "+tabHeader[0][g]);		 

                    	 
                         g++;
                         p=g-1;
                         if(h<g)
                        	 h=g;

                         
          			 }
          			 System.out.println("estaimated current cell "+cell.getColumnIndex());
                     //if (cell.getColumnIndex()==columnMax) {//original
          			if (cell.getColumnIndex()==redColumn) {
                    	 System.out.println("reaching final");
                    	 tabHeader[t+1][g-1]=Integer.toString(cell.getColumnIndex());
                    	 }
          		 }
          		 previousCell=cell;
          //		 System.out.println("colour check "+color);
          	//	g++;
                 previousCell=cell;
    			  

    			  
              }
                 
 //                System.out.println("tabHeader "+g + " tabheaderValue "+ g+ " tabheaderValueEnd "+ p);		//obselete 		 
                 
                	 
//////
                 
                
  //          	 System.out.println("newtab2 "+tabHeader[t-1][o]);
  //         	     System.out.println("newtab2 "+tabHeader[t][o-1]);
  //           	 System.out.println("newtab2 "+tabHeader[t+1][o]);                 

          		 
//i=cell.getRowIndex();
//j=cell.getColumnIndex();
          			  
          			            			  
          		  }
          	  }
            
            }
            catch (Exception ex) {
            	System.out.println(" EXE "+ex);
            }
            
            int lcl=0, tabHeaderColumnC=0, tabHeaderRowC=0;
            
            
            tabHeaderContentDimensions=new int[2];//original
            
          //  String tabHeaderContent[][]=new String[redRow][redColumn];//tabheadercontent original declaration
          /*  int e=0,r=0;
            for (int k=0;k<redRow;k++) {
            	for (int m=0;m<redColumn;m++) {
            		while(table[k][m]!="") {
            			if (k==0)
            				tabHeaderContent[e][r]=table[k][m];
            			else {
            				for (int b=0; b<o)
            			}
            		}
            	}
            }
            */
            System.out.println(redRow+" redalert "+redColumn+" h "+h);
            int eb=0,ebr=0;
            String oldHeader=null, newHeader=null;
            for (int k=0;k<=redRow;k++) {
            	
            	for (int m=0;m<h;m++) {
            		
            		System.out.println("tabHeaderContent "+tabHeader[k*3+2][m]+ " cda"+ tabHeader[k*3][m]+""+ tabHeader[k*3+1][m] + " k "+(k+2)+" "+m);
            		if ((tabHeader[k*3][m]==null)|k==0) 
            			
            			System.out.println("stuck in null");
            		
            		else {
//            		System.out.println("actualstring "+ tabHeader[k*3][m]+" "+tabHeader[k*3-3][m]+" "+tabHeader[k*3+1][m]+" "+tabHeader[k*3-2][m]);
          //  		System.out.println("parseint "+ ((Integer.valueOf(tabHeader[k*3][m]))+" "+(Integer.valueOf(tabHeader[k][m]))+" "+(Integer.valueOf(tabHeader[k*3+1][m])+" "+Integer.valueOf(tabHeader[k+1][m]))));
            			System.out.println("passing");
            		}
            		
            		
            		
            		//start
            		
            	//	if (k==0){
            		if (k==0){
            			if (tabHeader[k+2][m]!=null) {
 //           			System.out.println("doing nothing");//obeslete
 //           			System.out.println("main group "+ tabHeader[k+2][m]);
            			eb++;
            			
            			}	
            		}
            		else if (tabHeader[k*3+2][m]!=null) {
//            			lcl=0;//erroneous
            			System.out.println("k not null");
            			for (int t=0;t<h;t++) {
            				
 //           			System.out.println("pret");
          	//		System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);
            				System.out.println("ts value "+t+" h "+h);
            				if (tabHeader[k*3-3][t]==null)
            					System.out.println("t content is empty1");
            				else if ((Integer.valueOf(tabHeader[k*3][m]))>=(Integer.valueOf(tabHeader[k*3-3][t]))&(Integer.valueOf(tabHeader[k*3+1][m])<=Integer.valueOf(tabHeader[k*3-2][t])))
               		{ 
               		//	System.out.println(tabHeader[k*3+2][m]+" at "+ (k*3)+" "+ (k*3+1) +" belongs to "+tabHeader[k*3-1][m]+" at "+(k*3-3)+" "+(k*3-2));
               			System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);
               		//	lcl++;
               			newHeader=tabHeader[k*3-1][t];
               					System.out.println("already done");

               		}
            				
            			//	System.out.println("1st cycle end");
            				else
                       			System.out.println("else "+tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" does not belong to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);

            				//	lcl=0;
            				
                   		//	System.out.println("lcl "+lcl);
                   	//		if (ebr<lcl)
                   		//		ebr=lcl;	
                       		
            				
            		}
            			System.out.println("2nd cycle end");

                		
                		
                		
            		//	System.out.println("lcl "+lcl);
            		}
            		
            		//end
            		
            		
            	/*	//start//same program above untouched
            		
            		if (k==0){
 //           			System.out.println("doing nothing");
            			System.out.println("main group "+ tabHeader[k+2][m]);
            		}
            		else if (tabHeader[k*3+2][m]!=null) {
            			for (int t=0;t<h;t++) {
            				System.out.println("pret");
 //          			System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);

            				if (tabHeader[k*3-3][t]==null)
            					System.out.println("t content is empty");
            				else if ((Integer.valueOf(tabHeader[k*3][m]))>=(Integer.valueOf(tabHeader[k*3-3][t]))&(Integer.valueOf(tabHeader[k*3+1][m])<=Integer.valueOf(tabHeader[k*3-2][t])))
               		{
               		//	System.out.println(tabHeader[k*3+2][m]+" at "+ (k*3)+" "+ (k*3+1) +" belongs to "+tabHeader[k*3-1][m]+" at "+(k*3-3)+" "+(k*3-2));
               			System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);
               		}
            		}
            		}
            		
            		//end*///same program above untouched
            		
            		
            		
            		if ((oldHeader==null)){
        			//	System.out.println("lcl init "+lcl);
        			//lcl++;//erroneous
            			System.out.println("lcl init ");
        			
        			}
        		else if (oldHeader==newHeader)
        		{
        			System.out.println("lcl set ");
        			lcl++;
        			System.out.println("lcl set "+lcl);
                   		//	if (ebr<lcl)
               			//	ebr=lcl;	
        			
        		}
        		else {
        			System.out.println("lcl reset ");
        			System.out.println("lcl reset "+oldHeader+" "+newHeader);
        			lcl=0;
        			
        		}
        		oldHeader=newHeader;
            		
            		
       			if (ebr<lcl)
   				ebr=lcl;		
            	//	System.out.println("ebr "+ebr+" eb "+eb);
            	//	tabHeaderContent=new String[ebr+1][eb+1];
            		
            	
            		
            		
            		/*///
            		if(tabHeader[k*3+2][m]!=null) {
            		if ((k==0)) {
            			tabHeaderContent[k][m]=tabHeader[k*3+2][m];
            			System.out.println("misfit1 "+tabHeaderContent[e][m]);
            		}
            		//else if ((Integer.valueOf(tabHeader[k*3][m]))>=(Integer.valueOf(tabHeader[k][m]))&(Integer.valueOf(tabHeader[k*3+1][m])<=Integer.valueOf(tabHeader[k+1][m]))) {
            		else if ((Integer.valueOf(tabHeader[k*3][m]))>=(Integer.valueOf(tabHeader[k*3-3][m]))&(Integer.valueOf(tabHeader[k*3+1][m])<=Integer.valueOf(tabHeader[k*3-2][m]))) {
            			System.out.println("misfit2 "+tabHeaderContent[e][m]);
            				tabHeaderContent[e][m]=tabHeader[k*3+2][m];
            			System.out.println("misfit3 "+tabHeaderContent[e][m]);
            			e++;
            			
            		}
            		}	
            		
            		///*/
            		
            	}
            	
        		System.out.println("ebr "+ebr+" eb "+eb);
        		tabHeaderContent=new String[ebr+2][eb+2];
        		tabHeaderContentDimensions[0]=ebr;
        		tabHeaderContentDimensions[1]=eb;
            }
            
        	//start
    		
            for (int k=0;k<=redRow;k++) {
            	
            	for (int m=0;m<h;m++) {
            
    		if ((k==0)&tabHeader[k+2][m]!=null){
//           			System.out.println("doing nothing");
    			System.out.println("main group "+ tabHeader[k+2][m]);
    			tabHeaderContent[tabHeaderRowC][tabHeaderColumnC]=tabHeader[k+2][m];
    			tabHeaderColumnC++;
   // 			System.out.println("tabheadermainc "+ tabHeaderContent[tabHeaderRowC][tabHeaderColumnC]+" "+tabHeaderRowC+" "+tabHeaderColumnC);
    		}
    		else if (tabHeader[k*3+2][m]!=null) {
    			for (int t=0;t<h;t++) {
    				System.out.println("pret");
//          			System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);

    				if (tabHeader[k*3-3][t]==null)
    					System.out.println("t content is empty2");
    				else if ((Integer.valueOf(tabHeader[k*3][m]))>=(Integer.valueOf(tabHeader[k*3-3][t]))&(Integer.valueOf(tabHeader[k*3+1][m])<=Integer.valueOf(tabHeader[k*3-2][t])))
       		{
       		//	System.out.println(tabHeader[k*3+2][m]+" at "+ (k*3)+" "+ (k*3+1) +" belongs to "+tabHeader[k*3-1][m]+" at "+(k*3-3)+" "+(k*3-2));
       			System.out.println(tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" belongs to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);
       		//	int icnt=0;
       			for(int cnt=0;cnt<eb;cnt++) {
       				int icnt=0;
       				if (tabHeaderContent[0][cnt]==tabHeader[k*3-1][t]) {
       			//		System.out.println(tabHeader[k*3-1][t] +" is found at "+ tabHeaderContent[0][cnt]+" "+ icnt+" "+cnt);//original
       					while(tabHeaderContent[icnt][cnt]!=null)
       						icnt++;
       				
       				System.out.println(tabHeader[k*3+2][m] +" is inserted at "+ tabHeaderContent[icnt][cnt]+" "+ icnt+" "+cnt);
       				tabHeaderContent[icnt][cnt]=tabHeader[k*3+2][m];
       				}
       				System.out.println(tabHeader[k*3+2][m]+" is added to "+tabHeader[k*3-1][t]+" ranking "+icnt+" "+cnt);
       				
       				
       			}
   			//	System.out.println(tabHeader[k*3+2][m]+" is added to "+tabHeader[k*3-1][t]+" ranking "+icnt);//originally operational
       		//	tabHeaderColumnC++;
       		}
    				
    				else
    					System.out.println("else "+tabHeader[k*3+2][m]+" at "+ tabHeader[k*3][m]+" "+ tabHeader[k*3+1][m] +" does not belong to "+tabHeader[k*3-1][t]+" at "+tabHeader[k*3-3][t]+" "+tabHeader[k*3-2][t]);	
    				
    		}
    		}
            	}
            }
    		
    		//end
            
            System.out.println(" TABLE "+ table.toString());
            
            
            
            
            
          //  tb= new JTable(null,columnHeaders);
            System.out.println("disp");
  		//originally operational//	Display display = new Display(layout,frame,columnHeaders,table,c,cellAdList,tabDimensions,tabHeaderContent,tabHeaderContentDimensions);
  		//originally operational//	display.tableDisplay();
            
            }
	
	void tabHeaderMaker() {
		int a=rowMax+1;
		while(importedTab[a][0]!=null) {
			
		}
		}
		
	String[] getColumnHeaders() {
		return columnHeaders;
	}
	
	String[][] getTable() {
		return table;
	}
	
	List<CellRangeAddress> getCellAdList (){
		return cellAdList;
	}
	
	int[] getTabDimensions() {
		return tabDimensions;
	}
	
	String[][] getTabHeaderContent() {
		return tabHeaderContent;
	}
	
	int[] getTabHeaderContentDimensions() {
		return tabHeaderContentDimensions;
	}
	

	
	}
	
//}
