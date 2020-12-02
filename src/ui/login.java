package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;

public class login extends JFrame {

	
	private JTextField textField;
	private JPasswordField textField_1;
	private Point windowPosition = null; 
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	

	
	public JFrame getWindow() {
		return this;
	}
	
	public login() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 603);
		
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headerBar = new JPanel();
		headerBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				windowPosition=e.getPoint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				windowPosition=null;
			}
		});
		JFrame window=getWindow();
		headerBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point currentWindowPosition = e.getLocationOnScreen();
	            window.setLocation(currentWindowPosition.x - windowPosition.x , currentWindowPosition.y -  windowPosition.y);
			}
		});
		headerBar.setBounds(0, 0, 395, 22);
		headerBar.setBackground(new Color(44,62,80));
		contentPane.add(headerBar);
		headerBar.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_1.setIcon(new ImageIcon(login.class.getResource("/imgs/remove.png")));
		label_1.setBounds(375, 2, 18, 18);
		headerBar.add(label_1);
		
		JPanel contentPanel = new JPanel();
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setBorder(null);
				textField_1.setBorder(null);
			}
		});
		contentPanel.setBounds(0, 22, 395, 765);
		contentPanel.setBackground(new Color(34,47,62));
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setBounds(31, 20, 334, 29);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/imgs/Capture.PNG")));
		lblNewLabel_1.setBounds(1, -4, 395, 259);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/imgs/unnamed.png")));
		lblNewLabel_2.setBounds(-39, 190, 434, 106);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblSignIn = new JLabel("Sign in with your credentials");
		lblSignIn.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSignIn.setVerticalAlignment(SwingConstants.TOP);
		lblSignIn.setHorizontalTextPosition(SwingConstants.LEADING);
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblSignIn.setBounds(30, 278, 334, 29);
		contentPanel.add(lblSignIn);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(52,73,92));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setBorder(new LineBorder(Color.CYAN));
				textField_1.setBorder(null);
			}
			
		});
		
		
		textField.setBorder(null);
		textField.setBounds(95, 350, 231, 29);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 468, 257, 37);
		panel.setBackground(new Color(0,131,143));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignIn_1 = new JLabel("Sign In\r\n ");
		lblSignIn_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSignIn_1.setVerticalAlignment(SwingConstants.TOP);
		lblSignIn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSignIn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn_1.setForeground(Color.WHITE);
		lblSignIn_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblSignIn_1.setBounds(-38, 8, 334, 29);
		panel.add(lblSignIn_1);
		
		JLabel lblInOrderTo = new JLabel("in order to access the system\r\n");
		lblInOrderTo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblInOrderTo.setVerticalAlignment(SwingConstants.TOP);
		lblInOrderTo.setHorizontalTextPosition(SwingConstants.LEADING);
		lblInOrderTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInOrderTo.setForeground(Color.WHITE);
		lblInOrderTo.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblInOrderTo.setBounds(32, 303, 334, 29);
		contentPanel.add(lblInOrderTo);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/imgs/user.png")));
		lblNewLabel_3.setBounds(68, 350, 29, 29);
		contentPanel.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(login.class.getResource("/imgs/lock.png")));
		label.setBounds(68, 381, 29, 29);
		contentPanel.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/imgs/a.png")));
		lblNewLabel_4.setBounds(91, 534, 24, 24);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblCopyrightsaaSoftarwez = new JLabel("Copyrights@AA Softarwez");
		lblCopyrightsaaSoftarwez.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCopyrightsaaSoftarwez.setVerticalAlignment(SwingConstants.TOP);
		lblCopyrightsaaSoftarwez.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCopyrightsaaSoftarwez.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrightsaaSoftarwez.setForeground(Color.WHITE);
		lblCopyrightsaaSoftarwez.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblCopyrightsaaSoftarwez.setBounds(44, 538, 334, 29);
		contentPanel.add(lblCopyrightsaaSoftarwez);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 350, 29, 29);
		panel_1.setBackground(new Color(52,73,94));
		contentPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(66, 381, 29, 29);
		panel_2.setBackground(new Color(52,73,94));
		contentPanel.add(panel_2);
		
		textField_1 = new JPasswordField();
		textField_1.setForeground(Color.WHITE);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setBorder(new LineBorder(Color.CYAN));
				textField.setBorder(null);
			}
		});
		textField_1.setBorder(null);
		textField_1.setBounds(95, 381, 231, 29);
		textField_1.setBackground(new Color(52,73,94));
		contentPanel.add(textField_1);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
