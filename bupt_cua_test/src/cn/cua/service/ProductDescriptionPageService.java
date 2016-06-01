package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductdescriptionPageDAO;
import cn.cua.domain.JourneyInfo;
import cn.cua.domain.ProductInfo;

public class ProductDescriptionPageService {
	private ProductdescriptionPageDAO pdpDao = new ProductdescriptionPageDAO();
	
	/**
	 * �õ���Ӧ�Ĳ�Ʒ��Ϣ
	 * @param productId
	 * @return
	 */
	public ProductInfo getProduct(int productId){
		return pdpDao.getProduct(productId);
	}
	
	/**
	 * �õ���Ʒ���г���Ϣ
	 * @param productName
	 * @return
	 */
	public List<JourneyInfo> getJourney(String productName){
		return pdpDao.getJourney(productName);
	}
}
