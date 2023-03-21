package com.ysan.card.repository;

import com.ysan.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

	Card findCardByCardCode(String cardCode);
}
