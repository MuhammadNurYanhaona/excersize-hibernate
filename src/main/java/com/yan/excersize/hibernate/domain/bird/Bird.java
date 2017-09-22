package com.yan.excersize.hibernate.domain.bird;

import javax.persistence.*;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Entity
@Table(name = "birds")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "data_type")
@DiscriminatorValue("common")
public class Bird {

    @Id
    protected String name;

    @Column(name = "scientific_name")
    protected String scientificName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
}
