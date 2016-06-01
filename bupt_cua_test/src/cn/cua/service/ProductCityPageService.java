package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductCityPageDAO;
import cn.cua.domain.ProductInfo;
import cn.cua.domain.TravelDestinationInfo;

public class ProductCityPageService {
	private ProductCityPageDAO pcpDao = new ProductCityPageDAO();
	
	/**
	 * �õ����е�������Ϣ
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo getCity(String cityName){
		return pcpDao.getCity(cityName);
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-��ҳ
	 * @param cityName
	 * @return
	 */
	public int getAmountOfIsTopCity(String cityName){
		return pcpDao.getAmountOfIsTopCity(cityName);
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-���Ų�Ʒ
	 * @param cityName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findIsTopCity(String cityName,int pageNum,int pageSize){
		return pcpDao.findIsTopCity(cityName, pageNum, pageSize);
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-�۸�����
	 * @param cityName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findPriceCity(String cityName,int pageNum,int pageSize){
		return pcpDao.findPriceCity(cityName, pageNum, pageSize);
	}

}
