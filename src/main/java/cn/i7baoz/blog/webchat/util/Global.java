/** 
 * Project Name:webchat 
 * File Name:Global.java 
 * Package Name:cn.i7baoz.blog.webchat.test 
 * Date:2018年2月5日上午10:48:23 
 * 
 */  
  
package cn.i7baoz.blog.webchat.util;  
/** 
 * ClassName:Global 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月5日 上午10:48:23 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Global {
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
 