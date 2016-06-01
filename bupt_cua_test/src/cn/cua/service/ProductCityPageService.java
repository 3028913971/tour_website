package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductCityPageDAO;
import cn.cua.domain.ProductInfo;
import cn.cua.domain.TravelDestinationInfo;

public class ProductCityPageService {
	private ProductCityPageDAO pcpDao = new ProductCityPageDAO();
	
	/**
	 * 得到城市的描述信息
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo getCity(String cityName){
		return pcpDao.getCity(cityName);
	}
	
	/**
	 * 产品推荐二级页面-分页
	 * @param cityName
	 * @return
	 */
	public int getAmountOfIsTopCity(String cityName){
		return pcpDao.getAmountOfIsTopCity(cityName);
	}
	
	/**
	 * 产品推荐二级页面-热门产品
	 * @param cityName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findIsTopCity(String cityName,int pageNum,int pageSize){
		return pcpDao.findIsTopCity(cityName, pageNum, pageSize);
	}
	
	/**
	 * 产品推荐二级页面-价格排序
	 * @param cityName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findPriceCity(String cityName,int pageNum,int pageSize){
		return pcpDao.findPriceCity(cityName, pageNum, pageSize);
	}

}
