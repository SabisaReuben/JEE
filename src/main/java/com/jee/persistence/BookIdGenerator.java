package com.jee.persistence;

import javax.inject.Inject;

@Bk
public class BookIdGenerator implements NumberGenerator {

    @Inject
    @Bk
    private String prefix;

    @Inject
    @Random
    private String suffix;

    @Override
    public String generateNumber() {
        return prefix + suffix;
    }
}
