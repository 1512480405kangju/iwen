import java.awt.Checkbox;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.*;
public class One_Choice extends JFrame implements ActionListener {
    private static Object tjiao;
   	int questionNumber = 0;
   	int questionNumber1 = 0;
   	int j = 0;
   	int JCB_NUM = 0;
    JRadioButton[] radioButton = new JRadioButton[100];
    JCheckBox[] Jcb = new JCheckBox[100];
    public One_Choice() throws IOException {
        JFrame panel2 = new JFrame("问卷填写");
        panel2.setLayout(null);
        JLabel bti = new JLabel("圆圈为单选，方框为多选");
        bti.setFont(new Font("宋体", Font.BOLD, 20));
        bti.setBounds(250, 15, 800, 30);
        panel2.getContentPane().add(bti);

        BufferedReader br1;
       	String tmp = "";
		gettmp sa = new gettmp();
		tmp = sa.Get_Tmp();
        br1 = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\javacode\\iwen\\Project\\"+tmp+"\\one.txt"), "GBK"));
       	JScrollPane scrollPane = new JScrollPane(null);
       	scrollPane.setLayout(null);
       	scrollPane.setBounds(100, 100, 300, 500);
       	String title;
       	while ((title = br1.readLine()) != null) {//读一行标题
           String[] options = new String[4];
           for (int i = 0; i < options.length; i++) {
               options[i] = br1.readLine();//读四行
           }
           //添加个标题
           JLabel labelTitle = new JLabel((questionNumber + 1) + title);
           scrollPane.add(labelTitle);
           labelTitle.setBounds(1, 1 + questionNumber * 100, 400, 16);
           //循环添加按钮       
           ButtonGroup buttonGroup = new ButtonGroup();          
           for (int i = 0; i < options.length; i++) {
               radioButton[j] = new JRadioButton(options[i], i == 0);
               buttonGroup.add(radioButton[j]);
               scrollPane.add(radioButton[j]);
               radioButton[j].setBounds(16, questionNumber * 100 + i * 16 + 16, 400, 16);
               j++;
           }
           //问题数+1
           questionNumber++;
       	}      	
       panel2.getContentPane().add(scrollPane);
        BufferedReader br2;
        String tmp1 = "";
		gettmp sa1 = new gettmp();
		tmp1 = sa1.Get_Tmp();
        br2 = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\javacode\\iwen\\Project\\"+tmp1+"\\mult.txt")));
        questionNumber1 = questionNumber;
        while ((title = br2.readLine()) != null) {//读一行标题
            String[] options = new String[4];
            for (int i = 0; i < options.length; i++) {
                options[i] = br2.readLine();//读四行
            }
            //添加个标题
            JLabel labelTitle = new JLabel((questionNumber1 + 1) + title);
            scrollPane.add(labelTitle);
            labelTitle.setBounds(1, 1 + questionNumber1 * 100, 450, 26);
            //循环添加按钮
           // ButtonGroup buttonGroup = new ButtonGroup();
            for (int i = 0; i < options.length; i++) {
                Jcb[JCB_NUM] = new JCheckBox(options[i], i == 0);
               // buttonGroup.add(radioButton);
                scrollPane.add(Jcb[JCB_NUM]);
                Jcb[JCB_NUM].setBounds(16, questionNumber1 * 100 + i * 26 + 26, 450, 26);
                JCB_NUM++;
            }
            //问题数+1
            questionNumber1++;
        }
        panel2.getContentPane().add(scrollPane);      
        final JButton tjiao;
        JButton tji;
        tjiao = new JButton("提交");
        tjiao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    		String tmp1 = "";
    		gettmp sa1 = new gettmp();
    		try {
				tmp1 = sa1.Get_Tmp();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		int[] temp = new int[100];
    		int length = 0; 
    		File F1 = new File("C:\\javacode\\iwen\\Project\\"+tmp1+"\\one_num.txt");    
    	    try {
    	        InputStreamReader read = new InputStreamReader(new FileInputStream(F1), "GBK");
    	        BufferedReader reader = new BufferedReader(read);
    	        String line; 
    	        while ((line = reader.readLine()) != null) {
    	        	String s = "";
    	        	temp[length] = 0;
    	            s += line ;
    	            temp[length] += Integer.parseInt(s);
    	            length++;    	            
    	        }
    	        reader.close();
    	        read.close();
    	        } catch (Exception e1) {
    	            e1.printStackTrace();
    	        }
    	   for(int i = 0;i < j;i++){
    		   if(radioButton[i].isSelected()){
    			   temp[i]++;
    		   }
    	   }
		try {
			FileWriter pw = new FileWriter(F1);
	    	   for(int i = 0;i < j;i++){
	    		   pw.write(temp[i]+"\r\n");
	    	   }
	    	   pw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int[] temp1 = new int[100];
		int length1 = 0; 
		File F2 = new File("C:\\javacode\\iwen\\Project\\"+tmp1+"\\mult_num.txt");    
	    try {
	        InputStreamReader read = new InputStreamReader(new FileInputStream(F2), "GBK");
	        BufferedReader reader = new BufferedReader(read);
	        String line; 
	        while ((line = reader.readLine()) != null) {
	        	String s = "";
	        	temp1[length1] = 0;
	            s += line ;
	            temp1[length1] += Integer.parseInt(s);
	            length1++;    	            
	        }
	        reader.close();
	        read.close();
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	   for(int i = 0;i < JCB_NUM;i++){
		   if(Jcb[i].isSelected()){
			   temp1[i]++;
		   }
	   }
	try {
		System.exit (0);
		FileWriter pw = new FileWriter(F2);
    	   for(int i = 0;i < JCB_NUM;i++){
    		   pw.write(temp1[i]+"\r\n");
    	   }
    	   pw.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} } 
 });
        tjiao.setBounds(500, 600, 70, 30);
        panel2.getContentPane().add(tjiao);
        panel2.setVisible(true);
        panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        panel2.setBounds(300, 40, 700, 680); 
        panel2.setResizable(false);    
    }
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub		
	}    
}
