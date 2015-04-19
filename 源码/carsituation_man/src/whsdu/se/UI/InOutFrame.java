/*
 * 该ui类用于显示信息查询菜单下的出入厂信息菜单项
 * */

package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import whsdu.se.DAO.*;
public class InOutFrame extends JInternalFrame {
	private  JLabel bigsumjtextfield;
	private  JLabel smallsumjtextfield;
	private  JLabel bigusejtextfield;
	private  JLabel smallusejtextfield;

	//构造方法
	public InOutFrame() {
		super("出入场信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小

		JPanel mainPanel = new JPanel();			//创建中心面板
		GridLayout gridLayout = new GridLayout(4,2);//创建表格布局管理器
		gridLayout.setVgap(20);					//设置组件之间垂直距离
		gridLayout.setHgap(10);					//设置组件之间平行距离
		mainPanel.setLayout(gridLayout);		//设置布局

		mainPanel.setBorder(new EmptyBorder(30, 10, 50, 10));		//设置边框为0
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		setBounds(146,81,390,303);		

		JLabel bigsumjlabel = new JLabel();	//创建卡号标签
		bigsumjlabel.setText("大型车位数总量：");			//设置标签文本
		mainPanel.add(bigsumjlabel);				//添加到中心面板
		bigsumjtextfield = new JLabel();//创建卡号文本框
		//bigsumjtextfield.setColumns(12);//设置文本框长度
		mainPanel.add(bigsumjtextfield);

		JLabel smallsumjlabel = new JLabel();	//创建卡号标签
		smallsumjlabel.setText("小型车位数总量：");			//设置标签文本
		mainPanel.add(smallsumjlabel);				//添加到中心面板
		smallsumjtextfield = new JLabel();//创建卡号文本框
		//smallsumjtextfield.setColumns(12);//设置文本框长度
		mainPanel.add( smallsumjtextfield);

		JLabel bigusejlabel = new JLabel();	//创建卡号标签
		bigusejlabel.setText("可用大型车位数量：");			//设置标签文本
		mainPanel.add(bigusejlabel);				//添加到中心面板
		bigusejtextfield = new JLabel();//创建卡号文本框
		//bigusejtextfield.setColumns(12);//设置文本框长度
		mainPanel.add(bigusejtextfield);

		JLabel smallusejlabel = new JLabel();	//创建卡号标签
		smallusejlabel.setText("可用小型车位数量：");			//设置标签文本
		mainPanel.add(smallusejlabel);				//添加到中心面板
		smallusejtextfield = new JLabel();//创建卡号文本框
		//smallusejtextfield.setColumns(12);//设置文本框长度
		mainPanel.add(smallusejtextfield);

		setVisible(true);											// 显示窗体可见

		int b1 = Dal.count("select count(stationid) from sit_infor where stationtype = '大型车位'");

		String a1 = String.valueOf(b1);
		bigsumjtextfield.setText(a1);

		int b2 = Dal.count("select count(stationid) from sit_infor where stationtype = '小型车位'");
		String a2 = String.valueOf(b2);
		smallsumjtextfield.setText(a2);

		int b3 = Dal.count("select count(distinct stationid) from park where stationtype = '大型车位' and startpark  is not null and endpark is null ");

		int b4 = b1 - b3;
		String a3 = String.valueOf(b4);
		bigusejtextfield.setText(a3);

		int b5 = Dal.count("select count(distinct stationid) from park where stationtype = '小型车位'and startpark is not null and endpark is null ");
		int b6 = b2 - b5;
		String a4 = String.valueOf(b6);
		smallusejtextfield.setText(a4);
	}
}