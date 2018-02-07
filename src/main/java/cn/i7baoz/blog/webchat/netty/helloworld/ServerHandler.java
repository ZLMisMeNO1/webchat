/** 
 * Project Name:webchat 
 * File Name:ServerHandler.java 
 * Package Name:cn.i7baoz.blog.webchat.netty.helloworld 
 * Date:2018年2月7日下午4:00:14 
 * 
 */  
  
package cn.i7baoz.blog.webchat.netty.helloworld;  

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/** 
 * ClassName:ServerHandler 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月7日 下午4:00:14 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class ServerHandler extends ChannelHandlerAdapter{

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String resp = "服务端接收的消息是:" + new String(req,"utf-8");
		System.out.println(resp);
		ctx.writeAndFlush(Unpooled.copiedBuffer(resp.getBytes()));
	}

}
 