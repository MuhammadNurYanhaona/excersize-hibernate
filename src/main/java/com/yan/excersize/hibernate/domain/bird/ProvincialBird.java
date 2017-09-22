package com.yan.excersize.hibernate.domain.bird;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
@DiscriminatorValue("local")
@SecondaryTable(name = "provincial_birds",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "bird_name", referencedColumnName = "name"))
@org.hibernate.annotations.Table(appliesTo = "provincial_birds", fetch = FetchMode.SELECT)
public class ProvincialBird extends Bird {

    @Column(name = "found_in", table = "provincial_birds")
    private String foundIn;

    public String getFoundIn() {
        return foundIn;
    }

    public void setFoundIn(String foundIn) {
        this.foundIn = foundIn;
    }
}