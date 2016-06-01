package cn.cua.domain;
/**
 * Ê×Ò³¹¥ÂÔ¹ö¶¯Í¼Æ¬±í
 * @author W T
 *
 */
public class StrategyTopPhotoInfo {

	private Integer strategyTopPhotoId;
	private String strategyTopPhotoFileName;
	private String strategyTopPhotoRealName;
	private String updateTime;
	private String isTop;

	
	public StrategyTopPhotoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StrategyTopPhotoInfo(Integer strategyTopPhotoId, String strategyTopPhotoFileName,
			String strategyTopPhotoRealName, String updateTime) {
		super();
		this.strategyTopPhotoId = strategyTopPhotoId;
		this.strategyTopPhotoFileName = strategyTopPhotoFileName;
		this.strategyTopPhotoRealName = strategyTopPhotoRealName;
		this.updateTime = updateTime;
		this.isTop = isTop;
	}

	public Integer getStrategyTopPhotoId() {
		return this.strategyTopPhotoId;
	}

	public void setStrategyTopPhotoId(Integer strategyTopPhotoId) {
		this.strategyTopPhotoId = strategyTopPhotoId;
	}

	public String getStrategyTopPhotoFileName() {
		return this.strategyTopPhotoFileName;
	}

	public void setStrategyTopPhotoFileName(String strategyTopPhotoFileName) {
		this.strategyTopPhotoFileName = strategyTopPhotoFileName;
	}

	public String getStrategyTopPhotoRealName() {
		return this.strategyTopPhotoRealName;
	}

	public void setStrategyTopPhotoRealName(String strategyTopPhotoRealName) {
		this.strategyTopPhotoRealName = strategyTopPhotoRealName;
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
		return "StrategyTopPhotoInfo [strategyTopPhotoId=" + strategyTopPhotoId + ", strategyTopPhotoFileName="
				+ strategyTopPhotoFileName + ", strategyTopPhotoRealName=" + strategyTopPhotoRealName
				+ ", updateTime=" + updateTime + ", isTop=" + isTop + "]";
	}
	
}
