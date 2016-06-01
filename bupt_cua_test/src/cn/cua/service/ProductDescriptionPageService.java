package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductdescriptionPageDAO;
import cn.cua.domain.JourneyInfo;
import cn.cua.domain.ProductInfo;

public class ProductDescriptionPageService {
	private ProductdescriptionPageDAO pdpDao = new ProductdescriptionPageDAO();
	
	/**
	 * 得到对应的产品信息
	 * @param productId
	 * @return
	 */
	public ProductInfo getProduct(int productId){
		return pdpDao.getProduct(productId);
	}
	
	/**
	 * 得到产品的行程信息
	 * @param productName
	 * @return
	 */
	public List<JourneyInfo> getJourney(String productName){
		return pdpDao.getJourney(productName);
	}
}
