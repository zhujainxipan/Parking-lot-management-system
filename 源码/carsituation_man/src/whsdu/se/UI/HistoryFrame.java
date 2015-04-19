/*
 * 该ui类用于显示信息查询菜单下的用户历史记录菜单项的显示
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;																										
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import whsdu.se.DAL.Dal;
import whsdu.se.DAO.park;
import whsdu.se.DAO.users;
import whsdu.se.UI.ComUsersInfoFrame.queryActionListener;

public class HistoryFrame extends JInternalFrame {
	private  JLabel  queryjcombobox;
	private  JTextField queryjtextfield;
	private  JButton queryjbutton;
	private  JLabel  cardidjtextfield;
	private  JLabel  namejtextfield;
	private  JLabel  passwordjtextfield;
	private  JLabel  cardtypejtextfield;
	private  JLabel  overagejtextfield;
	private  JLabel  teljtextfield;
	private  users user;
	private  JLabel caridjtextfield;
	private  JPanel panel2;
	private  JPanel mainPanel;	

	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			park park = (park) list.get(i);
			s[i][0] = park.getCardid();
			s[i][1] = park.getStationid();
			s[i][2] = park.getStartpark();
			s[i][3] = park.getEndpark();
			s[i][4] = park.getSumpark();
			s[i][5] = park.getFee();
		}
		return s;
	}

	//构造方法
	public HistoryFrame() {
		super("用户历史信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(49,99,639,367));
		setBackground(java.awt.Color.gray);
		mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));

		JPanel Panel1 = new JPanel();			//创建中心面板
		Panel1.setLayout(new FlowLayout());		//设置布局
		Panel1.setBorder(new EmptyBorder(10,10,10,10));		//设置边框为0
		mainPanel.add(Panel1,BorderLayout.NORTH);		//将中心面板加入到窗体
		queryjcombobox = new JLabel("卡号");
		Panel1.add(queryjcombobox);//添加到中心面板			//添加到中心面板
		queryjtextfield = new JTextField();//创建密码文本框
		queryjtextfield.setColumns(10);//设置文本框长度
		Panel1.add(queryjtextfield);
		queryjbutton = new JButton();//创建保存按钮
		queryjbutton.addActionListener(new queryActionListener());//注册监听器
		queryjbutton.setText("查询");//设置按钮文本
		Panel1.add(queryjbutton);//添加到中心面板
		
		setVisible(true);
	}

	class queryActionListener implements ActionListener {//添加查询菜单监听器

		public void actionPerformed(ActionEvent arg0) {
			String [] history = { "卡号",  "车位", "开始时间", "结束时间","总时间(h)",  "费用(元)"};
			if(queryjtextfield.getText().equals(""))
				queryjtextfield.setText("");
			else {
				Object[][] results=getselect(Dal.selectcardid(Integer.parseInt(queryjtextfield.getText())));
				JTable table = new JTable(results,history);
				JScrollPane scroll = new JScrollPane(table);
				mainPanel.add(scroll,BorderLayout.CENTER);		//将中心面板加入到窗体
			}
		}
	}
}















