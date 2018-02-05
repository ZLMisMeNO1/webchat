/** 
 * Project Name:shiroWeb 
 * File Name:PermsBean.java 
 * Package Name:cn.i7baoz.blog.shiroweb.pojo 
 * Date:2017年12月27日下午4:41:40 
 * 
 */  
  
package cn.i7baoz.blog.shiroweb.pojo;  


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/** 
 * ClassName:PermsBean 权限实体
 * Function: TODO ADD FUNCTION. 
 * Date:     2017年12月27日 下午4:41:40 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Document(collection="t_collection_permission")
public class PermissionBean extends BaseBean{


	/**   
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String permsId;
	
	private String permission;
	
	

	//当前状态
	private Integer currentStatus;
	
	//描述
	private String descMsg;

	//权限类型  0：视图类型  1：接口类型
	private Integer permissionType = 0;
	
	//所属页面
	private String belong = "/";
	//是否为菜单 
	private Boolean isMenu = false;
	
	private Integer sortNumber = 0;
	
	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermsId() {
		return permsId;
	}

	public void setPermsId(String permsId) {
		this.permsId = permsId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}


	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}


	public String getDescMsg() {
		return descMsg;
	}

	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}


	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	@Override
	public String toString() {
		return "PermissionBean [permsId=" + permsId + ", permission="
				+ permission 
				+ ", currentStatus=" + currentStatus + ", descMsg=" + descMsg
				+ ", permissionType=" + permissionType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permission == null) ? 0 : permission.hashCode());
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
		PermissionBean other = (PermissionBean) obj;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		return true;
	}
	
}
 