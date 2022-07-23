package app.orange;


import java.awt.EventQueue;      
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
public class login1 extends JFrame { 

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					login1 frame = new login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public login1() throws IOException {
		setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 678);
		setTitle("Login");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Calibri", Font.BOLD, 35));
		lblLoginPage.setBounds(204, 58, 239, 56);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 23));
		lblUsername.setBounds(248, 179, 137, 48);
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setFont(new Font("Calibri", Font.PLAIN, 20));
		user.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		user.setBounds(258, 250, 427, 49);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 23));
		lblPassword.setBounds(248, 321, 137, 48);
		contentPane.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Calibri", Font.PLAIN, 20));
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(218, 165, 32)));
		pass.setBounds(258, 387, 427, 49);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 102, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String strUsername = user.getText();
					String strPassword = pass.getText();
					if(strUsername.equals("")) // Email
					{
						JOptionPane.showMessageDialog(null,
								"Please Input Username");
						user.requestFocusInWindow(); 
						
					}	
					else 
					
					if(strPassword.equals("")) // Password
					{
						JOptionPane.showMessageDialog(null,
								"Please Input Password");
						pass.requestFocusInWindow(); 
						
					}
					else
					{
				    String RegPassword =getMd5(strPassword);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","");
					Statement stmt=con.createStatement();
					String sql ="Select * from orange where Username='"+user.getText()+"' and Password ='"+RegPassword+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
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
									String a=getUsername();
									System.out.println(a);
									try {
								        UIManager.setLookAndFeel(
								            UIManager.getSystemLookAndFeelClassName());
								    } 
								    catch (UnsupportedLookAndFeelException e1) {
								    }
								    catch (ClassNotFoundException e1) {
								    }
								    catch (InstantiationException e1) {
								    }
								    catch (IllegalAccessException e1) {
								    }
								
							}
						});
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Incorret username and Password");
					con.close();
					}
					}}catch(Exception e1) {System.out.print(e1);}
						
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBounds(555, 522, 167, 56);
		contentPane.add(btnNewButton);
		
		String im = "img/orange.png";
		JLabel img = new JLabel("");
		img.setVerticalAlignment(SwingConstants.TOP);
		img.setIcon(new ImageIcon(im));
		img.setBounds(27, 28, 189, 180);
		contentPane.add(img);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(255, 102, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register1 hframe = new register1();
				hframe.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton_1.setBounds(204, 522, 155, 56);
		contentPane.add(btnNewButton_1);

	}
	String getUsername() {
		return user.getText();
	}
}
