package cn.cua.domain;
/**
 * Ê×Ò³¹ö¶¯Í¼Æ¬±í
 * @author W T
 *
 */
public class TopPhotoInfo {

	private Integer topPhotoId;
	private String topPhotoFileName;
	private String topPhotoRealName;
	private String updateTime;
	private String isTop;
	private String topPhotoCity;

	
	public TopPhotoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopPhotoInfo(Integer topPhotoId, String topPhotoFileName,
			String topPhotoRealName, String updateTime) {
		super();
		this.topPhotoId = topPhotoId;
		this.topPhotoFileName = topPhotoFileName;
		this.topPhotoRealName = topPhotoRealName;
		this.updateTime = updateTime;
		this.isTop = isTop;
		this.topPhotoCity = topPhotoCity;
	}

	public Integer getTopPhotoId() {
		return this.topPhotoId;
	}

	public void setTopPhotoId(Integer topPhotoId) {
		this.topPhotoId = topPhotoId;
	}	

	public String getTopPhotoFileName() {
		return this.topPhotoFileName;
	}

	public void setTopPhotoFileName(String topPhotoFileName) {
		this.topPhotoFileName = topPhotoFileName;
	}
	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	
	public String getTopPhotoCity() {
		return this.topPhotoCity;
	}

	public void setTopPhotoCity(String topPhotoCity) {
		this.topPhotoCity = topPhotoCity;
	}
	
	public String getTopPhotoRealName() {
		return this.topPhotoRealName;
	}

	public void setTopPhotoRealName(String topPhotoRealName) {
		this.topPhotoRealName = topPhotoRealName;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TopPhotoInfo [topPhotoId=" + topPhotoId + ", topPhotoFileName="
				+ topPhotoFileName + ", topPhotoRealName=" + topPhotoRealName
				+ ", updateTime=" + updateTime + ", isTop=" + isTop
				+ ", topPhotoCity=" + topPhotoCity + "]";
	}
	
}
