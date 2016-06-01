package cn.cua.domain;
/**
 * 旅游地信息表
 * @author LI AO
 *
 */
public class TravelDestinationInfo {
	
	private String cityName;//城市名
	private int tdOrder;//城市顺序
	private String province;//所属省份
	private String area;//所属区域
	private String topSeason;//热门季节
	private String themeType;//主题类型
	private String themeNickname;//主题别名
	private String isHomeTopSeason;//是否为首页热门季节推荐
	private String isTopSeason;//是否为热门季节推荐
	private String isHomeThemeType;//是否为首页主题目的地推荐
	private String isThemeType;//是否为主题目的地推荐
	private String homeOrAbroad;//国内还是国外
	private String description;//概述
	private String cityPhotoFileName;//概述图片文件名
	private String cityPhotoRealName;//概述问价存储名
	private String trafficDescription;//交通
	private String trafficPhotoFileName;//交通图片文件名
	private String trafficPhotoRealName;//交通图片存储名
	private String spotDescription;//景点
	private String spotPhotoFileName;//景点图片文件名
	private String spotPhotoRealName;//景点文件存储名
	private String shoppingDescription;//购物
	private String shoppingPhotoFileName;//购物图片文件名
	private String shoppingPhotoRealName;//购物图片存储名
	private String foodDescription;//美食
	private String foodPhotoFileName;//美食图片文件名
	private String foodPhotoRealName;//美食图片存储名
	private String isPublic;//是否发布
	
	
	
	public TravelDestinationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	




	public TravelDestinationInfo(String cityName, int tdOrder, String province,
			String area, String topSeason, String themeType,
			String themeNickname, String isHomeTopSeason, String isTopSeason,
			String isHomeThemeType, String isThemeType, String homeOrAbroad,
			String description, String cityPhotoFileName,
			String cityPhotoRealName, String trafficDescription,
			String trafficPhotoFileName, String trafficPhotoRealName,
			String spotDescription, String spotPhotoFileName,
			String spotPhotoRealName, String shoppingDescription,
			String shoppingPhotoFileName, String shoppingPhotoRealName,
			String foodDescription, String foodPhotoFileName,
			String foodPhotoRealName, String isPublic) {
		super();
		this.cityName = cityName;
		this.tdOrder = tdOrder;
		this.province = province;
		this.area = area;
		this.topSeason = topSeason;
		this.themeType = themeType;
		this.themeNickname = themeNickname;
		this.isHomeTopSeason = isHomeTopSeason;
		this.isTopSeason = isTopSeason;
		this.isHomeThemeType = isHomeThemeType;
		this.isThemeType = isThemeType;
		this.homeOrAbroad = homeOrAbroad;
		this.description = description;
		this.cityPhotoFileName = cityPhotoFileName;
		this.cityPhotoRealName = cityPhotoRealName;
		this.trafficDescription = trafficDescription;
		this.trafficPhotoFileName = trafficPhotoFileName;
		this.trafficPhotoRealName = trafficPhotoRealName;
		this.spotDescription = spotDescription;
		this.spotPhotoFileName = spotPhotoFileName;
		this.spotPhotoRealName = spotPhotoRealName;
		this.shoppingDescription = shoppingDescription;
		this.shoppingPhotoFileName = shoppingPhotoFileName;
		this.shoppingPhotoRealName = shoppingPhotoRealName;
		this.foodDescription = foodDescription;
		this.foodPhotoFileName = foodPhotoFileName;
		this.foodPhotoRealName = foodPhotoRealName;
		this.isPublic = isPublic;
	}







	public String getIsPublic() {
		return isPublic;
	}



	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}



	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public int getTdOrder() {
		return tdOrder;
	}

	public void setTdOrder(int tdOrder) {
		this.tdOrder = tdOrder;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTopSeason() {
		return topSeason;
	}
	public void setTopSeason(String topSeason) {
		this.topSeason = topSeason;
	}
	public String getThemeType() {
		return themeType;
	}
	public void setThemeType(String themeType) {
		this.themeType = themeType;
	}
	public String getThemeNickname() {
		return themeNickname;
	}
	public void setThemeNickname(String themeNickname) {
		this.themeNickname = themeNickname;
	}
	public String getIsHomeTopSeason() {
		return isHomeTopSeason;
	}
	public void setIsHomeTopSeason(String isHomeTopSeason) {
		this.isHomeTopSeason = isHomeTopSeason;
	}
	public String getIsTopSeason() {
		return isTopSeason;
	}
	public void setIsTopSeason(String isTopSeason) {
		this.isTopSeason = isTopSeason;
	}
	public String getIsHomeThemeType() {
		return isHomeThemeType;
	}
	public void setIsHomeThemeType(String isHomeThemeType) {
		this.isHomeThemeType = isHomeThemeType;
	}
	public String getIsThemeType() {
		return isThemeType;
	}
	public void setIsThemeType(String isThemeType) {
		this.isThemeType = isThemeType;
	}
	public String getHomeOrAbroad() {
		return homeOrAbroad;
	}
	public void setHomeOrAbroad(String homeOrAbroad) {
		this.homeOrAbroad = homeOrAbroad;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCityPhotoFileName() {
		return cityPhotoFileName;
	}
	public void setCityPhotoFileName(String cityPhotoFileName) {
		this.cityPhotoFileName = cityPhotoFileName;
	}
	public String getCityPhotoRealName() {
		return cityPhotoRealName;
	}
	public void setCityPhotoRealName(String cityPhotoRealName) {
		this.cityPhotoRealName = cityPhotoRealName;
	}
	public String getTrafficDescription() {
		return trafficDescription;
	}
	public void setTrafficDescription(String trafficDescription) {
		this.trafficDescription = trafficDescription;
	}
	public String getTrafficPhotoFileName() {
		return trafficPhotoFileName;
	}
	public void setTrafficPhotoFileName(String trafficPhotoFileName) {
		this.trafficPhotoFileName = trafficPhotoFileName;
	}
	public String getTrafficPhotoRealName() {
		return trafficPhotoRealName;
	}
	public void setTrafficPhotoRealName(String trafficPhotoRealName) {
		this.trafficPhotoRealName = trafficPhotoRealName;
	}
	public String getSpotDescription() {
		return spotDescription;
	}
	public void setSpotDescription(String spotDescription) {
		this.spotDescription = spotDescription;
	}
	public String getSpotPhotoFileName() {
		return spotPhotoFileName;
	}
	public void setSpotPhotoFileName(String spotPhotoFileName) {
		this.spotPhotoFileName = spotPhotoFileName;
	}
	public String getSpotPhotoRealName() {
		return spotPhotoRealName;
	}
	public void setSpotPhotoRealName(String spotPhotoRealName) {
		this.spotPhotoRealName = spotPhotoRealName;
	}
	public String getShoppingDescription() {
		return shoppingDescription;
	}
	public void setShoppingDescription(String shoppingDescription) {
		this.shoppingDescription = shoppingDescription;
	}
	public String getShoppingPhotoFileName() {
		return shoppingPhotoFileName;
	}
	public void setShoppingPhotoFileName(String shoppingPhotoFileName) {
		this.shoppingPhotoFileName = shoppingPhotoFileName;
	}
	public String getShoppingPhotoRealName() {
		return shoppingPhotoRealName;
	}
	public void setShoppingPhotoRealName(String shoppingPhotoRealName) {
		this.shoppingPhotoRealName = shoppingPhotoRealName;
	}
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public String getFoodPhotoFileName() {
		return foodPhotoFileName;
	}
	public void setFoodPhotoFileName(String foodPhotoFileName) {
		this.foodPhotoFileName = foodPhotoFileName;
	}
	public String getFoodPhotoRealName() {
		return foodPhotoRealName;
	}
	public void setFoodPhotoRealName(String foodPhotoRealName) {
		this.foodPhotoRealName = foodPhotoRealName;
	}







	@Override
	public String toString() {
		return "TravelDestinationInfo [cityName=" + cityName + ", tdOrder="
				+ tdOrder + ", province=" + province + ", area=" + area
				+ ", topSeason=" + topSeason + ", themeType=" + themeType
				+ ", themeNickname=" + themeNickname + ", isHomeTopSeason="
				+ isHomeTopSeason + ", isTopSeason=" + isTopSeason
				+ ", isHomeThemeType=" + isHomeThemeType + ", isThemeType="
				+ isThemeType + ", homeOrAbroad=" + homeOrAbroad
				+ ", description=" + description + ", cityPhotoFileName="
				+ cityPhotoFileName + ", cityPhotoRealName="
				+ cityPhotoRealName + ", trafficDescription="
				+ trafficDescription + ", trafficPhotoFileName="
				+ trafficPhotoFileName + ", trafficPhotoRealName="
				+ trafficPhotoRealName + ", spotDescription=" + spotDescription
				+ ", spotPhotoFileName=" + spotPhotoFileName
				+ ", spotPhotoRealName=" + spotPhotoRealName
				+ ", shoppingDescription=" + shoppingDescription
				+ ", shoppingPhotoFileName=" + shoppingPhotoFileName
				+ ", shoppingPhotoRealName=" + shoppingPhotoRealName
				+ ", foodDescription=" + foodDescription
				+ ", foodPhotoFileName=" + foodPhotoFileName
				+ ", foodPhotoRealName=" + foodPhotoRealName + ", isPublic="
				+ isPublic + "]";
	}





	
}
