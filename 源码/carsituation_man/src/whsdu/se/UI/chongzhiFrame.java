/*
 * 
 * 该ui类用于显示信息维护菜单里的充值菜单项
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

public class chongzhiFrame extends JInternalFrame {

	private JTextField cardidjtextfield;
	private JLabel namejtextfield;
	private JTextField passwordjtextfield;
	private JButton savejbutton;
	private int a4;
	private int a1;
	private users user;
	private JButton yuejbutton;
	//构造方法
	public chongzhiFrame() {
		super("用户充值");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(178,44,365,376));

		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());	//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));//设置中心面板的大小和位置

		JPanel Panel1 = new JPanel();			//创建面板1
		Panel1.setLayout(new GridLayout(3,2));	//设置布局
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));	//设置边框
		mainPanel.add(Panel1,BorderLayout.CENTER);	//将面板1加入到中心面板中

		JLabel cardidjlabel = new JLabel();	//创建卡号标签
		cardidjlabel.setText("卡号：");			//设置标签文本
		Panel1.add(cardidjlabel);				//添加到面板1
		cardidjtextfield = new JTextField();//创建卡号文本框
		cardidjtextfield.setColumns(6);//设置文本框长度
		Panel1.add(cardidjtextfield);//添加到面板1

		JLabel namejlabel = new JLabel();	//创建余额标签
		namejlabel.setText("余额：");			//设置标签文本
		Panel1.add(namejlabel);				//添加到面板1
		namejtextfield = new JLabel();//创建相应的标签
		namejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); //显示相应标签的边框
		Panel1.add(namejtextfield);//添加到面板1

		JLabel passwordjlabel = new JLabel();	//创建充值标签
		passwordjlabel.setText("充值：");			//设置标签文本
		Panel1.add(passwordjlabel);				//添加到面板1
		passwordjtextfield = new JTextField();//创建密码文本框
		passwordjtextfield.setColumns(10);//设置文本框长度
		Panel1.add(passwordjtextfield);//添加到面板1

		JPanel Panel2 = new JPanel();			//创建面板2
		Panel2.setLayout(new FlowLayout());		//设置布局
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));	//设置边框
		mainPanel.add(Panel2,BorderLayout.SOUTH);		//将面板2加入到窗体的南面

		yuejbutton = new JButton();//创建余额按钮
		yuejbutton.addActionListener(new yueActionListener());//注册监听器
		yuejbutton.setText("余额");//设置按钮文本
		Panel2.add(yuejbutton);//添加到面板2

		savejbutton = new JButton();//创建保存按钮
		savejbutton.addActionListener(new addmanActionListener());//注册监听器
		savejbutton.setText("充值");//设置按钮文本
		Panel2.add(savejbutton);//添加到面板2

		JButton backjbutton = new JButton();//创建返回按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("返回");//设置按钮文本
		Panel2.add(backjbutton);//添加面板2

		setVisible(true);											// 显示窗体可见
	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class addmanActionListener implements ActionListener {			// 添加充值按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			int a2 = Integer.parseInt(passwordjtextfield.getText());
			int a3 = a4 +a2;
			Dal.chongzhi("update users set overage ="+ a3+" where cardid = " + a1 );
			JOptionPane.showMessageDialog(null, "充值成功！");
		}
	}

	class yueActionListener implements ActionListener {			// 添加余额按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			if(cardidjtextfield.getText().equals(""))
				namejtextfield.setText("");
			else {
				a1 = Integer.parseInt(cardidjtextfield.getText());
				user = Dal.searchcominfo("select * from users where cardid = "+a1 );
				a4 = user.getOverage();
				namejtextfield.setText(String.valueOf(a4));
			}
		}
	}
}