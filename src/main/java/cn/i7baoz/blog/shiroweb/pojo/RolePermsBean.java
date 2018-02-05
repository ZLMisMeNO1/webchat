/** 
 * Project Name:shiroWeb 
 * File Name:UserPermsBean.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月28日上午9:22:26 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.pojo;  

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/** 
 * ClassName:UserPermsBean 
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月28日 上午9:22:26 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Document(collection="t_collection_rolepermission")
public class RolePermsBean extends BaseBean{

	/**   
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	//角色id
	private String roleId;
	
	//权限id
	private String permsId;
	
	//描述
	private String descMsg;
	
	//创建时间
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	//排序号
	private Integer sortNumber = 0 ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getPermsId() {
		return permsId;
	}

	public void setPermsId(String permsId) {
		this.permsId = permsId;
	}


	public String getDescMsg() {
		return descMsg;
	}

	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permsId == null) ? 0 : permsId.hashCode());
		result = prime * result
				+ ((sortNumber == null) ? 0 : sortNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePermsBean other = (RolePermsBean) obj;
		if (permsId == null) {
			if (other.permsId != null)
				return false;
		} else if (!permsId.equals(other.permsId))
			return false;
		if (sortNumber == null) {
			if (other.sortNumber != null)
				return false;
		} else if (!sortNumber.equals(other.sortNumber))
			return false;
		return true;
	}
	
	
}
 