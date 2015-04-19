/*
 * 该ui类用于实现系统维护中的用户标准修改项
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

public class ManChargeFrame extends JInternalFrame {
	private JTextField bigjtextfield1;
	private JTextField smalljtextfield1;
	private JTextField bigjtextfield2;
	private JTextField smalljtextfield2;

	//构造方法
	public  ManChargeFrame() {
		super("计费标准管理");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(167,30,383,450));

		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));

		JPanel Panel1 = new JPanel();			//创建面板1
		Panel1.setLayout(new GridLayout(6,2));		//设置布局
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//设置边框
		mainPanel.add(Panel1,BorderLayout.CENTER);	

		Panel1.add(new JLabel("优惠卡："));				//添加到面板1
		Panel1.add(new JLabel());//添加面板1

		JLabel bigjlabel1 = new JLabel();	
		bigjlabel1.setText("大型车位（元/h）：");		
		Panel1.add(bigjlabel1);				
		bigjtextfield1 = new JTextField();
		bigjtextfield1.setColumns(6);
		Panel1.add(bigjtextfield1);

		JLabel smalljlabel1 = new JLabel();	
		smalljlabel1.setText("小型车位（元/h）：");		
		Panel1.add(smalljlabel1);			
		smalljtextfield1 = new JTextField();
		smalljtextfield1.setColumns(6);
		Panel1.add(smalljtextfield1);


		Panel1.add(new JLabel("普通卡："));				
		Panel1.add(new JLabel());


		JLabel bigjlabel2 = new JLabel();	
		bigjlabel2.setText("大型车位（元/h）：");			
		Panel1.add(bigjlabel2);		
		bigjtextfield2 = new JTextField();
		bigjtextfield2.setColumns(6);
		Panel1.add(bigjtextfield2);

		JLabel smalljlabel2 = new JLabel();	
		smalljlabel2.setText("小型车位（元/h）：");		
		Panel1.add(smalljlabel2);				
		smalljtextfield2 = new JTextField();
		smalljtextfield2.setColumns(6);
		Panel1.add(smalljtextfield2);

		JPanel Panel2 = new JPanel();			
		Panel2.setLayout(new FlowLayout());		
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel2,BorderLayout.SOUTH);		

		JButton savejbutton = new JButton();//创建保存按钮
		savejbutton.addActionListener(new gaiActionListener());//注册监听器
		savejbutton.setText("修改");//设置按钮文本
		Panel2.add(savejbutton);

		JButton backjbutton = new JButton();//创建返回按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("返回");//设置按钮文本
		Panel2.add(backjbutton);

		setVisible(true);											// 显示窗体可见

	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class  gaiActionListener implements ActionListener {			// 添加修改按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {


			int a1 = Integer.parseInt( bigjtextfield1.getText());
			int a2 = Integer.parseInt(smalljtextfield1.getText());
			int a3 = Integer.parseInt(bigjtextfield2.getText());
			int a4 = Integer.parseInt(smalljtextfield2.getText());

			Dal.gaicharge("update charger set charge ="+ a1+" where cardtype = '优惠卡'and stationtype = '大型车位'");
			Dal.gaicharge("update charger set charge ="+ a2+" where cardtype = '优惠卡'and stationtype = '小型车位'");
			Dal.gaicharge("update charger set charge ="+ a3+" where cardtype = '普通卡'and stationtype = '大型车位'");
			Dal.gaicharge("update charger set charge ="+ a4+" where cardtype = '普通卡'and stationtype = '小型车位'");

			JOptionPane.showMessageDialog(null, "修改成功！");
		}

	}
}


