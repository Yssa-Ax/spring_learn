package com.ysan.netty.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author Administrator
 * @description
 * @since 2023/5/26 11:03
 **/
public class SampleOutBoundHandler extends ChannelOutboundHandlerAdapter {
    private final String name;

    public SampleOutBoundHandler(String name) {
        this.name = name;
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OutBoundHandler:" + name);
        super.write(ctx, msg, promise);
    }
}
