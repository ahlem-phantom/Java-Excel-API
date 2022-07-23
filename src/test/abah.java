package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class abah {

	//static LayoutManager layout= new GridBagLayout();
	
	
	public static void main(String[] args) throws Exception { /*
		  Row row;
	        Cell cell;
	       // Sheet sheet;
	             File fl = new File("frr.xlsx");
	              FileInputStream fis = new FileInputStream(fl);
	              
	              //
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	              //HSSFWorkbook workbook = new HSSFWorkbook(fis);
	             //System.out.println(fis);
	             // Workbook workbook = WorkbookFactory.create(fis);
	             Sheet sheet= workbook.getSheetAt(0);
	              //HSSFSheet sheet= workbook.getSheetAt(0);
	              int rownum=sheet.getLastRowNum();
	              //int col.sheet.get// for testing purposes
	              System.out.println(rownum);
	              Iterator<Row> rowIt=sheet.iterator();
	              
	              while (rowIt.hasNext()) {
	            	  row=rowIt.next();
	            	  Iterator<Cell> cellIt=row.cellIterator();
	            	  while (cellIt.hasNext()){
	            		  cell=cellIt.next();
	            		  System.out.println(cell.toString()+"  ;  ");
	            	  }
	              }
	              */
		 LayoutManager layout= new GridBagLayout();
		
		System.out.println("you spent too long on doing the things you should");
		//Import frer =new Import();
		//frer.imprt();
		testframe kolleb = new testframe (layout);
		//kolleb.setName("layout");
		//kolleb.getContentPane().setLayout(new GridBagLayout());
		kolleb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//actual
		//kolleb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kolleb.setVisible(true);
	//	kolleb.setBounds(100, 100, 450, 300);
		kolleb.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	//	kolleb.setResizable(false);
		

	}

}
