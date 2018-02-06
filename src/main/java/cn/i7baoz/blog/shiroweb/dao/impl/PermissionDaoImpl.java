/** 
 * Project Name:shiroWeb 
 * File Name:PermissionDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2017年12月28日上午10:29:59 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cn.i7baoz.blog.shiroweb.dao.PermissionDao;
import cn.i7baoz.blog.shiroweb.pojo.PermissionBean;

/** 
 * ClassName:PermissionDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:29:59 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public PermissionBean createPermission(PermissionBean permission) {
		PermissionBean oldBean = exist(permission);
		
		if ( null ==  oldBean) {
			
			mongoTemplate.save(permission);
			return permission;
		}
		return oldBean;
	}
	@Override
	public PermissionBean updateOrSave(PermissionBean permission) {
		PermissionBean oldBean = exist(permission);
		if ( null ==  oldBean) {
			mongoTemplate.save(permission);
			return permission;
		}
		Query query = new Query().addCriteria(new Criteria("permsId").is(oldBean.getPermsId()));
		Update update = new Update()
				.set("permission", permission.getPermission())
				.set("currentStatus", permission.getCurrentStatus())
				.set("descMsg", permission.getDescMsg())
				.set("permissionType", permission.getPermissionType())
				.set("belong", permission.getBelong())
				.set("isMenu", permission.getIsMenu())
				.set("sortNumber", permission.getSortNumber())
				;
		mongoTemplate.updateFirst(query, update, PermissionBean.class);
//		mongoTemplate.save(permission);
		return oldBean;
	}
	private PermissionBean exist(PermissionBean permission) {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria c = session.createCriteria(PermissionBean.class);
//		c.add(Restrictions.eq("permission", permission.getPermission()));
//		List<PermissionBean> list = c.list();
//		if ( null == list || list.size() == 0) {
//			return null;
//		} else {
//			return list.get(0);
//		}
		Query query = new Query();
		query.addCriteria(new Criteria("permission").is(permission.getPermission()));
		return mongoTemplate.findOne(query, PermissionBean.class);
	}
	
	@Override
	public void deletePermission(String permissionId) {
//		Session session = sessionFactory.getCurrentSession();
//		//删除角色
//		session.delete(PermissionBean.class.getName(), permissionId);
		Query query = new Query();
		query.addCriteria(new Criteria("permsId").is(permissionId));
		mongoTemplate.remove(query,PermissionBean.class);
	}

	@Override
	public List<PermissionBean> listAllPermission() {
//		Session session = sessionFactory.getCurrentSession();
//		Criteria c = session.createCriteria(PermissionBean.class);
//		return c.list();
		return mongoTemplate.findAll(PermissionBean.class);
	}

	@Override
	public List<PermissionBean> listMenu() {
		
//		Session session = sessionFactory.getCurrentSession();
//		Criteria c = session.createCriteria(PermissionBean.class);
//		c.add(Restrictions.eq("isMenu", true));
//		c.addOrder(Order.asc("sortNumber"));
//		return c.list();
		Query query = new Query();
		query.with(new Sort(new Order(Direction.ASC,"sortNumber")));
		query.addCriteria(new Criteria("isMenu").is(true));
		return mongoTemplate.find(query, PermissionBean.class);
	}
	@Override
	public PermissionBean getPermissionBeanByPermission(String permission) {
		
//		Session session = sessionFactory.getCurrentSession();
//		Criteria c = session.createCriteria(PermissionBean.class);
//		c.add(Restrictions.eq("permission", permission));
//		List<PermissionBean> list = c.list();
//		if(null == list || list.size() == 0 ) {
//			return null;
//		}
//		return list.get(0);
		Query query = new Query();
		query.addCriteria(new Criteria("permission").is(permission));
		return mongoTemplate.findOne(query, PermissionBean.class);
	}
	@Override
	public List<PermissionBean> getPermissionBeanByParentPermission(
			String parentPermission) {
		
//		Session session = sessionFactory.getCurrentSession();
//		Criteria c = session.createCriteria(PermissionBean.class);
//		c.add(Restrictions.eq("belong", parentPermission));
//		return c.list();
		
		Query query = new Query();
		query.addCriteria(new Criteria("belong").is(parentPermission));
		return mongoTemplate.find(query, PermissionBean.class);
	}

	

}
 