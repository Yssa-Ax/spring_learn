package com.ysan.netty.codec.fixedLength;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author Administrator
 * @description
 * @since 2023/5/29 13:45
 **/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive client:[" + ((ByteBuf) msg).toString(CharsetUtil.UTF_8) + "]");
    }
}
