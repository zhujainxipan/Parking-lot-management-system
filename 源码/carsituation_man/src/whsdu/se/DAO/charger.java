/**
 * 作者：红涛
 * 日期：2012.6.27
 * 功能：charger模型类，定义了用户属性及相应get、set方法
 * 修改：如果进行了修改，这里填写修改信息
 */


package whsdu.se.DAO;

public class charger {
	private String cardtype;
	private String stationtype;
	private int charge;
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getStationtype() {
		return stationtype;
	}
	public void setStationtype(String stationtype) {
		this.stationtype = stationtype;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	

}
