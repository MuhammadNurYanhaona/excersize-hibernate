package com.yan.excersize.hibernate.dao;

import com.yan.excersize.hibernate.domain.bird.Bird;
import com.yan.excersize.hibernate.domain.bird.MigratoryBird;
import com.yan.excersize.hibernate.domain.bird.ProvincialBird;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */
public interface IBirdDao {

    List<Bird> getBirds();
    List<ProvincialBird> getProvincialBirds();
    List<MigratoryBird> getMigratoryBirds();
}
