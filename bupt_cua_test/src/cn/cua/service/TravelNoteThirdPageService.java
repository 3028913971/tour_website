package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNoteThirdPageDAO;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNoteThirdPageService {
	private TravelNoteThirdPageDAO tntpDao = new TravelNoteThirdPageDAO();
	
	public TravelNoteInfo load(int travelNoteId){
		TravelNoteInfo travelNoteInfo = tntpDao.load(travelNoteId);
		travelNoteInfo.setPublicTime(travelNoteInfo.getPublicTime().split(" ")[0]);
		return travelNoteInfo;
	}
	
	public List<TravelDestinationInfo> getRelevantCityList(String cityName){
		return tntpDao.getRelevantCityList(cityName);
	}
}
