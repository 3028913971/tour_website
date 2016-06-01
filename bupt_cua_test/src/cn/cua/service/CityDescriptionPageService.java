package cn.cua.service;

import cn.cua.dao.CityDescriptionPageDAO;
import cn.cua.domain.TravelDestinationInfo;

public class CityDescriptionPageService {
	private CityDescriptionPageDAO cdpDao= new CityDescriptionPageDAO();
	
	/**
	 * ���н���ҳ���DAO��ͨ��������Ѱ�Ҷ�Ӧ�ĳ�����Ϣ
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return cdpDao.load(cityName);
	}
}
