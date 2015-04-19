/*
 * 该ui类用于实现系统管理下的管理员注册菜单项
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

public class ManZhuCeFrame extends JInternalFrame {
	private JTextField cardidjtextfield;
	private JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private JButton savejbutton;

	//构造方法
	public ManZhuCeFrame() {
		super("管理员注册");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(178,44,365,376));

		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(30, 10, 30, 10));

		JPanel Panel1 = new JPanel();			
		Panel1.setLayout(new GridLayout(3,2));		
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel1,BorderLayout.CENTER);		

		JLabel cardidjlabel = new JLabel();	
		cardidjlabel.setText("卡号：");			
		Panel1.add(cardidjlabel);			
		cardidjtextfield = new JTextField();
		cardidjtextfield.setColumns(6);
		Panel1.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	
		namejlabel.setText("姓名：");			
		Panel1.add(namejlabel);				
		namejtextfield = new JTextField();
		namejtextfield.setColumns(6);
		Panel1.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();
		passwordjlabel.setText("密码：");
		Panel1.add(passwordjlabel);				
		passwordjtextfield = new JTextField();
		
		passwordjtextfield.setColumns(10);
		Panel1.add(passwordjtextfield);

		JPanel Panel2 = new JPanel();			
		Panel2.setLayout(new FlowLayout());		
		Panel2.setBorder(new EmptyBorder(30, 10, 50, 10));		
		mainPanel.add(Panel2,BorderLayout.SOUTH);		

		savejbutton = new JButton();//创建保存按钮
		savejbutton.addActionListener(new addmanActionListener());//注册监听器
		savejbutton.setText("注册");//设置按钮文本
		Panel2.add(savejbutton);

		JButton backjbutton = new JButton();//创建返回按钮
		backjbutton.addActionListener(new CloseActionListener());//注册监听器
		backjbutton.setText("返回");//设置按钮文本
		Panel2.add(backjbutton);

		setVisible(true);											// 显示窗体可见

	}
	class CloseActionListener implements ActionListener {		// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class addmanActionListener implements ActionListener {		// 添加注册按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			int a1 = Integer.parseInt(cardidjtextfield.getText());
			String a2 = namejtextfield.getText();
			String a3 = passwordjtextfield.getText();
			int i=Dal.manzhuce(a1,a2,a3);
			if(i==1){
				JOptionPane.showMessageDialog(null, "注册成功！");
			}
		}
	}
}