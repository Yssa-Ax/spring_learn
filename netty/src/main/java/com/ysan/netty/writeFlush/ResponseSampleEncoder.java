package com.ysan.netty.writeFlush;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Administrator
 * @description
 * @since 2023/5/29 17:38
 **/
public class ResponseSampleEncoder extends MessageToByteEncoder<ResponseSample> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ResponseSample responseSample, ByteBuf byteBuf) throws Exception {
        if(responseSample != null) {
            byteBuf.writeBytes(responseSample.getCode().getBytes());
            byteBuf.writeBytes(responseSample.getData().getBytes());
            byteBuf.writeLong(responseSample.getTimestamp());
        }
    }
}
