package assignment;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener
{
	/* why issue here*/
	JLabel jlUserName;
	JLabel jlPassWord;
	JLabel jlConfirmPassWord;
	JLabel JlGender;
	JLabel JlDob;
	JLabel JlLanguage;

	JTextField jtUserName ;
	JTextField jtPassWord ;	
	JTextField jtConfirmPassWord ;

	JRadioButton jrMale;
	JRadioButton jrFemale;

	JComboBox<String> jcMonth;
	JComboBox<String> jcDay;
	JComboBox<String> jcYear;

	JCheckBox JchHindi;
	JCheckBox JchEnglish;
	JCheckBox JchOther;

	JButton jbAdd ;


	RegistrationForm(){

		jlUserName = new JLabel("Enter name");
		jlUserName.setBounds(30,50,100,20);
		jlPassWord = new JLabel("Enter Password");
		jlPassWord.setBounds(30,100,100,20);
		jlConfirmPassWord = new JLabel("Confirm Password");
		jlConfirmPassWord.setBounds(30,150,100,20);
		JlGender = new JLabel("Select Gender");
		JlGender.setBounds(30,200,200,20);
		JlDob = new JLabel("Choose DOB (MM/DD/YYY)");
		JlDob.setBounds(30,250,150,20);
		JlLanguage = new JLabel("Select languages");
		JlLanguage.setBounds(30,300,100,20);		

		add(jlUserName); add(jlPassWord); add(jlConfirmPassWord);
		add(JlGender); add(JlDob); add(JlLanguage);

		jtUserName = new JTextField();
		jtUserName.setBounds(150,50,100,20);
		jtPassWord = new JTextField();	
		jtPassWord.setBounds(150,100,100,20);
		jtConfirmPassWord = new JTextField();
		jtConfirmPassWord.setBounds(150,150,100,20);


		add(jtUserName); add(jtPassWord); add(jtConfirmPassWord);

		jrMale = new JRadioButton("Male");
		jrMale.setBounds(150,200,80,20);
		jrFemale = new JRadioButton("Female");
		jrFemale.setBounds(300,200,80,20);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrFemale);
		bg.add(jrMale);
		add(jrFemale); add(jrMale);

		jcMonth = new JComboBox<String>();
		for(int i=1;i<=12;i++){        
			jcMonth.addItem(String.valueOf(i));
		}

		jcMonth.setBounds(200,250,80,20);
		add(jcMonth);

		jcDay = new JComboBox<String>();
		for(int i=1;i<=31;i++){        
			jcDay.addItem(String.valueOf(i));
		}

		jcDay.setBounds(300,250,80,20);
		add(jcDay);

		jcYear = new JComboBox<String>();
		for(int i=1950;i<=2016;i++){        
			jcYear.addItem(String.valueOf(i));
		}

		jcYear.setBounds(400,250,80,20);
		add(jcYear);

		JchEnglish = new JCheckBox("English");
		JchEnglish.setBounds(130,300,100,20);
		JchHindi = new JCheckBox("Hindi");
		JchHindi.setBounds(230,300,100,20);
		JchOther = new JCheckBox("Other");
		JchOther.setBounds(330,300,100,20);
		add(JchEnglish); add(JchHindi); add(JchOther); 

		jbAdd = new JButton("Add");
		jbAdd.setBounds(130,400,100,20);
		add(jbAdd);
		jbAdd.addActionListener(this);
		setSize(500,500);
		setLayout(null);  
		setVisible(true); 	
	}



	public void actionPerformed(ActionEvent event) {

		String name = jtUserName.getText();
		String password = jtPassWord.getText();
		String gender = null;
		if(jrMale.isSelected())
			gender = "Male";
		if(jrFemale.isSelected())
			gender = "Female";

		String day = (String) jcDay.getSelectedItem();
		String year = (String) jcYear.getSelectedItem();
		String month = (String) jcMonth.getSelectedItem();

		String dob = month+"/"+day+"/"+year;

		String language="" ;
		if(JchEnglish.isSelected())
			language =   language.concat("English");
		if(JchOther.isSelected())
			language =   language.concat("Other");
		if(JchHindi.isSelected())
			language =   language.concat("Hindi");


		if(event.getSource().equals(jbAdd)){


			try
			{	//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
				//step3 create the statement object  
				PreparedStatement stmt = con.prepareStatement("insert into registrationForm values(?,?,?,?,?)");  
				stmt.setString(1, name);
				stmt.setString(2, password);
				stmt.setString(3, gender);
				stmt.setString(4, dob);
				stmt.setString(5, language);

				int i= stmt.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(this, "Inserted Sucess");
				con.close();  /* Why this is required? */
			}catch(Exception e1){ System.out.println(e1);}  

		}

		//		if(event.getSource().equals(jbExit)){
		//			System.exit(0);
		//		}
		//
		//		if(event.getSource().equals(jbSearch)){
		//			id = Integer.parseInt(jtId.getText());
		//			try
		//			{	//step1 load the driver class  
		//				Class.forName("oracle.jdbc.driver.OracleDriver");  
		//				//step2 create  the connection object  
		//				Connection con=DriverManager.getConnection(  
		//						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
		//				//step3 create the statement object  
		//				Statement stmt = con.createStatement();  
		//				ResultSet rs = stmt.executeQuery("select * from emp where id = "+id);
		//				rs.next();
		//				jtName.setText(rs.getString(2));
		//				jtSal.setText(rs.getString(3));
		//			}catch(Exception e1){ System.out.println(e1);}
		//		}
		//
		//		if(event.getSource().equals(jbUpdate)){
		//			id = Integer.parseInt(jtId.getText());
		//			name = jtName.getText();
		//			sal = Integer.parseInt(jtSal.getText());
		//
		//			try
		//			{	//step1 load the driver class  
		//				Class.forName("oracle.jdbc.driver.OracleDriver");  
		//				//step2 create  the connection object  
		//				Connection con=DriverManager.getConnection(  
		//						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
		//				//step3 create the statement object  
		//				PreparedStatement stmt = con.prepareStatement("update emp set name = ?, salary = ? where id = ?");  
		//
		//				stmt.setString(1, name);
		//				stmt.setInt(2, sal);
		//				stmt.setInt(3, id);
		//
		//				int i= stmt.executeUpdate();
		//				if(i>0)
		//					JOptionPane.showMessageDialog(this, "Updated Sucess");
		//
		//			}catch(Exception e1){ System.out.println(e1);}
		//		}
		//
		//		if(event.getSource().equals(jbDel)){
		//			id = Integer.parseInt(jtId.getText());
		//
		//			try
		//			{	//step1 load the driver class  
		//				Class.forName("oracle.jdbc.driver.OracleDriver");  
		//				//step2 create  the connection object  
		//				Connection con=DriverManager.getConnection(  
		//						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
		//				//step3 create the statement object  
		//				Statement stmt = con.createStatement();
		//				int i= stmt.executeUpdate("delete from emp where id = "+id);
		//				//	PreparedStatement stmt = con.prepareStatement("delete from emp where id = "+id);  				
		//				if(i>0)
		//					JOptionPane.showMessageDialog(this, "Delete Sucess");
		//
		//			}catch(Exception e1){ System.out.println(e1);}
		//		}
	}

	public static void main(String[] args) {
		new RegistrationForm();
	}


}
