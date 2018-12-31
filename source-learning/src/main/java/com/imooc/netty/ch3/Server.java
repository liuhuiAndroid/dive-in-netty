package com.imooc.netty.ch3;

import com.imooc.netty.ch6.AuthHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;

/**
 * @author
 */
public final class Server {

    public static void main(String[] args) throws Exception {
        // 监听端口，accept 新连接的线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 处理每一条连接的数据读写的线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 引导类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    // 给引导类配置两大线程组
                    .group(bossGroup, workerGroup)
                    // 指定我们服务端的 IO 模型为NIO
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    // 给服务端的 NioServerSocketChannel 指定一些自定义属性
                    .childAttr(AttributeKey.newInstance("childAttr"), "childAttrValue")
                    // 指定在服务端启动过程中的一些逻辑
                    .handler(new ServerHandler())
                    // 指定处理新连接数据的读写处理逻辑
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
//                            ch.pipeline().addLast(new AuthHandler());
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                    System.out.println(msg);
                                }
                            });
                            //..

                        }
                    });

            ChannelFuture f = serverBootstrap.bind(8888).sync();

            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}