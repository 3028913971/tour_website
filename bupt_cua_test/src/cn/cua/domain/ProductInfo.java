package cn.cua.domain;
/**
 * ��Ʒ��Ϣ��
 * @author LI AO
 *
 */
public class ProductInfo {
	
	private int productId;//��Ʒid
	private String productName;//��Ʒ����
	private int productPrice;//��Ʒ�۸�
	private String productCellphone;//����绰
	private String productDescription;//��Ʒ����
	private String productFileName;//��Ʒ�ļ���ʾ��
	private String productRealName;//��Ʒ�ļ��洢��
	private String isTop;//��Ʒ�Ƿ�Ϊ����
	private String isPublic;//��Ʒ�Ƿ񷢲�
	private String startDate;//��ʼʱ��
	private String endDate;//��ֹʱ��
	private String cityName;//������
	private String costDescription;//����˵��
	private String productFeature;//��Ʒ��ɫ
	
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductInfo(int productId, String productName, int productPrice,
			String productCellphone, String productDescription,
			String productFileName, String productRealName, String isTop,
			String isPublic, String startDate, String endDate, String cityName,
			String costDescription, String productFeature) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCellphone = productCellphone;
		this.productDescription = productDescription;
		this.productFileName = productFileName;
		this.productRealName = productRealName;
		this.isTop = isTop;
		this.isPublic = isPublic;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cityName = cityName;
		this.costDescription = costDescription;
		this.productFeature = productFeature;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCellphone() {
		return productCellphone;
	}
	public void setProductCellphone(String productCellphone) {
		this.productCellphone = productCellphone;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductFeature() {
		return productFeature;
	}
	public void setProductFeature(String productFeature) {
		this.productFeature = productFeature;
	}
	public String getProductFileName() {
		return productFileName;
	}
	public void setProductFileName(String productFileName) {
		this.productFileName = productFileName;
	}
	public String getProductRealName() {
		return productRealName;
	}
	public void setProductRealName(String productRealName) {
		this.productRealName = productRealName;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}


	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", productCellphone=" + productCellphone
				+ ", productDescription=" + productDescription
				+ ", productFileName=" + productFileName + ", productRealName="
				+ productRealName + ", isTop=" + isTop + ", startDate="
				+ startDate + ", endDate=" + endDate + ", cityName=" + cityName
				+ ", costDescription=" + costDescription + ", productFeature=" + productFeature
				+"]";
	}

	
}
