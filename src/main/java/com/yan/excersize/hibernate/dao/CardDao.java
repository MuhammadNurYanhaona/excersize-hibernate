package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.card.Card;
import com.yan.excersize.hibernate.domain.card.CardInfo;
import com.yan.excersize.hibernate.domain.card.CreditCard;
import com.yan.excersize.hibernate.domain.card.DebitCard;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mohammad Nur on 9/21/2017.
 */

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public class CardDao implements ICardDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Card> getCards() {
        return getCardsThroughCriteriaQuery();
    }

    @Override
    public List<CardInfo> getCardInfos() {
        String hql = "from CardInfo as cd order by cd.id";
        Query query = entityManager.createQuery(hql);
        return (List<CardInfo>) query.getResultList();
    }

    @Override
    public List<DebitCard> getDebitCards() {
        String hql = "from DebitCard as cd order by cd.id";
        Query query = entityManager.createQuery(hql);
        return (List<DebitCard>) query.getResultList();
    }

    @Override
    public List<CreditCard> getCreditCards() {
        String hql = "from CreditCard as cd order by cd.id";
        Query query = entityManager.createQuery(hql);
        return (List<CreditCard>) query.getResultList();
    }

    @Override
    public void saveCard(DebitCard card) {
        entityManager.persist(card);
    }

    @Override
    public void saveCard(CreditCard card) {
        entityManager.persist(card);
    }

    private List<Card> getCardsThroughNormalQuery() {
        String hql = "from Card as cd order by cd.id";
        Query query = entityManager.createQuery(hql);
        return (List<Card>) query.getResultList();
    }

    private List<Card> getCardsThroughCriteriaQuery() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Card> criteria = cb.createQuery(Card.class);
        Root<Card> card = criteria.from(Card.class);
        criteria.select(cb.construct(Card.class,
                card.get("id"), card.get("issuer"), card.get("brand"), card.get("pan")));
        return entityManager.createQuery(criteria).getResultList();
    }
}
