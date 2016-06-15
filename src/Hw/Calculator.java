package Hw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator  extends JFrame{
	private JTextField text;
	private String[] label = {"7","8","9","C","Del",
							"4","5","6","+","*",
							"1","2","3","-","/",
							"0",".","+/-","%","=",						
	};
	private JButton[] bu;
	private double result =0;
	private String operator ="=";
	private boolean startOfNumber=true;
	
	public Calculator(){
		setTitle("의연이와 강우의 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text = new JTextField("100");
		text.setText("0.");
		text.setEditable(false);
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
				index++;
			}
		}
		add(text,BorderLayout.NORTH);
		add(panel1,BorderLayout.SOUTH);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
