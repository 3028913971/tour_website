package cn.cua.service;

import java.util.List;


import cn.cua.dao.TdTopPhotoInfoDAO;
import cn.cua.domain.TdTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;

/**
 * 目的地推荐上方图片  Service层
 * @author LI AO
 *
 */
public class TdTopPhotoService {

	private TdTopPhotoInfoDAO tdTopPhotoDao = new TdTopPhotoInfoDAO();
	/**
	 * 分页操作，得到分页总数
	 * @return
	 */
	public int getTdTopPhotoAmount(){
		return tdTopPhotoDao.getTdTopPhotoAmount();
	}
	
	
	
	public TdTopPhotoInfo getOnePic(){
		return tdTopPhotoDao.getOnePic();
	}
	
	/**
	 * 查询所有图片
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TdTopPhotoInfo> findAll(int pageNum,int pageSize){
		return tdTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * 增加目的地推荐上方图片
	 * @param tdTopPhoto
	 */
	public void add(TdTopPhotoInfo tdTopPhoto){
		tdTopPhotoDao.add(tdTopPhoto);
	}
	
	/**
	 * 修改功能的加载操作
	 * @param tdTopPhotoId
	 * @return
	 */
	public TdTopPhotoInfo load(int tdTopPhotoId){
		return tdTopPhotoDao.load(tdTopPhotoId);
	}
	
	/**
	 * 修改操作
	 * @param tdTopPhoto
	 */
	public void edit(TdTopPhotoInfo tdTopPhoto){
		tdTopPhotoDao.edit(tdTopPhoto);			
	}
	
	/**
	 * 删除目的地推荐上方图片
	 * @param tdTopPhotoId
	 */
	public void delete(int tdTopPhotoId){
		tdTopPhotoDao.delete(tdTopPhotoId);
	}
}
