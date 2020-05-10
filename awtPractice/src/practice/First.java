package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

class First extends JFrame implements ActionListener{  
	First(){  
		JButton b=new JButton("India");  
		b.setBounds(30,50,80,30);  

		add(b);
		
		JButton b1=new JButton("China");  
		b1.setBounds(130,50,80,30);  
		
		add(b1);
		
		JButton b2=new JButton("Aus");  
		b2.setBounds(30,150,80,30); 
		
		JButton b3=new JButton("Japan");  
		b3.setBounds(130,150,80,30); 

		add(b2); add(b3);
			
		setSize(300,300);  
		setLayout(null);  
		setVisible(true);  
	}  
	public static void main(String args[]){  
		First f=new First();  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}  

