package cn.cua.service;

import cn.cua.dao.CityDescriptionPageDAO;
import cn.cua.domain.TravelDestinationInfo;

public class CityDescriptionPageService {
	private CityDescriptionPageDAO cdpDao= new CityDescriptionPageDAO();
	
	/**
	 * 城市介绍页面的DAO，通过城市名寻找对应的城市信息
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return cdpDao.load(cityName);
	}
}
