package com.lyao.net.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author lyao
 * @date 2021/1/14 19:09
 * @description
 */
public class EchoServer {

    public void bind(int port) throws Exception {
        // 1 创建线两个程组
        // 一个是用于处理服务器端接收客户端连接的
        // 一个是进行网络通信的（网络读写的）
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 2 创建辅助工具类，用于服务器通道的一系列配置
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            // 3 粘包/拆包处理
                            //sc.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ByteBuf delimiter = Unpooled.copiedBuffer("0D0A".getBytes());
                            sc.pipeline().addLast(new DelimiterBasedFrameDecoder(65792, delimiter));
                            sc.pipeline().addLast(new StringDecoder());
                            sc.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            // 4 进行绑定
            ChannelFuture cf1 = b.bind(port).sync();
            // 5 等待关闭
            cf1.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8888;
        try {
            new EchoServer().bind(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
