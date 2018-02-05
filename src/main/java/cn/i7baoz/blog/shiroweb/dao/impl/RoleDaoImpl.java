/** 
 * Project Name:shiroWeb 
 * File Name:RoleDaoImpl.java 
 * Package Name:cn.i7baoz.blog.shiroweb.dao.impl 
 * Date:2017年12月28日上午10:22:12 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.dao.impl;  

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cn.i7baoz.blog.shiroweb.dao.RoleDao;
import cn.i7baoz.blog.shiroweb.pojo.RoleBean;
import cn.i7baoz.blog.shiroweb.pojo.RolePermsBean;

/** 
 * ClassName:RoleDaoImpl 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午10:22:12 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public RoleBean createRole(RoleBean role) {
//		sessionFactory.getCurrentSession().save(role);
		mongoTemplate.save(role);
		return role;
	}

	@Override
	public void deleteRole(String roleId) {
//		Session session = sessionFactory.getCurrentSession();
		//删除角色
//		session.delete(RoleBean.class.getName(), roleId);
		Query query = new Query();
		query.addCriteria(new Criteria("roleId").is(roleId));
		mongoTemplate.remove(query,RoleBean.class);
		//删除角色关联权限
//		String hql = "delete from RolePermsBean where roleId = :roleId ";
//		Query query = session.createQuery(hql);
//		query.setString("roleId", roleId);
//		query.executeUpdate();
//		
		query = new Query();
		query.addCriteria(new Criteria("roleId").is(roleId));
		mongoTemplate.remove(query,RolePermsBean.class);
	}

	@Override
	public RolePermsBean correlationPermissions(String roleId, String... permissionIds) {
		RolePermsBean bean = null;
		for ( String permissionId : permissionIds ) {
			bean = getRolePermBean(roleId,permissionId);
			if ( null == bean ) {
				bean = new RolePermsBean();
				bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
				bean.setPermsId(permissionId);
				bean.setRoleId(roleId);
				bean.setSortNumber(0);
				mongoTemplate.save(bean);
//				sessionFactory.getCurrentSession().save(bean);
			}
		}
		return bean;
	}

	@Override
	public RolePermsBean uncorrelationPermissions(String roleId, String... permissionIds) {
		
		RolePermsBean bean = null;
		for ( String permissionId : permissionIds ) {
			bean = getRolePermBean(roleId,permissionId);
			if ( null != bean ) {
				mongoTemplate.remove(bean);
//				sessionFactory.getCurrentSession().delete(bean);
			}
		}
		
		return bean;
	}
	
	private RolePermsBean getRolePermBean (String roleId,String permsId) {
		Query query = new Query();
		query.addCriteria(new Criteria("permsId").is(permsId)).addCriteria(new Criteria("roleId").is(roleId));
		
		return mongoTemplate.findOne(query, RolePermsBean.class);
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(RolePermsBean.class);
//		criteria.add(Restrictions.eq("permsId", permsId)).add(Restrictions.eq("roleId", roleId));
//		List<RolePermsBean> list = criteria.list();
//		if ( null == list || list.size() == 0 ) {
//			return null;
//		}
//		return list.get(0);
	}

	@Override
	public List<RoleBean> listAllRoles() {
		Query query = new Query();
		query.with(new Sort(new Order(Direction.ASC,"createTime")));
		return mongoTemplate.find(query,RoleBean.class);
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(RoleBean.class);
//		return criteria.list();
	}

	@Override
	public List<String> findPermissionByRoleId(String roleId) {
		Query query = new Query();
		query.addCriteria(new Criteria("roleId").is(roleId));
		
		
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(RolePermsBean.class);
//		criteria.add(Restrictions.eq("roleId", roleId));
//		
		List<String> permissions = new ArrayList<String>();
//		List<RolePermsBean> list = criteria.list();
		List<RolePermsBean> list =mongoTemplate.find(query,RolePermsBean.class);
		if ( null != list ) {
			for ( RolePermsBean bean : list ) {
				permissions.add(bean.getPermsId());
			}
		}
		
		return permissions;
	}
}
 