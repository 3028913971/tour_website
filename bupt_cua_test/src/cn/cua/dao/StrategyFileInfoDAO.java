package cn.cua.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 攻略下载信息表
 * @author W T
 *
 */
public class StrategyFileInfoDAO {	
	
	@Test
	public StrategyFileInfo load(int strategyFileId){
		//通过id查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		StrategyFileInfo strategyFileInfo = (StrategyFileInfo) session.get(StrategyFileInfo.class,strategyFileId);
		if(strategyFileInfo.getUpdateTime().contains(".")){
				SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
				SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				try {
					Date date = simpleDateFormat_parse.parse(strategyFileInfo.getUpdateTime());
					strategyFileInfo.setUpdateTime(simpleDateFormat_format.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
		}
		
		

		transaction.commit();
		session.close();
		return strategyFileInfo;
	}
	
	public int getStrategyFileAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from StrategyFileInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<StrategyFileInfo> strategyFileInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return strategyFileInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<StrategyFileInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from StrategyFileInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<StrategyFileInfo> strategyFileInfos = query.list();	//执行查询		
		
		for(StrategyFileInfo strategyFileInfo : strategyFileInfos){
			if(strategyFileInfo.getUpdateTime().contains(".")){
				SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
				SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = simpleDateFormat_parse.parse(strategyFileInfo.getUpdateTime());
				strategyFileInfo.setUpdateTime(simpleDateFormat_format.format(date));
			}
		}
		
		
		transaction.commit();
		session.close();
		return strategyFileInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	//@Test
	public List<StrategyFileInfo> findByCityName(String cityName){
		
			try{
				//通过城市名称查找操作
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
			

				String hql="from StrategyFileInfo where cityName='"+ cityName +"'";
				List<StrategyFileInfo> list = this.strategyFileInfoFindByHQL(hql);
				Query query = session.createQuery(hql);	//获得query对象
				List<StrategyFileInfo> strategyFileInfos = query.list();
				for(StrategyFileInfo strategyFileInfo : strategyFileInfos){
					if(strategyFileInfo.getUpdateTime().contains(".")){
						SimpleDateFormat simpleDateFormat_parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
						SimpleDateFormat simpleDateFormat_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = simpleDateFormat_parse.parse(strategyFileInfo.getUpdateTime());
						strategyFileInfo.setUpdateTime(simpleDateFormat_format.format(date));
					}
				}
				transaction.commit();
				session.close();
				return strategyFileInfos;
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
		}
	@Test
	public List<StrategyFileInfo> strategyFileInfoFindByHQL(String hql){
		//通过HQL查找操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//获得query对象

		List<StrategyFileInfo> strategyFileInfos = query.list();	//执行查询		
		
		transaction.commit();
		session.close();
		return strategyFileInfos;
	}
	

	public void add(StrategyFileInfo strategyFileInfo){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(strategyFileInfo);
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void delete(int strategyFileId){
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		StrategyFileInfo strategyFileInfo = new StrategyFileInfo();
		strategyFileInfo.setStrategyFileId(strategyFileId);
		session.delete(strategyFileInfo);	
		transaction.commit();
		session.close();
	}
	@Test
	public void edit(StrategyFileInfo strategyFileInfo){
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(strategyFileInfo);
		transaction.commit();
		session.close();
	}


	public int getQueryAmount(StrategyFileInfo strategyFileInfo){
		//组合查询	
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			Criteria criteria = session.createCriteria(StrategyFileInfo.class);
			
			
			String cityName = strategyFileInfo.getCityName();
			//判断cityName这个条件是否存在
			if(cityName != null && !cityName.trim().isEmpty()){
				criteria.add(Restrictions.eq("cityName", cityName));
			}
			
			List<StrategyFileInfo> strategyFileInfos = criteria.list();
			
			
			for(int i=0;i<strategyFileInfos.size();i++){
			}
			
			transaction.commit();
			session.close();
			
			return strategyFileInfos.size();
	}

	@Test
	public List<StrategyFileInfo> query(StrategyFileInfo criteria,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		StringBuilder hql = new StringBuilder("from StrategyFileInfo where 1=1");
		

		String cityName = criteria.getCityName();
		//判断cityName这个条件是否存在
		if(cityName != null && !cityName.trim().isEmpty()){if(cityName != null && !cityName.trim().isEmpty()){
			hql.append(" and cityName like '%" + cityName +"%'");
		}}
		
		Query query = session.createQuery(hql.toString());	//获得query对象
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		
		List<StrategyFileInfo> strategyFileInfos = query.list();
		
		for(StrategyFileInfo strategyFileInfo : strategyFileInfos){
		}
		
		transaction.commit();
		session.close();
		
		return strategyFileInfos;
	}
	
}
