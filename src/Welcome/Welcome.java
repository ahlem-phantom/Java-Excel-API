package Welcome;

import java.awt.Color;     
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import app.telecom.*;
import app.orange.*;
import app.ooreedo.*;
public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 678);
		setTitle("Welcome");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseYourApplication = new JLabel("Select your application");
		lblChooseYourApplication.setFont(new Font("Calibri", Font.BOLD, 40));
		lblChooseYourApplication.setBounds(264, 123, 450, 40);
		contentPane.add(lblChooseYourApplication);
		
		String im = "img/ooredoo.png";
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(im));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login hframe = null;
				try {
					hframe = new login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				hframe.setVisible(true);
			}
		});
		btnNewButton.setBounds(246, 307, 385, 96);
		contentPane.add(btnNewButton);
		
		String im1 = "img/orange.png";
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(im1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 hframe = null;
				try {
					hframe = new login1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				hframe.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(70, 298, 119, 124);
		contentPane.add(btnNewButton_1);
		
		String im2 = "img/telecom.png";
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(im2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login2 hframe = null;
				try {
					hframe = new login2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				hframe.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(681, 298, 186, 124);
		contentPane.add(btnNewButton_2);
	}
}
