
package whsdu.se.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;







import whsdu.se.DAO.*;


public class Dal {
	protected static String dbClassName = 
		"com.microsoft.sqlserver.jdbc.SQLServerDriver";//数据库连接驱动类
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;"
		+ "DatabaseName=cardmange;";//数据库连接URL
	protected static String dbUser = "sa";				//数据库用户名
	protected static String dbPwd = "123456";			//数据库密码
	private static Connection conn = null;				//数据库连接对象
	private Dal() {										//默认构造函数
		try {
			if (conn == null) {							//如果连接对象为空
				Class.forName(dbClassName);				//加载驱动类
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);//获得连接对象
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}




	private static ResultSet executeQuery(String sql) {	//查询方法
		try {
			if(conn==null)  new Dal();  //如果连接对象为空，则重新调用构造方法
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//执行查询
		} catch (SQLException e) {
			e.printStackTrace();
			return null;				//返回null值
		} finally {
		}
	}




	private static int executeUpdate(String sql) {		//更新方法
		try {
			if(conn==null)  new Dal();	//如果连接对象为空，则重新调用构造方法
			return conn.createStatement().executeUpdate(sql);//执行更新
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
		}
	}



	public static void close() {//关闭方法
		try {
			conn.close();//关闭连接对象		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;	//设置连接对象为null值
		}
	}




	/*
	 * 登录方法
	 */
	public static users check(String name, String password) {
		users user=new users();//操作员信息对象
		String sql = "select * from users where name= '" + name
		+ "' and password='" + password+"'";//查询字符串
		ResultSet rs = Dal.executeQuery(sql);//执行查询
		try {
			while(rs.next()) {//如果查询到了记录
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//关闭连接对象
		return user;//返回操作员信息对象
	}

	/*
	 *查询计费标准
	 * */
	public static charger  searchcharge(String sql){
		charger charger = new charger();//计费标准对象
		ResultSet rs = Dal.executeQuery(sql);//执行查询
		try {
			while(rs.next()) {//如果查询到了
				charger.setCardtype(rs.getString("cardtype"));//设置计费标准卡的类型
				charger.setCharge(rs.getInt("charge"));//设置计费标准单价
				charger.setStationtype(rs.getString("stationtype"));//设置计费标准车位类型
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//关闭连接对象
		return charger;//返回计费标准对象
	}

	/*
	 * 查询用户个人信息
	 * */
	public static users searchcominfo(String sql){
		users user = new users();//用户对象
		ResultSet rs = Dal.executeQuery(sql);
		try {
			while(rs.next()) {
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();
		return user;
	}

	/*
	 * 实现出入场查询
	 * 
	 * */
	public static int count(String sql){
		int i = 0;
		ResultSet rs = Dal.executeQuery(sql);//执行查询
		try {
			while(rs.next()) {//如果查询到了
				i = rs.getInt(1);//得到count
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//关闭连接对象
		return i ; //返回i
	}


	/*
	 * 
	 * 实现普通用户注册
	 * 
	 * */
	public static int comzhuce(int cardid,String name,String password,String cardtype,int overage,int tel,int carid){
		int i=0;
		try{
			String sql="insert users(cardid,name,password,cardtype,overage,tel,carid,userstype) values("+cardid+",'"+name+"','"+password+"','"+cardtype+"',"+overage+","+tel+","+carid+",'普通用户')";//将用户信息插入数据库中
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}


	/*
	 * 
	 * 实现管理员注册
	 * 
	 * */
	public static int manzhuce(int cardid,String name,String password){
		int i=0;
		try{
			String sql="insert users(cardid,name,password,userstype) values("+cardid+",'"+name+"','"+password+"',"+"'管理员')";//将管理员信息插入到数据库中
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	/*
	 * 收费标准修改
	 * 
	 * 
	 * */

	public static void gaicharge(String sql){
		try{
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ;
	}


	/*
	 * 充值
	 * */
	public static void chongzhi(String sql){
		try{
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ;
	}

	/*
	 * 车位查询
	 * */

	public static sit_infor chewei(String sql){
		sit_infor sit = new sit_infor();//车位信息对象
		ResultSet rs = Dal.executeQuery(sql);//执行查询
		try {
			while(rs.next()) {//如果查询到了
				sit.setStationid(rs.getInt("stationid"));
				sit.setStationtype(rs.getString("stationtype"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//关闭连接对象
		return sit;
	}

	/*
	 * 当前可用车位信息
	 * */
	public static List nowstation(){
		List list=new ArrayList();
		String sql= "select stationid,stationtype from sit_infor  where stationid not in (select distinct stationid  from park where endpark is  null)";//查询当前可用车位的信息
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				sit_infor sit = new sit_infor();//车位信息对象
				sit.setStationid(rs.getInt("stationid"));//设定车位信息的车位号
				sit.setStationtype(rs.getString("stationtype"));//设定车位信息的车位类型
				list.add(sit);//将查询得到的车位信息加入到ArrayList()中
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 车辆入场
	 * 
	 */
	public static int parkin(int cardid,int stationid,String stationtype,String startpark){
		int i=0;
		try{
			String sql="insert park(cardid,stationid,stationtype,startpark) values("+cardid+","+stationid+",'"+stationtype+"','"+startpark+"')";//将入场车辆信息插入到数据库中
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(1);
		}
		return i;
	}


	/*
	 * 更改密码
	 * */	
	public static int Updatepass(String password,String name){
		int i=0;
		try{
			String sql="update users set password='"+password+"' where  name='"+name+"'";//更新数据库中的用户密码
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
		return i;
	}


	/*
	 * 出场
	 * 
	 * */
	public static void Updatepark(String endpark,int fee,int sumpark,int cardid,String startpark){
		try{
			String sql = "update park set endpark = '"+endpark+"' ,sumpark = "+sumpark +",fee ="+ fee +"where cardid ="+ cardid+" and startpark ='" +startpark+"'";
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
	}



	//在出场时，用于更新用户的余额
	public static void Updateoverage(int cardid,int overage){
		try{
			String sql = "update users set overage = "+overage +"where cardid = "+cardid;
			Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
	}



	/*
	 * 用户出场
	 * */
	public static park parkout(String sql){
		park park = new park();
		ResultSet rs = Dal.executeQuery(sql);//执行查询
		try {
			while(rs.next()) {//如果查询到了
				park.setStartpark(rs.getString("startpark"));
				park.setCardid(rs.getInt("cardid"));
				park.setEndpark(rs.getString("endpark"));
				park.setFee(rs.getInt("fee"));
				park.setStationid(rs.getInt("stationid"));
				park.setSumpark(rs.getInt("sumpark"));
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		Dal.close();	//关闭连接对象
		return park;
	}


	/*
	 * 根据cardid查询历史记录
	 * 
	 * */
	public static List selectcardid(int cardid){
		List list=new ArrayList();
		String sql= "select * from park where cardid ="+ cardid+" and sumpark is not null";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				park park = new park();
				park.setCardid(rs.getInt("cardid"));
				park.setStationid(rs.getInt("stationid"));
				park.setStartpark(rs.getString("startpark"));
				park.setEndpark(rs.getString("endpark"));
				park.setSumpark(rs.getInt("sumpark"));
				park.setFee(rs.getInt("fee"));
				list.add(park);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return list;
	}


	/*
	 * 查询当前在场信息
	 * */
	public static List now(){
		List list=new ArrayList();
		String sql= "select * from park where endpark is  null";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				park park = new park();
				park.setCardid(rs.getInt("cardid"));
				park.setStationid(rs.getInt("stationid"));
				park.setStartpark(rs.getString("startpark"));
				list.add(park);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return list;
	}


	/*
	 * 
	 * 更改用户信息
	 * */
	public static int updateuser(int cardid,String name,String password,String cardtype,int overage,int tel,int carid){
		int i=0;
		try{
			String sql= "update users set name = '"+name+"',password = '"+password +"',cardtype = '"+cardtype +"',overage = "+overage+",tel = "+tel+",carid = "+carid+" where cardid ="+ cardid;
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}


	/*
	 * 
	 * 查询所有成员
	 * */
	public static List selectuser(){
		List list=new ArrayList();
		String sql= "select * from users where userstype = '普通用户'";
		ResultSet rs=Dal.executeQuery(sql);
		try {
			while(rs.next()){
				users user  = new users();
				user.setCardid(rs.getInt("cardid"));
				user.setName(rs.getString("name")) ;//设置操作员用户名
				user.setUserstype(rs.getString("userstype")) ;
				user.setPassword(rs.getString("password"));//设置管理员密
				user.setCardtype(rs.getString("cardtype"));
				user.setCarid(rs.getInt("carid"));
				user.setOverage(rs.getInt("overage"));
				user.setTel(rs.getInt("tel"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return list;
	}


	/*
	 * 删除用户
	 * 
	 * */

	public static int Deluser(int cardid){
		int i=0;
		try{
			String sql = "delete from users where cardid ="+ cardid;
			i=Dal.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		Dal.close();
		return i;
	}

}
