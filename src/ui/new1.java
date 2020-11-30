package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;

public class new1 extends JFrame {
   
   private Point windowPosition = null;         
   private JPanel contentPane;

   public JFrame getWindow() { return this;}

   /**
    * Create the frame.
    */
   public new1() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 924, 608);

      setUndecorated(true);
      setVisible(true);

      contentPane = new JPanel();
   
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel = new JPanel();
      
      JFrame window = getWindow();
      panel.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            Point currentWindowPosition = e.getLocationOnScreen();
            window.setLocation(currentWindowPosition.x - windowPosition.x , currentWindowPosition.y -  windowPosition.y);
         }
      });

      panel.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            windowPosition = e.getPoint();
         }

         public void mouseReleased(MouseEvent e) {
            windowPosition = null;
         }
      });
      
      
      //TOP PANEL
      panel.setMaximumSize(new Dimension(2147483647, 32767));
      panel.setBackground(new Color(61, 61, 61));
      panel.setBounds(0, 0, 927, 22);
      contentPane.add(panel);
      panel.setLayout(null);
      
      //CLOSING ICON
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            System.exit(0);
         }
      });
      lblNewLabel_1.setIcon(new ImageIcon(new1.class.getResource("/imgs/remove.png")));
      lblNewLabel_1.setBounds(900, 2, 18, 18);
      panel.add(lblNewLabel_1);
      
      //SIDE BAR W - 44 H - 606
      JPanel sideBar = new JPanel();
      sideBar.setBackground(new Color(52, 73, 94));
      sideBar.setBounds(0, 22, 43, 636);
      contentPane.add(sideBar);
      sideBar.setLayout(null);
      
      //MENU ICON
      JLabel sideBarOpenHandler = new JLabel("");
      sideBarOpenHandler.setIcon(new ImageIcon(new1.class.getResource("/imgs/menu.png")));
      sideBarOpenHandler.setBounds(10, 11, 24, 24);
      sideBar.add(sideBarOpenHandler);
      
      //MENU ICON
      JLabel sideBarCloseHandler = new JLabel(""); 
      sideBarCloseHandler.setIcon(new ImageIcon(new1.class.getResource("/imgs/menu.png")));
      sideBarCloseHandler.setBounds(10, 11, 24, 24);
      sideBar.add(sideBarCloseHandler);
      
      //ANIMATION OPENING
      sideBarOpenHandler.addMouseListener(new MouseAdapter() {
         
         public void mouseClicked(MouseEvent e) {
            
               Thread th=new Thread() {
                  public void run() {
               try {
               for(int i=43;i<221;i++) {
                  Thread.sleep(1);
                  sideBar.setSize(i, 606);
                  
                  
               }
               sideBarOpenHandler.setVisible(false);
               
               sideBarCloseHandler.setEnabled(true);
               sideBarCloseHandler.setVisible(true);
            
            
         }
               catch(Exception ex) {
                  System.out.println(ex.getMessage());
               }
                  }
            };
            th.start();
         
         }
      });

      //ANIMATION CLOSIN
      sideBarCloseHandler.addMouseListener(new MouseAdapter() {
         @Override
      
            public void mouseClicked(MouseEvent e) {
               
               Thread th=new Thread() {
                  public void run() {
               try {
               for(int i=0;i<178;i++) {
                  Thread.sleep(1);
                  sideBar.setSize(220-i, 606);
                  
                  
               }
               sideBarOpenHandler.setVisible(true);
               
               sideBarCloseHandler.setVisible(false);
            
            
         }
               catch(Exception ex) {
                  System.out.println(ex.getMessage());
               }
                  }
            };
            th.start();
            
         }
      });
      
      //MAIN MENU TEXT
      JLabel lblNewLabel = new JLabel("Main Menu");
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel.setBounds(54, 15, 123, 24);
      sideBar.add(lblNewLabel);
      
      //COPYRIGHT ICON
      JLabel sideBarIcon1_2_1 = new JLabel("");
      sideBarIcon1_2_1.setIcon(new ImageIcon(new1.class.getResource("/imgs/a.png")));
      sideBarIcon1_2_1.setBounds(10, 499, 24, 24);
      sideBar.add(sideBarIcon1_2_1);
      
      JLabel lblNewLabel_3_1 = new JLabel("Copyrights@AA Softarwez");
      lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel_3_1.setForeground(Color.WHITE);
      lblNewLabel_3_1.setFont(new Font("Yu Gothic", Font.BOLD, 12));
      lblNewLabel_3_1.setBounds(43, 492, 167, 48);
      sideBar.add(lblNewLabel_3_1);
      
      //THE THREE CATEGORIES
      JPanel panel_1 = new JPanel();
      JPanel panel_1_2 = new JPanel();
      JPanel panel_1_1 = new JPanel();
      
      panel_1.setBounds(0, 111, 220, 38);
      sideBar.add(panel_1);
      panel_1.setLayout(null);
      panel_1.setBackground(new Color(52, 73, 94));
      
      JLabel sideBarIcon1 = new JLabel("");
      sideBarIcon1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1.setBackground(new Color(0,131,143));
            panel_1_2.setBackground(new Color(52,73,94));
            panel_1_1.setBackground(new Color(52,73,94));
         }
      });
      sideBarIcon1.setIcon(new ImageIcon(new1.class.getResource("/imgs/department.png")));
      sideBarIcon1.setBounds(10, 7, 24, 24);
      panel_1.add(sideBarIcon1);
      
      JLabel lblNewLabel_2 = new JLabel("Departments");
      lblNewLabel_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1.setBackground(new Color(0,131,143));
            panel_1_2.setBackground(new Color(52,73,94));
            panel_1_1.setBackground(new Color(52,73,94));
         }
      });
      lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel_2.setForeground(Color.WHITE);
      lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblNewLabel_2.setBounds(45, 12, 123, 24);
      panel_1.add(lblNewLabel_2);
      
      panel_1_1.setLayout(null);
      panel_1_1.setBackground(new Color(52, 73, 94));
      panel_1_1.setBounds(0, 191, 220, 38);
      sideBar.add(panel_1_1);
      
      JLabel sideBarIcon1_1 = new JLabel("");
      sideBarIcon1_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1_1.setBackground(new Color(0,131,143));
            panel_1_2.setBackground(new Color(52,73,94));
            panel_1.setBackground(new Color(52,73,94));
         }
      });
      sideBarIcon1_1.setIcon(new ImageIcon(new1.class.getResource("/imgs/department (1).png")));
      sideBarIcon1_1.setBounds(10, 7, 24, 24);
      panel_1_1.add(sideBarIcon1_1);
      
      JLabel lblNewLabel_2_1 = new JLabel("Students");
      lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1_1.setBackground(new Color(0,131,143));
            panel_1_2.setBackground(new Color(52,73,94));
            panel_1.setBackground(new Color(52,73,94));
         }
      });
      lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel_2_1.setForeground(Color.WHITE);
      lblNewLabel_2_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblNewLabel_2_1.setBounds(48, 11, 123, 24);
      panel_1_1.add(lblNewLabel_2_1);
         
      panel_1_2.setLayout(null);
      panel_1_2.setBackground(new Color(52, 73, 94));
      panel_1_2.setBounds(0, 271, 220, 38);
      sideBar.add(panel_1_2);
      
      JLabel sideBarIcon1_2 = new JLabel("");
      sideBarIcon1_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1_2.setBackground(new Color(0,131,143));
            panel_1_1.setBackground(new Color(52,73,94));
            panel_1.setBackground(new Color(52,73,94));
         }
      });
      sideBarIcon1_2.setIcon(new ImageIcon(new1.class.getResource("/imgs/personal-data.png")));
      sideBarIcon1_2.setBounds(10, 7, 24, 24);
      panel_1_2.add(sideBarIcon1_2);
      
      JLabel lblNewLabel_2_2 = new JLabel("Courses");
      lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            panel_1_2.setBackground(new Color(0,131,143));
            panel_1_1.setBackground(new Color(52,73,94));
            panel_1.setBackground(new Color(52,73,94));
         }
      });
      lblNewLabel_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
      lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel_2_2.setForeground(Color.WHITE);
      lblNewLabel_2_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblNewLabel_2_2.setBounds(48, 11, 123, 24);
      panel_1_2.add(lblNewLabel_2_2);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(new Color(34, 47, 62));
      panel_2.setBounds(39, 22, 885, 636);
      contentPane.add(panel_2);
      panel_2.setLayout(null);      
      
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
            
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               new1 frame = new new1();               
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}
