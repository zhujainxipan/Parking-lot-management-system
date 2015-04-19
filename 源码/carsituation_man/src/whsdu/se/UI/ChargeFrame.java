/*
 * 该ui类用于显示查询菜单里的计费标准菜单项
 * 
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
import java.util.ArrayList;
import java.util.List;


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

import whsdu.se.DAO.*;
import whsdu.se.DAL.*;

public class ChargeFrame extends JInternalFrame {


	private  JLabel cardidjlabel;
	private  JTextField cardidjtextfield;
	private  JLabel namejlabel;
	private  JTextField namejtextfield;
	private  JLabel passwordjlabel;
	private  JTextField passwordjtextfield;
	private  JLabel cardtypejlabel;
	private  JComboBox cardtypejcombobox;
	private  JLabel overagejlabel;
	private  JTextField overagejtextfield;
	private  JLabel teljlabel;
	private  JTextField teljtextfield;


	private  JLabel zhanwei;
	private static charger charger;

	private static JLabel bigjtextfield1;
	private static JLabel bigjtextfield2;
	private static JLabel smalljtextfield1;
	private static JLabel smalljtextfield2;


	//构造方法
	public  ChargeFrame() {
		super("计费标准");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(206,76,331,300));

		JPanel Panel1 = new JPanel();//创建中心面板
		Panel1.setLayout(new GridLayout(6,2));//设置布局
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));//设置边框
		getContentPane().add(Panel1);

		Panel1.add(new JLabel("优惠卡："));//添加到中心面板
		Panel1.add(new JLabel());//添加到中心面板

		JLabel bigjlabel1 = new JLabel();//创建大型车位（元/h）标签
		bigjlabel1.setText("大型车位（元/h）：");//设置标签文本
		Panel1.add(bigjlabel1);	//添加到中心面板
		bigjtextfield1 = new JLabel();//创建标签
		Panel1.add(bigjtextfield1);//添加到中心面板

		JLabel smalljlabel1 = new JLabel();//创建小型车位（元/h）标签
		smalljlabel1.setText("小型车位（元/h）：");//设置标签文本
		Panel1.add(smalljlabel1);//添加到中心面板
		smalljtextfield1 = new JLabel();//创建标签
		Panel1.add(smalljtextfield1);//添加到中心面板

		Panel1.add(new JLabel("普通卡："));//添加到中心面板
		Panel1.add(new JLabel());//添加到中心面板

		JLabel bigjlabel2 = new JLabel();
		bigjlabel2.setText("大型车位（元/h）：");			
		Panel1.add(bigjlabel2);				
		bigjtextfield2 = new JLabel();
		Panel1.add(bigjtextfield2);

		JLabel smalljlabel2 = new JLabel();
		smalljlabel2.setText("小型车位（元/h）：");	
		Panel1.add(smalljlabel2);			
		smalljtextfield2 = new JLabel();
		Panel1.add(smalljtextfield2);

		//查询优惠卡、大型车位的单价，并显示在相应的标签上
		charger = Dal.searchcharge("select * from charger where cardtype = '优惠卡'and stationtype = '大型车位'");
		String a1 = String.valueOf(charger.getCharge());
		bigjtextfield1.setText(a1);
		//查询优惠卡、小型车位的单价，并显示在相应的标签上
		charger = Dal.searchcharge("select * from charger where cardtype = '优惠卡'and stationtype = '小型车位'");	
		String a2 = String.valueOf(charger.getCharge());
		smalljtextfield1.setText(a2);
		//查询普通卡、大型车位的单价，并显示在相应的标签上
		charger = Dal.searchcharge("select * from charger where cardtype = '普通卡'and stationtype = '大型车位'");	
		String a3 = String.valueOf(charger.getCharge());
		bigjtextfield2.setText(a3);
		//查询普通卡、小型车位的单价，并显示在相应的标签上
		charger = Dal.searchcharge("select * from charger where cardtype = '普通卡'and stationtype = '小型车位'");
		String a4 = String.valueOf(charger.getCharge());
		smalljtextfield2.setText(a4);

		setVisible(true);// 显示窗体可见	
	}		
}
