package com.yan.excersize.hibernate.service;

import com.yan.excersize.hibernate.dao.IBirdDao;
import com.yan.excersize.hibernate.domain.bird.Bird;
import com.yan.excersize.hibernate.domain.bird.MigratoryBird;
import com.yan.excersize.hibernate.domain.bird.ProvincialBird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Service
public class BirdService implements IBirdService {

    @Autowired
    IBirdDao birdDao;

    @Override
    public List<Bird> getBirds() {
        return birdDao.getBirds();
    }

    @Override
    public List<ProvincialBird> getProvincialBirds() {
        return birdDao.getProvincialBirds();
    }

    @Override
    public List<MigratoryBird> getMigratoryBirds() {
        return birdDao.getMigratoryBirds();
    }

    @Override
    public void saveBird(MigratoryBird bird) {
        birdDao.saveBird(bird);
    }

    @Override
    public void saveBird(ProvincialBird bird) {
        birdDao.saveBird(bird);
    }
}
