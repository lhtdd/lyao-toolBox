package com.lyao.net.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author lyao
 * @date 2021/1/14 19:13
 * @description
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel active... ");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            /*ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "utf-8");*/
            String body = (String) msg;
            System.out.println("Server :" + body);
            String response = "{\"server\":\"已收到\"}";
            String l1 = Integer.toHexString(response.getBytes().length / 256);
            if (l1.length() == 1) {
                l1 = "0"+l1;
            }
            String l2 = Integer.toHexString(response.getBytes().length % 256);
            if (l2.length() == 1) {
                l2 = "0"+l2;
            }
            String len = l1 + l2;
            byte[] rs = (len + response+ "0D0A").getBytes();
            ctx.writeAndFlush(Unpooled.copiedBuffer(rs));
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Server读完了");
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
