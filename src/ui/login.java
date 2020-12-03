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

	
	private JTextField usernameInput;
	private JPasswordField passwordInput;
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
		
		JLabel closeButton = new JLabel("");
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeButton.setIcon(new ImageIcon(login.class.getResource("/imgs/remove.png")));
		closeButton.setBounds(375, 2, 18, 18);
		headerBar.add(closeButton);
		
		JPanel contentPanel = new JPanel();
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setBorder(null);
				passwordInput.setBorder(null);
			}
		});
		contentPanel.setBounds(0, 22, 395, 765);
		contentPanel.setBackground(new Color(34,47,62));
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel SMSHeading = new JLabel("Student Management System");
		SMSHeading.setForeground(Color.WHITE);
		SMSHeading.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		SMSHeading.setHorizontalAlignment(SwingConstants.CENTER);
		SMSHeading.setVerticalTextPosition(SwingConstants.BOTTOM);
		SMSHeading.setVerticalAlignment(SwingConstants.TOP);
		SMSHeading.setHorizontalTextPosition(SwingConstants.LEADING);
		SMSHeading.setBounds(35, 211, 334, 29);
		contentPanel.add(SMSHeading);
		
		JLabel LoginPic = new JLabel("");
		LoginPic.setHorizontalAlignment(SwingConstants.CENTER);
		LoginPic.setHorizontalTextPosition(SwingConstants.CENTER);
		LoginPic.setIcon(new ImageIcon(login.class.getResource("/imgs/exams-result-management.png")));
		LoginPic.setBounds(1, -20, 395, 259);
		contentPanel.add(LoginPic);
		
		JLabel shadow = new JLabel("");
		shadow.setIcon(new ImageIcon(login.class.getResource("/imgs/unnamed.png")));
		shadow.setBounds(-39, 190, 434, 106);
		contentPanel.add(shadow);
		
		JLabel lblSignIn = new JLabel("Sign in with your credentials");
		lblSignIn.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSignIn.setVerticalAlignment(SwingConstants.TOP);
		lblSignIn.setHorizontalTextPosition(SwingConstants.LEADING);
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblSignIn.setBounds(30, 278, 334, 29);
		contentPanel.add(lblSignIn);
		
		usernameInput = new JTextField();
		usernameInput.setForeground(Color.WHITE);
		usernameInput.setBackground(new Color(52,73,92));
		usernameInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameInput.setBorder(new LineBorder(Color.CYAN));
				passwordInput.setBorder(null);
			}
			
		});
		
		
		usernameInput.setBorder(null);
		usernameInput.setBounds(95, 350, 231, 29);
		contentPanel.add(usernameInput);
		usernameInput.setColumns(10);
		
		JPanel signInBtn = new JPanel();
		signInBtn.setBounds(69, 468, 257, 37);
		signInBtn.setBackground(new Color(0,131,143));
		contentPanel.add(signInBtn);
		signInBtn.setLayout(null);
		
		JLabel lblSignInBtnText = new JLabel("Sign In\r\n ");
		lblSignInBtnText.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSignInBtnText.setVerticalAlignment(SwingConstants.TOP);
		lblSignInBtnText.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSignInBtnText.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignInBtnText.setForeground(Color.WHITE);
		lblSignInBtnText.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblSignInBtnText.setBounds(-38, 8, 334, 29);
		signInBtn.add(lblSignInBtnText);
		
		JLabel lblInOrderTo = new JLabel("in order to access the system\r\n");
		lblInOrderTo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblInOrderTo.setVerticalAlignment(SwingConstants.TOP);
		lblInOrderTo.setHorizontalTextPosition(SwingConstants.LEADING);
		lblInOrderTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInOrderTo.setForeground(Color.WHITE);
		lblInOrderTo.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblInOrderTo.setBounds(32, 303, 334, 29);
		contentPanel.add(lblInOrderTo);
		
		JLabel usernameLogo = new JLabel("");
		usernameLogo.setIcon(new ImageIcon(login.class.getResource("/imgs/user.png")));
		usernameLogo.setBounds(68, 350, 29, 29);
		contentPanel.add(usernameLogo);
		
		JLabel passwordLogo = new JLabel("");
		passwordLogo.setIcon(new ImageIcon(login.class.getResource("/imgs/lock.png")));
		passwordLogo.setBounds(68, 381, 29, 29);
		contentPanel.add(passwordLogo);
		
		JLabel lblCompanyLogo = new JLabel("");
		lblCompanyLogo.setIcon(new ImageIcon(login.class.getResource("/imgs/a.png")));
		lblCompanyLogo.setBounds(91, 534, 24, 24);
		contentPanel.add(lblCompanyLogo);
		
		JLabel lblCopyRights = new JLabel("Copyrights@AA Softarwez");
		lblCopyRights.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCopyRights.setVerticalAlignment(SwingConstants.TOP);
		lblCopyRights.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCopyRights.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyRights.setForeground(Color.WHITE);
		lblCopyRights.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblCopyRights.setBounds(44, 538, 334, 29);
		contentPanel.add(lblCopyRights);
		
		JPanel usernameLogoBox = new JPanel();
		usernameLogoBox.setBounds(66, 350, 29, 29);
		usernameLogoBox.setBackground(new Color(52,73,94));
		contentPanel.add(usernameLogoBox);
		
		JPanel passwordLogoBox = new JPanel();
		passwordLogoBox.setBounds(66, 381, 29, 29);
		passwordLogoBox.setBackground(new Color(52,73,94));
		contentPanel.add(passwordLogoBox);
		
		passwordInput = new JPasswordField();
		passwordInput.setForeground(Color.WHITE);
		passwordInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordInput.setBorder(new LineBorder(Color.CYAN));
				usernameInput.setBorder(null);
			}
		});
		passwordInput.setBorder(null);
		passwordInput.setBounds(95, 381, 231, 29);
		passwordInput.setBackground(new Color(52,73,94));
		contentPanel.add(passwordInput);
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
