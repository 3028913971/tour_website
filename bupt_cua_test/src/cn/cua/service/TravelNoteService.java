package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNoteInfoDAO;
import cn.cua.domain.TravelNoteInfo;

/**
 * TravelNoteInfo的业务类
 * @author Sandm
 *
 */
public class TravelNoteService {

	private TravelNoteInfoDAO tNoteInfoDao = new TravelNoteInfoDAO();
	
	public TravelNoteService() {
		super();
		
	}
	/**
	 * 分页操作下查询所有问题
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Object findAll(int pageNum, int pageSize) {
		return tNoteInfoDao.findAll(pageNum,pageSize);
	}
	
	/**
	 * 查询分页操作下查询所有问题
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelNoteInfo> queryFindAll(TravelNoteInfo model, int pageNum, int pageSize) {
		return tNoteInfoDao.query(model,pageNum,pageSize);
	}

	/**
	 * 查找所有的游记信息
	 * @return
	 */
	/*public List<TravelNoteInfo> findAll() {
		return tNoteInfoDao.findAll();
	}*/

	/**
	 * 加载特定的游记信息
	 * @param tNoteId
	 * @return
	 */
	public TravelNoteInfo load(int tNoteId) {
		return tNoteInfoDao.load(tNoteId);
	}

	/**
	 * 加载特定游记的图片名称
	 * @param tNoteId
	 * @return
	 */
	public List<String> loadPhoto(int tNoteId) {
		return tNoteInfoDao.loadPhoto(tNoteId);
	}

	/**
	 * 删除特定的游记
	 * @param tNoteId
	 */
	public void delete(int tNoteId) {
		tNoteInfoDao.delete(tNoteId);
	}

	/**
	 * 修改特定的游记
	 * @param tNoteId
	 */
	public void edit(TravelNoteInfo tNoteInfo) {
		tNoteInfoDao.edit(tNoteInfo);
	}

	/**
	 * 查询符合特定条件的游记
	 * @param tNoteId
	 */
	/*public List<TravelNoteInfo> query(TravelNoteInfo tNoteInfo) {
		return tNoteInfoDao.query(tNoteInfo);
	}*/
	
	/**
	 * 获取游记总数
	 * @return
	 */
	public int getTNoteAmount() {
		return tNoteInfoDao.getTNoteAmount();
	}

	/**
	 * 获取符合查询条件的游记总数
	 * @param model
	 * @return
	 */
	public int getTNoteAmount(TravelNoteInfo model) {
		return tNoteInfoDao.getTNoteAmount(model);
	}

	
}
