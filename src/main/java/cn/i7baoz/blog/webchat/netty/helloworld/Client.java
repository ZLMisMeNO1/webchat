/** 
 * Project Name:webchat 
 * File Name:Client.java 
 * Package Name:cn.i7baoz.blog.webchat.netty.helloworld 
 * Date:2018年2月7日下午4:42:41 
 * 
 */  
  
package cn.i7baoz.blog.webchat.netty.helloworld;  

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/** 
 * ClassName:Client 
 * Function: TODO ADD FUNCTION. 
 * Date:     2018年2月7日 下午4:42:41 
 * @author   baoqi.zhang 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class Client {

	public Client() {
		EventLoopGroup client = new NioEventLoopGroup();
		
		try {
			Bootstrap b = new Bootstrap();
			b.group(client)
			.channel(NioSocketChannel.class)
			.handler(new ChannelInitializer<SocketChannel>(){

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ClientHandler());
				}
				
			});
			ChannelFuture future = b.connect("127.0.0.1", 8765).sync();
			//多个端口
			ChannelFuture future2 = b.connect("127.0.0.1",8764).sync();
			
			future.channel().writeAndFlush(Unpooled.copiedBuffer("Hello Netty".getBytes()));
			future2.channel().writeAndFlush(Unpooled.copiedBuffer("Hello World".getBytes()));
			//18:36
			future.channel().closeFuture().sync();
			
		} catch (Exception e ) {
			
		} finally {
			client.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}
 