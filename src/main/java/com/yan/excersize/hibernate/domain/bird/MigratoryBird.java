package com.yan.excersize.hibernate.domain.bird;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;

/**
 * Created by Mohammad Nur on 9/22/2017.
 */

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
@DiscriminatorValue("traveling")
@SecondaryTable(name = "migratory_birds",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "bird_name", referencedColumnName = "name"))
@org.hibernate.annotations.Table(appliesTo = "migratory_birds", fetch = FetchMode.SELECT)
public class MigratoryBird extends Bird {

    @Column(name = "migration_period", table = "migratory_birds")
    private String migrationPeriod;

    public String getMigrationPeriod() {
        return migrationPeriod;
    }

    public void setMigrationPeriod(String migrationPeriod) {
        this.migrationPeriod = migrationPeriod;
    }
}
