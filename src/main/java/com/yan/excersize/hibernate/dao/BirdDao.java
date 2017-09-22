package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.bird.Bird;
import com.yan.excersize.hibernate.domain.bird.MigratoryBird;
import com.yan.excersize.hibernate.domain.bird.ProvincialBird;
import com.yan.excersize.hibernate.domain.card.Card;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public class BirdDao implements IBirdDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Bird> getBirds() {
        String hql = "from Bird as bd order by bd.name";
        Query query = entityManager.createQuery(hql);
        return (List<Bird>) query.getResultList();
    }

    @Override
    public List<ProvincialBird> getProvincialBirds() {
        String hql = "from ProvincialBird as bd order by bd.name";
        Query query = entityManager.createQuery(hql);
        return (List<ProvincialBird>) query.getResultList();
    }

    @Override
    public List<MigratoryBird> getMigratoryBirds() {
        String hql = "from MigratoryBird as bd order by bd.name";
        Query query = entityManager.createQuery(hql);
        return (List<MigratoryBird>) query.getResultList();
    }
}
