package student_system;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;
public class Main_borad {
	static int i_sum=0;
	static String sc="";
	static Student []s= new Student[100];
	static public void init()
	{
		for(int i=0;i<100;i++) {
	    	s[i]=new Student();
	    }
	}
}

class UIManager extends JFrame {
	DefaultTableModel m_data;
	
	JTable m_view;
	Check_borad c;
    public UIManager() {
        super("STUDENT_SYSTEM V0.1");
        setResizable(false);
    }

    public void initUI() {
        this.setBounds(300,300,480, 400);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        layoutUI();
        this.setVisible(true);
    }

    private void layoutUI() {

        // 对象实例化
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
        // 容器
        Container container = this.getLayeredPane();
        // 对象化面板
        JPanel combop = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
       
        tab.add(p1, "Grade_Input");
        tab.add(p2, "Grade_Check");
        tab.add(p3, "Grade_Rank");
       

        combop.add(new JLabel("STUDENT_SYSTEM V0.1"));

        container.setLayout(new BorderLayout());
        container.add(combop, BorderLayout.NORTH);
        container.add(tab, BorderLayout.CENTER);

        /*p1*/
        JTextField []t= {
        		new JTextField("S_NO：",15),
        		new JTextField("",20),
        		new JTextField("NAME：",15),
        		new JTextField("",20),
        		new JTextField("CHINESE_GRADE：",15),
        		new JTextField("",20),
        		new JTextField("MATH_GRADE：",15),
        		new JTextField("",20),
        		new JTextField("ENGLISH_GRADE：",15),
        		new JTextField("",20),
        		
        };
       t[0].setEditable(false);
       t[2].setEditable(false);
       t[4].setEditable(false);
       t[6].setEditable(false);
       t[8].setEditable(false);
       for(int i=0;i<10;i++) {
    	   p1.add(t[i]);
       }
       
       JButton jb1=new JButton("SUBMIT");
       p1.add(jb1);
       
       /*P1*/
       
       /**P2**/
       JTextField []t1= {
       		new JTextField("S_NO：",15),
       		new JTextField("",20),
       		
       };
       for(int i=0;i<2;i++) {
    	   p2.add(t1[i]);
       }
       t1[0].setEditable(false);
       
       JButton jb2=new JButton("CHECK");
       p2.add(jb2);
       /**P2**/
       
       /*p3*/
       JButton jb3=new JButton("C_RANK");
       JButton jb4=new JButton("M_RANK");
       JButton jb5=new JButton("E_RANK");
       JButton jb6=new JButton("S_RANK");
       p3.add(jb3);
       p3.add(jb4);
       p3.add(jb5);
       p3.add(jb6);
       Object[] table_head = {"S_NO","NAME","C","M","E","SUM"};// 定义表格列名数组
       // 定义表格数据数组
       String[][] tableValues = {{"1","张三","100","100","100","300"},{"1","张三","100","100","100","300"}};
       // 创建指定列名和数据的表格
       m_data=new DefaultTableModel(tableValues,table_head);
       m_view=new JTable(m_data);
     
       // 创建显示表格的滚动面板
       
       p3.add(new JScrollPane(m_view));
       
       /*p3*/
       //提交按钮
       jb1.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			
   			// TODO Auto-generated method stub
   			//Student t=new Student(t[1].getText(), t[3].getText(), t[5].getText(), t[7].getText(),t[9].getText());
   			String s1=t[1].getText();
   			String s2=t[3].getText();
   			String s3=t[5].getText();
   			String s4=t[7].getText();
   			String s5=t[9].getText();
   			System.out.println(s1);
   			if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")) {
   				
   				JOptionPane.showMessageDialog(new JFrame().getContentPane(),
   	   					"INFORMATION IS NOT COMPELETED!", "SYSTEM_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
   			}
   			if(s3.charAt(0)<48||s3.charAt(0)>57||s4.charAt(0)<48||s4.charAt(0)>57||s5.charAt(0)<48||s5.charAt(0)>57)
				{
					JOptionPane.showMessageDialog(new JFrame().getContentPane(),
	   	   					"GRADE IS NOT INT!", "SYSTEM_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
				}
   			else 
   			{
   			t[1].setText("");
   			t[3].setText("");
   			t[5].setText("");
   			t[7].setText("");
   			t[9].setText("");
   			
   			Student t=new Student(s1, s2, s3, s4,s5);
   			Main_borad.s[Main_borad.i_sum]=t;
   			Main_borad.i_sum++;
   			String []s6= {s1,s2,s3,s4,s5,t.getSum()};
   			m_data.insertRow(0, s6);
   			JOptionPane.showMessageDialog(new JFrame().getContentPane(),
   					"INPUT COMPELETED!", "SYSTEM_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
   			
   		}
   		}
   	});
       //语文排序按钮
       jb3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("C_rank"+"SUM:"+Main_borad.i_sum);
			// TODO Auto-generated method stub
			for(int j=0;j<Main_borad.i_sum;j++) {
				for(int i=1;i<Main_borad.i_sum-j;i++) {
					//System.out.println(Integer.parseInt(Main_borad.s[i].s_c));
				if(Integer.parseInt(Main_borad.s[i-1].s_c)>Integer.parseInt(Main_borad.s[i].s_c)) {
					Student t =new Student();
					t=Main_borad.s[i];
					Main_borad.s[i]=Main_borad.s[i-1];
					Main_borad.s[i-1]=t;
				}
				}
			}//xunhuanjiesu
			m_data.setRowCount(0);
			for(int i=0;i<Main_borad.i_sum;i++) {
				String []st= {Main_borad.s[i].s_no,Main_borad.s[i].s_name,Main_borad.s[i].s_c,Main_borad.s[i].s_m,Main_borad.s[i].s_e,Main_borad.s[i].getSum()};
	   			m_data.insertRow(0, st);
			}
			
		}
	});
       //数学排序按钮
       jb4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("C_rank"+"SUM:"+Main_borad.i_sum);
			// TODO Auto-generated method stub
			for(int j=0;j<Main_borad.i_sum;j++) {
				for(int i=1;i<Main_borad.i_sum-j;i++) {
					//System.out.println(Integer.parseInt(Main_borad.s[i].s_c));
				if(Integer.parseInt(Main_borad.s[i-1].s_m)>Integer.parseInt(Main_borad.s[i].s_m)) {
					Student t =new Student();
					t=Main_borad.s[i];
					Main_borad.s[i]=Main_borad.s[i-1];
					Main_borad.s[i-1]=t;
				}
				}
			}//xunhuanjiesu
			m_data.setRowCount(0);
			for(int i=0;i<Main_borad.i_sum;i++) {
				String []st= {Main_borad.s[i].s_no,Main_borad.s[i].s_name,Main_borad.s[i].s_c,Main_borad.s[i].s_m,Main_borad.s[i].s_e,Main_borad.s[i].getSum()};
	   			m_data.insertRow(0, st);
			}
			
		}
	});
       //英语排序按钮
       jb5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("C_rank"+"SUM:"+Main_borad.i_sum);
			// TODO Auto-generated method stub
			for(int j=0;j<Main_borad.i_sum;j++) {
				for(int i=1;i<Main_borad.i_sum-j;i++) {
					//System.out.println(Integer.parseInt(Main_borad.s[i].s_c));
				if(Integer.parseInt(Main_borad.s[i-1].s_e)>Integer.parseInt(Main_borad.s[i].s_e)) {
					Student t =new Student();
					t=Main_borad.s[i];
					Main_borad.s[i]=Main_borad.s[i-1];
					Main_borad.s[i-1]=t;
				}
				}
			}//xunhuanjiesu
			m_data.setRowCount(0);
			for(int i=0;i<Main_borad.i_sum;i++) {
				String []st= {Main_borad.s[i].s_no,Main_borad.s[i].s_name,Main_borad.s[i].s_c,Main_borad.s[i].s_m,Main_borad.s[i].s_e,Main_borad.s[i].getSum()};
	   			m_data.insertRow(0, st);
			}
			
		}
	});
       //zongfen排序按钮
       jb6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("C_rank"+"SUM:"+Main_borad.i_sum);
			// TODO Auto-generated method stub
			for(int j=0;j<Main_borad.i_sum;j++) {
				for(int i=1;i<Main_borad.i_sum-j;i++) {
					//System.out.println(Integer.parseInt(Main_borad.s[i].s_c));
				if(Main_borad.s[i-1].s>Main_borad.s[i].s) {
					Student t =new Student();
					t=Main_borad.s[i];
					Main_borad.s[i]=Main_borad.s[i-1];
					Main_borad.s[i-1]=t;
				}
				}
			}//xunhuanjiesu
			m_data.setRowCount(0);
			for(int i=0;i<Main_borad.i_sum;i++) {
				String []st= {Main_borad.s[i].s_no,Main_borad.s[i].s_name,Main_borad.s[i].s_c,Main_borad.s[i].s_m,Main_borad.s[i].s_e,Main_borad.s[i].getSum()};
	   			m_data.insertRow(0, st);
			}
			
		}
	});
       
       //查询
       jb2.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent arg0) {
   			Main_borad.sc=t1[1].getText();
   			 c=new Check_borad();//新建子窗口对象  
   			c.setVisible(true);//子窗口可见  
            //getContentPane().add(c);//子窗口添加到父窗口中     
   		}
   	});
}
}