
/*
 * 该ui类用于查询菜单下的用户个人信息菜单项的显示
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;

public class ComUsersInfoFrame1 extends JInternalFrame {
	private static JComboBox queryjcombobox;
	private static JTextField queryjtextfield;
	private static JButton queryjbutton;
	private static JLabel  cardidjtextfield;
	private static JLabel  namejtextfield;
	private static JLabel  passwordjtextfield;
	private static JLabel  cardtypejtextfield;
	private static JLabel  overagejtextfield;
	private static JLabel  teljtextfield;
	private static JLabel caridjtextfield;
	private users user = LoginFrame.getUser(); 
	
	
	//构造方法
	public ComUsersInfoFrame1() {
		super("用户个人信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(114,97,482,221));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		
		JPanel Panel2 = new JPanel();			//创建面板2
		GridLayout gridLayout = new GridLayout(4,4);
		Panel2.setLayout(gridLayout);		//设置布局
		gridLayout.setVgap(5);					//设置组件之间垂直距离
		gridLayout.setHgap(5);					//设置组件之间平行距离
		Panel2.setBorder(new EmptyBorder(10,30,30,30));		//设置边框
		mainPanel.add(Panel2,BorderLayout.CENTER);		//将面板2加入到中心面板的中心
		
	    JLabel cardidjlabel = new JLabel();	//创建卡号标签
		cardidjlabel.setText("卡号：");			//设置标签文本
		Panel2.add(cardidjlabel);				//添加到面板2
		cardidjtextfield = new JLabel();
		cardidjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardidjtextfield);
		cardidjtextfield.setText(String.valueOf(user.getCardid()));
		
		JLabel namejlabel = new JLabel();	//创建姓名标签
		namejlabel.setText("姓名：");			//设置标签文本
		Panel2.add(namejlabel);				//添加到面板2
		namejtextfield = new JLabel();
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(namejtextfield);
		namejtextfield.setText(user.getName());
		
		JLabel passwordjlabel = new JLabel();	//创建密码标签
		passwordjlabel.setText("密码：");			//设置标签文本
		Panel2.add(passwordjlabel);				//添加到面板2
		passwordjtextfield = new JLabel();
		passwordjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(passwordjtextfield);
		passwordjtextfield.setText(user.getPassword());
		
		JLabel cardtypejlabel = new JLabel();	//创建卡的类型标签
		cardtypejlabel.setText("类型：");			//设置标签文本
		Panel2.add(cardtypejlabel);				//添加到面板2
		cardtypejtextfield = new JLabel();//创建密码文本框
		cardtypejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardtypejtextfield);
		cardtypejtextfield.setText(user.getCardtype());
		
		JLabel overagejlabel = new JLabel();	//创建余额标签
		overagejlabel.setText("余额：");			//设置标签文本
		Panel2.add(overagejlabel);				//添加到面板2
		overagejtextfield = new JLabel();
		overagejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(overagejtextfield);
		overagejtextfield.setText(String.valueOf(user.getOverage()));
		
		JLabel teljlabel = new JLabel();	//创建电话标签
		teljlabel.setText("电话：");			//设置标签文本
		Panel2.add(teljlabel);				//添加到面板2
		teljtextfield = new JLabel();
		teljtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(teljtextfield);
		teljtextfield.setText(String.valueOf(user.getTel()));
		
		JLabel caridjlabel = new JLabel();	//创建车牌号标签
		caridjlabel.setText("车牌号：");			//设置标签文本
		Panel2.add(caridjlabel);				//添加到面板2
		caridjtextfield = new JLabel();
		caridjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(caridjtextfield);
		caridjtextfield.setText(String.valueOf(user.getCarid()));
		setVisible(true);		// 显示窗体可见	
  }
}











