/*
 * 
 * 这个ui类，用于显示关于菜单项中的信息
 * */

package whsdu.se.UI;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class aboutFrame extends JInternalFrame {

	private  JLabel label;
	public  aboutFrame() {
		super("关于");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(206,76,331,300));
		JPanel Panel1 = new JPanel();	//创建中心面板
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//设置边框
		getContentPane().add(Panel1);
		label = new JLabel();
		Panel1.add(label);
		label.setText("<html>不应该放弃<br />  直到失去的那一刻 <br /> 我们见过多少~<br />  在奋斗中无奈放弃的人<br />  无责任随意来去的人 <br />   我们要坚持下去<br />  因为有这样的~义务~ <br /> 记得生命中的每一刻都是礼物<br /> 让我们一起共同刻划人生的烙印！</html>");//输入显示的汉字
		setVisible(true);		
	}
}
