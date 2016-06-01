package cn.cua.domain;
/**
 * 游记信息表
 * @author LI AO
 *
 */
public class TravelNoteInfo {
	
	private int travelNoteId;//游记id
	private String travelNoteName;//游记名称
	private String travelNoteAuthor;//游记作者
	private String travelNoteContent;//游记内容
	private String publicTime;//游记发表时间
	private String isTop;//是否为热门游记
	private String cityName;//城市名
	private String travelNoteFileName;
	private String travelNoteRealName;
	private String status;

	
	public TravelNoteInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TravelNoteInfo(int travelNoteId, String travelNoteName,
			String travelNoteAuthor, String travelNoteContent,
			String publicTime, String isTop, String cityName,
			String travelNoteFileName, String travelNoteRealName,String status) {
		super();
		this.travelNoteId = travelNoteId;
		this.travelNoteName = travelNoteName;
		this.travelNoteAuthor = travelNoteAuthor;
		this.travelNoteContent = travelNoteContent;
		this.publicTime = publicTime;
		this.isTop = isTop;
		this.cityName = cityName;
		this.travelNoteFileName = travelNoteFileName;
		this.travelNoteRealName = travelNoteRealName;
		this.status = status;
	}
	public int getTravelNoteId() {
		return travelNoteId;
	}
	public void setTravelNoteId(int travelNoteId) {
		this.travelNoteId = travelNoteId;
	}
	public String getTravelNoteName() {
		return travelNoteName;
	}
	public void setTravelNoteName(String travelNoteName) {
		this.travelNoteName = travelNoteName;
	}
	public String getTravelNoteAuthor() {
		return travelNoteAuthor;
	}
	public void setTravelNoteAuthor(String travelNoteAuthor) {
		this.travelNoteAuthor = travelNoteAuthor;
	}
	public String getTravelNoteContent() {
		return travelNoteContent;
	}
	public void setTravelNoteContent(String travelNoteContent) {
		this.travelNoteContent = travelNoteContent;
	}
	public String getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTravelNoteFileName() {
		return travelNoteFileName;
	}
	public void setTravelNoteFileName(String travelNoteFileName) {
		this.travelNoteFileName = travelNoteFileName;
	}
	public String getTravelNoteRealName() {
		return travelNoteRealName;
	}
	public void setTravelNoteRealName(String travelNoteRealName) {
		this.travelNoteRealName = travelNoteRealName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TravelNoteInfo [travelNoteId=" + travelNoteId
				+ ", travelNoteName=" + travelNoteName + ", travelNoteAuthor="
				+ travelNoteAuthor + ", travelNoteContent=" + travelNoteContent
				+ ", publicTime=" + publicTime + ", isTop=" + isTop
				+ ", cityName=" + cityName + ", travelNoteFileName="
				+ travelNoteFileName + ", travelNoteRealName="
				+ travelNoteRealName + ", status=" + status + "]";
	}
	
}
