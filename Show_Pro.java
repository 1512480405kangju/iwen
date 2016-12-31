import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
public class Show_Pro extends JFrame implements ActionListener {
    JButton jb1, jb2 = null;
    JPanel jp1, jp2, jp3 = null;
    JComboBox<String> fileComboBox = null; 
    JLabel jlb1, jlb2 = null;
    String getsit;
    public Show_Pro() {
        jb1 = new JButton("确认");
        jb2 = new JButton("返回");
        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jlb1 = new JLabel("问卷的名字：");
      try {
            String userName = new getstate().Get_State();
            File path = new File("C:/javacode/iwen/Project/");
            if (path.isDirectory() && path.exists()) {
                String[] dirList = path.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return dir.isDirectory();
                    }
                });
                fileComboBox = new JComboBox<String>(dirList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp1.add(jlb1);
        jp1.add(fileComboBox);
        jp3.add(jb1);
        jp3.add(jb2);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("调查问卷统计界面");
        this.setLayout(new GridLayout(3, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 300, 180);      
    }
    public void actionPerformed(ActionEvent e) {
        //监听各个按钮
        if (e.getActionCommand() == "确认") {
            this.dispose();
            try {
				new Show_Num();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        } else if (e.getActionCommand() == "返回") {
            //返回UI
            this.dispose();
            new UI();
        }
    }
    public static void createtmp(String str1) {
        File fi1 = new File("C:/javacode/iwen/User/tmp.txt");
        try {
            fi1.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter("C:/javacode/iwen/User/tmp.txt"));
            pw.print(str1);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

