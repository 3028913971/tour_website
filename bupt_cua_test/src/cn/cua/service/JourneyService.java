package cn.cua.service;

import java.util.List;

import cn.cua.dao.JourneyInfoDAO;
import cn.cua.domain.JourneyInfo;

/**
 * 行程信息的业务类
 * @author Sandm
 *
 */
public class JourneyService {
	JourneyInfoDAO journeyInfoDao = new  JourneyInfoDAO();

	public JourneyService() {
		super();
	}

	/**
	 * 增加行程信息
	 * @param journeyInfo
	 */
	public void add(JourneyInfo journeyInfo) {
		journeyInfoDao.add(journeyInfo);
	}

	/**
	 * 返回特定产品的行程
	 * @param productName
	 * @return
	 */
	public List<JourneyInfo> findByProductName(String productName) {
		return journeyInfoDao.findByProductName(productName);
	}

	/**
	 * 删除行程
	 * @param journeyId
	 */
	public void delete(int journeyId) {
		journeyInfoDao.delete(journeyId);
		
	}

	/**
	 * 加载行程
	 * @param jourId
	 * @return
	 */
	public JourneyInfo load(Integer jourId) {
		return journeyInfoDao.load(jourId);
	}

	/**
	 * 编辑行程
	 * @param journeyInfo
	 */
	public void edit(JourneyInfo journeyInfo) {
		journeyInfoDao.edit(journeyInfo);
	}

	
}
