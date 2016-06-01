package cn.cua.domain;
/**
 * Ê×Ò³¹ö¶¯Í¼Æ¬±í
 * @author W T
 *
 */
public class TravelnoteTopPhotoInfo {

	private Integer travelnoteTopPhotoId;
	private String travelnoteTopPhotoFileName;
	private String travelnoteTopPhotoRealName;
	private String updateTime;
	private String isTop;

	
	public TravelnoteTopPhotoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TravelnoteTopPhotoInfo(Integer travelnoteTopPhotoId, String travelnoteTopPhotoFileName,
			String travelnoteTopPhotoRealName, String updateTime) {
		super();
		this.travelnoteTopPhotoId = travelnoteTopPhotoId;
		this.travelnoteTopPhotoFileName = travelnoteTopPhotoFileName;
		this.travelnoteTopPhotoRealName = travelnoteTopPhotoRealName;
		this.updateTime = updateTime;
		this.isTop = isTop;
	}

	public Integer getTravelnoteTopPhotoId() {
		return this.travelnoteTopPhotoId;
	}

	public void setTravelnoteTopPhotoId(Integer travelnoteTopPhotoId) {
		this.travelnoteTopPhotoId = travelnoteTopPhotoId;
	}

	public String getTravelnoteTopPhotoFileName() {
		return this.travelnoteTopPhotoFileName;
	}

	public void setTravelnoteTopPhotoFileName(String travelnoteTopPhotoFileName) {
		this.travelnoteTopPhotoFileName = travelnoteTopPhotoFileName;
	}

	public String getTravelnoteTopPhotoRealName() {
		return this.travelnoteTopPhotoRealName;
	}

	public void setTravelnoteTopPhotoRealName(String travelnoteTopPhotoRealName) {
		this.travelnoteTopPhotoRealName = travelnoteTopPhotoRealName;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	@Override
	public String toString() {
		return "TravelnoteTopPhotoInfo [travelnoteTopPhotoId=" + travelnoteTopPhotoId + ", travelnoteTopPhotoFileName="
				+ travelnoteTopPhotoFileName + ", travelnoteTopPhotoRealName=" + travelnoteTopPhotoRealName
				+ ", updateTime=" + updateTime + ", isTop=" + isTop + "]";
	}
	
}
