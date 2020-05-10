package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SalaryForm extends JFrame implements ActionListener {

	JLabel jl1;
	JLabel jl2;

	JRadioButton jr1;
	JRadioButton jr2;

	JTextField jt1 ;
	JTextField jt2 ;

	JTextField jt3 ;

	JButton jbCheck ;
	JButton jbExit ;	

	SalaryForm(){

		jl1 = new JLabel("Enter name");
		jl1.setBounds(30,50,80,20);

		jl2 = new JLabel("Enter Salary");
		jl2.setBounds(30,150,80,20);

		add(jl1); add(jl2);

		jt1 = new JTextField();
		jt2 = new JTextField();		

		jt1.setBounds(130,50,80,20);
		jt2.setBounds(130,150,80,20);

		add(jt1);add(jt2);

		jr1 = new JRadioButton("Clerk");
		jr2 = new JRadioButton("Peon");

		jr1.setBounds(130,210,70,40);
		jr2.setBounds(210,210,70,40);	
		ButtonGroup bg=new ButtonGroup();
		bg.add(jr1);
		bg.add(jr2);
		add(jr1);
		add(jr2);

		jbCheck = new JButton("Check");
		jbCheck.setBounds(130,270,70,30);
		jbCheck.addActionListener(this);	

		jbExit = new JButton("Exit");
		jbExit.setBounds(210,270,70,30);
		jbExit.addActionListener(this);		

		add(jbExit);
		add(jbCheck);

		jt3 = new JTextField();
		jt3.setBounds(210,360,70,30);
		add(jt3);
		setSize(500,500);

		setLayout(null);  
		setVisible(true);  


	}



	public void actionPerformed(ActionEvent e) {

		String input1 = jt1.getText();
		String input2 = jt2.getText();

		if(e.getSource().equals(jbCheck)){
			if(jr1.isSelected())
				jt3.setText("25000");
			else 
				jt3.setText("30000");
		}

		if(e.getSource().equals(jbExit)){
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new SalaryForm();
	}


}
