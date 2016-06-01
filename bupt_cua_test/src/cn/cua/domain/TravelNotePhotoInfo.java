package cn.cua.domain;
/**
 * 游记图片信息表
 * @author LI AO
 *
 */
public class TravelNotePhotoInfo {
	
	private int travelNotePhotoId;//游记图片id
	private String travelNotePhotoFileName;//游记图片文件名
	private String travelNotePhotoRealName;//游记图片存储名
	private String travelNotePhotoAuthor;//游记图片作者
	private String travelNoteName;//游记名称
	
	
	
	public TravelNotePhotoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TravelNotePhotoInfo(int travelNotePhotoId,
			String travelNotePhotoFileName, String travelNotePhotoRealName,
			String travelNotePhotoAuthor, String travelNoteName) {
		super();
		this.travelNotePhotoId = travelNotePhotoId;
		this.travelNotePhotoFileName = travelNotePhotoFileName;
		this.travelNotePhotoRealName = travelNotePhotoRealName;
		this.travelNotePhotoAuthor = travelNotePhotoAuthor;
		this.travelNoteName = travelNoteName;
	}
	public int getTravelNotePhotoId() {
		return travelNotePhotoId;
	}
	public void setTravelNotePhotoId(int travelNotePhotoId) {
		this.travelNotePhotoId = travelNotePhotoId;
	}
	public String getTravelNotePhotoFileName() {
		return travelNotePhotoFileName;
	}
	public void setTravelNotePhotoFileName(String travelNotePhotoFileName) {
		this.travelNotePhotoFileName = travelNotePhotoFileName;
	}
	public String getTravelNotePhotoRealName() {
		return travelNotePhotoRealName;
	}
	public void setTravelNotePhotoRealName(String travelNotePhotoRealName) {
		this.travelNotePhotoRealName = travelNotePhotoRealName;
	}
	public String getTravelNotePhotoAuthor() {
		return travelNotePhotoAuthor;
	}
	public void setTravelNotePhotoAuthor(String travelNotePhotoAuthor) {
		this.travelNotePhotoAuthor = travelNotePhotoAuthor;
	}
	public String getTravelNoteName() {
		return travelNoteName;
	}
	public void setTravelNoteName(String travelNoteName) {
		this.travelNoteName = travelNoteName;
	}
	@Override
	public String toString() {
		return "TravelnotephotoInfo [travelNotePhotoId=" + travelNotePhotoId
				+ ", travelNotePhotoFileName=" + travelNotePhotoFileName
				+ ", travelNotePhotoRealName=" + travelNotePhotoRealName
				+ ", travelNotePhotoAuthor=" + travelNotePhotoAuthor
				+ ", travelNoteName=" + travelNoteName + "]";
	}
	
	
}
