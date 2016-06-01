package cn.cua.service;

import java.util.List;

import cn.cua.dao.JourneyInfoDAO;
import cn.cua.domain.JourneyInfo;

/**
 * �г���Ϣ��ҵ����
 * @author Sandm
 *
 */
public class JourneyService {
	JourneyInfoDAO journeyInfoDao = new  JourneyInfoDAO();

	public JourneyService() {
		super();
	}

	/**
	 * �����г���Ϣ
	 * @param journeyInfo
	 */
	public void add(JourneyInfo journeyInfo) {
		journeyInfoDao.add(journeyInfo);
	}

	/**
	 * �����ض���Ʒ���г�
	 * @param productName
	 * @return
	 */
	public List<JourneyInfo> findByProductName(String productName) {
		return journeyInfoDao.findByProductName(productName);
	}

	/**
	 * ɾ���г�
	 * @param journeyId
	 */
	public void delete(int journeyId) {
		journeyInfoDao.delete(journeyId);
		
	}

	/**
	 * �����г�
	 * @param jourId
	 * @return
	 */
	public JourneyInfo load(Integer jourId) {
		return journeyInfoDao.load(jourId);
	}

	/**
	 * �༭�г�
	 * @param journeyInfo
	 */
	public void edit(JourneyInfo journeyInfo) {
		journeyInfoDao.edit(journeyInfo);
	}

	
}
