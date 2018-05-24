package student_system;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Check_borad extends JFrame{

	JPanel p1;
	DefaultTableModel m_data;
	JTable m_view;
	public Check_borad() {
		// TODO Auto-generated constructor stub
		super("CHECKING");
		setResizable(false);
		 this.setBounds(300,300,480, 400);
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                super.windowClosing(e);
	                System.exit(0);
	            }
	        });
	        
	        this.setVisible(true);
	        p1=new JPanel();
	        Object[] table_head = {"S_NO","NAME","C","M","E","SUM"};// 定义表格列名数组
	        // 定义表格数据数组
	        String[][] tableValues = {{"1","张三","100","100","100","300"},{"1","张三","100","100","100","300"}};
	        // 创建指定列名和数据的表格
	        m_data=new DefaultTableModel(tableValues,table_head);
	        m_view=new JTable(m_data);
	        m_data.setRowCount(0);
	      for(int i=0;i<Main_borad.i_sum;i++) {
	    	 
	    	  if(Main_borad.sc.equals(Main_borad.s[i].s_no)) {
	    		  System.out.println(Main_borad.sc+"  "+Main_borad.s[i].s_no);
	    		  String []st= {Main_borad.s[i].s_no,Main_borad.s[i].s_name,Main_borad.s[i].s_c,Main_borad.s[i].s_m,Main_borad.s[i].s_e,Main_borad.s[i].getSum()};
		   			m_data.insertRow(0, st);
	    	  }
	    	  
	      }
	        // 创建显示表格的滚动面板
	        
	        p1.add(new JScrollPane(m_view));
	        add(p1);
	        
	}
}
