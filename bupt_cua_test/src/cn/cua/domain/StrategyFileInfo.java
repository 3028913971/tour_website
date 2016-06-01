package cn.cua.domain;
/**
 * 攻略文件信息表
 * @author LI AO
 *
 */
public class StrategyFileInfo {
	
	private int strategyFileId;//攻略文件id
	private String strategyFileName;//攻略文件PDF显示名
	private String strategyFileRealName;//攻略文件PDF存储名
	private String strategyPhotoFileName;//攻略图片显示名
	private String strategyPhotoRealName;//攻略图片存储名
	private String strategyJpgName;//攻略文件JPG显示名
	private String strategyJpgRealName;//攻略文件JPG存储名
	private int amountOfDownload;//攻略文件下载量
	private String updateTime;//攻略文件发表是济南
	private String isTop;//攻略文件是否问热门
	private String cityName;//城市名
	
	
	
	public StrategyFileInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StrategyFileInfo(int strategyFileId, String strategyFileName,
			String strategyFileRealName, int amountOfDownload,
			String updateTime, String isTop, String cityName) {
		super();
		this.strategyFileId = strategyFileId;
		this.strategyFileName = strategyFileName;
		this.strategyFileRealName = strategyFileRealName;
		this.strategyPhotoFileName = strategyPhotoFileName;
		this.strategyPhotoRealName = strategyPhotoRealName;
		this.strategyJpgName = strategyJpgName ;
		this.strategyJpgRealName = strategyJpgRealName ;
		this.amountOfDownload = amountOfDownload;
		this.updateTime = updateTime;
		this.isTop = isTop;
		this.cityName = cityName;
	}
	public int getStrategyFileId() {
		return strategyFileId;
	}
	public void setStrategyFileId(int strategyFileId) {
		this.strategyFileId = strategyFileId;
	}
	public String getStrategyFileName() {
		return strategyFileName;
	}
	public void setStrategyFileName(String strategyFileName) {
		this.strategyFileName = strategyFileName;
	}
	public String getStrategyPhotoFileName() {
		return strategyPhotoFileName;
	}
	public void setStrategyPhotoFileName(String strategyPhotoFileName) {
		this.strategyPhotoFileName = strategyPhotoFileName;
	}
	public String getStrategyPhotoRealName() {
		return strategyPhotoRealName;
	}
	public void setStrategyPhotoRealName(String strategyPhotoRealName) {
		this.strategyPhotoRealName = strategyPhotoRealName;
	}
	
	public String getStrategyFileRealName() {
		return strategyFileRealName;
	}
	public void setStrategyFileRealName(String strategyFileRealName) {
		this.strategyFileRealName = strategyFileRealName;
	}
	public String getStrategyJpgName() {
		return strategyJpgName;
	}
	public void setStrategyJpgName(String strategyJpgName) {
		this.strategyJpgName = strategyJpgName;
	}
	public String getStrategyJpgRealName() {
		return strategyJpgRealName;
	}
	public void setStrategyJpgRealName(String strategyJpgRealName) {
		this.strategyJpgRealName = strategyJpgRealName;
	}
	
	public int getAmountOfDownload() {
		return amountOfDownload;
	}
	public void setAmountOfDownload(int amountOfDownload) {
		this.amountOfDownload = amountOfDownload;
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
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "StrategyfileInfo [strategyFileId=" + strategyFileId
				+ ", strategyFileName=" + strategyFileName
				+ ", strategyFileRealName=" + strategyFileRealName
				+ ", strategyPhotoFileName=" + strategyPhotoFileName
				+ ", strategyPhotoRealName=" + strategyPhotoRealName
				+ ", strategyJpgName=" + strategyJpgName
				+ ", strategyJpgRealName=" + strategyJpgRealName
				+ ", amountOfDownload=" + amountOfDownload + ", updateTime="
				+ updateTime + ", isTop=" + isTop + ", cityName=" + cityName
				+ "]";
	}
	
	
}
