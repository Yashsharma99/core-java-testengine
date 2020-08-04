import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class cal extends JFrame {

	private JPanel contentPane;
	private JTextField txtDob;
	 JDateChooser dateChooser ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cal frame = new cal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void getDateDemo() {
	

	DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date date = dateChooser.getDate();
	
	String strDate = sdf.format(date);
	System.out.println(strDate);
}
	/**
	 * Create the frame.
	 */
	public cal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		txtDob = new JTextField();
//		txtDob.setText("DOB");
//		txtDob.setBounds(23, 83, 96, 20);
//		contentPane.add(txtDob);
//		txtDob.setColumns(10);
//		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(209, 83, 77, 20);
		contentPane.add(dateChooser);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDateDemo();
			}
		});
		btnOk.setBounds(197, 154, 89, 23);
		contentPane.add(btnOk);
	}
}
