package com.ysan.netty.writeFlush;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @description
 * @since 2023/5/29 17:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSample {
    private String code;
    private String data;
    private Long timestamp;

}
