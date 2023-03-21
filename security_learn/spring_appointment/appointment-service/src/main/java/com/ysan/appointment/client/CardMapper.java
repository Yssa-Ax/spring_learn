package com.ysan.appointment.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardMapper implements Serializable {

    private Long id;
    private Long userId;
    private String cardCode;
    private String description;
}
