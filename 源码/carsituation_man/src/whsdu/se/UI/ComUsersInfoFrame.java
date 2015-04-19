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

public class ComUsersInfoFrame extends JInternalFrame {
	private static JComboBox queryjcombobox;
	private static JTextField queryjtextfield;
	private static JButton queryjbutton;
	private static JLabel  cardidjtextfield;
	private static JLabel  namejtextfield;
	private static JLabel  passwordjtextfield;
	private static JLabel  cardtypejtextfield;
	private static JLabel  overagejtextfield;
	private static JLabel  teljtextfield;
	private static users user;
	private static JLabel caridjtextfield;
	
	
	//构造方法
	public ComUsersInfoFrame() {
		super("用户个人信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(124,110,495,295));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		
		JPanel Panel1 = new JPanel();			//创建面板1
		Panel1.setLayout(new FlowLayout());		//设置布局
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//设置边框为
		mainPanel.add(Panel1,BorderLayout.NORTH);		//将面板1加入到中心面板的北面
		
		queryjcombobox = new JComboBox();//创建下拉框
		String[] array=new String[]{"姓名","卡号"};//列表
		queryjcombobox.setModel(new DefaultComboBoxModel(array));//设置下拉框模型
		Panel1.add(queryjcombobox);//添加到面板1		
		
		queryjtextfield = new JTextField();//创建查询文本框
		queryjtextfield.setColumns(10);//设置文本框长度
		Panel1.add(queryjtextfield);
		
		queryjbutton = new JButton();//创建查询按钮
		queryjbutton.addActionListener(new queryActionListener());//注册监听器
		queryjbutton.setText("查询");//设置按钮文本
		Panel1.add(queryjbutton);//添加到面板1
		
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
		
		JLabel namejlabel = new JLabel();	//创建姓名标签
		namejlabel.setText("姓名：");			//设置标签文本
		Panel2.add(namejlabel);				//添加到面板2
		namejtextfield = new JLabel();
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(namejtextfield);
		
		JLabel passwordjlabel = new JLabel();	//创建密码标签
		passwordjlabel.setText("密码：");			//设置标签文本
		Panel2.add(passwordjlabel);				//添加到面板2
		passwordjtextfield = new JLabel();
		passwordjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(passwordjtextfield);
		
		JLabel cardtypejlabel = new JLabel();	//创建卡的类型标签
		cardtypejlabel.setText("类型：");			//设置标签文本
		Panel2.add(cardtypejlabel);				//添加到面板2
		cardtypejtextfield = new JLabel();//创建密码文本框
		cardtypejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(cardtypejtextfield);
		
		JLabel overagejlabel = new JLabel();	//创建余额标签
		overagejlabel.setText("余额：");			//设置标签文本
		Panel2.add(overagejlabel);				//添加到面板2
		overagejtextfield = new JLabel();
		overagejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(overagejtextfield);
		
		JLabel teljlabel = new JLabel();	//创建电话标签
		teljlabel.setText("电话：");			//设置标签文本
		Panel2.add(teljlabel);				//添加到面板2
		teljtextfield = new JLabel();
		teljtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(teljtextfield);
		
		JLabel caridjlabel = new JLabel();	//创建车牌号标签
		caridjlabel.setText("车牌号：");			//设置标签文本
		Panel2.add(caridjlabel);				//添加到面板2
		caridjtextfield = new JLabel();
		caridjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(caridjtextfield);
	
		setVisible(true);											// 显示窗体可见	
}

	class queryActionListener implements ActionListener {			// 添加查询按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			users user = new users();
			if(queryjcombobox.getSelectedItem().equals("姓名")){
				String a1 = queryjtextfield.getText();
				user = Dal.searchcominfo("select * from users where userstype = '普通用户'and name =" +"'"+a1+"'");
				cardidjtextfield.setText(String.valueOf(user.getCardid()));
				namejtextfield.setText(String.valueOf(user.getName()));
				passwordjtextfield.setText(String.valueOf(user.getPassword()));
				cardtypejtextfield.setText(user.getCardtype());
				overagejtextfield.setText(String.valueOf(user.getOverage()));
				teljtextfield.setText(String.valueOf(user.getTel()));
				caridjtextfield.setText(String.valueOf(user.getCarid()));
			}
			
			else {
				int a2 = Integer.parseInt(queryjtextfield.getText().trim());
				user = Dal.searchcominfo("select * from users where userstype = '普通用户'and cardid = "+a2 );
				cardidjtextfield.setText(String.valueOf(user.getCardid()));
				namejtextfield.setText(user.getName());
				passwordjtextfield.setText(String.valueOf(user.getPassword()));
				cardtypejtextfield.setText(user.getCardtype());
				overagejtextfield.setText(String.valueOf(user.getOverage()));
				teljtextfield.setText(String.valueOf(user.getTel()));
				caridjtextfield.setText(String.valueOf(user.getCarid()));
			}
		}
	}
}











