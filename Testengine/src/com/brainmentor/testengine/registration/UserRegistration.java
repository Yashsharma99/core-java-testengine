package com.brainmentor.testengine.registration;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.testengine.user.DTO.UserDTO;
import com.brainmentor.testengine.user.Dao.userDAO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class UserRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
//	Logger logger=Logger.getLogger(UserRegistration.class);
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JCalendar calendar ;
    JDateChooser dateChooser;

    ButtonGroup bg= new ButtonGroup();
    
	//public String ok()
//	{
		
//		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        java.util.Date Date= dateChooser.getDate();
//        String strDate=sdf.format(Date);
//        System.out.println("DOB is:"+strDate);
//		System.out.println("working1090");
//		return strDate;
//}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void registration1()  {

		String UserName = textField.getText();

		String Password =new String (passwordField.getPassword());
		String Address=textField_2.getText();
	String Gender= selectgender();
		String PinCode =textField_3.getText();
		Date date = dateChooser.getDate();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		System.out.println(strDate);

	//	String Calander=ok();
       
		System.out.println("working1");
        
        	 //Calendar cal = Calendar.getInstance();
         
		//cal.add(Calendar.DATE, 1);
		//Date date = (Date) cal.getTime();              
		//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//String date1 = format1.format(date);            
	//	Date inActiveDate = null;
	//	try {
		//    inActiveDate = (Date) format1.parse(date1);
		//} catch (ParseException e1) {
		    // TODO Auto-generated catch block
		  //  e1.printStackTrace();
	//	}
         
 
		//String SimpleDateFormat =format1.format(date);
	
		
		
		UserDTO userDTO = new UserDTO();

		userDTO.setUserName(UserName);

		userDTO.setPassword(Password);
		 userDTO.setAddress(Address);
		 userDTO.setGender(Gender);
		 userDTO.setPinCode(PinCode);
		 userDTO.setDOB(strDate);
		// userDTO.setSetSimpleDateFormat (SimpleDateFormat);
		 System.out.println("working2");
		
		userDAO usersDAO = new userDAO();
		 System.out.println("working3");


		try {
			 System.out.println("working4");

			String message = usersDAO.doRegister(userDTO);
			 System.out.println("working5");


			JOptionPane.showMessageDialog(this, message);

		}
		catch (ClassNotFoundException e) {

			JOptionPane.showMessageDialog(this, "Can't Register Some  Problem Occuer");

			// TODO Auto-generated catch block

		//	logger.error(convertPrintStackIntoString(e));
			e.printStackTrace();

		}
		catch (SQLException e) {

			JOptionPane.showMessageDialog(this, "Can't Register Some DB  Problem Occuer");

			// TODO Auto-generated catch block

			//logger.error(convertPrintStackIntoString(e));
e.printStackTrace();
		}

		catch(Exception e) {

			JOptionPane.showMessageDialog(this, "Can't Register Some Other  Problem Occuer");
			e.printStackTrace();
	//		logger.error(convertPrintStackIntoString(e));

		}

	}
	
    public String selectgender() {
    	
    	
    	 if(gender.equals("male")) {
    		 rdbtnMale.setSelected(true);
		 }
		 else
			 	if(gender.equals("female")) {
				 rdbtnFemale.setSelected(true);
			 }
			 else{

					bg.clearSelection();

				}
		return gender;

    	
    }
	
	
	
	private void fetch()
	{
		if(rdbtnMale.isSelected()){

			gender = "Male";

		}

		else

			if(rdbtnFemale.isSelected()){

				gender = "Female";

			}	
	}
		
	
	
	
	JRadioButton rdbtnMale = new JRadioButton("Male");
	JRadioButton rdbtnFemale = new JRadioButton("Female");
    private String gender="";
	//private Object convertPrintStackIntoString(Exception e) {
		// TODO Auto-generated method stub
		//return null;
//	}
	
	/**
	 * Create the frame.
	 */
	public UserRegistration() {
		
		bg.add(rdbtnMale);

		bg.add(rdbtnFemale);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRgisterion = new JLabel("Registration");
		lblRgisterion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRgisterion.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblRgisterion.setBounds(67, 0, 261, 32);
		contentPane.add(lblRgisterion);
		
		
		JLabel username = new JLabel("UserName");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Arial Black", Font.BOLD, 16));
		username.setBounds(10, 43, 112, 32);
		contentPane.add(username);
		
		textField = new JTextField();
		textField.setBounds(154, 43, 206, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 86, 46, 14);
		contentPane.add(label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(20, 74, 128, 26);
		contentPane.add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblGender.setBounds(10, 279, 100, 28);
		contentPane.add(lblGender);
		
		
		
		rdbtnMale.setFont(new Font("Arial Black", Font.BOLD, 15));
		rdbtnMale.setBounds(148, 283, 109, 23);
		contentPane.add(rdbtnMale);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetch();
			}
			
		});
		
		rdbtnFemale.setFont(new Font("Arial Black", Font.BOLD, 15));
		rdbtnFemale.setBounds(298, 283, 109, 23);
		contentPane.add(rdbtnFemale);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetch();
			}
			
		});

		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAddress.setBounds(10, 337, 100, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 330, 280, 32);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 86, 203, 29);
		contentPane.add(passwordField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registration1();
			}
			
		});
		btnConfirm.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnConfirm.setBounds(10, 429, 138, 23);
		contentPane.add(btnConfirm);
		
		JLabel pincode = new JLabel("PinCode");
		pincode.setFont(new Font("Arial Black", Font.BOLD, 16));
		pincode.setBounds(22, 374, 100, 26);
		contentPane.add(pincode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(171, 373, 221, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		  
		  
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDob.setBounds(20, 161, 46, 14);
		contentPane.add(lblDob);
		
		
		 dateChooser = new JDateChooser();
			dateChooser.setBounds(156, 155, 77, 20);
			contentPane.add(dateChooser);
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		 dateChooser_1 = new JDateChooser();
//		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dateChooser = new JDateChooser();
//				dateChooser.setBounds(585, 265, 142, 20);
//				contentPane.add(dateChooser);
//			}
//		});
//		dateChooser_1.setBounds(154, 155, 77, 20);
//		contentPane.add(dateChooser_1);
//		
//
//		
		
		
		
		
		
		
		//		////JDateChooser dateChooser = new JDateChooser();
//		dateChooser.setBounds(194, 161, 91, 20);
//		contentPane.add(dateChooser);
//		
//		JButton btnOk = new JButton("ok");
//		
//		btnOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				//System.out.println("working19");
//
//		//	   ok();
//			
//
//			}
//		});
//		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnOk.setBounds(196, 216, 89, 23);
//		contentPane.add(btnOk);
	}
}
