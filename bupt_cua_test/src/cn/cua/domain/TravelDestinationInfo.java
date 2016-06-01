package cn.cua.domain;
/**
 * ���ε���Ϣ��
 * @author LI AO
 *
 */
public class TravelDestinationInfo {
	
	private String cityName;//������
	private int tdOrder;//����˳��
	private String province;//����ʡ��
	private String area;//��������
	private String topSeason;//���ż���
	private String themeType;//��������
	private String themeNickname;//�������
	private String isHomeTopSeason;//�Ƿ�Ϊ��ҳ���ż����Ƽ�
	private String isTopSeason;//�Ƿ�Ϊ���ż����Ƽ�
	private String isHomeThemeType;//�Ƿ�Ϊ��ҳ����Ŀ�ĵ��Ƽ�
	private String isThemeType;//�Ƿ�Ϊ����Ŀ�ĵ��Ƽ�
	private String homeOrAbroad;//���ڻ��ǹ���
	private String description;//����
	private String cityPhotoFileName;//����ͼƬ�ļ���
	private String cityPhotoRealName;//�����ʼ۴洢��
	private String trafficDescription;//��ͨ
	private String trafficPhotoFileName;//��ͨͼƬ�ļ���
	private String trafficPhotoRealName;//��ͨͼƬ�洢��
	private String spotDescription;//����
	private String spotPhotoFileName;//����ͼƬ�ļ���
	private String spotPhotoRealName;//�����ļ��洢��
	private String shoppingDescription;//����
	private String shoppingPhotoFileName;//����ͼƬ�ļ���
	private String shoppingPhotoRealName;//����ͼƬ�洢��
	private String foodDescription;//��ʳ
	private String foodPhotoFileName;//��ʳͼƬ�ļ���
	private String foodPhotoRealName;//��ʳͼƬ�洢��
	private String isPublic;//�Ƿ񷢲�
	
	
	
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
