/** 
 * Project Name:webchat 
 * File Name:Server.java 
 * Package Name:cn.i7baoz.blog.webchat.netty.helloworld 
 * Date:2018年2月7日下午3:44:01 
 * 
 */  
  
package cn.i7baoz.blog.webchat.netty.helloworld;  

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/** 
 * ClassName:Server 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月7日 下午3:44:01 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class Server {

	public Server() {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		ServerBootstrap b = new ServerBootstrap();
		
		b.group(boss, worker)
			//指定NIO的模式
			.channel(NioServerSocketChannel.class)
			//设置tcp缓存的大小
			.option(ChannelOption.SO_BACKLOG, 1024)
			//设置发送缓存的大小
			.option(ChannelOption.SO_SNDBUF,3 * 1024 )
			//设置接收缓存的大小
			.option(ChannelOption.SO_RCVBUF, 3 * 1024)
			//保持连接
			.option(ChannelOption.SO_KEEPALIVE, true)
			//信息的处理方式
			.childHandler(new ChannelInitializer<SocketChannel>(){

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ServerHandler());
				}
				
			});
		try {
			ChannelFuture future = b.bind(8765).sync();
			
			future.channel().closeFuture().sync();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
 