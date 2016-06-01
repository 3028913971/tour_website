package cn.cua.service;


import java.util.List;

import cn.cua.dao.AdminInfoDAO;
import cn.cua.dao.TravelDestinationInfoDAO;
import cn.cua.domain.AdminInfo;
import cn.cua.domain.TravelDestinationInfo;

public class TravelDestinationService {
	private TravelDestinationInfoDAO travelDestinationDao= new TravelDestinationInfoDAO();
	
	
	public List<String> getThemeList(){
		return travelDestinationDao.getThemeList();
	}
	
	/**
	 * ��ҳ�������õ����ε�����
	 * @return
	 */
	public int getDestinationAmount(){
		return travelDestinationDao.getTravelDestinationAmount();
	}
	
	/**
	 * ��ѯ�������ε�
	 * @return
	 */
	public List<TravelDestinationInfo> findAll(int pageNum,int pageSize){
		return travelDestinationDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * �������ε���Ϣ
	 * @param travelDestinationInfo
	 * @throws TravelDestinationException 
	 */
	public void add(TravelDestinationInfo travelDestinationInfo) throws TravelDestinationException{
		
		List<TravelDestinationInfo> travelDestinationList = travelDestinationDao.findBycityName(travelDestinationInfo.getCityName());
		if(travelDestinationList.size() != 0){
			throw new TravelDestinationException("���ε����Ѵ��ڣ���������ε�����");
		}else{
			travelDestinationDao.add(travelDestinationInfo);
		}	
		
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return travelDestinationDao.load(cityName);
	}
	
	/**
	 * �޸Ĳ���
	 * @param travelDestinationInfo
	 * @throws TravelDestinationException 
	 */
	public void edit(TravelDestinationInfo travelDestinationInfo) throws TravelDestinationException{	
		travelDestinationDao.edit(travelDestinationInfo);
	}

	/**
	 * ɾ������
	 * @param cityName
	 */
	public void delete(String cityName){
		travelDestinationDao.delete(cityName);
	}
	
	/**
	 * ��ϲ�ѯ��ҳ�������õ����ε�����
	 * @return
	 */
	public int getQueryAmount(TravelDestinationInfo travelDestinationInfo){
		return travelDestinationDao.getQueryAmount(travelDestinationInfo);
	}
	
	/**
	 * ��ϲ�ѯ����
	 * @param travelDestinationInfo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelDestinationInfo> query(TravelDestinationInfo travelDestinationInfo,int pageNum,int pageSize){
		return travelDestinationDao.query(travelDestinationInfo, pageNum, pageSize);
	}
	/**
	 * �������е����ε���Ϣ
	 * @return
	 */
	public List<TravelDestinationInfo> findAll() {
		return travelDestinationDao.findAll();
	}
}
