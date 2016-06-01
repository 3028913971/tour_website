package cn.cua.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.TravelNoteFirstPageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNoteFirstPageService {
	private TravelNoteFirstPageDAO tnfpDao = new TravelNoteFirstPageDAO();
	/**
	 * ��ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		return tnfpDao.findPictures();
	}
	
	/**
	 * �μ���ҳ-����Ŀ�ĵ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeList(){
		return tnfpDao.findThemeTypeList();
	}
	
	/**
	 * �μ���ҳ-����Ŀ�ĵ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
		return tnfpDao.findHomeTD();
	}
	
	/**
	 * �μ���ҳ-����Ŀ�ĵ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		return tnfpDao.findIsTopSeason();
	}
	
	/**
	 * �����μǵ�����
	 * @return
	 */
	public int getAmount(){
		return tnfpDao.getAmount();
	}
	
	/**
	 * �μ���������
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnfpDao.findIsTop(pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * �μǷ���ʱ������
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnfpDao.findPublicTime(pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
}
