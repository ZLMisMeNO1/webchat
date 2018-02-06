/** 
 * Project Name:webchat 
 * File Name:RoomUserBean.java 
 * Package Name:cn.i7baoz.blog.webchat.pojo 
 * Date:2018年2月6日上午11:05:25 
 * 
 */  
  
package cn.i7baoz.blog.webchat.pojo;  

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** 
 * ClassName:RoomUserBean 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月6日 上午11:05:25 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Document(collection="t_room_user")
public class ChatUserBean {

	@Id
	private String userId;
	
	private String name;
	
	private String password;
	
	private String salt;
	
	private Integer userType = 0; //0:普通用户 1：主播
	
	private Integer roomId; //主播可用
	
	private String msg;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
 