package cn.i7baoz.blog.shiroweb.pojo;

import java.io.Serializable;
import java.util.Date;


public class BaseBean implements Serializable{

	/**   
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1L;
	
	//创建时间
	private Date createTime = new Date();

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
