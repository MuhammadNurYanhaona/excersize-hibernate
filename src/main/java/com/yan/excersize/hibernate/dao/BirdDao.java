package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.bird.Bird;
import com.yan.excersize.hibernate.domain.bird.MigratoryBird;
import com.yan.excersize.hibernate.domain.bird.ProvincialBird;
import com.yan.excersize.hibernate.domain.card.Card;
import oracle.net.aso.b;
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
 * Created by Mohammad Nur on 9/22/2017.
 */

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public class BirdDao implements IBirdDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Bird> getBirds() {
        return getBirdsThroughCriteriaQuery();
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

    @Override
    public void saveBird(ProvincialBird bird) {
        entityManager.persist(bird);
    }

    @Override
    public void saveBird(MigratoryBird bird) {
        entityManager.persist(bird);
    }

    private List<Bird> getBirdsThroughSimpleQuery() {
        String hql = "from Bird as bd order by bd.name";
        Query query = entityManager.createQuery(hql).setHint("org.hibernate.readOnly", true);
        return (List<Bird>) query.getResultList();
    }

    private List<Bird> getBirdsThroughCriteriaQuery() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bird> criteria = cb.createQuery(Bird.class);
        Root<Bird> bird = criteria.from(Bird.class);
        criteria.select(cb.construct(Bird.class, bird.get("name"), bird.get("scientificName")));
        return entityManager.createQuery(criteria).getResultList();
    }
}
