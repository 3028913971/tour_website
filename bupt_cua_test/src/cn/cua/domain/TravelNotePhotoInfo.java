package cn.cua.domain;
/**
 * �μ�ͼƬ��Ϣ��
 * @author LI AO
 *
 */
public class TravelNotePhotoInfo {
	
	private int travelNotePhotoId;//�μ�ͼƬid
	private String travelNotePhotoFileName;//�μ�ͼƬ�ļ���
	private String travelNotePhotoRealName;//�μ�ͼƬ�洢��
	private String travelNotePhotoAuthor;//�μ�ͼƬ����
	private String travelNoteName;//�μ�����
	
	
	
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
