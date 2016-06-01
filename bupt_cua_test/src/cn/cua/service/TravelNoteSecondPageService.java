package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNoteSecondPageDAO;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNoteSecondPageService {
	private TravelNoteSecondPageDAO tnspDao = new TravelNoteSecondPageDAO();
	/**
	 * �õ����е�������Ϣ
	 * 
	 * */
	public TravelDestinationInfo getCity(String cityName){
		return tnspDao.getCity(cityName);
	}
	
	/**
	 * �μǶ���ҳ��-��ҳ����
	 * @param cityName
	 * @return
	 */
	public int getAmount(String cityName){
		return tnspDao.getAmount(cityName);
	}
	
	/**
	 * �μ���������
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(String cityName,int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnspDao.findIsTop(cityName, pageNum, pageSize);
		if(list == null){
			return null;
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * �μǷ���ʱ������
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(String cityName,int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnspDao.findPublicTime(cityName, pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
}
