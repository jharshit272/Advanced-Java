package practice;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Calculator extends JFrame implements ActionListener {

	JTextField jt1 ;
	JTextField jt2 ;	
	JTextField jt3 ;
	
	JButton jbPlus ;
	JButton jbMinus ;
	JButton jbMultiply ;
	JButton jbDivide ;
	JButton jbClr ;
	
	
	Calculator(){
		jt1 = new JTextField();
		jt2 = new JTextField();
		jt3 = new JTextField();
		
		jt1.setBounds(30,50,30,30);
		jt2.setBounds(30,90,30,30);
		jt3.setBounds(80,90,30,30);
		
				
		jbPlus = new JButton("");
		jbPlus.setBounds(30,160,50,30);
		jbPlus.addActionListener(this);
		
		jbMinus = new JButton("-");
		jbMinus.setBounds(90,160,50,30);
		jbMinus.addActionListener(this);
		
		jbMultiply = new JButton("X");
		jbMultiply.setBounds(150,160,50,30);
		jbMultiply.addActionListener(this);
		
		jbDivide = new JButton("/");
		jbDivide.setBounds(210,160,50,30);
		jbDivide.addActionListener(this);
		
		jbClr = new JButton("Clr");
		jbClr.setBounds(270,160,50,30);
		jbClr.addActionListener(this);
		
		add(jbClr); add(jbDivide);
		add(jbMinus); add(jbMultiply);
		add(jbPlus); add(jt1);
		 add(jt2);add(jt3);
		
		setSize(500,500);
		
		setLayout(null);  
		setVisible(true);  
	}
	
	

	public void actionPerformed(ActionEvent e) {
		
		String input1 = jt1.getText();
		String input2 = jt2.getText();
	   
		if(e.getSource().equals(jbPlus)){
			jt3.setText(String.valueOf(Integer.parseInt(input1)+Integer.parseInt(input2)));
		}
		
		if(e.getSource().equals(jbMinus)){
			jt3.setText(String.valueOf(Integer.parseInt(input1)-Integer.parseInt(input2)));
		}
		
		
		if(e.getSource().equals(jbMultiply)){
			jt3.setText(String.valueOf(Integer.parseInt(input1)*Integer.parseInt(input2)));
		}
		
		
		if(e.getSource().equals(jbDivide)){
			jt3.setText(String.valueOf(Integer.parseInt(input1)/Integer.parseInt(input2)));
		}
		
		if(e.getSource().equals(jbClr)){
			jt3.setText("");
		}
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	
}
