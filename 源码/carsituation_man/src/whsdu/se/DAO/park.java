/**
 * 作者：红涛
 * 日期：2012.6.27
 * 功能：park模型类，定义了用户属性及相应get、set方法
 * 修改：如果进行了修改，这里填写修改信息
 */


package whsdu.se.DAO;

public class park {
	private int parkid;
	private String startpark;
	private String endpark;
	private int sumpark;
	private int fee;
	private int cardid;
	private int stationid;
	private String stationtype;
	public int getparkid() {
		return parkid;
	}
	public void setOutid(int parkid) {
		this.parkid = parkid;
	}
	public int getSumpark() {
		return sumpark;
	}
	public void setSumpark(int sumpark) {
		this.sumpark = sumpark;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public String getStartpark() {
		return startpark;
	}
	public void setStartpark(String startpark) {
		this.startpark = startpark;
	}
	public String getEndpark() {
		return endpark;
	}
	public void setEndpark(String endpark) {
		this.endpark = endpark;
	}
	public String getStationtype() {
		return stationtype;
	}
	public void setStationtype(String stationtype) {
		this.stationtype = stationtype;
	}
	

}
