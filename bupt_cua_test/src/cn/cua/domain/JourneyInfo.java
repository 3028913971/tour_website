package cn.cua.domain;
/**
 * ��Ʒ�г̱�
 * @author LI AO
 *
 */
public class JourneyInfo {
	
	private int journeyId;//�г�id
	private int journeyDayNumber;//�г̵ڼ���
	private String journeyTitle;//�г�����
	private String journeyDescription;//�г�����
	private String journeyFileName;//�г��ļ���ʾ��
	private String journeyRealName;//�г��ļ��洢��
	private String productName;//��Ʒ����
	
	
	
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
