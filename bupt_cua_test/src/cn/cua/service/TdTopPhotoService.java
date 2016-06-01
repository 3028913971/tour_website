package cn.cua.service;

import java.util.List;


import cn.cua.dao.TdTopPhotoInfoDAO;
import cn.cua.domain.TdTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;

/**
 * Ŀ�ĵ��Ƽ��Ϸ�ͼƬ  Service��
 * @author LI AO
 *
 */
public class TdTopPhotoService {

	private TdTopPhotoInfoDAO tdTopPhotoDao = new TdTopPhotoInfoDAO();
	/**
	 * ��ҳ�������õ���ҳ����
	 * @return
	 */
	public int getTdTopPhotoAmount(){
		return tdTopPhotoDao.getTdTopPhotoAmount();
	}
	
	
	
	public TdTopPhotoInfo getOnePic(){
		return tdTopPhotoDao.getOnePic();
	}
	
	/**
	 * ��ѯ����ͼƬ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TdTopPhotoInfo> findAll(int pageNum,int pageSize){
		return tdTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * ����Ŀ�ĵ��Ƽ��Ϸ�ͼƬ
	 * @param tdTopPhoto
	 */
	public void add(TdTopPhotoInfo tdTopPhoto){
		tdTopPhotoDao.add(tdTopPhoto);
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param tdTopPhotoId
	 * @return
	 */
	public TdTopPhotoInfo load(int tdTopPhotoId){
		return tdTopPhotoDao.load(tdTopPhotoId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param tdTopPhoto
	 */
	public void edit(TdTopPhotoInfo tdTopPhoto){
		tdTopPhotoDao.edit(tdTopPhoto);			
	}
	
	/**
	 * ɾ��Ŀ�ĵ��Ƽ��Ϸ�ͼƬ
	 * @param tdTopPhotoId
	 */
	public void delete(int tdTopPhotoId){
		tdTopPhotoDao.delete(tdTopPhotoId);
	}
}
