/*
 * 该ui类是主窗口
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import whsdu.se.Common.*;
import whsdu.se.UI.*;
import whsdu.se.DAO.*;

public class MdiFrame extends JFrame implements ActionListener {
	//关键！MDIDesktopPane(该类实际继承了 JDesktopPane) 用来容纳子窗体
	//即使子窗体最大化也仅仅限制在该容器的范围之内
	private MDIDesktopPane desktop = new MDIDesktopPane();
	//菜单条
	private JMenuBar menuBar = new JMenuBar();
	//菜单
	private JMenu mnuPark = new JMenu("车场管理");
	private JMenu mnuQuery = new JMenu("信息查询");
	private JMenu mnuSever = new JMenu("信息维护");
	private JMenu mnuManSes = new JMenu("系统管理");
	//菜单项
	private JMenuItem munParkIn = new JMenuItem("车辆入场");
	private JMenuItem mnuParkOut = new JMenuItem("车辆出场");
	private JMenuItem munCharge = new JMenuItem("计费标准");
	private JMenuItem mnuNowInfo = new JMenuItem("当前在场信息");
	private JMenuItem mnuHistory = new JMenuItem("用户历史信息");
	private JMenuItem mnuComUsersInfo = new JMenuItem("用户个人信息");
	private JMenuItem mnuInOut = new JMenuItem("出入场信息");
	private JMenuItem mnuComZhuCe = new JMenuItem("用户注册");
	private JMenuItem mnuComIdentity = new JMenuItem("用户修改");
	private JMenuItem mnuManZhuCe = new JMenuItem("管理员注册");
	private JMenuItem mnuManIdentity = new JMenuItem("口令修改");
	private JMenuItem mnuManCharge = new JMenuItem("计费标准管理");
	private JMenuItem mnumancharge = new JMenuItem("用户充值");
	private JMenuItem mnunowstation = new JMenuItem("当前可用车位信息");
	private JMenuItem mnuabout = new JMenuItem("关于");
	private JMenuItem mnuduichu = new JMenuItem("退出");
	private JScrollPane scrollPane = new JScrollPane();
	private users user = LoginFrame.getUser(); 
	
	//主窗体构造方法
	public MdiFrame() {
		desktop.setOpaque(false);  //JPanel 透明模式
		ImageIcon img = new ImageIcon("E:/java练习/carsituation_man/res/main.jpg");  //创建一个图片路径
		JLabel background = new JLabel(img);  //创建个带背景图片的JLabel
		background.setIcon(img);
		this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		desktop.add(background);
		setMenu();
		setTitle("停车场管理系统");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(280,119,800, 600);
		this.setVisible(true);
	}

	/**
	 * 为窗体添加菜单并注册监听器
	 * 只写了部分菜单
	 */
	private void setMenu(){
		//车场管理菜单
		mnuPark.add(munParkIn);
		munParkIn.addActionListener(this);
		mnuPark.add(mnuParkOut);
		mnuParkOut.addActionListener(this);
		//信息查询菜单
		mnuQuery.add(munCharge);
		munCharge.addActionListener(this);
		mnuQuery.add(mnuNowInfo);
		mnuNowInfo.addActionListener(this);
		mnuQuery.add(mnuHistory);
		mnuHistory.addActionListener(this);
		mnuQuery.add(mnuComUsersInfo);
		mnuComUsersInfo.addActionListener(this);
		mnuQuery.add(mnuInOut);
		mnuInOut.addActionListener(this);
		mnuQuery.add(mnunowstation);
		mnunowstation.addActionListener(this);
		//信息维护菜单
		mnuSever.add(mnuComZhuCe);
		mnuComZhuCe.addActionListener(this);
		mnuSever.add(mnuComIdentity);
		mnuComIdentity.addActionListener(this);
		mnuSever.add(mnumancharge);
		mnumancharge.addActionListener(this);
		//系统管理菜单
		mnuManSes.add(mnuManZhuCe);
		mnuManZhuCe.addActionListener(this);
		mnuManSes.add(mnuManIdentity);
		mnuManIdentity.addActionListener(this);
		mnuManSes.add(mnuManCharge);
		mnuManCharge.addActionListener(this);
		mnuManSes.add(mnuabout);
		mnuabout.addActionListener(this);
		mnuManSes.add(mnuduichu);
		mnuduichu.addActionListener(this);
		
		//添加到菜单栏
		menuBar.add(mnuPark);
		menuBar.add(mnuQuery);
		menuBar.add(mnuSever);
		menuBar.add(mnuManSes);
		//菜单栏添加到主窗体
		setJMenuBar(menuBar);
	}

	//如果是普通用户，将不允许使用的菜单项禁止使用
	public void disMenu() {
		//将车场管理、信息维护、系统管理对普通用户都不可用
		mnuPark.setEnabled(false);
		mnuSever.setEnabled(false);
		mnuManZhuCe.setEnabled(false);
		mnuManCharge.setEnabled(false);
	}

	//点击菜单项出现相应的子窗体
	public void actionPerformed(ActionEvent ae) {

		//如果允许同时打开多个子窗口，可以用该方法获得所有子窗口对象数组
		JInternalFrame[] jiFrame = desktop.getAllFrames();  

		//如果只允许同时打开一个，可以用该方法移除现有窗口
		//desktop.removeAll();  

		//获得点击的菜单名称
		String mnuName = ae.getActionCommand();

		//根据菜单名称决定显示的子窗口，可以按下面的格式为每一个子菜单指定显示的子窗口
		if(mnuName.equals("车辆入场")) {
			//MdiFrame.addIFrame(new ParkInFrame(),BorderLayout.CENTER);
			desktop.add(new ParkInFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("车辆出场")) {
			desktop.add(new ParkOutFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("计费标准")) {
			desktop.add(new ChargeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("当前在场信息")) {
			desktop.add(new NowInfoFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("用户个人信息")) {
			if(user.getUserstype().equals("管理员"))
			desktop.add(new ComUsersInfoFrame(),BorderLayout.CENTER);
			else
				desktop.add(new ComUsersInfoFrame1(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("用户历史信息")) {
			desktop.add(new HistoryFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("出入场信息")) {
			desktop.add(new InOutFrame(),BorderLayout.CENTER);
		}
		//		
		else if(mnuName.equals("用户注册")) {
			desktop.add(new ComZhuCeFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("用户修改")) {
			desktop.add(new ComIdentityFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("用户充值")) {
			desktop.add(new chongzhiFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("管理员注册")) {
			desktop.add(new ManZhuCeFrame(),BorderLayout.CENTER);
		}

		else if(mnuName.equals("口令修改")) {
			desktop.add(new GengGaiMiMa(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("当前可用车位信息")) {
			desktop.add(new nowstationFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("关于")) {
			desktop.add(new aboutFrame(),BorderLayout.CENTER);
		}
		else if(mnuName.equals("退出")) {
			System.exit(0);
		}
		else 
			desktop.add(new ManChargeFrame(),BorderLayout.CENTER);
	}		
	
}
