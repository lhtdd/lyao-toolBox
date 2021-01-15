package com.lyao.net.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author lyao
 * @date 2021/1/14 19:30
 * @description
 */
public class EchoClient {

    public void connect(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            //sc.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ByteBuf delimiter = Unpooled.copiedBuffer("0D0A".getBytes());
                            sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
                            sc.pipeline().addLast(new StringDecoder());
                            sc.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            ChannelFuture cf1 = b.connect(host, port).sync();
            // 等待关闭
            cf1.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8888;
        try {
            new EchoClient().connect(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
