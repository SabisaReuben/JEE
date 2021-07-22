package com.jee.persistence;

import javax.inject.Inject;

@ISBN
public class ISBNumber implements NumberGenerator{

    @Random
    @Inject
    private String suffix;

    @Override
    public String generateNumber() {
        return "13-" + suffix;
    }
}
