package com.yan.excersize.hibernate.domain.card;

import javax.persistence.*;

/**
 * Created by Mohammad Nur on 9/19/2017.
 */

@Entity
@Table(name = "cards")
@Inheritance(strategy = InheritanceType.JOINED)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq_gen")
    @SequenceGenerator(name = "card_seq_gen", sequenceName = "card_seq", allocationSize = 1)
    @Column(name = "id")
    protected int id;

    @Column
    protected String issuer;

    @Column
    protected String brand;

    @Column
    protected String pan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
