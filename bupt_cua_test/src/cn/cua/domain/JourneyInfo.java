package cn.cua.domain;
/**
 * 产品行程表
 * @author LI AO
 *
 */
public class JourneyInfo {
	
	private int journeyId;//行程id
	private int journeyDayNumber;//行程第几天
	private String journeyTitle;//行程主题
	private String journeyDescription;//行程描述
	private String journeyFileName;//行程文件显示名
	private String journeyRealName;//行程文件存储名
	private String productName;//产品名称
	
	
	
	public JourneyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JourneyInfo(int journeyId, int journeyDayNumber,
			String journeyTitle, String journeyDescription,
			String journeyFileName, String journeyRealName, String productName) {
		super();
		this.journeyId = journeyId;
		this.journeyDayNumber = journeyDayNumber;
		this.journeyTitle = journeyTitle;
		this.journeyDescription = journeyDescription;
		this.journeyFileName = journeyFileName;
		this.journeyRealName = journeyRealName;
		this.productName = productName;
	}
	public int getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}
	public int getJourneyDayNumber() {
		return journeyDayNumber;
	}
	public void setJourneyDayNumber(int journeyDayNumber) {
		this.journeyDayNumber = journeyDayNumber;
	}
	public String getJourneyTitle() {
		return journeyTitle;
	}
	public void setJourneyTitle(String journeyTitle) {
		this.journeyTitle = journeyTitle;
	}
	public String getJourneyDescription() {
		return journeyDescription;
	}
	public void setJourneyDescription(String journeyDescription) {
		this.journeyDescription = journeyDescription;
	}
	public String getJourneyFileName() {
		return journeyFileName;
	}
	public void setJourneyFileName(String journeyFileName) {
		this.journeyFileName = journeyFileName;
	}
	public String getJourneyRealName() {
		return journeyRealName;
	}
	public void setJourneyRealName(String journeyRealName) {
		this.journeyRealName = journeyRealName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "JourneyInfo [journeyId=" + journeyId + ", journeyDayNumber="
				+ journeyDayNumber + ", journeyTitle=" + journeyTitle
				+ ", journeyDescription=" + journeyDescription
				+ ", journeyFileName=" + journeyFileName + ", journeyRealName="
				+ journeyRealName + ", productName=" + productName + "]";
	}
	
	
}
