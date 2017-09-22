package com.yan.excersize.hibernate.domain.card;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Mohammad Nur on 9/19/2017.
 */

@Entity
@Table(name = "credit_cards")
@Polymorphism(type = PolymorphismType.EXPLICIT)
@PrimaryKeyJoinColumn(name = "card_id", referencedColumnName = "id")
public class CreditCard extends Card {

    @Column(name = "interest_rate")
    double interestRate;

    @Column(name = "transaction_limit")
    int transactionLimit;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(int transactionLimit) {
        this.transactionLimit = transactionLimit;
    }
}
