package com.yan.excersize.hibernate.service;

import com.yan.excersize.hibernate.dao.ICardDao;
import com.yan.excersize.hibernate.domain.card.Card;
import com.yan.excersize.hibernate.domain.card.CardInfo;
import com.yan.excersize.hibernate.domain.card.CreditCard;
import com.yan.excersize.hibernate.domain.card.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/21/2017.
 */

@Transactional
@Service
public class CardService implements ICardService {

    @Autowired
    ICardDao cardDao;

    @Override
    public List<Card> getCards() {
        return cardDao.getCards();
    }

    @Override
    public List<CardInfo> getCardInfos() {
        return cardDao.getCardInfos();
    }

    @Override
    public List<DebitCard> getDebitCards() {
        return cardDao.getDebitCards();
    }

    @Override
    public List<CreditCard> getCreditCards() {
        return cardDao.getCreditCards();
    }

    @Override
    public void saveCard(DebitCard card) {
        cardDao.saveCard(card);
    }

    @Override
    public void saveCard(CreditCard card) {
        cardDao.saveCard(card);
    }
}
