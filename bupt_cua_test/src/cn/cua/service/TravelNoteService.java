package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNoteInfoDAO;
import cn.cua.domain.TravelNoteInfo;

/**
 * TravelNoteInfo��ҵ����
 * @author Sandm
 *
 */
public class TravelNoteService {

	private TravelNoteInfoDAO tNoteInfoDao = new TravelNoteInfoDAO();
	
	public TravelNoteService() {
		super();
		
	}
	/**
	 * ��ҳ�����²�ѯ��������
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Object findAll(int pageNum, int pageSize) {
		return tNoteInfoDao.findAll(pageNum,pageSize);
	}
	
	/**
	 * ��ѯ��ҳ�����²�ѯ��������
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelNoteInfo> queryFindAll(TravelNoteInfo model, int pageNum, int pageSize) {
		return tNoteInfoDao.query(model,pageNum,pageSize);
	}

	/**
	 * �������е��μ���Ϣ
	 * @return
	 */
	/*public List<TravelNoteInfo> findAll() {
		return tNoteInfoDao.findAll();
	}*/

	/**
	 * �����ض����μ���Ϣ
	 * @param tNoteId
	 * @return
	 */
	public TravelNoteInfo load(int tNoteId) {
		return tNoteInfoDao.load(tNoteId);
	}

	/**
	 * �����ض��μǵ�ͼƬ����
	 * @param tNoteId
	 * @return
	 */
	public List<String> loadPhoto(int tNoteId) {
		return tNoteInfoDao.loadPhoto(tNoteId);
	}

	/**
	 * ɾ���ض����μ�
	 * @param tNoteId
	 */
	public void delete(int tNoteId) {
		tNoteInfoDao.delete(tNoteId);
	}

	/**
	 * �޸��ض����μ�
	 * @param tNoteId
	 */
	public void edit(TravelNoteInfo tNoteInfo) {
		tNoteInfoDao.edit(tNoteInfo);
	}

	/**
	 * ��ѯ�����ض��������μ�
	 * @param tNoteId
	 */
	/*public List<TravelNoteInfo> query(TravelNoteInfo tNoteInfo) {
		return tNoteInfoDao.query(tNoteInfo);
	}*/
	
	/**
	 * ��ȡ�μ�����
	 * @return
	 */
	public int getTNoteAmount() {
		return tNoteInfoDao.getTNoteAmount();
	}

	/**
	 * ��ȡ���ϲ�ѯ�������μ�����
	 * @param model
	 * @return
	 */
	public int getTNoteAmount(TravelNoteInfo model) {
		return tNoteInfoDao.getTNoteAmount(model);
	}

	
}
