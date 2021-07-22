package com.jee.persistence;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * This  is a mapped class  are  not entities; They are not managed by persistent provider, hence they do not
 * have table mapped to and cannot be queried or be part of the relationship, but they provide persistent
 * properties to entities that extend them.
 *
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Embeddable
public class Valuation {

    private double initialPrice;

    private float discount;

    public Valuation(double initialPrice, float discount) {
        this.initialPrice = initialPrice;
        this.discount = discount;
    }

    public Valuation(double initialPrice) {
        this(initialPrice, 0.0f);
    }

    public Valuation() {
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    private double getProductPrice(){
        return initialPrice * ((100 - discount) / 100);
    }

    @Override
    public String toString() {
        return "Valuation{" +
                "initialPrice=" + initialPrice +
                ", discount=" + discount +
                '}';
    }
}
