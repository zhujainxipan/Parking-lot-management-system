/*
 * 该ui类用于实现车辆管理菜单下的车辆出场菜单项
 * */
package whsdu.se.UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import whsdu.se.DAO.*;

public class ParkOutFrame extends JInternalFrame {
	private JTextField cardidjtextfield;//创建卡号文本框
	private JTextField stationidtextfield;//创建姓名文本框
	private JLabel sumparkjtextfield ;//创建卡号文本框
	private JLabel feejtextfield ;//创建卡号文本框
	private users user;
	private sit_infor sit;
	private charger charger;
	private park park;
	private int day;
	private int hour;
	private int min;

	//构造方法
	public ParkOutFrame() {
		super("车辆出场");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		JPanel mainPanel = new JPanel();			//创建中心面板
		GridLayout gridLayout = new GridLayout(4,1);//创建表格布局管理器
		gridLayout.setVgap(20);					//设置组件之间垂直距离
		gridLayout.setHgap(10);					//设置组件之间平行距离
		mainPanel.setLayout(gridLayout);		//设置布局
		mainPanel.setBorder(new EmptyBorder(30, 10, 20, 10));		//设置边框
		getContentPane().add(mainPanel);		//将中心面板加入到窗体
		setBounds(186,40,329,360);		
		JPanel Panel1 = new JPanel();			
		GridLayout gridLayout1 = new GridLayout(2,2);
		Panel1.setLayout(gridLayout1);
		mainPanel.add(Panel1);
		JPanel Panel3 = new JPanel();			
		Panel3.setLayout(new FlowLayout());		
		Panel3.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel3);	
		JButton xiaofeijbutton = new JButton();
		xiaofeijbutton.addActionListener(new xiaofeiActionListener());
		xiaofeijbutton.setText("刷卡消费");
		Panel3.add(xiaofeijbutton);
		JPanel Panel2 = new JPanel();			
		GridLayout gridLayout2 = new GridLayout(2,2);
		Panel2.setLayout(gridLayout2);
		mainPanel.add(Panel2);
		JPanel Panel4 = new JPanel();			
		Panel4.setLayout(new FlowLayout());		
		Panel4.setBorder(new EmptyBorder(10, 10, 20, 10));		
		mainPanel.add(Panel4);	
		JButton enjbutton = new JButton();
		enjbutton.addActionListener(new enActionListener());//注册监听器
		enjbutton.setText("确认出场");//设置按钮文本
		Panel4.add(new JLabel());
		Panel4.add(enjbutton);
		Panel4.add(new JLabel());
		JLabel cardidjlabel = new JLabel();	//创建卡号标签
		cardidjlabel.setText("卡号：");			//设置标签文本
		Panel1.add(cardidjlabel);				
		cardidjtextfield = new JTextField();//创建卡号文本框
		cardidjtextfield.setColumns(12);//设置文本框长度
		Panel1.add(cardidjtextfield);
		JLabel stationidjlabel = new JLabel();
		stationidjlabel.setText("车位号：");			
		Panel1.add(stationidjlabel);				
		stationidtextfield = new JTextField();
		stationidtextfield.setColumns(6);
		Panel1.add(stationidtextfield);
		JLabel sumparkjlabel = new JLabel();	
		sumparkjlabel.setText("停车时间（h）：");			
		Panel2.add(sumparkjlabel);			
		sumparkjtextfield = new JLabel();
		//sumparkjtextfield.setColumns(12);
		sumparkjtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(sumparkjtextfield);
		JLabel feejlabel = new JLabel();	
		feejlabel.setText("应收费用（元）：");			
		Panel2.add(feejlabel);				
		feejtextfield = new JLabel();
		feejtextfield.setBorder(BorderFactory.createLineBorder(java.awt.Color.gray)); 
		Panel2.add(feejtextfield);
		setVisible(true);											
	}

	class enActionListener implements ActionListener {			// 添加确认出场的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}

	class xiaofeiActionListener implements ActionListener {			// 添加刷卡消费的事件监听器
		public void actionPerformed(final ActionEvent e) {
			//第一步：得到单价 = a6
			int  a1 = Integer.parseInt(cardidjtextfield.getText());
			int a2 = Integer.parseInt(stationidtextfield.getText());
			SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String a3 = myfmt.format(new java.util.Date()).toString();

			user = Dal.searchcominfo("select * from users where cardid =" + a1);
			String a4 = user.getCardtype();

			sit = Dal.chewei("select * from  sit_infor   where stationid ="+ a2 ) ;
			String a5 = sit.getStationtype();

			charger = Dal.searchcharge("select * from charger where cardtype = '"+a4 +"'and stationtype = '"+a5+"'");
			int a6 = charger.getCharge();
			//第二步：得到startpark
			park = Dal.parkout("select * from park where cardid = "+a1 +"and stationid ="+ a2 +"and endpark is null");
			String a7 = park.getStartpark();

			//计算sumpark = a8
			int a8,a9;
			try {
				java.util.Date now = myfmt.parse(a3);
				java.util.Date date=myfmt.parse(a7);
				int l=(int) (now.getTime()-date.getTime());
				day=l/(24*60*60*1000);
				hour=(l/(60*60*1000)-day*24);
				min=((l/(60*1000))-day*24*60-hour*60);
			}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null,"消费计算错误");
			}
			System.out.print(min);
			if(min < 30)
				a8 = day*24+hour;
			else
				a8 = day*24+hour+1;
			//计算费用fee = a9
			a9 = a8*a6;
			//更新出场信息 endpark(a3)  fee(a9)  sumpark(a8)
			Dal.Updatepark(a3,a9,a8,a1,a7);
			//更新用户信息的余额1\先得到余额2、更该余额
			int a10 = user.getOverage();
			int a11 = a10 - a9;
			if(a11 <0)
				JOptionPane.showMessageDialog(null,"余额不足，请先充值！");
			else{
				Dal.Updateoverage(a1,a11);
				sumparkjtextfield.setText(String.valueOf(a8));
				feejtextfield.setText(String.valueOf(a9));
				JOptionPane.showMessageDialog(null,"消费成功，欢迎你下次再来");
			}
		}
	}	
}