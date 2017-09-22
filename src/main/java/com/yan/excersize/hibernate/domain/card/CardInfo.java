package com.yan.excersize.hibernate.domain.card;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Created by Mohammad Nur on 9/21/2017.
 */

@Entity
@Immutable
@Table(name = "cards")
public class CardInfo {

    @Id
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
