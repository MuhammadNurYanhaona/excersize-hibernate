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
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Table(name = "debit_cards")
@PrimaryKeyJoinColumn(name = "card_id", referencedColumnName = "id")
public class DebitCard extends Card {

    @Column(name = "account_no")
    String accountNo;

    @Column
    String pin;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
