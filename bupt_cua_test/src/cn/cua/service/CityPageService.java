package cn.cua.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.CityPageDAO;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;

public class CityPageService {
	
	private CityPageDAO cpDao = new CityPageDAO();
	
	/**
	 * Ŀ�ĵ��Ƽ���ҳ-���������Ƽ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		return cpDao.findIsTopSeason();
	}
	
	/**
	 * Ŀ�ĵ��Ƽ���ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		return cpDao.findThemeTypeList();
	}
	
	/**
	 * Ŀ�ĵ��Ƽ���ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return cpDao.findTD();
	}

	/**
	 * ͨ��������Ѱ�Ҷ�Ӧ�ĳ�����Ϣ,�жϳ����Ƿ����
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return cpDao.load(cityName);
	}
}
