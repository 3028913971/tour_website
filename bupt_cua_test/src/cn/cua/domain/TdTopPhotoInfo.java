package cn.cua.domain;
/**
 * 目的地推荐上方图片 实体类
 * @author LI AO
 *
 */
public class TdTopPhotoInfo {

	private Integer tdTopPhotoId;
	private String tdTopPhotoFileName;
	private String tdTopPhotoRealName;
	private String updateTime;
	private String isTop;
	
	
	
	public TdTopPhotoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TdTopPhotoInfo(Integer tdTopPhotoId, String tdTopPhotoFileName,
			String tdTopPhotoRealName, String updateTime) {
		super();
		this.tdTopPhotoId = tdTopPhotoId;
		this.tdTopPhotoFileName = tdTopPhotoFileName;
		this.tdTopPhotoRealName = tdTopPhotoRealName;
		this.updateTime = updateTime;
		this.isTop = isTop;
	}
	public Integer getTdTopPhotoId() {
		return tdTopPhotoId;
	}
	public void setTdTopPhotoId(Integer tdTopPhotoId) {
		this.tdTopPhotoId = tdTopPhotoId;
	}
	public String getTdTopPhotoFileName() {
		return tdTopPhotoFileName;
	}
	public void setTdTopPhotoFileName(String tdTopPhotoFileName) {
		this.tdTopPhotoFileName = tdTopPhotoFileName;
	}
	public String getTdTopPhotoRealName() {
		return tdTopPhotoRealName;
	}
	public void setTdTopPhotoRealName(String tdTopPhotoRealName) {
		this.tdTopPhotoRealName = tdTopPhotoRealName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	@Override
	public String toString() {
		return "TdTopPhotoInfo [tdTopPhotoId=" + tdTopPhotoId
				+ ", tdTopPhotoFileName=" + tdTopPhotoFileName
				+ ", tdTopPhotoRealName=" + tdTopPhotoRealName
				+ ", updateTime=" + updateTime + ", isTop=" + isTop + "]";
	}
	
	
}
