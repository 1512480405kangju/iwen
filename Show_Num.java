import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;
public class Show_Num extends JFrame implements ActionListener{
	JButton jb1 = null;
	JLabel[] jlb = new JLabel[100];
	JLabel lb = null;
	int questionNumber = 0;
	int multnumber = 0;
	public Show_Num() throws IOException{
		String tmp2 = "";
		gettmp sa = new gettmp();
		tmp2 = sa.Get_Tmp();
		JFrame panel2 = new JFrame("问卷填写");
        panel2.setLayout(null);
		JLabel bti = new JLabel(tmp2);
        bti.setFont(new Font("宋体", Font.BOLD, 20));
        bti.setBounds(250, 15, 800, 30);
        panel2.getContentPane().add(bti);       
        BufferedReader br1;
       	String tmp = "";
		gettmp sa1 = new gettmp();
		tmp = sa1.Get_Tmp();
        br1 = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\javacode\\iwen\\Project\\"+tmp+"\\one.txt"), "GBK"));
       	JScrollPane scrollPane = new JScrollPane(null);
       	scrollPane.setLayout(null);
       	scrollPane.setBounds(100, 100, 300, 500);
       	String title;
       	File F2 = new File("C:\\javacode\\iwen\\Project\\"+tmp2+"\\one_num.txt");    
       	int length = 0;	  
	    	int[] temp1 = new int[100];
	        InputStreamReader read = new InputStreamReader(new FileInputStream(F2), "GBK");
	        BufferedReader reader = new BufferedReader(read);
	        String line; 
	        while ((line = reader.readLine()) != null) {
	        	String s = "";
	        	temp1[length] = 0;
	            s += line ;
	            temp1[length] += Integer.parseInt(s);
	            length++;    	            
	        }
	        reader.close();
	        read.close();       
	    for(int i = 0;i < length/4;i++){
	    	JLabel lb = new JLabel("第"+(1+questionNumber)+"题" );
	    	lb.setBounds(1, 1 + questionNumber * 100, 400, 16);
	    	panel2.add(lb);
	    	for(int j = 0;j < 4;j++){
	    		 jlb[j+4*questionNumber] = new JLabel((j+1)+"选项有"+temp1[j+4*questionNumber] +"人选择\r\n");
	    		 jlb[j+4*questionNumber].setBounds(16, questionNumber * 100 + j * 16 + 16, 400, 16);
	    		 panel2.add(jlb[j+4*questionNumber]);
	    	}
	    	questionNumber++;
	    }
	    multnumber = questionNumber;	    	   	    
       	File F1 = new File("C:\\javacode\\iwen\\Project\\"+tmp2+"\\mult_num.txt");    
       	int length1 = 0;	  
	    	int[] temp4 = new int[100];
	        InputStreamReader read1 = new InputStreamReader(new FileInputStream(F1), "GBK");
	        BufferedReader reader1 = new BufferedReader(read1);
	        String line1; 
	        while ((line1 = reader1.readLine()) != null) {
	        	String s = "";
	        	temp4[length1] = 0;
	            s += line1 ;
	            temp4[length1] += Integer.parseInt(s);
	            length1++;    	            
	        }
	        reader1.close();
	        read1.close();
	    for(int i = 0;i < length1/4;i++){
	    	JLabel lb = new JLabel("第"+(1+questionNumber)+"题" );
	    	lb.setBounds(1, 1 + questionNumber * 100, 400, 16);
	    	panel2.add(lb);
	    	for(int j = 0;j < 4;j++){
	    		 jlb[j+4*questionNumber] = new JLabel((j+1)+"选项有"+temp4[j+4*(questionNumber - multnumber)] +"人选择\r\n");
	    		 jlb[j+4*questionNumber].setBounds(16, questionNumber * 100 + j * 16 + 16, 400, 16);
	    		 panel2.add(jlb[j+4*questionNumber]);
	    	}
	    	questionNumber++;
	    }                
		jb1 = new JButton("确认");
		jb1.addActionListener(this);
		panel2.add(jb1);
		jb1.setBounds(500, 600, 70, 30);
		panel2.setVisible(true);
        panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        panel2.setBounds(300, 40, 700, 680); 
        panel2.setResizable(false);		
	}
	public void actionPerformed(ActionEvent e) {         //监听各个按钮  
        if(e.getActionCommand()=="确认")  
        {    System.exit (0);        }        }	}

