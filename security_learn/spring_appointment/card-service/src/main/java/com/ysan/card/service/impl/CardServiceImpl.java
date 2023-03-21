package com.ysan.card.service.impl;

import com.ysan.card.domain.Card;
import com.ysan.card.repository.CardRepository;
import com.ysan.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:31
 **/
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card getDeviceByCode(String cardCode) {
        return cardRepository.findCardByCardCode(cardCode);
    }
}
