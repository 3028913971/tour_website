package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNotePublishPageDAO;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNotePublishPageService {
	private TravelNotePublishPageDAO tnppDao = new TravelNotePublishPageDAO();
	
	public void add(TravelNoteInfo travelNoteInfo){
		tnppDao.add(travelNoteInfo);
	}
	
	public List<TravelDestinationInfo> getRelevantCityList(String cityName){
		return tnppDao.getRelevantCityList(cityName);
	}
}
