package app.orange;

import java.awt.EventQueue; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.MatteBorder;



public class register1 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	
	//This is the method of Email Control
	
	static boolean isValid(String email) {
	      String regex = "^[0-9A-Za-z_-]+@gmail.com$";
	      return email.matches(regex);
	   }
	
	//The method of Hashing password with Md5 
	
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
	
	//Class Main 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				register1 frame = new register1();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Class register 
	
	public register1() {
		//Panel 
		getContentPane().setBackground(new Color(245, 245, 245));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 678);
		setTitle("Registration");
		getContentPane().setLayout(null);

		// *** Title ****//
		
		JLabel registerr = new JLabel("Registration Page");
		registerr.setHorizontalAlignment(SwingConstants.CENTER);
		registerr.setFont(new Font("Calibri", Font.BOLD, 35));
		registerr.setBounds(204, 58, 298, 56);
		getContentPane().add(registerr);
		
		// *** Headers ***//
		JLabel hUsername = new JLabel("Username ");
		hUsername.setFont(new Font("Calibri", Font.BOLD, 22));
		hUsername.setBounds(258, 128, 137, 48);
		getContentPane().add(hUsername);
		
		JLabel hPassword = new JLabel("Password ");
		hPassword.setFont(new Font("Calibri", Font.BOLD, 22));
		hPassword.setBounds(258, 325, 145, 32);
		getContentPane().add(hPassword);
		
		JLabel hConfirmPassword = new JLabel("Confirm Password ");
		hConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 22));
		hConfirmPassword.setBounds(258, 427, 219, 32);
		getContentPane().add(hConfirmPassword);
		

		JLabel hEmail = new JLabel("Email ");
		hEmail.setFont(new Font("Calibri", Font.BOLD, 22));
		hEmail.setBounds(258, 233, 125, 32);
		getContentPane().add(hEmail);
       
        // *** Input ***//
		
		// User ID
		txtUsername = new JTextField("");
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setFont(new Font("Calibri", Font.PLAIN, 21));
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		txtUsername.setBounds(258, 177, 406, 47);
		getContentPane().add(txtUsername);
		
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Calibri", Font.PLAIN, 21));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		txtPassword.setBounds(258, 367, 410, 47);
		getContentPane().add(txtPassword);
		
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 21));
		txtConfirmPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		txtConfirmPassword.setBounds(258, 471, 410, 47);
		getContentPane().add(txtConfirmPassword);

	
		// Email
		txtEmail = new JTextField("");
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 21));
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		txtEmail.setBounds(258, 265, 410, 47);
		getContentPane().add(txtEmail);

		// Save Button
		JButton btnSave = new JButton("Register");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(255, 102, 0));
		btnSave.setFont(new Font("Calibri", Font.BOLD, 24));
		
		// Button function 
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(RegisterData()) {
					login1 hframe;
					try {
						hframe = new login1();
						hframe.setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Cannot connect to database");
				}
			}
		});
		btnSave.setBounds(394, 553, 137, 56);
		getContentPane().add(btnSave);		
		
		// *** Insert Image *** //
		
		JLabel img = new JLabel("");
		img.setBounds(27, 28, 189, 180);
		img.setIcon(new ImageIcon("img/orange.png"));
		getContentPane().add(img);
		
	

	}
	
	//Function
	
	private Boolean RegisterData()
	{
		
		String strUsername = txtUsername.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strEmail = txtEmail.getText();
		
		// *** User name Input Control *** //
		
		if(strUsername.equals("")) // User name 
		{
			JOptionPane.showMessageDialog(null, "Please Input Username");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		
		if (strUsername.length() < 4)
		{
			JOptionPane.showMessageDialog(null, "Username must be at least 4 characters");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		
		
		// *** Email Input Control *** //
		
		if(strEmail.equals("")) // Email
		{
			JOptionPane.showMessageDialog(null, "Please Input Email");
			txtEmail.requestFocusInWindow(); 
			return false;
		}	
		
		if  (isValid(strEmail)==false) 
		{ 
		      JOptionPane.showMessageDialog(null, "Your email must be gmail");
				txtEmail.requestFocusInWindow(); 
				return false;
		}
		
		
	   // *** Password Input Control *** //
		
		if(strPassword.equals("")) // Password
		{
			JOptionPane.showMessageDialog(null, "Please Input Password");
			txtPassword.requestFocusInWindow(); 
			return false;
		}
		
		if (strPassword.length() < 6)
		{
			JOptionPane.showMessageDialog(null, "Password must be at least 6 characters");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		
		
		if(strConfirmPassword.equals("")) // Confirm Password
		{
			JOptionPane.showMessageDialog(null, "Please Input Confirm Password");
		    txtConfirmPassword.requestFocusInWindow(); 
			return false;
		}
		
		if(!strPassword.equals(strConfirmPassword)) // Password math
		{
			JOptionPane.showMessageDialog(null, "Passwords Do Not Match!");
			txtPassword.requestFocusInWindow(); 
			return false;
		}		
		
	
		Connection connect = null;
		Statement s = null;
		Boolean status = false;
		String RegPassword =getMd5(strPassword); // Calling Method Md5  
		
		try {
			// *** Connecting to database *** //
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(""+ "jdbc:mysql://localhost:3306/application" + "?user=root&password=");
			s = connect.createStatement();
			
			// SQL Insert
			String sql = "INSERT INTO orange "
					+ "(Username,Password,Email) "
					+ "VALUES ('" + strUsername + "','"
					+ RegPassword + "','"
					+ strEmail + "') ";
			s.execute(sql);
		
			
			// Reset Text Fields
			txtUsername.setText("");
			txtPassword.setText("");
			txtConfirmPassword.setText("");
			txtEmail.setText("");
				
			status  = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return status;

	}
}