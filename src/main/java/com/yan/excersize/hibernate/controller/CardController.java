package com.yan.excersize.hibernate.controller;

import com.yan.excersize.hibernate.domain.Article;
import com.yan.excersize.hibernate.domain.card.Card;
import com.yan.excersize.hibernate.domain.card.CardInfo;
import com.yan.excersize.hibernate.domain.card.CreditCard;
import com.yan.excersize.hibernate.domain.card.DebitCard;
import com.yan.excersize.hibernate.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Mohammad Nur on 9/21/2017.
 */

@Controller
@RequestMapping("cards")
public class CardController {

    @Autowired
    ICardService cardService;

    @GetMapping("basic")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> list = cardService.getCards();
        return new ResponseEntity<List<Card>>(list, HttpStatus.OK);
    }

    @GetMapping("info")
    public ResponseEntity<List<CardInfo>> getAllCardInfos() {
        List<CardInfo> list = cardService.getCardInfos();
        return new ResponseEntity<List<CardInfo>>(list, HttpStatus.OK);
    }

    @GetMapping("debit")
    public ResponseEntity<List<DebitCard>> getAllDebitCards() {
        List<DebitCard> list = cardService.getDebitCards();
        return new ResponseEntity<List<DebitCard>>(list, HttpStatus.OK);
    }

    @GetMapping("credit")
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        List<CreditCard> list = cardService.getCreditCards();
        return new ResponseEntity<List<CreditCard>>(list, HttpStatus.OK);
    }

    @PostMapping("addCredit")
    public ResponseEntity<String> addCreditCard(@RequestBody CreditCard card) {
        cardService.saveCard(card);
        return new ResponseEntity<String>("Credit card created", HttpStatus.CREATED);
    }

    @PostMapping("addDebit")
    public ResponseEntity<String> addDebitCard(@RequestBody DebitCard card) {
        cardService.saveCard(card);
        return new ResponseEntity<String>("Debit card created", HttpStatus.CREATED);
    }
}
