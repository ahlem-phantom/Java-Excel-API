package app.orange;

import java.awt.GridBagConstraints;   
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class export extends javax.swing.JFrame  {

	LayoutManager layout;
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
	JFrame frame;
	ListSelectionModel model;
	String table[][];
	String path;
	

	public export(LayoutManager layout,JFrame frame,String[] tab, String[][] fullTable, GridBagConstraints c, List<CellRangeAddress> cellAdList, int tabDimensions[], String tabHeaderContent[][], int tabHeaderContentDimensions[],String path) 
	{
		this.layout=layout;
		this.frame=frame;
		this.tab=tab;
		this.fullTable=fullTable;
		//this.c=c;
		this.cellAdList=cellAdList;
		this.tabDimensions=tabDimensions;
		this.tabHeaderContent=tabHeaderContent;
		this.tabHeaderContentDimensions=tabHeaderContentDimensions;
		this.path=path;
		frame.setLayout(layout);
	}


	private static final long serialVersionUID = 1L;
    public void export() throws Exception {

  //export       
    	

    	//tabDimensions=nombre de colonnes 
    	System.out.println ("exporting started"+tabDimensions[1]+"a"+tabDimensions[2]+"b"+tabHeaderContentDimensions[0]+"c");
        XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create a blank sheetf
		XSSFSheet sheet = workbook.createSheet("Global-Besoin-Materiel-LTE-orange-18072019-update-RFI-Power-Solution");
		
	    CellStyle style=workbook.createCellStyle();
	    CellStyle style1=workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.ORANGE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style1.setAlignment(HorizontalAlignment.CENTER);
        
        //exporting data 
		int i=0;
		do {
		    sheet.createRow(i);
		   for(int j=0; j < tabDimensions[1]; j++) {
		  // sheet.addMergedRegion(new CellRangeAddress(0,1,0,tabDimensions[1]));
		   sheet.getRow(i).createCell(j).setCellValue(fullTable[i][j]);
		   sheet.getRow(i).getCell(j).setCellStyle(style1);
		    }
		i++;
		}
		while(i<fullTable.length);
		
		//exporting cell style 
		XSSFFont font=workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setFontName("Calibri");
		font.setFontHeightInPoints((short)12);
		   for(int i1=0; i1 < 2; i1++) {
		   for(int j1=0; j1 < tabDimensions[1]; j1++) {
		   sheet.getRow(i1).getCell(j1).setCellStyle(style);
		   style.setFont(font);
		   sheet.autoSizeColumn(j1);
		   sheet.getRow(i1).setHeight((short) 700);
       //    sheet.addMergedRegion(new CellRangeAddress(1,1,2,2));
		    }
		   }
		System.out.println("charlie");
         System.out.println(fullTable.length+"ok45"+tabHeaderContent.length);//ligne 
         //colonne
      
        try 
		{
			//Write the workbook in file system
        	  FileOutputStream out = new FileOutputStream(new File(path+".xlsx"));
			    workbook.write(out);
			    out.close();
			    System.out.println("ok.xlsx written successfully on disk.");
		
    }
        catch (Exception e) 
		{
        	System.out.println("Exporting crashed");
		    e.printStackTrace();
		}
    }                           

}
