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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class new1 extends JFrame {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Point windowPosition = null;         
   private JPanel contentPane;
   private JTextField deptIdInput;
   private JTextField deptNameInput;
   private JTextField deptNoOfStudentsInput;
   private JTextField deptHodInput;
   private JTable table;
   private JTextField studentIdInput;
   private JTextField studentNameInput;
   private JTextField StudentNoOfCourses;
   private JTextField studentFnameInput;
   private JTextField studentSectionInput;
   private JTable stdRecordTable;
   private String deptNameStr;
   private JTextField SearchInput;
   private JTextField SearchStudentInput;
   private JTextField crsIDInput;
   private JTextField crsNameInput;
   private JTextField crsTotalMarksInput;
   private JTextField crsCreditHrsInput;
   private JTextField crsObtainedMarksInput;
   private JTextField searchCourseInput;
   private JTextField crsCourseGpaInput;
   private JTextField crsCourseGradeInput;
   private JTable crsRecordTable;

   public JFrame getWindow() { return this;}

   /**
    * Create the frame.
    */
   public new1() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1178, 608);

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
      headerBar.setBounds(0, 0, 1178, 22);
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
      contentArea.setBounds(245, 22, 933, 636);
      contentPane.add(contentArea);
      contentArea.setLayout(new CardLayout(0, 0));
      
      JPanel Departments = new JPanel();
      Departments.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		deptIdInput.setBorder(null);
      		deptHodInput.setBorder(null);
      		deptNameInput.setBorder(null);
      		deptNoOfStudentsInput.setBorder(null);
      		SearchInput.setBorder(null);

      	}
      });
      Departments.setFont(new Font("Yu Gothic", Font.BOLD, 13));
     
      Departments.setBackground(new Color(34,47,62));
      contentArea.add(Departments, "name_6017372618579");
      Departments.setLayout(null);
      
      JLabel lblDepartmentsPanel = new JLabel("Department's Panel:");
      lblDepartmentsPanel.setBounds(10, 11, 280, 35);
      Departments.add(lblDepartmentsPanel);
      lblDepartmentsPanel.setForeground(Color.WHITE);
      lblDepartmentsPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
      
      JTextPane txtDeptDesc = new JTextPane();
      txtDeptDesc.setEditable(false);
      txtDeptDesc.setForeground(Color.ORANGE);
      txtDeptDesc.setBackground(new Color(34,47,62));
      txtDeptDesc.setText("In this panel, all the information related to the departments established in the institute is managed. \r\n");
      txtDeptDesc.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtDeptDesc.setBounds(9, 40, 430, 59);
      Departments.add(txtDeptDesc);
      
      JLabel lblDepartmentsId = new JLabel("Department's ID \r\n");
      lblDepartmentsId.setHorizontalAlignment(SwingConstants.CENTER);
      lblDepartmentsId.setForeground(Color.WHITE);
      lblDepartmentsId.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblDepartmentsId.setBounds(12, 154, 202, 35);
      Departments.add(lblDepartmentsId);
      
      deptIdInput = new JTextField();
      deptIdInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		deptIdInput.setBorder(new LineBorder(Color.CYAN));
      		deptHodInput.setBorder(null);
      		deptNameInput.setBorder(null);
      		deptNoOfStudentsInput.setBorder(null);
      		SearchInput.setBorder(null);

      	}
      });
      deptIdInput.setHorizontalAlignment(SwingConstants.CENTER);
      deptIdInput.setForeground(Color.WHITE);
      deptIdInput.setBorder(null);
      deptIdInput.setBounds(12, 200, 202, 27);
      deptIdInput.setBackground(new Color(52,73,94));
      Departments.add(deptIdInput);
      deptIdInput.setColumns(10);
      
      JLabel lblDepartmentsName = new JLabel("Name of Department\r\n");
      lblDepartmentsName.setHorizontalAlignment(SwingConstants.CENTER);
      lblDepartmentsName.setForeground(Color.WHITE);
      lblDepartmentsName.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblDepartmentsName.setBounds(224, 154, 202, 35);
      Departments.add(lblDepartmentsName);
      
      deptNameInput = new JTextField();
      deptNameInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {

      		deptNameInput.setBorder(new LineBorder(Color.CYAN));
      		deptHodInput.setBorder(null);
      		deptIdInput.setBorder(null);
      		deptNoOfStudentsInput.setBorder(null);
      		SearchInput.setBorder(null);

      	}
      });
      deptNameInput.setHorizontalAlignment(SwingConstants.CENTER);
      deptNameInput.setForeground(Color.WHITE);
      deptNameInput.setBorder(null);
      deptNameInput.setColumns(10);
      deptNameInput.setBounds(224, 200, 202, 27);
      deptNameInput.setBackground(new Color(52,73,94));
      Departments.add(deptNameInput);
      
      JLabel lblDepartmentsNumberOf = new JLabel(" Number of Students\r\n\r\n");
      lblDepartmentsNumberOf.setHorizontalAlignment(SwingConstants.CENTER);
      lblDepartmentsNumberOf.setForeground(Color.WHITE);
      lblDepartmentsNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblDepartmentsNumberOf.setBounds(643, 152, 203, 35);
      Departments.add(lblDepartmentsNumberOf);
      
      deptNoOfStudentsInput = new JTextField();
      deptNoOfStudentsInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {

      		deptNoOfStudentsInput.setBorder(new LineBorder(Color.CYAN));
      		deptHodInput.setBorder(null);
      		deptNameInput.setBorder(null);
      		deptIdInput.setBorder(null);
      		SearchInput.setBorder(null);

      	}
      });
      deptNoOfStudentsInput.setHorizontalAlignment(SwingConstants.CENTER);
      deptNoOfStudentsInput.setForeground(Color.WHITE);
      deptNoOfStudentsInput.setBorder(null);
      deptNoOfStudentsInput.setColumns(10);
      deptNoOfStudentsInput.setBounds(644, 200, 202, 27);
      deptNoOfStudentsInput.setBackground(new Color(52,73,94));
      Departments.add(deptNoOfStudentsInput);
      
      JLabel lblDepartmentsHead = new JLabel("Head of Department\r\n");
      lblDepartmentsHead.setHorizontalAlignment(SwingConstants.CENTER);
      lblDepartmentsHead.setForeground(Color.WHITE);
      lblDepartmentsHead.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblDepartmentsHead.setBounds(431, 153, 202, 35);
      Departments.add(lblDepartmentsHead);
      
      deptHodInput = new JTextField();
      deptHodInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {

      		deptHodInput.setBorder(new LineBorder(Color.CYAN));
      		deptIdInput.setBorder(null);
      		deptNameInput.setBorder(null);
      		deptNoOfStudentsInput.setBorder(null);
      		SearchInput.setBorder(null);

      	}
      });
      deptHodInput.setHorizontalAlignment(SwingConstants.CENTER);
      deptHodInput.setForeground(Color.WHITE);
      deptHodInput.setBorder(null);
      deptHodInput.setColumns(10);
      deptHodInput.setBounds(433, 200, 202, 27);
      deptHodInput.setBackground(new Color(52,73,94));
      Departments.add(deptHodInput);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setFont(new Font("Yu Gothic", Font.BOLD, 13));
      scrollPane.setBorder(null);
      scrollPane.setBackground(new Color(52,73,94));
      
      scrollPane.setBounds(10, 283, 852, 195);
      Departments.add(scrollPane);
      
      table = new JTable();
      table.setRowMargin(2);
      table.setForeground(Color.WHITE);
      
      
      
      table.setFont(new Font("Yu Gothic", Font.BOLD, 13));
      table.setAlignmentX(Component.RIGHT_ALIGNMENT);
      table.setShowHorizontalLines(false);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      table.setFillsViewportHeight(true);
      table.setSize(new Dimension(24, 24));
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      table.setRowHeight(24);
      
      table.setGridColor(Color.WHITE);
      table.setBackground(new Color(34,47,62) );
      table.setBorder(null);
      table.getTableHeader().setBackground(new Color(34,47,62) );
      table.getTableHeader().setForeground(Color.white);
      table.getTableHeader().setBorder(null);
      table.getTableHeader().setOpaque(false);
      table.setSelectionBackground(new Color(0,131,143));
      table.setSelectionForeground(Color.WHITE);
      
       Object[][] tableModelData= {
    		{"DP1929", "BSCS", "Asim Riaz", "19"},
    		{"DP1930", "BSCS", "Nadeem Qamar", "60"},
    		{"DP1931", "BSCS", "Waseem Badami ", "90"},
    		{"DP1932", "BSCS", "Asif Khalid", "10"},
    		{"DP1933", "BSCS", "Sikandar Khan", "100"},

    	};
    	String[] tableModelDataColumns = {
    		"Department's ID", "Department's Name", "Department's HOD", "No. of Students"
    	};
    	
       DefaultTableModel tableModel=new DefaultTableModel(tableModelData, tableModelDataColumns) {
    	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column) {
    		 return false;
    	 }
       };
     
      
      
      table.setModel(tableModel);
      table.getColumnModel().getColumn(0).setPreferredWidth(90);
      table.getColumnModel().getColumn(1).setPreferredWidth(120);
      table.getColumnModel().getColumn(2).setPreferredWidth(120);
      table.getColumnModel().getColumn(3).setPreferredWidth(127);
      scrollPane.setViewportView(table);
      
      JLabel addRecordBtn = new JLabel("");
      addRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      addRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/plus.png")));
      addRecordBtn.setBounds(885, 284, 24, 24);
      Departments.add(addRecordBtn);
      
      JLabel deleteRecordBtn = new JLabel("");
      deleteRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Delete_132192.png")));
      deleteRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      deleteRecordBtn.setBounds(885, 338, 24, 24);
      Departments.add(deleteRecordBtn);
      
      JLabel editRecordBtn = new JLabel("");
      editRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/pencil.png")));
      editRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      editRecordBtn.setBounds(885, 394, 24, 24);
      Departments.add(editRecordBtn);
      
      JLabel truncateBtn = new JLabel("");
      truncateBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Wizard_132269.png")));
      truncateBtn.setHorizontalAlignment(SwingConstants.CENTER);
      truncateBtn.setBounds(885, 451, 24, 24);
      Departments.add(truncateBtn);
      
      JLabel lblSearchDepartmentBy = new JLabel("Search Department By ID or Name");
      lblSearchDepartmentBy.setForeground(Color.WHITE);
      lblSearchDepartmentBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblSearchDepartmentBy.setBounds(10, 490, 338, 35);
      Departments.add(lblSearchDepartmentBy);
      
      SearchInput = new JTextField();
      SearchInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {

      		SearchInput.setBorder(new LineBorder(Color.CYAN));
      		deptHodInput.setBorder(null);
      		deptNameInput.setBorder(null);
      		deptNoOfStudentsInput.setBorder(null);
      		deptIdInput.setBorder(null);
      		      	}
      });
      SearchInput.setHorizontalAlignment(SwingConstants.CENTER);
      SearchInput.setForeground(Color.WHITE);
      SearchInput.setColumns(10);
      SearchInput.setBorder(null);
      SearchInput.setBackground(new Color(52, 73, 94));
      SearchInput.setBounds(10, 536, 202, 27);
      Departments.add(SearchInput);
      
      JLabel clearFieldBtn = new JLabel("");
      clearFieldBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/icons8-clear-symbol-24.png")));
      clearFieldBtn.setHorizontalAlignment(SwingConstants.CENTER);
      clearFieldBtn.setBounds(884, 200, 24, 24);
      Departments.add(clearFieldBtn);
      
      JLabel searchRecordBtn = new JLabel("");
      searchRecordBtn.setBackground(new Color(52,73,94));
      searchRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/magnifying-glass.png")));
      searchRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      searchRecordBtn.setBounds(216, 537, 27, 27);
      Departments.add(searchRecordBtn);
      
      JLabel lbltheFollowingResults = new JLabel("*The following results will be displayed in the table above*");
      lbltheFollowingResults.setForeground(Color.WHITE);
      lbltheFollowingResults.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lbltheFollowingResults.setBounds(259, 529, 338, 35);
      Departments.add(lbltheFollowingResults);
      
      JPanel AboutUs = new JPanel();
     
      AboutUs.setBackground(new Color(34,47,62));
      contentArea.add(AboutUs, "name_6095155560573");
      AboutUs.setLayout(null);
      
      JLabel logoTxt = new JLabel("AA Softarwez");
      logoTxt.setHorizontalAlignment(SwingConstants.CENTER);
      logoTxt.setFont(new Font("Yu Gothic", Font.BOLD, 21));
      logoTxt.setForeground(Color.WHITE);
      logoTxt.setBounds(340, 226, 253, 60);
      AboutUs.add(logoTxt);
      
      JLabel Logo = new JLabel("");
      Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/logo1.png")));
      Logo.setBounds(338, 31, 256, 256);
      AboutUs.add(Logo);
      
      JTextPane txtLines = new JTextPane();
      txtLines.setForeground(Color.WHITE);
      txtLines.setText("AA Softarwez (established in late September 2020) is the brain-child of two undergraduates from SZABIST, the primary inspiration driving this is to improve the advancement collaboration between individuals and to develop market standard to make market standard products that will be an ideal issue solver. \r\n\r\nMuch obliged to you for picking AA Softarwez as your difficulty solver!");
      txtLines.setFont(new Font("Yu Gothic", Font.BOLD, 17));
      txtLines.setBounds(78, 316, 777, 201);
      txtLines.setBackground(new Color(34,47,62));
      AboutUs.add(txtLines);
      
      JPanel HowToUse = new JPanel();
      
      HowToUse.setBackground(new Color(34,47,62));
      contentArea.add(HowToUse, "name_6570327227353");
      HowToUse.setLayout(null);
      
      JLabel HTUheading = new JLabel("How to use?");
      HTUheading.setHorizontalAlignment(SwingConstants.CENTER);
      HTUheading.setForeground(Color.WHITE);
      HTUheading.setFont(new Font("Yu Gothic", Font.BOLD, 25));
      HTUheading.setBounds(329, 139, 253, 60);
      HowToUse.add(HTUheading);
      
      JLabel confusedBoyLogo = new JLabel("");
      confusedBoyLogo.setIcon(new ImageIcon(new1.class.getResource("/imgs/confused.png")));
      confusedBoyLogo.setForeground(Color.WHITE);
      confusedBoyLogo.setFont(new Font("Yu Gothic", Font.BOLD, 18));
      confusedBoyLogo.setBounds(402, 10, 128, 128);
      HowToUse.add(confusedBoyLogo);
      
      JTextPane txtBigLines = new JTextPane();
      txtBigLines.setText("Don't worry we got you covered !\r\n\r\nThe userinterface is pretty easy to understand as you can work your way around it for more comfortability,here are some buttons and what role they play in the software:\r\n\r\n");
      txtBigLines.setForeground(Color.WHITE);
      txtBigLines.setFont(new Font("Yu Gothic", Font.BOLD, 17));
      txtBigLines.setBackground(new Color(34, 47, 62));
      txtBigLines.setBounds(10, 175, 777, 122);
      HowToUse.add(txtBigLines);
      
      JPanel mainBoxGrid = new JPanel();
      mainBoxGrid.setBorder(new LineBorder(Color.WHITE, 3));
      mainBoxGrid.setBounds(10, 308, 891, 128);
      mainBoxGrid.setBackground(new Color(34,47,62));
      HowToUse.add(mainBoxGrid);
      mainBoxGrid.setLayout(null);
      
      JPanel box1 = new JPanel();
      box1.setLayout(null);
      box1.setBorder(new LineBorder(Color.WHITE, 3));
      box1.setBackground(new Color(34, 47, 62));
      box1.setBounds(0, 0, 151, 128);
      mainBoxGrid.add(box1);
      
      JLabel box1Logo = new JLabel("");
      box1Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/back.png")));
      box1Logo.setBounds(63, 11, 24, 24);
      box1.add(box1Logo);
      
      JTextPane box1Txt = new JTextPane();
      box1Txt.setForeground(Color.WHITE);
      box1Txt.setText("This is the button which you can click to go back to the last panel\r\n");
      box1Txt.setBounds(10, 46, 131, 71);
      box1Txt.setBackground(new Color(34,47,62));
      box1.add(box1Txt);
      
      JPanel box2 = new JPanel();
      box2.setLayout(null);
      box2.setBorder(new LineBorder(Color.WHITE, 3));
      box2.setBackground(new Color(34, 47, 62));
      box2.setBounds(149, 0, 151, 128);
      mainBoxGrid.add(box2);
      
      JLabel box2Logo = new JLabel("");
      box2Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/magnifying-glass.png")));
      box2Logo.setBounds(60, 11, 24, 24);
      box2.add(box2Logo);
      
      JTextPane box2Txt = new JTextPane();
      box2Txt.setForeground(Color.WHITE);
      box2Txt.setText("This is the button through which u can search any record in the database\r\n");
      box2Txt.setBounds(10, 46, 131, 71);
      box2Txt.setBackground(new Color(34,47,62));
      box2.add(box2Txt);
      
      JPanel box3 = new JPanel();
      box3.setLayout(null);
      box3.setBorder(new LineBorder(Color.WHITE, 3));
      box3.setBackground(new Color(34, 47, 62));
      box3.setBounds(299, 0, 151, 128);
      mainBoxGrid.add(box3);
      
      JLabel box3Logo = new JLabel("");
      box3Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Delete_132192.png")));
      box3Logo.setBounds(63, 11, 24, 24);
      box3.add(box3Logo);
      
      JTextPane box3Txt = new JTextPane();
      box3Txt.setForeground(Color.WHITE);
      box3Txt.setText("This is the button through which you can delete any record in the database\r\n");
      box3Txt.setBounds(10, 46, 131, 71);
      box3Txt.setBackground(new Color(34,47,62));
      box3.add(box3Txt);
      
      JPanel box4 = new JPanel();
      box4.setLayout(null);
      box4.setBorder(new LineBorder(Color.WHITE, 3));
      box4.setBackground(new Color(34, 47, 62));
      box4.setBounds(447, 0, 151, 128);
      mainBoxGrid.add(box4);
      
      JLabel box4Logo = new JLabel("");
      box4Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/plus.png")));
      box4Logo.setBounds(63, 11, 24, 24);
      box4.add(box4Logo);
      
      JTextPane box4Txt = new JTextPane();
      box4Txt.setForeground(Color.WHITE);
      box4Txt.setText("This is the button through which you can add any record in the database\r\n");
      box4Txt.setBounds(10, 46, 131, 71);
      box4Txt.setBackground(new Color(34,47,62));
      box4.add(box4Txt);
      
      JPanel box5 = new JPanel();
      box5.setLayout(null);
      box5.setBorder(new LineBorder(Color.WHITE, 3));
      box5.setBackground(new Color(34, 47, 62));
      box5.setBounds(596, 0, 151, 128);
      mainBoxGrid.add(box5);
      
      JLabel box5Logo = new JLabel("");
      box5Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/icons8-clear-symbol-24.png")));
      box5Logo.setBounds(63, 11, 24, 24);
      box5.add(box5Logo);
      
      JTextPane box5Txt = new JTextPane();
      box5Txt.setForeground(Color.WHITE);
      box5Txt.setText("This is the button through which you can clear data in the input fields \r\n");
      box5Txt.setBounds(10, 46, 131, 71);
      box5Txt.setBackground(new Color(34,47,62));
      box5.add(box5Txt);
      
      JPanel box6 = new JPanel();
      box6.setLayout(null);
      box6.setBorder(new LineBorder(Color.WHITE, 3));
      box6.setBackground(new Color(34, 47, 62));
      box6.setBounds(740, 0, 151, 128);
      mainBoxGrid.add(box6);
      
      JLabel box6Logo = new JLabel("");
      box6Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/pencil.png")));
      box6Logo.setBounds(64, 11, 24, 24);
      box6.add(box6Logo);
      
      JTextPane box6Txt = new JTextPane();
      box6Txt.setForeground(Color.WHITE);
      box6Txt.setText("This is the button through which you can edit any record in the database\r\n");
      box6Txt.setBounds(12, 46, 131, 71);
      box6Txt.setBackground(new Color(34,47,62));
      box6.add(box6Txt);
      
      JPanel box7outsideGrid = new JPanel();
      box7outsideGrid.setLayout(null);
      box7outsideGrid.setBorder(new LineBorder(Color.WHITE, 3));
      box7outsideGrid.setBackground(new Color(34, 47, 62));
      box7outsideGrid.setBounds(308, 433, 151, 122);
      HowToUse.add(box7outsideGrid);
      
      JLabel box7Logo = new JLabel("");
      box7Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Wizard_132269.png")));
      box7Logo.setBounds(63, 11, 24, 24);
      box7outsideGrid.add(box7Logo);
      
      JTextPane box7Txt = new JTextPane();
      box7Txt.setForeground(Color.WHITE);
      box7Txt.setText("Be careful! As this button wipes out all the records in the database\r\n\r\n*Use with caution*");
      box7Txt.setBounds(10, 39, 131, 73);
      box7Txt.setBackground(new Color(34,47,62));
      box7outsideGrid.add(box7Txt);
      
      JPanel box8outsideGrid = new JPanel();
      box8outsideGrid.setLayout(null);
      box8outsideGrid.setBorder(new LineBorder(Color.WHITE, 3));
      box8outsideGrid.setBackground(new Color(34, 47, 62));
      box8outsideGrid.setBounds(457, 433, 151, 122);
      HowToUse.add(box8outsideGrid);
      
      JLabel box8Logo = new JLabel("");
      box8Logo.setIcon(new ImageIcon(new1.class.getResource("/imgs/menu.png")));
      box8Logo.setBounds(63, 11, 24, 24);
      box8outsideGrid.add(box8Logo);
      
      JTextPane box8Txt = new JTextPane();
      box8Txt.setText("This is the button which you can click to go enlarge the side menu bar\r\n");
      box8Txt.setForeground(Color.WHITE);
      box8Txt.setBackground(new Color(34, 47, 62));
      box8Txt.setBounds(10, 39, 131, 73);
      box8outsideGrid.add(box8Txt);
      
      JPanel students = new JPanel();
      students.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		SearchStudentInput.setBorder(null);
      		studentNameInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		studentIdInput.setBorder(null);
      	}
      });
      students.setBackground(new Color(34,47,62));
      contentArea.add(students, "name_11192510052267");
      students.setLayout(null);
      
      JLabel label_2 = new JLabel("Student's Panel:");
      label_2.setForeground(Color.WHITE);
      label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
      label_2.setBounds(41, 11, 280, 35);
      students.add(label_2);
      
      JTextPane StudDesc = new JTextPane();
      StudDesc.setText("In this panel, all the information related to the students enrolled in the institute is managed. \r\n");
      StudDesc.setForeground(Color.ORANGE);
      StudDesc.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      StudDesc.setEditable(false);
      StudDesc.setBackground(new Color(34, 47, 62));
      StudDesc.setBounds(40, 35, 430, 59);
      students.add(StudDesc);
      
      JLabel lblStudentsId = new JLabel("Student's ID \r\n");
      lblStudentsId.setHorizontalAlignment(SwingConstants.CENTER);
      lblStudentsId.setForeground(Color.WHITE);
      lblStudentsId.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblStudentsId.setBounds(14, 122, 202, 35);
      students.add(lblStudentsId);
      
      studentIdInput = new JTextField();
      studentIdInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		studentIdInput.setBorder(new LineBorder(Color.CYAN));
      		studentNameInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		SearchStudentInput.setBorder(null);
      	}
      });
      studentIdInput.setHorizontalAlignment(SwingConstants.CENTER);
      studentIdInput.setForeground(Color.WHITE);
      studentIdInput.setColumns(10);
      studentIdInput.setBorder(null);
      studentIdInput.setBackground(new Color(52, 73, 94));
      studentIdInput.setBounds(14, 168, 202, 27);
      students.add(studentIdInput);
      
      JLabel lblNameOfStudent = new JLabel("Name of Student\r\n\r\n");
      lblNameOfStudent.setHorizontalAlignment(SwingConstants.CENTER);
      lblNameOfStudent.setForeground(Color.WHITE);
      lblNameOfStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblNameOfStudent.setBounds(226, 122, 202, 35);
      students.add(lblNameOfStudent);
      
      studentNameInput = new JTextField();
      studentNameInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		studentNameInput.setBorder(new LineBorder(Color.CYAN));
      		studentIdInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		SearchStudentInput.setBorder(null);
      	}
      });
      studentNameInput.setHorizontalAlignment(SwingConstants.CENTER);
      studentNameInput.setForeground(Color.WHITE);
      studentNameInput.setColumns(10);
      studentNameInput.setBorder(null);
      studentNameInput.setBackground(new Color(52, 73, 94));
      studentNameInput.setBounds(226, 168, 202, 27);
      students.add(studentNameInput);
      
      JLabel lblNumberOfCourses = new JLabel(" Number of Courses\n");
      lblNumberOfCourses.setHorizontalAlignment(SwingConstants.CENTER);
      lblNumberOfCourses.setForeground(Color.WHITE);
      lblNumberOfCourses.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblNumberOfCourses.setBounds(645, 120, 203, 35);
      students.add(lblNumberOfCourses);
      
      StudentNoOfCourses = new JTextField();
      StudentNoOfCourses.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		StudentNoOfCourses.setBorder(new LineBorder(Color.CYAN));
      		studentNameInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		studentIdInput.setBorder(null);
      		SearchStudentInput.setBorder(null);
      	}
      });
      StudentNoOfCourses.setHorizontalAlignment(SwingConstants.CENTER);
      StudentNoOfCourses.setForeground(Color.WHITE);
      StudentNoOfCourses.setColumns(10);
      StudentNoOfCourses.setBorder(null);
      StudentNoOfCourses.setBackground(new Color(52, 73, 94));
      StudentNoOfCourses.setBounds(646, 168, 202, 27);
      students.add(StudentNoOfCourses);
      
      JLabel lblFathersName = new JLabel("Father's Name\r\n");
      lblFathersName.setHorizontalAlignment(SwingConstants.CENTER);
      lblFathersName.setForeground(Color.WHITE);
      lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblFathersName.setBounds(433, 121, 202, 35);
      students.add(lblFathersName);
      
      studentFnameInput = new JTextField();
      studentFnameInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		studentFnameInput.setBorder(new LineBorder(Color.CYAN));
      		studentNameInput.setBorder(null);
      		studentIdInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		SearchStudentInput.setBorder(null);
      	}
      });
      studentFnameInput.setHorizontalAlignment(SwingConstants.CENTER);
      studentFnameInput.setForeground(Color.WHITE);
      studentFnameInput.setColumns(10);
      studentFnameInput.setBorder(null);
      studentFnameInput.setBackground(new Color(52, 73, 94));
      studentFnameInput.setBounds(435, 168, 202, 27);
      students.add(studentFnameInput);
      
      JLabel lblSection = new JLabel("Enrolled Section\r\n");
      lblSection.setHorizontalAlignment(SwingConstants.CENTER);
      lblSection.setForeground(Color.WHITE);
      lblSection.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblSection.setBounds(13, 197, 203, 35);
      students.add(lblSection);
      
      studentSectionInput = new JTextField();
      studentSectionInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		studentSectionInput.setBorder(new LineBorder(Color.CYAN));
      		studentNameInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentIdInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		SearchStudentInput.setBorder(null);
      	}
      });
      studentSectionInput.setHorizontalAlignment(SwingConstants.CENTER);
      studentSectionInput.setForeground(Color.WHITE);
      studentSectionInput.setColumns(10);
      studentSectionInput.setBorder(null);
      studentSectionInput.setBackground(new Color(52, 73, 94));
      studentSectionInput.setBounds(14, 245, 202, 27);
      students.add(studentSectionInput);
      
      JLabel addStdRecordBtn = new JLabel("");
      addStdRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/plus.png")));
      addStdRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      addStdRecordBtn.setBounds(891, 284, 24, 24);
      students.add(addStdRecordBtn);
      
      JLabel deleteStdRecordBtn = new JLabel("");
      deleteStdRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Delete_132192.png")));
      deleteStdRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      deleteStdRecordBtn.setBounds(893, 338, 24, 24);
      students.add(deleteStdRecordBtn);
      
      JLabel editStdRecordBtn = new JLabel("");
      editStdRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/pencil.png")));
      editStdRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      editStdRecordBtn.setBounds(893, 394, 24, 24);
      students.add(editStdRecordBtn);
      
      JLabel truncateStdRecordsBtn = new JLabel("");
      truncateStdRecordsBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Wizard_132269.png")));
      truncateStdRecordsBtn.setHorizontalAlignment(SwingConstants.CENTER);
      truncateStdRecordsBtn.setBounds(893, 451, 24, 24);
      students.add(truncateStdRecordsBtn);
      
      JScrollPane stdRecordTableScroll = new JScrollPane();
      stdRecordTableScroll.setBounds(12, 283, 852, 195);
      students.add(stdRecordTableScroll);
      
      stdRecordTable = new JTable();
      
      stdRecordTable.setRowMargin(2);
      stdRecordTable.setForeground(Color.WHITE);
      
      
      
      stdRecordTable.setFont(new Font("Yu Gothic", Font.BOLD, 13));
      stdRecordTable.setAlignmentX(Component.RIGHT_ALIGNMENT);
      stdRecordTable.setShowHorizontalLines(false);
      stdRecordTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      stdRecordTable.setFillsViewportHeight(true);
      stdRecordTable.setSize(new Dimension(24, 24));
      stdRecordTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      stdRecordTable.setRowHeight(24);
      
      stdRecordTable.setGridColor(Color.WHITE);
      stdRecordTable.setBackground(new Color(34,47,62) );
      stdRecordTable.setBorder(null);
      stdRecordTable.getTableHeader().setBackground(new Color(34,47,62) );
      stdRecordTable.getTableHeader().setForeground(Color.white);
      stdRecordTable.getTableHeader().setBorder(null);
      stdRecordTable.getTableHeader().setOpaque(false);
      stdRecordTable.setSelectionBackground(new Color(0,131,143));
      stdRecordTable.setSelectionForeground(Color.WHITE);
      
       Object[][] tableModelData1= {
    		{"CS1912310", "Muhammad Ahsan", "Tahseen Ahmed", "17","F","BSCS"},
    		{"CS1912311", "Asaad Noman", "Noman Abbasi", "38","C","BSCS"},
    		{"CS1912312", "Willy Wonka", "Wonka Wurber", "20","E","BSCS"},
    		{"CS1912313", "Shayan Ali", "Ali Mankani", "40","D","BSCS"},
    		{"CS1912314", "Hallar Khalid", "Khalil Ahmed", "19","A","BSCS"},

    	};
    	String[] tableModelDataColumns1 = {
    		"Student's ID", "Students's Name", "Father's Name", "No. of Courses","Section","Department"
    	};
    	
       @SuppressWarnings("serial")
	DefaultTableModel tableModel1=new DefaultTableModel(tableModelData1, tableModelDataColumns1) {
    	

		public boolean isCellEditable(int row,int column) {
    		 return false;
    	 }
       };
     
      
      
      stdRecordTable.setModel(tableModel1);
      stdRecordTable.getColumnModel().getColumn(0).setPreferredWidth(120);
      stdRecordTable.getColumnModel().getColumn(1).setPreferredWidth(120);
      stdRecordTable.getColumnModel().getColumn(2).setPreferredWidth(120);
      stdRecordTable.getColumnModel().getColumn(3).setPreferredWidth(20);
      stdRecordTable.getColumnModel().getColumn(4).setPreferredWidth(20);
      stdRecordTable.getColumnModel().getColumn(5).setPreferredWidth(50);
      stdRecordTableScroll.setViewportView(stdRecordTable);
      
      
      JPanel coursesOfStudent = new JPanel();
      coursesOfStudent.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		searchCourseInput.setBorder(null);
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		crsIDInput.setBorder(null);
      	}
      });
      coursesOfStudent.setBackground(new Color(34,47,62));
      contentArea.add(coursesOfStudent, "name_11197816179944");
      coursesOfStudent.setLayout(null);
      
      JLabel lblCoursesPanel = new JLabel("Course's Panel:");
      lblCoursesPanel.setForeground(Color.WHITE);
      lblCoursesPanel.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCoursesPanel.setBounds(33, 11, 280, 35);
      coursesOfStudent.add(lblCoursesPanel);
      
      JTextPane txtPanelIntro = new JTextPane();
      txtPanelIntro.setText("In this panel, all the information related to the courses that the student has been enrolled in of the institute is managed.\r\n");
      txtPanelIntro.setForeground(Color.ORANGE);
      txtPanelIntro.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtPanelIntro.setEditable(false);
      txtPanelIntro.setBackground(new Color(34, 47, 62));
      txtPanelIntro.setBounds(30, 35, 430, 59);
      coursesOfStudent.add(txtPanelIntro);
      
      JLabel lblCoursesId = new JLabel("Course's ID \r\n");
      lblCoursesId.setHorizontalAlignment(SwingConstants.CENTER);
      lblCoursesId.setForeground(Color.WHITE);
      lblCoursesId.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCoursesId.setBounds(6, 125, 202, 35);
      coursesOfStudent.add(lblCoursesId);
      
      crsIDInput = new JTextField();
      crsIDInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsIDInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		searchCourseInput.setBorder(null);
      	}
      });
      crsIDInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsIDInput.setForeground(Color.WHITE);
      crsIDInput.setColumns(10);
      crsIDInput.setBorder(null);
      crsIDInput.setBackground(new Color(52, 73, 94));
      crsIDInput.setBounds(6, 171, 202, 27);
      coursesOfStudent.add(crsIDInput);
      
      JLabel lblNameOfCourse = new JLabel("Name of Course");
      lblNameOfCourse.setHorizontalAlignment(SwingConstants.CENTER);
      lblNameOfCourse.setForeground(Color.WHITE);
      lblNameOfCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblNameOfCourse.setBounds(218, 125, 202, 35);
      coursesOfStudent.add(lblNameOfCourse);
      
      crsNameInput = new JTextField();
      crsNameInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsNameInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		searchCourseInput.setBorder(null);
      	}
      });
      crsNameInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsNameInput.setForeground(Color.WHITE);
      crsNameInput.setColumns(10);
      crsNameInput.setBorder(null);
      crsNameInput.setBackground(new Color(52, 73, 94));
      crsNameInput.setBounds(218, 171, 202, 27);
      coursesOfStudent.add(crsNameInput);
      
      JLabel lblTotalMarks = new JLabel("Total Marks\r\n");
      lblTotalMarks.setHorizontalAlignment(SwingConstants.CENTER);
      lblTotalMarks.setForeground(Color.WHITE);
      lblTotalMarks.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblTotalMarks.setBounds(637, 123, 203, 35);
      coursesOfStudent.add(lblTotalMarks);
      
      crsTotalMarksInput = new JTextField();
      crsTotalMarksInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsTotalMarksInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		searchCourseInput.setBorder(null);
      	}
      });
      crsTotalMarksInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsTotalMarksInput.setForeground(Color.WHITE);
      crsTotalMarksInput.setColumns(10);
      crsTotalMarksInput.setBorder(null);
      crsTotalMarksInput.setBackground(new Color(52, 73, 94));
      crsTotalMarksInput.setBounds(638, 171, 202, 27);
      coursesOfStudent.add(crsTotalMarksInput);
      
      JLabel lblCreditHours = new JLabel("Credit Hours\r\n");
      lblCreditHours.setHorizontalAlignment(SwingConstants.CENTER);
      lblCreditHours.setForeground(Color.WHITE);
      lblCreditHours.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCreditHours.setBounds(425, 124, 202, 35);
      coursesOfStudent.add(lblCreditHours);
      
      crsCreditHrsInput = new JTextField();
      crsCreditHrsInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsCreditHrsInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		searchCourseInput.setBorder(null);
      	}
      });
      crsCreditHrsInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsCreditHrsInput.setForeground(Color.WHITE);
      crsCreditHrsInput.setColumns(10);
      crsCreditHrsInput.setBorder(null);
      crsCreditHrsInput.setBackground(new Color(52, 73, 94));
      crsCreditHrsInput.setBounds(427, 171, 202, 27);
      coursesOfStudent.add(crsCreditHrsInput);
      
      JLabel lblObtainedMarks = new JLabel("Obtained Marks\r\n");
      lblObtainedMarks.setHorizontalAlignment(SwingConstants.CENTER);
      lblObtainedMarks.setForeground(Color.WHITE);
      lblObtainedMarks.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblObtainedMarks.setBounds(5, 200, 203, 35);
      coursesOfStudent.add(lblObtainedMarks);
      
      crsObtainedMarksInput = new JTextField();
      crsObtainedMarksInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsObtainedMarksInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		searchCourseInput.setBorder(null);
      	}
      });
      crsObtainedMarksInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsObtainedMarksInput.setForeground(Color.WHITE);
      crsObtainedMarksInput.setColumns(10);
      crsObtainedMarksInput.setBorder(null);
      crsObtainedMarksInput.setBackground(new Color(52, 73, 94));
      crsObtainedMarksInput.setBounds(6, 248, 202, 27);
      coursesOfStudent.add(crsObtainedMarksInput);
      
      JLabel addCrsRecordBtn = new JLabel("");
      addCrsRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/plus.png")));
      addCrsRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      addCrsRecordBtn.setBounds(883, 287, 24, 24);
      coursesOfStudent.add(addCrsRecordBtn);
      
      JLabel deleteCrsRecordBtn = new JLabel("");
      deleteCrsRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Delete_132192.png")));
      deleteCrsRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      deleteCrsRecordBtn.setBounds(885, 341, 24, 24);
      coursesOfStudent.add(deleteCrsRecordBtn);
      
      JLabel editCrsRecordBtn = new JLabel("");
      editCrsRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/pencil.png")));
      editCrsRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      editCrsRecordBtn.setBounds(885, 397, 24, 24);
      coursesOfStudent.add(editCrsRecordBtn);
      
      JLabel truncateCrsRecordBtn = new JLabel("");
      truncateCrsRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/iconfinder_Wizard_132269.png")));
      truncateCrsRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      truncateCrsRecordBtn.setBounds(885, 454, 24, 24);
      coursesOfStudent.add(truncateCrsRecordBtn);
      
      JLabel goBackBtn = new JLabel("");
      goBackBtn.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		Departments.setVisible(false);
            AboutUs.setVisible(false);
            HowToUse.setVisible(false);
            students.setVisible(true);
            coursesOfStudent.setVisible(false);
      	}
      });
      goBackBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/back.png")));
      goBackBtn.setBounds(0, 17, 24, 24);
      coursesOfStudent.add(goBackBtn);
      
      JLabel IDLabel = new JLabel("ID:");
      IDLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      IDLabel.setVerticalAlignment(SwingConstants.TOP);
      IDLabel.setHorizontalTextPosition(SwingConstants.LEADING);
      IDLabel.setForeground(Color.GREEN);
      IDLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      IDLabel.setBounds(532, 51, 27, 14);
      coursesOfStudent.add(IDLabel);
      
      JLabel txtID = new JLabel("1919291");
      txtID.setVerticalTextPosition(SwingConstants.BOTTOM);
      txtID.setVerticalAlignment(SwingConstants.TOP);
      txtID.setHorizontalTextPosition(SwingConstants.LEADING);
      txtID.setForeground(Color.ORANGE);
      txtID.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtID.setBounds(558, 51, 110, 14);
      coursesOfStudent.add(txtID);
      
      JLabel txtSection = new JLabel("F\r\n");
      txtSection.setVerticalTextPosition(SwingConstants.BOTTOM);
      txtSection.setVerticalAlignment(SwingConstants.TOP);
      txtSection.setHorizontalTextPosition(SwingConstants.LEADING);
      txtSection.setHorizontalAlignment(SwingConstants.LEFT);
      txtSection.setForeground(Color.ORANGE);
      txtSection.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtSection.setBounds(863, 50, 44, 21);
      coursesOfStudent.add(txtSection);
      
      JLabel SectionLabel = new JLabel("Section:");
      SectionLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      SectionLabel.setVerticalAlignment(SwingConstants.TOP);
      SectionLabel.setHorizontalTextPosition(SwingConstants.LEADING);
      SectionLabel.setForeground(Color.GREEN);
      SectionLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      SectionLabel.setBounds(805, 50, 145, 16);
      coursesOfStudent.add(SectionLabel);
      
      JLabel NoOfCoursesLabel = new JLabel("No of Courses:");
      NoOfCoursesLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      NoOfCoursesLabel.setVerticalAlignment(SwingConstants.TOP);
      NoOfCoursesLabel.setHorizontalTextPosition(SwingConstants.LEADING);
      NoOfCoursesLabel.setForeground(Color.GREEN);
      NoOfCoursesLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      NoOfCoursesLabel.setBounds(530, 76, 110, 25);
      coursesOfStudent.add(NoOfCoursesLabel);
      
      JLabel txtNoOfCourses = new JLabel("22");
      txtNoOfCourses.setVerticalTextPosition(SwingConstants.BOTTOM);
      txtNoOfCourses.setVerticalAlignment(SwingConstants.TOP);
      txtNoOfCourses.setHorizontalTextPosition(SwingConstants.LEADING);
      txtNoOfCourses.setHorizontalAlignment(SwingConstants.LEFT);
      txtNoOfCourses.setForeground(Color.ORANGE);
      txtNoOfCourses.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtNoOfCourses.setBounds(640, 76, 44, 14);
      coursesOfStudent.add(txtNoOfCourses);
      
      JLabel txtStudentName = new JLabel("Ahsan Tahseen\r\n");
      txtStudentName.setVerticalTextPosition(SwingConstants.BOTTOM);
      txtStudentName.setVerticalAlignment(SwingConstants.TOP);
      txtStudentName.setHorizontalTextPosition(SwingConstants.LEADING);
      txtStudentName.setHorizontalAlignment(SwingConstants.LEFT);
      txtStudentName.setForeground(Color.ORANGE);
      txtStudentName.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtStudentName.setBounds(680, 51, 145, 20);
      coursesOfStudent.add(txtStudentName);
      
      JLabel StudentNameLabel = new JLabel("Name:");
      StudentNameLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      StudentNameLabel.setVerticalAlignment(SwingConstants.TOP);
      StudentNameLabel.setHorizontalTextPosition(SwingConstants.LEADING);
      StudentNameLabel.setForeground(Color.GREEN);
      StudentNameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      StudentNameLabel.setBounds(628, 51, 110, 20);
      coursesOfStudent.add(StudentNameLabel);
      
      JLabel CurrentStudentLabel = new JLabel("Current Student:");
      CurrentStudentLabel.setForeground(Color.WHITE);
      CurrentStudentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
      CurrentStudentLabel.setBounds(533, 11, 280, 35);
      coursesOfStudent.add(CurrentStudentLabel);
      
      JLabel shadow = new JLabel("");
      shadow.setIcon(new ImageIcon(new1.class.getResource("/imgs/unnamed.png")));
      shadow.setBounds(477, 77, 449, 40);
      coursesOfStudent.add(shadow);
      
      JLabel lblSearchCourseBy = new JLabel("Search Course By ID or Name:");
      lblSearchCourseBy.setForeground(Color.WHITE);
      lblSearchCourseBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblSearchCourseBy.setBounds(6, 491, 338, 35);
      coursesOfStudent.add(lblSearchCourseBy);
      
      searchCourseInput = new JTextField();
      searchCourseInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		searchCourseInput.setBorder(new LineBorder(Color.CYAN));
      		crsCourseGpaInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		crsIDInput.setBorder(null);
      	}
      });
      searchCourseInput.setHorizontalAlignment(SwingConstants.CENTER);
      searchCourseInput.setForeground(Color.WHITE);
      searchCourseInput.setColumns(10);
      searchCourseInput.setBorder(null);
      searchCourseInput.setBackground(new Color(52, 73, 94));
      searchCourseInput.setBounds(6, 537, 202, 27);
      coursesOfStudent.add(searchCourseInput);
      
      JLabel searchCrsRecordBtn = new JLabel("");
      searchCrsRecordBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/magnifying-glass.png")));
      searchCrsRecordBtn.setHorizontalAlignment(SwingConstants.CENTER);
      searchCrsRecordBtn.setBackground(new Color(52, 73, 94));
      searchCrsRecordBtn.setBounds(212, 538, 27, 27);
      coursesOfStudent.add(searchCrsRecordBtn);
      
      JLabel resultLine = new JLabel("*The following results will be displayed in the table above*");
      resultLine.setForeground(Color.WHITE);
      resultLine.setFont(new Font("Tahoma", Font.PLAIN, 12));
      resultLine.setBounds(260, 532, 338, 35);
      coursesOfStudent.add(resultLine);
      
      JLabel clearCrsInputBtn = new JLabel("");
      clearCrsInputBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/icons8-clear-symbol-24.png")));
      clearCrsInputBtn.setHorizontalAlignment(SwingConstants.CENTER);
      clearCrsInputBtn.setBounds(883, 171, 24, 24);
      coursesOfStudent.add(clearCrsInputBtn);
      
      JLabel DepartmentLabel = new JLabel("Department:");
      DepartmentLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
      DepartmentLabel.setVerticalAlignment(SwingConstants.TOP);
      DepartmentLabel.setHorizontalTextPosition(SwingConstants.LEADING);
      DepartmentLabel.setForeground(Color.GREEN);
      DepartmentLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      DepartmentLabel.setBounds(667, 76, 110, 25);
      coursesOfStudent.add(DepartmentLabel);
      
      JLabel txtDepartment = new JLabel("Computer Science");
      txtDepartment.setVerticalTextPosition(SwingConstants.BOTTOM);
      txtDepartment.setVerticalAlignment(SwingConstants.TOP);
      txtDepartment.setHorizontalTextPosition(SwingConstants.LEADING);
      txtDepartment.setHorizontalAlignment(SwingConstants.LEFT);
      txtDepartment.setForeground(Color.ORANGE);
      txtDepartment.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      txtDepartment.setBounds(767, 76, 159, 21);
      coursesOfStudent.add(txtDepartment);
      
      crsCourseGpaInput = new JTextField();
      crsCourseGpaInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsCourseGpaInput.setBorder(new LineBorder(Color.CYAN));
      		searchCourseInput.setBorder(null);
      		crsCourseGradeInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		
      	}
      });
      crsCourseGpaInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsCourseGpaInput.setForeground(Color.WHITE);
      crsCourseGpaInput.setColumns(10);
      crsCourseGpaInput.setBorder(null);
      crsCourseGpaInput.setBackground(new Color(52, 73, 94));
      crsCourseGpaInput.setBounds(219, 248, 202, 27);
      coursesOfStudent.add(crsCourseGpaInput);
      
      JLabel lblGpa = new JLabel("Course's GPA");
      lblGpa.setHorizontalAlignment(SwingConstants.CENTER);
      lblGpa.setForeground(Color.WHITE);
      lblGpa.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblGpa.setBounds(218, 200, 203, 35);
      coursesOfStudent.add(lblGpa);
      
      JLabel lblCourseGrade = new JLabel("Course's Grade");
      lblCourseGrade.setHorizontalAlignment(SwingConstants.CENTER);
      lblCourseGrade.setForeground(Color.WHITE);
      lblCourseGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCourseGrade.setBounds(427, 200, 203, 35);
      coursesOfStudent.add(lblCourseGrade);
      
      crsCourseGradeInput = new JTextField();
      crsCourseGradeInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		crsCourseGradeInput.setBorder(new LineBorder(Color.CYAN));
      		searchCourseInput.setBorder(null);
      		crsCourseGpaInput.setBorder(null);
      		crsCreditHrsInput.setBorder(null);
      		crsObtainedMarksInput.setBorder(null);
      		crsTotalMarksInput.setBorder(null);
      		crsNameInput.setBorder(null);
      		crsIDInput.setBorder(null);
      		
      	}
      });
      crsCourseGradeInput.setHorizontalAlignment(SwingConstants.CENTER);
      crsCourseGradeInput.setForeground(Color.WHITE);
      crsCourseGradeInput.setColumns(10);
      crsCourseGradeInput.setBorder(null);
      crsCourseGradeInput.setBackground(new Color(52, 73, 94));
      crsCourseGradeInput.setBounds(428, 248, 202, 27);
      coursesOfStudent.add(crsCourseGradeInput);
      
      JScrollPane crsRecordTableScroll = new JScrollPane();
      crsRecordTableScroll.setBounds(12, 283, 852, 195);
      coursesOfStudent.add(crsRecordTableScroll);
      
      crsRecordTable = new JTable();
      
      
      crsRecordTableScroll.setViewportView(crsRecordTable);
      crsRecordTable.setRowMargin(2);
      crsRecordTable.setForeground(Color.WHITE);
      
      
      
      crsRecordTable.setFont(new Font("Yu Gothic", Font.BOLD, 13));
      crsRecordTable.setAlignmentX(Component.RIGHT_ALIGNMENT);
      crsRecordTable.setShowHorizontalLines(false);
      crsRecordTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      crsRecordTable.setFillsViewportHeight(true);
      crsRecordTable.setSize(new Dimension(24, 24));
      crsRecordTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      crsRecordTable.setRowHeight(24);
      
      crsRecordTable.setGridColor(Color.WHITE);
      crsRecordTable.setBackground(new Color(34,47,62) );
      crsRecordTable.setBorder(null);
      crsRecordTable.getTableHeader().setBackground(new Color(34,47,62) );
      crsRecordTable.getTableHeader().setForeground(Color.white);
      crsRecordTable.getTableHeader().setBorder(null);
      crsRecordTable.getTableHeader().setOpaque(false);
      crsRecordTable.setSelectionBackground(new Color(0,131,143));
      crsRecordTable.setSelectionForeground(Color.WHITE);
      
       Object[][] tableModelData2= {
    		{"CS1140", "Data Structures", "3", "100","60","2.4","C"},
    		{"CS1911", "Differential Equations", "3", "100","60","2.4","C"},
    		{"CS1231", "Assembly Language", "1", "75","60","2.4","A"},
    		{"CS2313", "Design and Creativity", "2", "80","60","2.4","B"},
    		{"CS2314", "Discrete Maths", "3", "100","60","2.4","B"},

    	};
    	String[] tableModelDataColumns2 = {
    		"Course's ID", "Course's Name", "Credit Hours", "Total Marks","Obtained Marks","GPA","Grade"
    	};
    	
       @SuppressWarnings("serial")
	DefaultTableModel tableModel2=new DefaultTableModel(tableModelData2, tableModelDataColumns2) {
    	

		public boolean isCellEditable(int row,int column) {
    		 return false;
    	 }
       };
     
      
      
      crsRecordTable.setModel(tableModel2);
      crsRecordTable.getColumnModel().getColumn(0).setPreferredWidth(120);
      crsRecordTable.getColumnModel().getColumn(1).setPreferredWidth(120);
      crsRecordTable.getColumnModel().getColumn(2).setPreferredWidth(50);
      crsRecordTable.getColumnModel().getColumn(3).setPreferredWidth(20);
      crsRecordTable.getColumnModel().getColumn(4).setPreferredWidth(50);
      crsRecordTable.getColumnModel().getColumn(5).setPreferredWidth(50);
      crsRecordTable.getColumnModel().getColumn(6).setPreferredWidth(20);
      crsRecordTableScroll.setViewportView(crsRecordTable);
      
      
    //THE THREE CATEGORIES OF SIDE BAR 
      JPanel DepartmentBtn = new JPanel();
      JPanel HowToUseBtn = new JPanel();
      JPanel AboutUsBtn = new JPanel();
      
      DepartmentBtn.setBounds(0, 111, 220, 38);
      sideBar.add(DepartmentBtn);
      DepartmentBtn.setLayout(null);
      DepartmentBtn.setBackground(new Color(0, 131, 143)); //Default Selected
      
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
      lblNewLabel_1.setBounds(1153, 2, 18, 18);
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
      
      //Table to another panel (dept to student)
      table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int selectedIndex=table.getSelectedRow();
        		if(e.getClickCount()==2) {

        		  deptNameStr=(String) table.getValueAt(selectedIndex, 1);
        		  Departments.setVisible(false);
                  AboutUs.setVisible(false);
                  HowToUse.setVisible(false);
                  students.setVisible(true);
                  coursesOfStudent.setVisible(false);
                  
        		}
        		else {
        			
        			deptIdInput.setText((String) table.getValueAt(selectedIndex, 0));
        			deptNameInput.setText((String) table.getValueAt(selectedIndex, 1));
        			deptHodInput.setText((String) table.getValueAt(selectedIndex, 2));
        			deptNoOfStudentsInput.setText((String) table.getValueAt(selectedIndex, 3));
        		}
        	}
        });
    //Table to another panel (student to courses)
      stdRecordTable.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		int selectedIndex=stdRecordTable.getSelectedRow();
      		if(e.getClickCount()==2) {

      		  deptNameStr=(String) table.getValueAt(selectedIndex, 1);
      		  Departments.setVisible(false);
                AboutUs.setVisible(false);
                HowToUse.setVisible(false);
                students.setVisible(false);
                coursesOfStudent.setVisible(true);
                
      		}
      		else {
      			
      			studentIdInput.setText((String) stdRecordTable.getValueAt(selectedIndex, 0));
      			studentNameInput.setText((String) stdRecordTable.getValueAt(selectedIndex, 1));
      			studentFnameInput.setText((String) stdRecordTable.getValueAt(selectedIndex, 2));
      			StudentNoOfCourses.setText((String) stdRecordTable.getValueAt(selectedIndex, 3));
      			studentSectionInput.setText((String) stdRecordTable.getValueAt(selectedIndex, 4));
      			
      		
      		}
      	}
      });
      crsRecordTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int selectedIndex=crsRecordTable.getSelectedRow();
        	        			
        			crsIDInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 0));
        			crsNameInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 1));
        			crsCreditHrsInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 2));
        			crsTotalMarksInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 3));
        			crsObtainedMarksInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 4));
        			crsCourseGpaInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 5));
        			crsCourseGradeInput.setText((String) crsRecordTable.getValueAt(selectedIndex, 6));
        			
        		
        		
        	}
        });
      //Back Button
      JLabel GoBackToDeptBtn = new JLabel("");
      GoBackToDeptBtn.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		Departments.setVisible(true);
            AboutUs.setVisible(false);
            HowToUse.setVisible(false);
            students.setVisible(false);
            coursesOfStudent.setVisible(false);
      	}
      });
      GoBackToDeptBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/back.png")));
      GoBackToDeptBtn.setBounds(8, 17, 24, 24);
      students.add(GoBackToDeptBtn);
      
      JLabel MiniDeptIDHeading = new JLabel("ID:");
      MiniDeptIDHeading.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptIDHeading.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptIDHeading.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptIDHeading.setForeground(Color.GREEN);
      MiniDeptIDHeading.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptIDHeading.setBounds(540, 48, 110, 14);
      students.add(MiniDeptIDHeading);
      
      JLabel MiniDeptID = new JLabel("1919291");
      MiniDeptID.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptID.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptID.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptID.setForeground(Color.ORANGE);
      MiniDeptID.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptID.setBounds(566, 48, 110, 14);
      students.add(MiniDeptID);
      
      JLabel MiniDeptName = new JLabel("Computer Science");
      MiniDeptName.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptName.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptName.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptName.setHorizontalAlignment(SwingConstants.LEFT);
      MiniDeptName.setForeground(Color.ORANGE);
      MiniDeptName.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptName.setBounds(587, 73, 155, 21);
      students.add(MiniDeptName);
      
      JLabel MiniDeptNameHeading = new JLabel(" Name:");
      MiniDeptNameHeading.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptNameHeading.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptNameHeading.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptNameHeading.setForeground(Color.GREEN);
      MiniDeptNameHeading.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptNameHeading.setBounds(535, 73, 145, 16);
      students.add(MiniDeptNameHeading);
      
      JLabel MiniDeptNoOfStudentsHeading = new JLabel("No of Students:");
      MiniDeptNoOfStudentsHeading.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptNoOfStudentsHeading.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptNoOfStudentsHeading.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptNoOfStudentsHeading.setForeground(Color.GREEN);
      MiniDeptNoOfStudentsHeading.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptNoOfStudentsHeading.setBounds(727, 71, 110, 25);
      students.add(MiniDeptNoOfStudentsHeading);
      
      JLabel MiniDeptNoOfStudents = new JLabel("22");
      MiniDeptNoOfStudents.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptNoOfStudents.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptNoOfStudents.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptNoOfStudents.setHorizontalAlignment(SwingConstants.LEFT);
      MiniDeptNoOfStudents.setForeground(Color.ORANGE);
      MiniDeptNoOfStudents.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptNoOfStudents.setBounds(836, 71, 44, 14);
      students.add(MiniDeptNoOfStudents);
      
      JLabel MiniDeptHOD = new JLabel("Ahsan Tahseen\r\n");
      MiniDeptHOD.setHorizontalAlignment(SwingConstants.LEFT);
      MiniDeptHOD.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptHOD.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptHOD.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptHOD.setForeground(Color.ORANGE);
      MiniDeptHOD.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptHOD.setBounds(770, 48, 145, 20);
      students.add(MiniDeptHOD);
      
      JLabel MiniDeptHODHeading = new JLabel("HOD:");
      MiniDeptHODHeading.setVerticalTextPosition(SwingConstants.BOTTOM);
      MiniDeptHODHeading.setVerticalAlignment(SwingConstants.TOP);
      MiniDeptHODHeading.setHorizontalTextPosition(SwingConstants.LEADING);
      MiniDeptHODHeading.setForeground(Color.GREEN);
      MiniDeptHODHeading.setFont(new Font("Yu Gothic", Font.BOLD, 14));
      MiniDeptHODHeading.setBounds(726, 48, 110, 20);
      students.add(MiniDeptHODHeading);
      
      JLabel lblCurrentDepartment = new JLabel("Current Department:");
      lblCurrentDepartment.setForeground(Color.WHITE);
      lblCurrentDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblCurrentDepartment.setBounds(541, 8, 280, 35);
      students.add(lblCurrentDepartment);
      
      JLabel MiniBoxShadow = new JLabel("");
      MiniBoxShadow.setIcon(new ImageIcon(new1.class.getResource("/imgs/unnamed.png")));
      MiniBoxShadow.setBounds(485, 73, 449, 41);
      students.add(MiniBoxShadow);
      
      JLabel lblSearchStudentBy = new JLabel("Search Student By ID or Name:");
      lblSearchStudentBy.setForeground(Color.WHITE);
      lblSearchStudentBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblSearchStudentBy.setBounds(14, 488, 338, 35);
      students.add(lblSearchStudentBy);
      
      SearchStudentInput = new JTextField();
      SearchStudentInput.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		SearchStudentInput.setBorder(new LineBorder(Color.CYAN));
      		studentNameInput.setBorder(null);
      		studentFnameInput.setBorder(null);
      		studentSectionInput.setBorder(null);
      		StudentNoOfCourses.setBorder(null);
      		studentIdInput.setBorder(null);
      	}
      });
      SearchStudentInput.setHorizontalAlignment(SwingConstants.CENTER);
      SearchStudentInput.setForeground(Color.WHITE);
      SearchStudentInput.setColumns(10);
      SearchStudentInput.setBorder(null);
      SearchStudentInput.setBackground(new Color(52, 73, 94));
      SearchStudentInput.setBounds(14, 534, 202, 27);
      students.add(SearchStudentInput);
      
      JLabel SearchStudentBtn = new JLabel("");
      SearchStudentBtn.setIcon(new ImageIcon(new1.class.getResource("/imgs/magnifying-glass.png")));
      SearchStudentBtn.setHorizontalAlignment(SwingConstants.CENTER);
      SearchStudentBtn.setBackground(new Color(52, 73, 94));
      SearchStudentBtn.setBounds(220, 535, 27, 27);
      students.add(SearchStudentBtn);
      
      JLabel lbltheFollowingResults_1 = new JLabel("*The following results will be displayed in the table above*");
      lbltheFollowingResults_1.setForeground(Color.WHITE);
      lbltheFollowingResults_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lbltheFollowingResults_1.setBounds(268, 529, 338, 35);
      students.add(lbltheFollowingResults_1);
      
      JLabel clearStdInputFields = new JLabel("");
      clearStdInputFields.setIcon(new ImageIcon(new1.class.getResource("/imgs/icons8-clear-symbol-24.png")));
      clearStdInputFields.setHorizontalAlignment(SwingConstants.CENTER);
      clearStdInputFields.setBounds(891, 168, 24, 24);
      students.add(clearStdInputFields);
      
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
