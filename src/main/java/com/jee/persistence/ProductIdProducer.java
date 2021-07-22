package com.jee.persistence;


import javax.enterprise.inject.Produces;

public class ProductIdProducer {
    @Produces
    @Bk
    private String bookIdPrefix = "BK_";

    @Random
    @Produces
    public String getRandom(){
        return Math.abs(new java.util.Random().nextInt()) + "";
    }
}
