/*
 * 该ui类用于是显示信息查询菜单下的当前可用车位信息菜单项
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
import java.util.List;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import whsdu.se.DAL.Dal;
import whsdu.se.DAO.park;
import whsdu.se.DAO.sit_infor;
import whsdu.se.DAO.users;
import whsdu.se.UI.ComUsersInfoFrame.queryActionListener;

public class nowstationFrame extends JInternalFrame {
	private  sit_infor sit;;

	private Object[][] getselect(List list) {
		Object[][] s = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			sit = (sit_infor) list.get(i);
			s[i][0] = sit.getStationid();
			s[i][1] = sit.getStationtype();
		}
		return s;
	}

	//构造方法
	public  nowstationFrame() {
		super("当前可用车位信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(122,10,489,505));
		setBackground(java.awt.Color.gray);
		JPanel mainPanel = new JPanel();			//创建中心面板
		mainPanel.setLayout(new BorderLayout());		//设置布局
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		mainPanel.setBorder(new EmptyBorder(1, 1, 10, 10));
		JPanel panel2 = new JPanel();
		mainPanel.add(panel2,BorderLayout.CENTER);		
		String [] nowin = { "车位号","车位类型"}; 
		Object[][] results=getselect(Dal.nowstation());
		JTable table = new JTable(results,nowin);
		JScrollPane scroll = new JScrollPane(table);
		panel2.add(scroll);
		setVisible(true);
	}
}

















