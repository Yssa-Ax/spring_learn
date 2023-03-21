package com.ysan.card.service;

import com.ysan.card.domain.Card;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:31
 **/
public interface CardService {
    Card getDeviceByCode(String cardCode);
}
