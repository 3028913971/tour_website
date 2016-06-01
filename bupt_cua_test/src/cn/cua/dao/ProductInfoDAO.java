package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cua.domain.ProductInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 产品信息的数据访问类
 * @author Sandm
 *
 */
public class ProductInfoDAO {
	private int productAmount;

	public ProductInfoDAO() {
		super();
	}

	/**
	 * 返回所有产品的数目
	 * @return
	 */
	public int getProductAmount() {
		
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql="from ProductInfo";
			Query query = session.createQuery(hql);
			
			this.productAmount = query.list().size();
			
			tx.commit();
			session.close();
			
			return this.productAmount;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 返回符合条件的产品数
	 * @param model
	 * @return
	 */
	public int getProductAmount(ProductInfo model) {

		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			StringBuilder hql=new StringBuilder("from ProductInfo where 1=1");
			
			String productName =model.getProductName(); 
			if(productName!=null && !productName.trim().isEmpty()){
				hql.append(" and productName like '%"+productName +"%'");
			}
			
			String productDescription =model.getProductDescription(); 
			if(productDescription!=null && !productDescription.trim().isEmpty()){
				hql.append(" and productDescription like '%"+productDescription +"%'");
			}
			
			String cityName =model.getCityName(); 
			if(cityName!=null && !cityName.trim().isEmpty()){
				hql.append(" and cityName like '%"+cityName +"%'");
			}
			
			String isTop =model.getIsTop(); 
			if(isTop!=null && !isTop.trim().isEmpty()){
				hql.append(" and isTop='"+isTop +"'");
			}
			
			Query query = session.createQuery(hql.toString());
			
			this.productAmount = query.list().size();
			
			tx.commit();
			session.close();
			
			return this.productAmount;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 分页操作下返回所有产品
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(int pageNum, int pageSize) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql="from ProductInfo";
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNum-1) * pageSize);
			query.setMaxResults(pageSize);
			
			List<ProductInfo> productInfos= query.list();
			
			
			
			tx.commit();
			session.close();

			return productInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 返回符合条件的所有产品
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(ProductInfo model, int pageNum,
			int pageSize) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			StringBuilder hql=new StringBuilder("from ProductInfo where 1=1");
			
			String productName =model.getProductName(); 
			if(productName!=null && !productName.trim().isEmpty()){
				hql.append(" and productName like '%"+productName +"%'");
			}
			
			String productDescription =model.getProductDescription(); 
			if(productDescription!=null && !productDescription.trim().isEmpty()){
				hql.append(" and productDescription like '%"+productDescription +"%'");
			}
			String cityName =model.getCityName(); 
			if(cityName!=null && !cityName.trim().isEmpty()){
				hql.append(" and cityName like '%"+cityName +"%'");
			}
			
			String isTop =model.getIsTop(); 
			if(isTop!=null && !isTop.trim().isEmpty()){
				hql.append(" and isTop='"+isTop +"'");
			}
			
			Query query = session.createQuery(hql.toString());
			query.setFirstResult((pageNum-1) * pageSize);
			query.setMaxResults(pageSize);
			
			List<ProductInfo> productInfos= query.list();
			
			
			
			tx.commit();
			session.close();

			return productInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 增加产品
	 * @param model
	 */
	public void add(ProductInfo model) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(model);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除产品
	 * @param productId
	 */
	public void delete(int productId) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProductId(productId);
			session.delete(productInfo);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 加载产品
	 * @param productId
	 * @return
	 */
	public ProductInfo load(int productId) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from ProductInfo where productId="+productId;
			Query query = session.createQuery(hql);
			
			ProductInfo productInfo = (ProductInfo)query.list().get(0);
			
			tx.commit();
			session.close();
			
			return productInfo;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 编辑产品
	 * @param model
	 */
	public void edit(ProductInfo model) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			session.update(model);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public List<ProductInfo> findAll() {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql="from ProductInfo";
			Query query = session.createQuery(hql);
			
			List<ProductInfo> productInfos= query.list();
			

			
			tx.commit();
			session.close();

			return productInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
