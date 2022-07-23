package test;

import javax.swing.JOptionPane;

public class dataAcquisition {

	String IDValue;
	void getIDValue (String IDValue) {
	//	JOptionPane.showMessageDialog(null, "IDV is "+ IDValue);
		this.IDValue=IDValue;
	}
	
	int SelectedRow;
	void getSelectedRow (int SelectedRow) {
	//	JOptionPane.showMessageDialog(null, "IDV is "+ SelectedRow);
		this.SelectedRow=SelectedRow;
	}
	
	String IDValueIs() {
	//	JOptionPane.showMessageDialog(null, "returning "+ IDValue);
		return IDValue;
	}
	
	int selectedRowIS() {
	//	JOptionPane.showMessageDialog(null, "returning "+ SelectedRow);
		return SelectedRow;
	}
	
}
