/*
 * 该ui类用于显示信息维护菜单下的用户注册菜单项
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


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

public class ComZhuCeFrame extends JInternalFrame {
	private  JTextField cardidjtextfield;
	private  JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private  JComboBox cardtypejcombobox;
	private  JTextField overagejtextfield;
	private JTextField teljtextfield;
	private JButton savejbutton;
	private JTextField caridjtextfield;

	//构造方法
	public ComZhuCeFrame() {
		super("用户注册");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(99,76,514,317));
		JPanel mainPanel = new JPanel();			//创建中心面板
		GridLayout gridLayout = new GridLayout(8,4);//创建表格布局管理器
		gridLayout.setVgap(5);					//设置组件之间垂直距离
		gridLayout.setHgap(5);					//设置组件之间平行距离
		mainPanel.setLayout(gridLayout);		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(10, 30, 10, 30));

		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	
		mainPanel.add(new JLabel());	

		JLabel cardidjlabel = new JLabel();	//创建卡号标签
		cardidjlabel.setText("卡号：");			//设置标签文本
		mainPanel.add(cardidjlabel);				//添加到中心面板
		cardidjtextfield = new JTextField();//创建卡号文本框
		cardidjtextfield.setColumns(12);//设置文本框长度
		mainPanel.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	//创建姓名标签
		namejlabel.setText("姓名：");			//设置标签文本
		mainPanel.add(namejlabel);				//添加到中心面板
		namejtextfield = new JTextField();//创建姓名文本框
		cardidjtextfield.setColumns(6);//设置文本框长度
		mainPanel.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();	//创建密码标签
		passwordjlabel.setText("密码：");			//设置标签文本
		mainPanel.add(passwordjlabel);				//添加到中心面板
		passwordjtextfield = new JTextField();//创建密码文本框
		passwordjtextfield.setColumns(10);//设置文本框长度
		mainPanel.add(passwordjtextfield);

		JLabel cardtypejlabel = new JLabel();	//创建卡的类型标签
		cardtypejlabel.setText("类型：");			//设置标签文本
		mainPanel.add(cardtypejlabel);				//添加到中心面板
		cardtypejcombobox = new JComboBox();//创建卡的类型下拉框
		String[] array=new String[]{"普通卡","优惠卡"};//卡的类型列表
		cardtypejcombobox.setModel(new DefaultComboBoxModel(array));//设置下拉框模型
		mainPanel.add(cardtypejcombobox);//添加到中心面板

		JLabel overagejlabel = new JLabel();	//创建余额标签
		overagejlabel.setText("余额：");			//设置标签文本
		mainPanel.add(overagejlabel);				//添加到中心面板
		overagejtextfield = new JTextField();//创建余额文本框
		overagejtextfield.setColumns(4);//设置文本框长度
		mainPanel.add(overagejtextfield);

		JLabel teljlabel = new JLabel();	//创建电话标签
		teljlabel.setText("电话：");			//设置标签文本
		mainPanel.add(teljlabel);				//添加到中心面板
		teljtextfield = new JTextField();//创建电话文本框
		teljtextfield.setColumns(11);//设置文本框长度
		mainPanel.add(teljtextfield);


		JLabel caridjlabel = new JLabel();	//创建车牌号标签
		caridjlabel.setText("车牌号：");			//设置标签文本
		mainPanel.add(caridjlabel);				//添加到中心面板
		caridjtextfield = new JTextField();//创建电话文本框
		caridjtextfield.setColumns(11);//设置文本框长度
		mainPanel.add(caridjtextfield);

		mainPanel.add(new JLabel());//为了显示的美观而添加的标签
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());

		savejbutton = new JButton();//创建保存按钮
		savejbutton.addActionListener(new zhuceActionListener());//注册监听器
		savejbutton.setText("注册");//设置按钮文本
		mainPanel.add(savejbutton);//添加到中心面板

		JButton backjbutton = new JButton();//创建返回按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("返回");//设置按钮文本
		mainPanel.add(backjbutton);//添加到中心面板

		setVisible(true);											// 显示窗体可见

	}
	class CloseActionListener implements ActionListener {			// 添加返回按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class zhuceActionListener implements ActionListener {			// 添加保存按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			int a1 = Integer.parseInt(cardidjtextfield.getText());
			String a2 = namejtextfield.getText();
			String a3 = passwordjtextfield.getText();
			String a4 = (String)cardtypejcombobox.getSelectedItem();
			int a5 = Integer.parseInt(overagejtextfield.getText());
			int a6 = Integer.parseInt(teljtextfield.getText());
			int a7 = Integer.parseInt(caridjtextfield.getText());
			int i=Dal.comzhuce(a1,a2,a3,a4,a5,a6,a7);
			if(i==1){
				JOptionPane.showMessageDialog(null, "注册成功！");
			}
		}		
	}
}

