package com.ysan.netty.simple.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description
 * @since 2023/5/11 17:24
 **/
public class DemoSocketServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("Client Address ====== " + ctx.channel().remoteAddress());
        ctx.channel().writeAndFlush("from server:" + UUID.randomUUID());
        ctx.fireChannelActive();
        TimeUnit.MILLISECONDS.sleep(500);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
