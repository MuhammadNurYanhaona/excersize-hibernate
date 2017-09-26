package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.card.Card;
import com.yan.excersize.hibernate.domain.card.CardInfo;
import com.yan.excersize.hibernate.domain.card.CreditCard;
import com.yan.excersize.hibernate.domain.card.DebitCard;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/21/2017.
 */
public interface ICardDao {

    List<Card> getCards();
    List<CardInfo> getCardInfos();
    List<DebitCard> getDebitCards();
    List<CreditCard> getCreditCards();

    void saveCard(DebitCard card);
    void saveCard(CreditCard card);
}
