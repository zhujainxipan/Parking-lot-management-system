/*
 * 该ui类用于显示信息维护菜单下的用户修改菜单项
 * */

package whsdu.se.UI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import whsdu.se.DAL.Dal;
import whsdu.se.DAO.users;

public class ComIdentityFrame extends JInternalFrame {
	private  JTextField cardidjtextfield;
	private  JTextField namejtextfield;
	private JTextField passwordjtextfield;
	private  JComboBox cardtypejcombobox;
	private  JTextField overagejtextfield;
	private JTextField teljtextfield;
	private JButton savejbutton;
	private JTextField caridjtextfield;
	private JTable table; 
	private users user;
	private JTextField cardtypejtextfield;
	private String[] str = { "卡号", "姓名", "密码", "卡类型","车牌号 ","电话", "余额"};

	private Object[][] getFileStates(List list){
		Object[][]users=new Object[list.size()][str.length];
		for(int i=0;i<list.size();i++){
			users user=(users)list.get(i);
			users[i][0]=user.getCardid();
			users[i][1]=user.getName();
			users[i][2]=user.getPassword();
			users[i][3]=user.getCardtype();
			users[i][4]=user.getCarid();
			users[i][5]=user.getTel();
			users[i][6]=user.getOverage();
		}
		return users;        		
	}

	//构造方法
	public ComIdentityFrame() {
		super("用户修改");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(98,42,532,369));//设置窗体的大小
		getContentPane().setLayout(new BorderLayout());//设置窗体的布局
		setVisible(true);	

		JPanel panel1 = new JPanel();//创建面板1
		panel1.setPreferredSize(new Dimension(0, 150));
		getContentPane().add(panel1, BorderLayout.NORTH);//将面板1加入到窗体的南边 

		JPanel panel2 = new JPanel();//创建面板2
		GridLayout gridLayout = new GridLayout(4,4);//创建表格布局管理器
		gridLayout.setVgap(5);					//设置组件之间垂直距离
		gridLayout.setHgap(5);					//设置组件之间平行距离
		panel2.setLayout(gridLayout);		//设置布局
		getContentPane().add(panel2, BorderLayout.CENTER);		//将面板加入到窗体中心
		panel2.setBorder(new EmptyBorder(10, 30, 10, 30));//设置面板2的边框

		JLabel cardidjlabel = new JLabel();	//创建卡号标签
		cardidjlabel.setText("卡号：");			//设置标签文本
		panel2.add(cardidjlabel);				//添加到面板2
		cardidjtextfield = new JTextField();//创建卡号文本框
		cardidjtextfield.setColumns(12);//设置文本框长度
		panel2.add(cardidjtextfield);

		JLabel namejlabel = new JLabel();	//创建姓名标签
		namejlabel.setText("姓名：");			//设置标签文本
		panel2.add(namejlabel);				//添加到面板2
		namejtextfield = new JTextField();//创建姓名文本框
		cardidjtextfield.setColumns(6);//设置文本框长度
		panel2.add(namejtextfield);

		JLabel passwordjlabel = new JLabel();	//创建密码标签
		passwordjlabel.setText("密码：");			//设置标签文本
		panel2.add(passwordjlabel);				//添加到面板2
		passwordjtextfield = new JTextField();//创建密码文本框
		passwordjtextfield.setColumns(10);//设置文本框长度
		panel2.add(passwordjtextfield);

		JLabel cardtypejlabel = new JLabel();	//创建卡的类型标签
		cardtypejlabel.setText("类型：");			//设置标签文本
		panel2.add(cardtypejlabel);				//添加到面板2
		cardtypejtextfield = new JTextField();//创建密码文本框
		cardtypejtextfield.setColumns(10);//设置文本框长度
		panel2.add(cardtypejtextfield);

		JLabel overagejlabel = new JLabel();	//创建余额标签
		overagejlabel.setText("余额：");			//设置标签文本
		panel2.add(overagejlabel);				//添加面板2
		overagejtextfield = new JTextField();//创建余额文本框
		overagejtextfield.setColumns(4);//设置文本框长度
		panel2.add(overagejtextfield);

		JLabel teljlabel = new JLabel();	//创建电话标签
		teljlabel.setText("电话：");			//设置标签文本
		panel2.add(teljlabel);				//添加到面板2
		teljtextfield = new JTextField();//创建电话文本框
		teljtextfield.setColumns(11);//设置文本框长度
		panel2.add(teljtextfield);

		JLabel caridjlabel = new JLabel();	//创建车牌号标签
		caridjlabel.setText("车牌号：");			//设置标签文本
		panel2.add(caridjlabel);				//添加到面板2
		caridjtextfield = new JTextField();//创建电话文本框
		caridjtextfield.setColumns(11);//设置文本框长度
		panel2.add(caridjtextfield);

		final JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(0, 50));
		panel3.setLayout(new FlowLayout());
		getContentPane().add(panel3, BorderLayout.SOUTH);
		final JButton button1 = new JButton();
		button1.setText("修改");
		panel3.add(button1);
		button1.addActionListener(new ActionListener(){//给修改按钮添加监听器
			public void actionPerformed(ActionEvent arg0) {
				int a1 = Integer.parseInt(cardidjtextfield.getText());
				String a2 = namejtextfield.getText();
				String a3 = passwordjtextfield.getText();
				String a4 = caridjtextfield.getText();
				int a5 = Integer.parseInt(overagejtextfield.getText());
				int a6 = Integer.parseInt(teljtextfield.getText());
				int a7 = Integer.parseInt(caridjtextfield.getText());

				int i=	Dal.updateuser(a1,a2,a3,a4,a5,a6,a7);
				if(i==1){
					JOptionPane.showMessageDialog(null, "修改成功");
					Object[][] results=getFileStates(Dal.selectuser());
					DefaultTableModel model=new DefaultTableModel();					
					table.setModel(model);
					model.setDataVector(results, str);
				}
			}	
		});
		JButton button2 = new JButton();
		button2.setText("删除");
		panel3.add(button2);
		button2.addActionListener(new ActionListener(){//给删除按钮添加监听器
			public void actionPerformed(final ActionEvent e) {
				int a8 =Integer.parseInt(cardidjtextfield.getText());
				int i=Dal.Deluser(a8);
				if(i==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					Object[][] results=getFileStates(Dal.selectuser());
					DefaultTableModel model=new DefaultTableModel();					
					table.setModel(model);
					model.setDataVector(results, str);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 120));
		panel1.add(scrollPane);
		Object[][] results=getFileStates(Dal.selectuser());
		table = new JTable(results,str);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.addMouseListener(new MouseAdapter() {//给鼠标事件添加监听器
			public void mouseClicked(final MouseEvent e) {
				String cardid,name,password,cardtype,carid,tel,overage;
				int selRow = table.getSelectedRow();
				cardid = table.getValueAt(selRow, 0).toString().trim();
				name = table.getValueAt(selRow, 1).toString().trim();
				password = table.getValueAt(selRow,2).toString().trim();
				cardtype = table.getValueAt(selRow,3).toString().trim();
				carid = table.getValueAt(selRow,4).toString().trim();
				tel = table.getValueAt(selRow,5).toString().trim();
				overage = table.getValueAt(selRow,6).toString().trim();
				cardidjtextfield.setText(cardid);
				namejtextfield.setText(name);
				passwordjtextfield.setText(password);
				cardtypejtextfield.setText(cardtype);
				overagejtextfield.setText(overage);
				teljtextfield.setText( tel);
				caridjtextfield.setText( carid);
			}
		});
		scrollPane.setViewportView(table);
	}
}
