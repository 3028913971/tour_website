package cn.cua.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cua.domain.TravelNoteInfo;
import cn.cua.domain.TravelNotePhotoInfo;
import cn.cua.utils.HibernateUtils;

/**
 * TravelNoteInfo的数据访问类
 * @author Sandm
 *
 */
public class TravelNoteInfoDAO {
	private int tNoteAmount;

	/**
	 * 显示所有游记信息
	 * @return
	 */
	public List<TravelNoteInfo> findAll() {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from TravelNoteInfo";
			Query query = session.createQuery(hql);
			
			List<TravelNoteInfo> tNoteInfos = query.list();
			this.tNoteAmount = tNoteInfos.size();
			
			for(TravelNoteInfo tNoteInfo:tNoteInfos){
				if(tNoteInfo.getPublicTime().contains(".")){
					SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
					SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = simpleDateFormat_parse.parse(tNoteInfo.getPublicTime());
					tNoteInfo.setPublicTime(simpleDateFormat_format.format(date));
				}
			}
			
			tx.commit();
			session.close();
			
			return tNoteInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 分页操作下查询所有
	 * @return
	 */
	public List<TravelNoteInfo> findAll(int pageNum, int pageSize) {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			String hql="from TravelNoteInfo order by status DESC";
			Query query = session.createQuery(hql);	//获得query对象
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);
					

			List<TravelNoteInfo> TravelNoteInfos = query.list();//执行查询
						
			for(TravelNoteInfo tNoteInfo:TravelNoteInfos){
				if(tNoteInfo.getPublicTime().contains(".")){
					SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
					SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = simpleDateFormat_parse.parse(tNoteInfo.getPublicTime());
					tNoteInfo.setPublicTime(simpleDateFormat_format.format(date));
				}
			}
						
						
			transaction.commit();
			session.close();
			return TravelNoteInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载特定的游记信息
	 * @param tNoteId
	 * @return
	 */
	public TravelNoteInfo load(int tNoteId) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from TravelNoteInfo where travelNoteId = "+ tNoteId;
			
			Query query = session.createQuery(hql);
			TravelNoteInfo tNoteInfo = (TravelNoteInfo)query.list().get(0);
			if(tNoteInfo.getPublicTime().contains(".")){
				SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
				SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = simpleDateFormat_parse.parse(tNoteInfo.getPublicTime());
				tNoteInfo.setPublicTime(simpleDateFormat_format.format(date));
			}
			
			tx.commit();
			session.close();
			
			return tNoteInfo;
			
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载特定的游记的图片
	 * @param tNoteId
	 * @return
	 */
	public List<String> loadPhoto(int tNoteId) {
		try{
			TravelNoteInfo tNoteInfo = load(tNoteId);
			
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from TravelNotePhotoInfo where travelNoteName like '%" + tNoteInfo.getTravelNoteName()+
					"%' and travelNotePhotoAuthor like '%" + tNoteInfo.getTravelNoteAuthor()+"%'";
			
			Query query = session.createQuery(hql);
			List<TravelNotePhotoInfo> tNotePhotoInfos = query.list();
			
			List<String> tNotePhotoRealNames = new ArrayList<String>();
			
			for(TravelNotePhotoInfo tNotePhotoInfo : tNotePhotoInfos){
				tNotePhotoRealNames.add("/travelNotes/" + tNotePhotoInfo.getTravelNotePhotoRealName());
			}
			
			tx.commit();
			session.close();
			
			return tNotePhotoRealNames;
			
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除特定的游记及游记图片信息
	 * @param tNoteId
	 */
	public void delete(int tNoteId) {
		try{
			TravelNoteInfo tNoteInfo = load(tNoteId);
			
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from TravelNotePhotoInfo where travelNoteName like '%" + tNoteInfo.getTravelNoteName()+
					"%' and travelNotePhotoAuthor like '%" + tNoteInfo.getTravelNoteAuthor()+"%'";
			
			Query query = session.createQuery(hql);
			List<TravelNotePhotoInfo> tNotePhotoInfos = query.list();
			
			session.clear();
			
			for(TravelNotePhotoInfo tNotePhotoInfo:tNotePhotoInfos){
				TravelNotePhotoInfo tNPhotoInfo = new TravelNotePhotoInfo();
				tNPhotoInfo.setTravelNotePhotoId(tNotePhotoInfo.getTravelNotePhotoId());
				session.delete(tNPhotoInfo);
			}
			
			session.delete(tNoteInfo);
			
			tx.commit();
			session.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 编辑特定的游记信息
	 * @param tNoteInfo
	 */
	public void edit(TravelNoteInfo tNoteInfo) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			session.update(tNoteInfo);
			
			tx.commit();
			session.close();
			
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查找符合特定条件的游记信息
	 * @param tNoteInfo
	 * @return
	 */
	public List<TravelNoteInfo> query(TravelNoteInfo tNoteInfo) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			StringBuilder hql = new StringBuilder("from TravelNoteInfo where 1=1");
			
			String tNoteName = tNoteInfo.getTravelNoteName();
			if(tNoteName!=null && !tNoteName.trim().isEmpty()){
				hql.append(" and travelNoteName like '%"+tNoteName+"%'");
			}
			
			String status = tNoteInfo.getStatus();
			if(status!=null && !status.trim().isEmpty()){
				hql.append(" and status='"+status+"'");
			}
			
			String isTop = tNoteInfo.getIsTop();
			if(isTop!=null && !isTop.trim().isEmpty()){
				hql.append(" and isTop='"+isTop+"'");
			}
			
			String cityName = tNoteInfo.getCityName();
			if(cityName!=null && !cityName.trim().isEmpty()){
				hql.append(" and cityName='"+cityName+"'");
			}
			
			Query query = session.createQuery(hql.toString());
			
			List<TravelNoteInfo> tNoteInfos = query.list();
			this.tNoteAmount = tNoteInfos.size();//符合条件的游记数
			
			
			tx.commit();
			session.close();
			
			return tNoteInfos;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 分页操作下查询问题
	 * @param criteria
	 * @return
	 */
	public List<TravelNoteInfo> query(TravelNoteInfo criteria, int pageNum, int pageSize) {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
					
			StringBuilder hql = new StringBuilder("from TravelNoteInfo where 1=1");
					
			String tNoteName = criteria.getTravelNoteName();
			if(tNoteName != null && !tNoteName.trim().isEmpty()){
				hql.append(" and travelNoteName like '%" + tNoteName +"%'");
			}
					
			String status = criteria.getStatus();
			if(status!=null && !status.trim().isEmpty()){
				hql.append(" and status='"+status+"'");
			}
			
			String isTop = criteria.getIsTop();
			if(isTop != null && !isTop.trim().isEmpty()){
				hql.append(" and isTop='" + isTop +"'");
			}
					
			String cityName = criteria.getCityName();
			if(cityName != null && !cityName.trim().isEmpty()){
				hql.append(" and cityName like '%" + cityName +"%'");
			}
					
			Query query = session.createQuery(hql.toString());	//获得query对象
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);

			List<TravelNoteInfo> TravelNoteInfos = query.list();	//执行查询
					
			for(TravelNoteInfo tNoteInfo : TravelNoteInfos){
				if(tNoteInfo.getPublicTime().contains(".")){
					SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
					SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = simpleDateFormat_parse.parse(tNoteInfo.getPublicTime());
					tNoteInfo.setPublicTime(simpleDateFormat_format.format(date));
				}
			}
								
								
			transaction.commit();
			session.close();
			return TravelNoteInfos;
								
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}


	/**
	 * 获取游记总数
	 * @return
	 */
	public int getTNoteAmount() {
		findAll();
		return this.tNoteAmount;
	}

	/**
	 * 获取符合特定条件的游记总数
	 * @param model
	 * @return
	 */
	public int getTNoteAmount(TravelNoteInfo model) {
		query(model);
		return this.tNoteAmount;
	}

}
