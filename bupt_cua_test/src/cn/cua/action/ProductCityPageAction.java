package cn.cua.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.ProductInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.ProductCityPageService;

import com.opensymphony.xwork2.ActionSupport;

public class ProductCityPageAction extends ActionSupport {
	private ProductCityPageService pcpService = new ProductCityPageService();
	
	private String cityName;
	private TravelDestinationInfo city = new TravelDestinationInfo();
	private List<ProductInfo> isTopCityList = new ArrayList<ProductInfo>();
	private List<ProductInfo> priceCityList = new ArrayList<ProductInfo>();
	
	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	
	public TravelDestinationInfo getCity() {
		return city;
	}
	public void setCity(TravelDestinationInfo city) {
		this.city = city;
	}
	public List<ProductInfo> getIsTopCityList() {
		return isTopCityList;
	}
	public void setIsTopCityList(List<ProductInfo> isTopCityList) {
		this.isTopCityList = isTopCityList;
	}
	public List<ProductInfo> getPriceCityList() {
		return priceCityList;
	}
	public void setPriceCityList(List<ProductInfo> priceCityList) {
		this.priceCityList = priceCityList;
	}
	
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 产品一级页面默认排序分页
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageIsTop() throws UnsupportedEncodingException{
		pageSize = 18;
		city.setCityName(new String(cityName.getBytes("ISO-8859-1"),"UTF-8"));
		int productAmount = pcpService.getAmountOfIsTopCity(city.getCityName());
		if(productAmount == 0){
			return "pageIsTopFailed";
		}
		//ServletActionContext.getRequest().getSession().setAttribute("city", this.city);//--
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8"); //++
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageIsTop";
	}
	
	/**
	 * 产品一级页面默认排序分页
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageIsTop1() throws UnsupportedEncodingException{
		pageSize = 18;
		//city = (TravelDestinationInfo)ServletActionContext.getRequest().getSession().getAttribute("city");//--
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		//int productAmount = pcpService.getAmountOfIsTopCity(city.getCityName());//--
		int productAmount = pcpService.getAmountOfIsTopCity(this.cityName);
		//ServletActionContext.getRequest().getSession().setAttribute("city", this.city);//--
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageIsTop";
	}
	
	/**
	 * 产品一级页面默认排序分页
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findAllIsTop() throws UnsupportedEncodingException{
		//city= (TravelDestinationInfo)ServletActionContext.getRequest().getSession().getAttribute("city");//--
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		
		//city = pcpService.getCity(city.getCityName());--
		city = pcpService.getCity(this.cityName);
		
		isTopCityList = pcpService.findIsTopCity(city.getCityName(), pageNum, pageSize);
		
		return "isTopList";
	}
	
	/**
	 * 产品一级页面价格排序分页
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pagePrice() throws UnsupportedEncodingException{
		pageSize = 18;
		//city = (TravelDestinationInfo)ServletActionContext.getRequest().getSession().getAttribute("city");//--
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		//int productAmount = pcpService.getAmountOfIsTopCity(city.getCityName());//--
		int productAmount = pcpService.getAmountOfIsTopCity(this.cityName);
		//ServletActionContext.getRequest().getSession().setAttribute("city", this.city);//--
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pagePrice";
	}
	
	/**
	 * 产品一级页面价格排序分页
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findAllPrice() throws UnsupportedEncodingException{
		
		//city= (TravelDestinationInfo)ServletActionContext.getRequest().getSession().getAttribute("city");
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");//++
		//city = pcpService.getCity(city.getCityName());//--
		city = pcpService.getCity(cityName);
		
		priceCityList = pcpService.findPriceCity(city.getCityName(), pageNum, pageSize);
		
		return "priceList";
	}
	
	
}
