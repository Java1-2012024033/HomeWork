package Hw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator  extends JFrame implements ActionListener{
	private JTextField text;
	private String[] label = {"7","8","9","C"," ",
							"4","5","6","+","*",
							"1","2","3","-","/",
							"0",".","+/-","%","=",						
	};
	private JButton[] bu;
	private double result =0;
	private String operator = "=";
	private boolean startOfNumber=true;
	
	public Calculator(){
		setTitle("의연이와 강우의 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text = new JTextField("100");
		text.setText("0.0");
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new GridLayout(0,5,3,3));
		bu = new JButton[20];
		
		int index =0;
		
		for(int i=0;i<4;i++){
			for(int j=0; j<5;j++){
				bu[index] = new JButton(label[index]);
				if(j>2){
					bu[index].setBackground(Color.YELLOW);
				}
				else{
					bu[index].setBackground(Color.MAGENTA);
				}
				panel1.add(bu[index]);
				bu[index].addActionListener(this);
				index++;
			}
		}
		add(text,BorderLayout.NORTH);
		add(panel1,BorderLayout.SOUTH);
		setVisible(true);
		pack();
	}
	
	public void actionPerformed(ActionEvent e){
		String Command = e.getActionCommand();
		if (Command.charAt(0) == 'C'){
			startOfNumber = true;
			result = 0;
			operator = "=";
			text.setText("0.0");
		}
		else if (Command.charAt(0) >= '0' && Command.charAt(0) <= '9' || Command.equals(".")){
			if(startOfNumber == true)
				text.setText(Command);
			else
				text.setText(text.getText()+Command);
			startOfNumber = false;	
		}
		else {
			if(startOfNumber){
				if(Command.equals("-")){
					text.setText(Command);
					startOfNumber = false;
				} else
					operator = Command;
			}
			else {
				double x = Double.parseDouble(text.getText());
				calculate(x);
				operator = Command;
				startOfNumber = true;
			}
		}
	}
	
	private void calculate(double n){
		if(operator.equals("+"))
			result += n;
		else if (operator.equals("-"))
			result -= n;
		else if(operator.equals("*"))
			result *= n;
		else if (operator.equals("/"))
			result /= n;
		else if (operator.equals("%"))
			result = result % n;
		else if (operator.equals("="))
			result = n;
		text.setText(" " + result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
