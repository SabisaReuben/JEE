package com.jee.persistence;

import java.lang.annotation.*;

@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Random {
}
