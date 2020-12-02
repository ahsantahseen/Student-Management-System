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
import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.border.LineBorder;

public class new1 extends JFrame {
   
   private Point windowPosition = null;         
   private JPanel contentPane;

   public JFrame getWindow() { return this;}

   /**
    * Create the frame.
    */
   public new1() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1126, 608);

      setUndecorated(true);
      setVisible(true);

      contentPane = new JPanel();
   
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel headerBar = new JPanel();
      
      JFrame window = getWindow();
      headerBar.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            Point currentWindowPosition = e.getLocationOnScreen();
            window.setLocation(currentWindowPosition.x - windowPosition.x , currentWindowPosition.y -  windowPosition.y);
         }
      });

      headerBar.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            windowPosition = e.getPoint();
         }

         public void mouseReleased(MouseEvent e) {
            windowPosition = null;
         }
      });
      
      
      //TOP PANEL
      headerBar.setMaximumSize(new Dimension(2147483647, 32767));
      headerBar.setBackground(new Color(44, 62, 80));
      headerBar.setBounds(0, 0, 1141, 22);
      contentPane.add(headerBar);
      headerBar.setLayout(null);
      
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
            JLabel MainMenuLabel = new JLabel("Main Menu");
            MainMenuLabel.setForeground(new Color(255, 255, 255));
            MainMenuLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
            MainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MainMenuLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            MainMenuLabel.setBounds(54, 15, 123, 24);
            sideBar.add(MainMenuLabel);
            
            //COPYRIGHT ICON
            JLabel CompanyIcon = new JLabel("");
            CompanyIcon.setIcon(new ImageIcon(new1.class.getResource("/imgs/a.png")));
            CompanyIcon.setBounds(10, 499, 24, 24);
            sideBar.add(CompanyIcon);
            
            JLabel CompanyLabel = new JLabel("Copyrights@AA Softarwez");
            CompanyLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            CompanyLabel.setHorizontalAlignment(SwingConstants.LEFT);
            CompanyLabel.setForeground(Color.WHITE);
            CompanyLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
            CompanyLabel.setBounds(43, 492, 167, 48);
            sideBar.add(CompanyLabel);
            
                  //Content Area 
      
      JPanel contentArea = new JPanel();
      contentArea.setBackground(new Color(34, 47, 62));
      contentArea.setBounds(245, 22, 881, 636);
      contentPane.add(contentArea);
      contentArea.setLayout(new CardLayout(0, 0));
      
      JPanel Departments = new JPanel();
     
      Departments.setBackground(new Color(34,47,62));
      contentArea.add(Departments, "name_6017372618579");
      Departments.setLayout(null);
      
      JLabel lbldeptTest = new JLabel("Department");
      lbldeptTest.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lbldeptTest.setForeground(Color.WHITE);
      lbldeptTest.setBounds(205, 290, 280, 59);
      Departments.add(lbldeptTest);
      
      JLabel lblClickToView = new JLabel("Click to view Students in this dept");
      
      lblClickToView.setForeground(Color.WHITE);
      lblClickToView.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblClickToView.setBounds(205, 93, 280, 59);
      Departments.add(lblClickToView);
      
      JPanel AboutUs = new JPanel();
     
      AboutUs.setBackground(new Color(34,47,62));
      contentArea.add(AboutUs, "name_6095155560573");
      AboutUs.setLayout(null);
      
      JLabel lblabtus = new JLabel("About us");
      lblabtus.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblabtus.setForeground(Color.WHITE);
      lblabtus.setBounds(216, 212, 253, 60);
      AboutUs.add(lblabtus);
      
      JPanel HowToUse = new JPanel();
      
      HowToUse.setBackground(new Color(34,47,62));
      contentArea.add(HowToUse, "name_6570327227353");
      HowToUse.setLayout(null);
      
      JLabel lblHowToUse = new JLabel("How to use");
      lblHowToUse.setForeground(Color.WHITE);
      lblHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblHowToUse.setBounds(297, 168, 253, 60);
      HowToUse.add(lblHowToUse);
      
      JPanel students = new JPanel();
      students.setBackground(new Color(34,47,62));
      contentArea.add(students, "name_11192510052267");
      students.setLayout(null);
      
      JLabel lblClickToView_1 = new JLabel("Click to view courses of this student\r\n");

      lblClickToView_1.setForeground(Color.WHITE);
      lblClickToView_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblClickToView_1.setBounds(79, 86, 392, 59);
      students.add(lblClickToView_1);
      
      JLabel lblStudent = new JLabel("Student");
      lblStudent.setForeground(Color.WHITE);
      lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblStudent.setBounds(191, 283, 280, 59);
      students.add(lblStudent);
      
      JPanel coursesOfStudent = new JPanel();
      coursesOfStudent.setBackground(new Color(34,47,62));
      contentArea.add(coursesOfStudent, "name_11197816179944");
      coursesOfStudent.setLayout(null);
      
      JLabel lblCourses = new JLabel("Courses");
      lblCourses.setForeground(Color.WHITE);
      lblCourses.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCourses.setBounds(180, 283, 280, 59);
      coursesOfStudent.add(lblCourses);
      
    //THE THREE CATEGORIES OF SIDE BAR 
      JPanel DepartmentBtn = new JPanel();
      JPanel HowToUseBtn = new JPanel();
      JPanel AboutUsBtn = new JPanel();
      
      DepartmentBtn.setBounds(0, 111, 220, 38);
      sideBar.add(DepartmentBtn);
      DepartmentBtn.setLayout(null);
      DepartmentBtn.setBackground(new Color(52, 73, 94));
      
      JLabel DeptIcon = new JLabel("");
      DeptIcon.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            DepartmentBtn.setBackground(new Color(0,131,143));
            HowToUseBtn.setBackground(new Color(52,73,94));
            AboutUsBtn.setBackground(new Color(52,73,94));
            Departments.setVisible(true);
            AboutUs.setVisible(false);
            HowToUse.setVisible(false);
            students.setVisible(false);
            coursesOfStudent.setVisible(false);
            
            
         }
      });
      DeptIcon.setIcon(new ImageIcon(new1.class.getResource("/imgs/department.png")));
      DeptIcon.setBounds(10, 6, 24, 24);
      DepartmentBtn.add(DeptIcon);
      
      JLabel DeptLabel = new JLabel("Departments");
      DeptLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            DepartmentBtn.setBackground(new Color(0,131,143));
            HowToUseBtn.setBackground(new Color(52,73,94));
            AboutUsBtn.setBackground(new Color(52,73,94));
            Departments.setVisible(true);
            AboutUs.setVisible(false);
            HowToUse.setVisible(false);
            students.setVisible(false);
            coursesOfStudent.setVisible(false);
         }
      });
      DeptLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      DeptLabel.setHorizontalAlignment(SwingConstants.LEFT);
      DeptLabel.setForeground(Color.WHITE);
      DeptLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      DeptLabel.setBounds(48, 12, 123, 24);
      DepartmentBtn.add(DeptLabel);
      
      AboutUsBtn.setLayout(null);
      AboutUsBtn.setBackground(new Color(52, 73, 94));
      AboutUsBtn.setBounds(0, 191, 220, 38);
      sideBar.add(AboutUsBtn);
      
      JLabel AboutUsIcon = new JLabel("");
      AboutUsIcon.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            AboutUsBtn.setBackground(new Color(0,131,143));
            HowToUseBtn.setBackground(new Color(52,73,94));
            DepartmentBtn.setBackground(new Color(52,73,94));
            Departments.setVisible(false);
            AboutUs.setVisible(true);
            HowToUse.setVisible(false);
            students.setVisible(false);
            coursesOfStudent.setVisible(false);
         }
      });
      AboutUsIcon.setIcon(new ImageIcon(new1.class.getResource("/imgs/department (1).png")));
      AboutUsIcon.setBounds(10, 7, 24, 24);
      AboutUsBtn.add(AboutUsIcon);
      
      JLabel AboutUsLabel = new JLabel("About Us");
      AboutUsLabel.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            AboutUsBtn.setBackground(new Color(0,131,143));
            HowToUseBtn.setBackground(new Color(52,73,94));
            DepartmentBtn.setBackground(new Color(52,73,94));
            Departments.setVisible(false);
            AboutUs.setVisible(true);
            HowToUse.setVisible(false);
            students.setVisible(false);
            coursesOfStudent.setVisible(false);
         }
      });
      AboutUsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
      AboutUsLabel.setHorizontalAlignment(SwingConstants.LEFT);
      AboutUsLabel.setForeground(Color.WHITE);
      AboutUsLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      AboutUsLabel.setBounds(48, 11, 123, 24);
      AboutUsBtn.add(AboutUsLabel);
      
HowToUseBtn.setLayout(null);
HowToUseBtn.setBackground(new Color(52, 73, 94));
HowToUseBtn.setBounds(0, 271, 220, 38);
sideBar.add(HowToUseBtn);

JLabel HowToUseIcon = new JLabel("");
HowToUseIcon.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
      HowToUseBtn.setBackground(new Color(0,131,143));
      AboutUsBtn.setBackground(new Color(52,73,94));
      DepartmentBtn.setBackground(new Color(52,73,94));
      Departments.setVisible(false);
      AboutUs.setVisible(false);
      HowToUse.setVisible(true);
      students.setVisible(false);
      coursesOfStudent.setVisible(false);
   }
});
HowToUseIcon.setIcon(new ImageIcon(new1.class.getResource("/imgs/personal-data.png")));
HowToUseIcon.setBounds(10, 7, 24, 24);
HowToUseBtn.add(HowToUseIcon);

JLabel HowToUseLabel = new JLabel("How to use?");
HowToUseLabel.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseClicked(MouseEvent e) {
      HowToUseBtn.setBackground(new Color(0,131,143));
      AboutUsBtn.setBackground(new Color(52,73,94));
      DepartmentBtn.setBackground(new Color(52,73,94));
      Departments.setVisible(false);
      AboutUs.setVisible(false);
      HowToUse.setVisible(true);
      students.setVisible(false);
      coursesOfStudent.setVisible(false);
   }
});
HowToUseLabel.setHorizontalTextPosition(SwingConstants.CENTER);
HowToUseLabel.setHorizontalAlignment(SwingConstants.LEFT);
HowToUseLabel.setForeground(Color.WHITE);
HowToUseLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
HowToUseLabel.setBounds(48, 11, 123, 24);
HowToUseBtn.add(HowToUseLabel);


      
      //CLOSING ICON
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            System.exit(0);
         }
      });
      lblNewLabel_1.setIcon(new ImageIcon(new1.class.getResource("/imgs/remove.png")));
      lblNewLabel_1.setBounds(1103, 2, 18, 18);
      headerBar.add(lblNewLabel_1);
      
      JPanel userContent = new JPanel();
      userContent.setBorder(null);
      userContent.setBounds(43, 22, 204, 636);
      userContent.setBackground(new Color(34,47,62) );
      contentPane.add(userContent);
      userContent.setLayout(null);
      
      JLabel UserImg = new JLabel("");
      UserImg.setHorizontalAlignment(SwingConstants.CENTER);
      UserImg.setHorizontalTextPosition(SwingConstants.CENTER);
      UserImg.setIcon(new ImageIcon(new1.class.getResource("/imgs/man.png")));
      UserImg.setBounds(57, 81, 64, 64);
      userContent.add(UserImg);
      
      JLabel SideBarShadow = new JLabel("");
      SideBarShadow.setBounds(139, 0, 41, 636);
      userContent.add(SideBarShadow);
      SideBarShadow.setIcon(new ImageIcon(new1.class.getResource("/imgs/bbbb.png")));
      SideBarShadow.setBackground(new Color(34,47,62));
      
      JPanel userInfoPanel = new JPanel();
      userInfoPanel.setForeground(Color.WHITE);
      userInfoPanel.setBounds(10, 164, 159, 26);
      userInfoPanel.setBackground(new Color(52,73,94));
      userContent.add(userInfoPanel);
      userInfoPanel.setLayout(null);
      
      JLabel lblPersonalDetails = new JLabel("Information\r\n");
      lblPersonalDetails.setForeground(Color.WHITE);
      lblPersonalDetails.setHorizontalAlignment(SwingConstants.CENTER);
      lblPersonalDetails.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblPersonalDetails.setVerticalAlignment(SwingConstants.TOP);
      lblPersonalDetails.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblPersonalDetails.setBounds(24, 6, 110, 14);
      userInfoPanel.add(lblPersonalDetails);
      
      
      JLabel lblName = new JLabel("Name\r\n:");
      lblName.setForeground(Color.GREEN);
      lblName.setVerticalAlignment(SwingConstants.TOP);
      lblName.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblName.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblName.setHorizontalTextPosition(SwingConstants.LEADING);
      lblName.setBounds(10, 211, 110, 14);
      userContent.add(lblName);
      
      JLabel username = new JLabel("Ahsan Tahseen\r\n");
      username.setForeground(Color.ORANGE);
      username.setVerticalTextPosition(SwingConstants.BOTTOM);
      username.setVerticalAlignment(SwingConstants.TOP);
      username.setHorizontalTextPosition(SwingConstants.LEADING);
      username.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      username.setBounds(59, 211, 110, 14);
      userContent.add(username);
      
      JLabel userDesignation = new JLabel("Admin");
      userDesignation.setForeground(Color.ORANGE);
      userDesignation.setHorizontalAlignment(SwingConstants.RIGHT);
      userDesignation.setVerticalTextPosition(SwingConstants.BOTTOM);
      userDesignation.setVerticalAlignment(SwingConstants.TOP);
      userDesignation.setHorizontalTextPosition(SwingConstants.LEADING);
      userDesignation.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      userDesignation.setBounds(32, 236, 110, 14);
      userContent.add(userDesignation);
      
      JLabel lblDesignation = new JLabel("Designation:");
      lblDesignation.setForeground(Color.GREEN);
      lblDesignation.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblDesignation.setVerticalAlignment(SwingConstants.TOP);
      lblDesignation.setHorizontalTextPosition(SwingConstants.LEADING);
      lblDesignation.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblDesignation.setBounds(10, 236, 110, 16);
      userContent.add(lblDesignation);
      
      JPanel DeptAuthPanel = new JPanel();
      DeptAuthPanel.setLayout(null);
      DeptAuthPanel.setBackground(new Color(52,74,94));
      DeptAuthPanel.setBounds(10, 264, 159, 50);
      userContent.add(DeptAuthPanel);
      
      JLabel lblDepartment = new JLabel("Department ");
      lblDepartment.setForeground(Color.WHITE);
      lblDepartment.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblDepartment.setVerticalAlignment(SwingConstants.TOP);
      lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
      lblDepartment.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblDepartment.setBounds(24, 8, 110, 14);
      DeptAuthPanel.add(lblDepartment);
      
      JLabel lblAuthorities = new JLabel("Authoritization");
      lblAuthorities.setForeground(Color.WHITE);
      lblAuthorities.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblAuthorities.setVerticalAlignment(SwingConstants.TOP);
      lblAuthorities.setHorizontalAlignment(SwingConstants.CENTER);
      lblAuthorities.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblAuthorities.setBounds(24, 27, 110, 14);
      DeptAuthPanel.add(lblAuthorities);
      
      JLabel lblComputerSciences = new JLabel("Computer Science");
      lblComputerSciences.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblComputerSciences.setVerticalAlignment(SwingConstants.TOP);
      lblComputerSciences.setHorizontalTextPosition(SwingConstants.LEADING);
      lblComputerSciences.setForeground(Color.YELLOW);
      lblComputerSciences.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblComputerSciences.setBounds(10, 331, 159, 16);
      userContent.add(lblComputerSciences);
      
      JLabel lblMedicalSciences = new JLabel("Medical Science");
      lblMedicalSciences.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblMedicalSciences.setVerticalAlignment(SwingConstants.TOP);
      lblMedicalSciences.setHorizontalTextPosition(SwingConstants.LEADING);
      lblMedicalSciences.setForeground(Color.YELLOW);
      lblMedicalSciences.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblMedicalSciences.setBounds(11, 360, 131, 16);
      userContent.add(lblMedicalSciences);
      
      JLabel lblMediaarts = new JLabel("Media Science\r\n\r\n");
      lblMediaarts.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblMediaarts.setVerticalAlignment(SwingConstants.TOP);
      lblMediaarts.setHorizontalTextPosition(SwingConstants.LEADING);
      lblMediaarts.setForeground(Color.YELLOW);
      lblMediaarts.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblMediaarts.setBounds(11, 416, 110, 16);
      userContent.add(lblMediaarts);
      
      JLabel lblMechatronics = new JLabel("Mechatronics");
      lblMechatronics.setVerticalTextPosition(SwingConstants.BOTTOM);
      lblMechatronics.setVerticalAlignment(SwingConstants.TOP);
      lblMechatronics.setHorizontalTextPosition(SwingConstants.LEADING);
      lblMechatronics.setForeground(Color.YELLOW);
      lblMechatronics.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lblMechatronics.setBounds(11, 388, 110, 16);
      userContent.add(lblMechatronics);
      
      JPanel userStatusPanel = new JPanel();
      userStatusPanel.setLayout(null);
      userStatusPanel.setForeground(Color.WHITE);
      userStatusPanel.setBackground(new Color(52, 73, 94));
      userStatusPanel.setBounds(10, 11, 159, 26);
      userContent.add(userStatusPanel);
      
      JLabel userStatusText = new JLabel("Online");
      userStatusText.setVerticalTextPosition(SwingConstants.BOTTOM);
      userStatusText.setVerticalAlignment(SwingConstants.TOP);
      userStatusText.setHorizontalAlignment(SwingConstants.CENTER);
      userStatusText.setForeground(Color.WHITE);
      userStatusText.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      userStatusText.setBounds(39, 6, 86, 14);
      userStatusPanel.add(userStatusText);
      
      JLabel userStatusIndicator = new JLabel("*");
      userStatusIndicator.setBackground(Color.GREEN);
      userStatusIndicator.setVerticalTextPosition(SwingConstants.BOTTOM);
      userStatusIndicator.setVerticalAlignment(SwingConstants.TOP);
      userStatusIndicator.setHorizontalAlignment(SwingConstants.CENTER);
      userStatusIndicator.setForeground(Color.GREEN);
      userStatusIndicator.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      userStatusIndicator.setBounds(8, 6, 86, 14);
      userStatusPanel.add(userStatusIndicator);
      
      JPanel userSignout = new JPanel();
      userSignout.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
      userSignout.setBounds(10, 499, 159, 28);
      userSignout.setBackground(new Color(231, 76, 60));
      userContent.add(userSignout);
      userSignout.setLayout(null);
      
      JLabel userSignOutText = new JLabel("Sign Out");
      userSignOutText.setForeground(Color.WHITE);
      userSignOutText.setHorizontalAlignment(SwingConstants.CENTER);
      userSignOutText.setVerticalTextPosition(SwingConstants.BOTTOM);
      userSignOutText.setVerticalAlignment(SwingConstants.TOP);
      userSignOutText.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      userSignOutText.setBounds(10, 6, 139, 16);
      userSignout.add(userSignOutText);
      
      JLabel lbllastLogin = new JLabel("*Last seen 22:17 PM*");
      lbllastLogin.setVerticalTextPosition(SwingConstants.BOTTOM);
      lbllastLogin.setVerticalAlignment(SwingConstants.TOP);
      lbllastLogin.setHorizontalAlignment(SwingConstants.CENTER);
      lbllastLogin.setForeground(Color.WHITE);
      lbllastLogin.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      lbllastLogin.setBounds(5, 44, 170, 16);
      userContent.add(lbllastLogin);
      
      
      //Special Mouse Listeners for changing Department to students to courses of students
      
      lblClickToView.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
              Departments.setVisible(false);
              AboutUs.setVisible(false);
              HowToUse.setVisible(false);
              students.setVisible(true);
              coursesOfStudent.setVisible(false);
        	}
        });
      
      lblClickToView_1.addMouseListener(new MouseAdapter() {
        	
        	      	@Override
        	      	public void mouseClicked(MouseEvent e) {
        	            Departments.setVisible(false);
        	            AboutUs.setVisible(false);
        	            HowToUse.setVisible(false);
        	            students.setVisible(false);
        	            coursesOfStudent.setVisible(true);
        	      	}
        	      });
           
      
   }
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
            
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               new1 frame = new new1(); 
               frame.setLocationRelativeTo(null);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}
