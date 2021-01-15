package com.lyao.net.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author lyao
 * @date 2021/1/14 19:32
 * @description
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    public EchoClientHandler() {
        super();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channel active... ");
        // 发送消息
        String body = "{\"name\":\"发送第1条测试消息\"}";
        String l1 = Integer.toHexString(body.getBytes().length / 256);
        if (l1.length() == 1) {
            l1 = "0"+l1;
        }
        String l2 = Integer.toHexString(body.getBytes().length % 256);
        if (l2.length() == 1) {
            l2 = "0"+l2;
        }
        String len = l1 + l2;
        byte[] msg = (len + body+ "0D0A").getBytes();
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer(msg));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            /*ByteBuf buf = (ByteBuf) msg;

            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "utf-8");
            */
            String body = (String) msg;
            System.out.println("Client :" + body);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client读完了");
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
