package assignment;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SalaryForm extends JFrame implements ActionListener
{
/* why issue here*/
	JLabel jlName;
	JLabel jlSal;
	JLabel jlId;

	JTextField jtName ;
	JTextField jtSal ;	
	JTextField jtId ;

	JButton jbAdd ;
	JButton jbExit ;
	JButton jbSearch ;
	JButton jbUpdate ;
	JButton jbDel ;
	
	JLabel jlNote;

	SalaryForm(){

		jlName = new JLabel("Enter name");
		jlName.setBounds(30,50,80,20);

		jlId = new JLabel("Enter Id");
		jlId.setBounds(30,100,80,20);

		jlSal = new JLabel("Enter Salary");
		jlSal.setBounds(30,150,80,20);

		add(jlName); add(jlId); add(jlSal);

		jtName = new JTextField();
		jtSal = new JTextField();	
		jtId = new JTextField();	

		jtName.setBounds(130,50,80,20);
		jtSal.setBounds(130,150,80,20);
		jtId.setBounds(130,100,80,20);

		add(jtName); add(jtSal); add(jtId);

		jbAdd = new JButton("Add");
		jbAdd.setBounds(30,270,60,30);
		jbAdd.addActionListener(this);	
		add(jbAdd);

		jbSearch = new JButton("Search");
		jbSearch.setBounds(100,270,80,30);
		jbSearch.addActionListener(this);
		add(jbSearch);

		jbUpdate = new JButton("Update");
		jbUpdate.setBounds(190,270,80,30);
		jbUpdate.addActionListener(this);
		add(jbUpdate);

		jbDel = new JButton("Delete");
		jbDel.setBounds(280,270,80,30);
		jbDel.addActionListener(this);
		add(jbDel);

		jbExit = new JButton("Exit");
		jbExit.setBounds(370,270,60,30);
		jbExit.addActionListener(this);			
		add(jbExit);
		
		jlNote = new JLabel("Note:Plz Perform Update Search and Delete operation by entering the Id");
		jlNote.setBounds(10,330,450,30);		
		add(jlNote);

		setSize(500,500);
		setLayout(null);  
		setVisible(true); 	
	}



	public void actionPerformed(ActionEvent event) {

		int id = 0;
		String name = null;
		int sal = 0;
		if(event.getSource().equals(jbAdd)){
			id = Integer.parseInt(jtId.getText());
			name = jtName.getText();
			sal = Integer.parseInt(jtSal.getText());
			//	createConnection();
			try
			{	//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
				//step3 create the statement object  
				PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");  
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setInt(3, sal);

				int i= stmt.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(this, "Inserted Sucess");
				con.close();  /* Why this is required? */
			}catch(Exception e1){ System.out.println(e1);}  

		}

		if(event.getSource().equals(jbExit)){
			System.exit(0);
		}

		if(event.getSource().equals(jbSearch)){
			id = Integer.parseInt(jtId.getText());
			try
			{	//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
				//step3 create the statement object  
				Statement stmt = con.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from emp where id = "+id);
				rs.next();
				jtName.setText(rs.getString(2));
				jtSal.setText(rs.getString(3));
			}catch(Exception e1){ System.out.println(e1);}
		}
		
		if(event.getSource().equals(jbUpdate)){
			id = Integer.parseInt(jtId.getText());
			name = jtName.getText();
			sal = Integer.parseInt(jtSal.getText());
			
			try
			{	//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
				//step3 create the statement object  
				PreparedStatement stmt = con.prepareStatement("update emp set name = ?, salary = ? where id = ?");  
				
				stmt.setString(1, name);
				stmt.setInt(2, sal);
				stmt.setInt(3, id);
				
				int i= stmt.executeUpdate();
				if(i>0)
					JOptionPane.showMessageDialog(this, "Updated Sucess");
				
			}catch(Exception e1){ System.out.println(e1);}
		}
		
		if(event.getSource().equals(jbDel)){
			id = Integer.parseInt(jtId.getText());
			
			try
			{	//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
				//step3 create the statement object  
				Statement stmt = con.createStatement();
				int i= stmt.executeUpdate("delete from emp where id = "+id);
			//	PreparedStatement stmt = con.prepareStatement("delete from emp where id = "+id);  				
				if(i>0)
					JOptionPane.showMessageDialog(this, "Delete Sucess");
				
			}catch(Exception e1){ System.out.println(e1);}
		}
	}

	public static void main(String[] args) {
		new SalaryForm();
	}


}
